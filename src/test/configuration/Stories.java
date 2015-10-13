package test.configuration;

import org.jbehave.core.io.StoryFinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * This class is responsible for setting up the stories to be run.
 */
@RunWith(Parameterized.class)
public class Stories {
    private static Pattern storyNamePattern = Pattern.compile("^(.*/)?([^/]+).story$");
    private static StoryEmbedder storyEmbedder = new StoryEmbedder();
    private String browser;
    private String storyName;
    private String storyPath;

    public Stories(String theBrowser, String theName, String theStoryPath) {
        browser = theBrowser;
        storyName = theName;
        storyPath = theStoryPath;

        // Don't throw an exception for failing stories while generating reports
        storyEmbedder.embedderControls().doBatch(false);
        storyEmbedder.embedderControls().doGenerateViewAfterStories(false);
        storyEmbedder.embedderControls().doIgnoreFailureInStories(false);
        storyEmbedder.embedderControls().doIgnoreFailureInView(false);
        storyEmbedder.embedderControls().doSkip(false);
        storyEmbedder.embedderControls().doVerboseFailures(false);
        storyEmbedder.embedderControls().doVerboseFiltering(false);
        storyEmbedder.embedderControls().useThreads(1);
        storyEmbedder.embedderControls().useStoryTimeoutInSecs(10000);

        // Optionally configure the embedder with meta filters passed in using -DmetaFilters=filter1,filter2,...
        String metaFilter = System.getProperty("metaFilters");
        if(metaFilter != null) {
            String[] metaFilters = metaFilter.split(",");
            storyEmbedder.useMetaFilters(asList(metaFilters));
        }
    }

    @Parameterized.Parameters(name = "{1}:{0}")
    public static List<String[]> storyPaths() {
        String storyExcludeFilter = "";
        if (System.getProperty("storyExcludeFilter") != null) {
            storyExcludeFilter = "test/story/**/" + System.getProperty("storyExcludeFilter", "*") + ".story";
        }
        List<String> paths = new StoryFinder().findPaths(codeLocationFromClass(Stories.class).getFile(),
                asList("test/story/**/" + System.getProperty("storyFilter", "*") + ".story"), asList(storyExcludeFilter));
        System.out.println(paths);

        String[] browsers = System.getProperty("acceptance.browsers", "firefox").split(",");
        List<String[]> stories = new ArrayList<String[]>();
        for (String path : paths) {
            Matcher matcher = storyNamePattern.matcher(path);
            String name = path;
            if (matcher.find()) {
                name = matcher.group(2);

            }
            for (String browser : browsers) {
                stories.add(new String[]{browser, name, path});
            }
        }

        return stories;
    }

    @Test
    public void testWithJBehave() {
        System.setProperty("browser", browser);
        storyEmbedder.runStoriesAsPaths(Collections.singletonList(storyPath));
    }
}
