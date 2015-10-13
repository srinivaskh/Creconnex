package test.steps;

import com.google.inject.Inject;
import org.jbehave.core.annotations.When;
import test.pages.PageFactory;
import test.pages.SearchPage;

public class SearchSteps {
    private final SearchPage searchPage;

    @Inject
    public SearchSteps(PageFactory thePageFactory) {
        searchPage = thePageFactory.newSearchPage();
    }

    @When("I click on 'People,companies and association' link")
    public void peopleCompaniesLinkClick(){
        searchPage.peopleCompaniesLinkClick();
    }

    @When("I click on 'People' link")
    public void peopleClick(){
        searchPage.peopleClick();
    }

    @When("I click on 'Companies/Associations' link")
    public void companiesClick(){
        searchPage.companiesClick();
    }

    @When("I click on 'Developers, Sponsors & GPs' link")
    public void dealSponsorClick(){
        searchPage.dealSponsorClick();
    }

    @When("I click on 'Deal Sponsor' link")
    public void selectDealSponsor(){
        searchPage.selectDealSponsor();
    }

    @When("I click on 'View Search Results' button")
    public void clickViewSearchResults(){
        searchPage.clickViewSearchResults();
    }

    @When("I click on 'Developer' link")
    public void selectDeveloper(){
        searchPage.selectDeveloper();
    }

    @When("I select 'Fund Sponsor' link")
    public void selectFundSponsor(){
        searchPage.selectFundSponsor();
    }

    @When("I select 'Developer','DealSponsor' link")
    public void clickUsers(){
        searchPage.clickUsers();
    }

    @When("I click on 'Transaction and Capital markets Link' link")
    public void clickTransactionAndCapitalMarketProfessionalsLink(){
        searchPage.clickTransactionAndCapitalMarketProfessionalsLink();
    }

    @When("I click on 'Advisor' link")
    public void clickAdvisorLink(){
        searchPage.clickAdvisorLink();
    }

    @When("I click on 'Project Management' link")
    public void clickProjectManagementLink(){
        searchPage.clickProjectManagementLink();
    }

    @When("I click on 'Appraisal' link")
    public void clickAppraisalLink(){
        searchPage.clickAppraisalLink();
    }

    @When("I click on 'Commercial Brokers' link")
    public void clickCommercialBroker(){
        searchPage.clickCommercialBroker();
    }

    @When("I click on 'Residential Brokers' link")
    public void clickResidentialBroker(){
        searchPage.clickResidentialBroker();
    }

    @When("I click on 'Acquisitions' link")
    public void clickAcquisitions(){
        searchPage.clickAcquisitions();
    }

    @When("I click on 'Off Plan Sales' link")
    public void clickOffPlanSales(){
        searchPage.clickOffPlanSales();
    }

    @When("I click on 'Investment Banker' link")
    public void clickInvestmentBanker(){
        searchPage.clickInvestmentBanker();
    }

    @When("I click on 'Capital Raising' link")
    public void clickCapitalRaising(){
        searchPage.clickCapitalRaising();
    }

    @When("I click on 'Invest or Lend' link")
    public void clickInvestments(){
        searchPage.clickInvestOrLend();
    }

    @When("I click on 'Properties' link")
    public void clickDirectIntoProject(){
        searchPage.clickProperties();
    }

   @When("I click on 'Core' link")
    public void clickCore(){
        searchPage.clickCore();
    }

    @When("I click on 'Opportunistic' link")
    public void clickOpportunistic(){
        searchPage.clickOpportunistic();
    }

    @When("I click on 'Fund' link")
    public void clickFundOfFunds(){
        searchPage.clickFund();
    }

    @When("I click on 'Equity' in fund link")
    public void clickEquityOfFund(){
        searchPage.clickEquityOfFund();
    }

    @When("I click on 'Money & Buyers' link")
    public void clickMoney(){
        searchPage.clickMoney();
    }

    @When("I click on 'Equity' link")
    public void clickEquity(){
        searchPage.clickEquity();
    }

    @When("I click on 'Preferred' link")
    public void clickPreferred(){
        searchPage.clickPreferred();
    }

    @When("I click on 'Fund' of money search")
    public void clickFundOfMoney(){
        searchPage.clickFundOfMoney();
    }

    @When("I click on 'Mezz' link")
    public void clickMezz(){
        searchPage.clickMezz();
    }

    @When("I click on 'Properties' link in money search")
    public void clickDirectIntoProjectLink(){
        searchPage.clickDirectIntoProjectLink();
    }

    @When("I click on 'Fund' link in money search")
    public void clickFundLink(){
        searchPage.clickFundLink();
    }

    @When("I click on 'Debt' link")
    public void clickDebt(){
        searchPage.clickDebt();
    }

    @When("I click on 'Loans' link")
    public void clickLoans() {
        searchPage.clickLoans();
    }

    @When("I click on 'Land Loan' link")
    public void clickLandLoan(){
        searchPage.clickLandLoan();
    }

    @When("I click on 'Income/Core' link")
    public void clickIncomeOrCore(){
        searchPage.clickIncomeOrCore();
    }

