package test.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.PassingUponPendingStep;
import org.jbehave.core.failures.PendingStepStrategy;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.guice.GuiceStepsFactory;
import org.jbehave.web.selenium.*;
import test.steps.*;

import java.util.HashMap;

import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

public class StoryEmbedder extends Embedder {
    private SeleniumContext      seleniumContext     = new SeleniumContext();
    private PendingStepStrategy  pendingStepStrategy = new PassingUponPendingStep();
    private CrossReference       crossReference      = new CrossReference().withJsonOnly().withPendingStepStrategy(pendingStepStrategy)
            .withOutputAfterEachStory(true).excludingStoriesWithNoExecutedScenarios(true);
    private ContextView          contextView         = new LocalFrameContextView().sized(640, 120);
    private SeleniumStepMonitor  stepMonitor         = new SeleniumStepMonitor(contextView, seleniumContext,
            crossReference.getStepMonitor());
    private Format[]             formats             = new Format[]{new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML};
    private StoryReporterBuilder reporterBuilder     = new StoryReporterBuilder()
            .withFailureTrace(true)
            .withFailureTraceCompression(false).withDefaultFormats().withFormats(formats)
            .withCrossReference(crossReference);
    // Do this last, because it might override some of the settings above
    private Injector             injector            = createInjector();

    @Override
    public Configuration configuration() {
        return new SeleniumConfiguration()
                .useSeleniumContext(seleniumContext)
                .usePendingStepStrategy(pendingStepStrategy)
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(true)).useStepMonitor(stepMonitor)
                .useStoryLoader(new LoadFromClasspath(Stories.class))
                .useStoryReporterBuilder(reporterBuilder);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new GuiceStepsFactory(configuration(), injector);
    }

    private Injector createInjector() {
        Injector injector = Guice.createInjector(new SetupModule(reporterBuilder), new StepsModule());

        // Reset headless property for acceptance tests, the server sets it to true in PropertiesModule, but that would
        // make JBehave unhappy
        System.setProperty("java.awt.headless", "false");

        return injector;
    }

    public class SetupModule extends AbstractModule {
        private StoryReporterBuilder reporterBuilder;

        public SetupModule(StoryReporterBuilder theReporterBuilder) {
            reporterBuilder = theReporterBuilder;
        }

        @Override
        protected void configure() {
            WebDriverProvider driverProvider;
            if (System.getProperty("SAUCE_USERNAME") != null) {
                driverProvider = new RealConnexWebDriverProvider();

                // This isn't really entirely kosher, it's overwriting configuration of the containing class
                // and will only work if the injector is the last thing to be initialized as part of the
                // construction of the class
                formats = new Format[]{new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML};
                contextView = new SauceLabsContextView(driverProvider);
                crossReference.withThreadSafeDelegateFormat(new SauceContextOutput(driverProvider, seleniumContext,
                        new HashMap<String, String>()));

                reporterBuilder = new StoryReporterBuilder()
                        .withFailureTrace(true)
                        .withFailureTraceCompression(false).withDefaultFormats().withFormats(Format.STATS)
                        .withCrossReference(crossReference);
            }
            else {
                driverProvider = new PropertyWebDriverProvider();
            }
            bind(WebDriverProvider.class).toInstance(driverProvider);

            bind(WebDriverPageDumpOnFailure.class).toInstance(
                    new WebDriverPageDumpOnFailure(driverProvider, reporterBuilder));
            bind(WebDriverScreenshotOnFailure.class).toInstance(
                    new WebDriverScreenshotOnFailure(driverProvider, reporterBuilder));

            bind(PerStoryWebDriverConfiguration.class).toInstance(new PerStoryWebDriverConfiguration(driverProvider));
//            bind(LifecycleSteps.class).in(Scopes.SINGLETON);
        }
    }

    public static class StepsModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(LoginRealConnexSteps.class).in(Scopes.SINGLETON);
            bind(LogoutSteps.class).in(Scopes.SINGLETON);
        }
    }
}