    @When("I click on 'Hard Money' link")
    public void clickHardMoney(){
        searchPage.clickHardMoney();
    }

    @When("I click on 'JV Partner' link")
    public void jvPartnerLinkClick(){
        searchPage.jvPartnerLinkClick();
    }

    /*@When("I click on 'Find New Clients' link")
    public void clickFindClientLink(){
        searchPage.clickNewBusinessLinkClick();
    }*/

    @When("I click on 'Loans' link in new business search")
    public void clickOnLoansInNewBusinessSearch(){
        searchPage.clickOnLoansInNewBusinessSearch();
    }

    @When("I click on 'LoansOrHardMoney' link")
    public void clickLoansOrHardMoneyLink(){
        searchPage.clickLoansOrHardMoneyLink();
    }

    @When("I click on 'Mezz' link of new business search")
    public void clickMezzOfNewBusinessSearch(){
        searchPage.clickMezzOfNewBusinessSearch();
    }

    @When("I click on 'Land' link")
    public void landLinkClick(){
        searchPage.landLinkClick();
    }

    @When("I click on 'Project' link")
    public void clickProject(){
        searchPage.clickProject();
    }

    @When("I click on 'Equity' link in JV Partner search")
    public void clickEquity_JVPartner(){
        searchPage.clickEquity_JVPartner();
    }

    @When("I click on 'Services' link")
    public void clickService(){
        searchPage.clickService();
    }

    @When("I click on 'Other' link")
    public void clickOther(){
        searchPage.clickOther();
    }

    @When("I click on 'Corporate Finance' link")
    public void clickCorporateFinance(){
        searchPage.clickCorporateFinance();
    }

    @When("I click on 'Residential Broker' link")
    public void clickResidentialBrokerLink(){
        searchPage.clickResidentialBrokerLink();
    }

    @When("I click on 'Commercial Broker' link")
    public void clickCommercialBrokerLink(){
        searchPage.clickCommercialBrokerLink();
    }

    @When("I click on 'Sale of Existing' link in find client search")
    public void clickSaleOfExisting_NewBusiness(){
        searchPage.clickSaleOfExisting_NewBusiness();
    }

    @When("I click on 'Acquisitions' link in new business search")
    public void clickAcquisitionLink_NewBusiness(){
        searchPage.clickAcquisitionLink_NewBusiness();
    }

    @When("I click on 'Design, Build & Engineering' link")
    public void clickDesignBuildEngineerLink(){
        searchPage.clickDesignBuildEngineerLink();
    }

    @When("I click on 'Architect' link")
    public void clickArchitectLink(){
        searchPage.clickArchitectLink();
    }

    @When("I click on 'Designer' link")
    public void clickDesignerLink(){
        searchPage.clickDesignerLink();
    }

    @When("I click on 'Contractor' link")
    public void clickContractorLink(){
        searchPage.clickContractorLink();
    }

    @When("I click on 'Sub Contractor' link")
    public void clickSubContractorLink(){
        searchPage.clickSubContractorLink();
    }

    @When("I click on 'Engineer' link")
    public void clickOnEngineerLink(){
        searchPage.clickOnEngineerLink();
    }

    @When("I click on 'Civil Engineer' link")
    public void clickOnCivilEngineerLink(){
        searchPage.clickOnCivilEngineerLink();
    }

    @When("I click on 'Mechanical Engineer' link")
    public void clickOnMechanicalEngineerLink(){
        searchPage.clickOnMechanicalEngineerLink();
    }

    @When("I click on 'Electrical Engineer' link")
    public void clickOnElectricalEngineerLink(){
        searchPage.clickOnElectricalEngineerLink();
    }

    @When("I click on 'Environmental Engineer' link")
    public void clickOnEnvironmentalEngineerLink(){
        searchPage.clickOnEnvironmentalEngineerLink();
    }

    @When("I click on 'Structural Engineer' link")
    public void clickOnStructuralEngineerLink(){
        searchPage.clickOnStructuralEngineerLink();
    }

    @When("I click on 'Health & Safety Engineer' link")
    public void clickHealthAndSafetyEngineerLink(){
        searchPage.clickHealthAndSafetyEngineerLink();
    }

    @When("I click on 'Outright Sales' link")
    public void clickOutrightSalesLink(){
        searchPage.clickOutrightSalesLink();
    }

    @When("I click on 'Forward Commit' Link")
    public void clickForwardCommitLink(){
        searchPage.clickForwardCommitLink();
    }

    @When("I click on 'Property' link")
    public void clickPropertyLink(){
        searchPage.clickPropertyLink();
    }

    @When("I click on 'Operating Company' link")
    public void clickOperatingCompanyLink(){
        searchPage.clickOperatingCompanyLink();
    }

    @When("I click on 'Forward Sales' link")
    public void clickForwardSalesLink(){
        searchPage.clickForwardSalesLink();
    }

    @When("I click on 'Find Clients' link")
    public void clickFindClientLink(){
        searchPage.clickFindClientLink();
    }
    @When("I click on 'Operating Partner' link")
    public void clickOperatingPartner(){
        searchPage.clickOperatingPartner();
    }

    @When("I click on 'Accountant' link")
    public void clickAccountantLink(){
        searchPage.clickAccountantLink();
    }

    @When("I click on 'Audit' link")
    public void clickAuditLink(){
        searchPage.clickAuditLink();
    }

    @When("I click on 'For Sale' link")
    public void clickForSaleLink(){
        searchPage.clickForSaleLink();
    }

    @When("I click on 'For Lease' link")
    public void clickForLeaseLink(){
        searchPage.clickForLeaseLink();
    }

    @When("I click on 'Listings' link")
    public void clickListingsLink(){
        searchPage.clickListingsLink();
    }

    @When("I click on 'Facilities Management & Services' link")
    public void clickFacilitiesManagementAndServices(){
        searchPage.clickFacilitiesManagementAndServices();
    }

    @When("I click on 'Properties of Facilities' link")
    public void clickPropertyOfFacilitiesLink(){
        searchPage.clickPropertyOfFacilitiesLink();
    }

    @When("I click on 'Find Client of Design, Build & Engineering' link")
    public void clickFindClientOfDesignBuildEngineering(){
        searchPage.clickFindClientOfDesignBuildEngineering();
    }

    @When("I click on 'Find client of Architect' link")
    public void clickFindClientArchitectLink(){
        searchPage.clickFindClientArchitectLink();
    }

    @When("And I click on 'Find client of Designer' link")
    public void clickFindClientDesignerLink(){
        searchPage.clickFindClientDesignerLink();
    }

    @When("I click on 'Find client of Contractor' link")
    public void clickFindClientContractorLink(){
        searchPage.clickFindClientContractorLink();
    }

    @When("I should see sub role as 'Find client of Sub Contractor' link")
    public void clickFindClientSubContractorLink(){
        searchPage.clickFindClientSubContractorLink();
    }

    @When("I click on 'Find client of Civil Engineer' link")
    public void clickFindClientCivilEngineerLink(){
        searchPage.clickFindClientCivilEngineerLink();
    }

    @When("I click on 'Find client of Mechanical Engineer' link")
    public void clickFindClientMechanicalEngineer(){
        searchPage.clickFindClientMechanicalEngineer();
    }

    @When("I click on 'Environmental Inspection' link")
    public void clickEnvironmentalInspectionLink(){
        searchPage.clickEnvironmentalInspectionLink();
    }

    @When("I click on 'Transaction & Capital Market Professionals' link")
    public void clickTransactionAndCapitalMarketsLink(){
        searchPage.clickTransactionAndCapitalMarketProfessionalsLink();
    }

    @When("I click on 'Valuations & Appraisals' link")
    public void clickValuationsAndAppraisalsLink(){
        searchPage.clickValuationsAndAppraisalsLink();
    }

    @When("I click on 'Research' link")
    public void clickResearchLink(){
        searchPage.clickResearchLink();
    }

    @When("I click on 'Other' link in Transaction And Capital Market search")
    public void clickOtherLink_TransactionAndCapitalMarket(){
        searchPage.clickOtherLink_TransactionAndCapitalMarket();
    }

    @When("I click on 'Commercial' link")
    public void clickCommercial(){
        searchPage.clickCommercial();
    }

    @When("I click on 'M&A' link")
    public void clickMAndA(){
        searchPage.clickMAndA();
    }

    @When("I click on 'Pension Fund Consultant' link")
    public void clickPensionFundConsultant(){
        searchPage.clickPensionFundConsultant();
    }

    @When("I click on 'Fee Developer' link")
    public void selectFeeDeveloper(){
        searchPage.selectFeeDeveloper();
    }

    @When("I click on 'Soft Deposit' link")
    public void selectSoftDeposit(){
        searchPage.selectSoftDeposit();
    }

    @When("I click on 'Outright Purchase' link")
    public void selectOutrightPurchase(){
        searchPage.selectOutrightPurchase();
    }

    @When("I click on 'Professional Service Providers' link")
    public void selectProfessionalServiceProviders(){
        searchPage.selectProfessionalServiceProviders();
    }

    @When("I click on 'Legal' link")
    public void selectLegalLink(){
        searchPage.selectLegalLink();
    }

    @When("I click on 'Residential' link")
    public void clickResidential(){
        searchPage.clickResidential();
    }

    @When("I click on 'Corporate Structuring' link")
    public void clickCorporateStructuring(){
        searchPage.clickCorporateStructuring();
    }

    @When("I click on 'Accounting' link")
    public void selectAccountingLink(){
        searchPage.selectAccountingLink();
    }

    @When("I click on 'Due Diligence' link")
    public void clickDueDiligenceLink(){
        searchPage.clickDueDiligenceLink();
    }

    @When("I click on 'BookKeeper/Controller' link")
    public void clickBookKeeperControllerLink(){
        searchPage.clickBookKeeperControllerLink();
    }

    @When("I click on 'Find client of Structural Engineer' link")
    public void clickFindclientofStructuralEngineer(){
        searchPage.clickFindclientofStructuralEngineer();
    }
}
