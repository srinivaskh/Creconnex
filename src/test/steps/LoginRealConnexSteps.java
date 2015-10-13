package test.steps;

import com.google.inject.Inject;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import test.pages.LoginRealConnexPage;
import test.pages.PageFactory;

import java.awt.*;
import java.io.IOException;

public class LoginRealConnexSteps {
    private final LoginRealConnexPage loginRealConnexPage;

    @Inject
    public LoginRealConnexSteps(PageFactory thePageFactory) {
        loginRealConnexPage = thePageFactory.newLoginRealConnexPage();
    }

    @When("I launch RealConnex application")
    public void launchRealConnexPage()throws IOException {
        loginRealConnexPage.launchRealConnexPage();
    }

    @When("I click on Log In button in RealConnex login page")
    public void clickLogInButtonInLoginPage(){
        loginRealConnexPage.clickLogInButtonInLoginPage();
    }

    @When("I enter user email ID")
    public void enterEmailId()throws Exception{
        loginRealConnexPage.enterEmailId(1);
    }

    @When("I enter Password")
    public void enterPassword() throws Exception {
        loginRealConnexPage.enterPassword(1);
    }

    @When("I click on login button")
    public void clickLogin(){
        loginRealConnexPage.clickLogIn();
    }

    @When("I enter deal sponsor email ID for privacy set to public")
        @Alias("I enter deal sponsor email ID with subrole as deal sponsor")
    public void enterEmailId_Public() {
        loginRealConnexPage.enterEmailId(2);
    }

    @When("I enter deal sponsor email ID with different deal/fund size")
    public void enterEmailIdOfDealSponsorWithDealFundSize(){
        loginRealConnexPage.enterEmailId(20);
    }

    @When("I enter investor email Id with different deal/fund size")
    public void enterEmailIdOfInvestorWithDealFundSize(){
        loginRealConnexPage.enterEmailId(24);
    }

    @When("I enter investor with different location")
    public void enterEmailIdOfInvestorWithLocation(){
        loginRealConnexPage.enterEmailId(25);
    }

    @When("I enter deal sponsor email ID with different location")
    @Aliases(values = {"I enter deal sponsor email Id with developer subrole and different location"})
    public void enterEmailIdOfDealSponsorWithLocation(){
        loginRealConnexPage.enterEmailId(21);
    }

    @When("I enter deal sponsor email ID with subrole as all")
    public void enterEmailIdOfDealSponsorWithAllSubRole(){
        loginRealConnexPage.enterEmailId(22);
    }

    @When("I enter investor email ID with subrole bank")
    public void enterEmailIdOfInvestorWithSubRoleBank() {
        loginRealConnexPage.enterEmailId(23);
    }

    @When("I enter lender email ID with subrole private lender")
    public void enterEmailIdOfLenderWithSubRolePrivateLender(){
        loginRealConnexPage.enterEmailId(26);
    }

    @When("I enter lender email ID with different deal/fund size")
    public void enterLenderEmailIdWithDealFundSize(){
        loginRealConnexPage.enterEmailId(27);
    }

    @When("I enter lender email ID with different location")
    public void enterLenderEmailIdWithLocation(){
        loginRealConnexPage.enterEmailId(28);
    }

    @When("I enter real estate advisor with subrole corporate finance")
    public void enterRealEstateAdvisorWithSubRoleCorporateFinance(){
        loginRealConnexPage.enterEmailId(29);
    }

    @When("I enter real estate advisor with different deal/fund size")
    public void enterRealEstateAdvisorWithDealFundSize(){
        loginRealConnexPage.enterEmailId(30);
    }

    @When("I enter real estate advisor with different location")
    public void enterRealEstateAdvisorWithLocation(){
        loginRealConnexPage.enterEmailId(31);
    }

    @When("I enter deal sponsor email ID whose privacy set to private")
        @Alias("I enter deal sponsor email ID where privacy is set")
    public void enterEmailId_DealSponsorPrivate() throws Exception {
        loginRealConnexPage.enterEmailId(3);
    }

    @When("I enter investor email ID whose privacy set to private")
        @Alias("I enter investor email ID where privacy is set")
    public void enterEmailId_InvestorPrivate() throws Exception {
        loginRealConnexPage.enterEmailId(8);
    }

    @When("I enter lender email ID whose privacy set to private")
        @Alias("I enter lender email ID where privacy is set")
    public void enterEmailId_LenderPrivate() throws Exception {
        loginRealConnexPage.enterEmailId(9);
    }

    @When("I enter real estate advisor email ID whose privacy set to private")
        @Alias("I enter real estate advisor email ID where privacy is set")
    public void enterEmailId_RealEstateAdvisorPrivate() throws Exception {
        loginRealConnexPage.enterEmailId(10);
    }

    @When("I enter user login details:$LoginDetailsTable")
    public void enterLoginDetails(ExamplesTable LoginDetailsTable){
        loginRealConnexPage.enterLoginDetails(LoginDetailsTable);
    }

    @When("I enter investor email ID for login")
    public void enterEmailIdOfInvestor() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(4);
    }

    @When("I enter deal sponsor email ID for login")
    public void enterEmailIdOfDealSponsor() {
        loginRealConnexPage.enterEmailIdOfUsers(7);
    }

    @When("I enter lender email ID for login")
    public void enterEmailIdOfLender() {
        loginRealConnexPage.enterEmailIdOfUsers(5);
    }

    @When("I enter real estate advisor email ID for login")
    public void enterEmailIdOfRealEstateAdvisor() {
        loginRealConnexPage.enterEmailIdOfUsers(6);
    }


    @When("I enter email ID of user who set the privacy in my universe include")
        @Alias("I enter email ID of user who set the privacy in my universe exclude")
    public void enterEmailIdOfUserMyUniverseInclude() {
        loginRealConnexPage.enterEmailIdOfUsers(11);
    }

    @When("I enter investor email ID of user who set the privacy in my universe include as private in me tab")
        @Aliases(values = {"I enter investor email ID of user who set the privacy in my universe include in project tab",
                "I enter investor email ID of user who set the privacy in my universe exclude","I enter investor email ID of user who set the privacy in my universe include"})
    public void enterEmailIdOfInvestorUserMyUniverseIncludePrivate() {
        loginRealConnexPage.enterEmailIdOfUsers(16);
    }

    @When("I enter deal sponsor email ID of user who set the privacy in my universe include as private in me tab")
        @Aliases( values = {"I enter deal sponsor email ID of user who set the privacy in my universe include as public in project tab",
                "I enter deal sponsor email ID of user who set the privacy in my universe include as private in project tab",
                "I enter deal sponsor email ID of user who set the privacy in my universe exclude"})
    public void enterEmailIdOfDealSponsorUserMyUniverseIncludePrivate()  {
        loginRealConnexPage.enterEmailIdOfUsers(17);
    }

    @When("I enter real estate advisor email ID of user who set the privacy in my universe include as private in me tab")
        @Alias("I enter real estate advisor email ID of user who set the privacy in my universe include in project tab")
    public void enterEmailIdOfRealEstateAdvisorUserMyUniverseIncludePrivate()  {
        loginRealConnexPage.enterEmailIdOfUsers(18);
    }

    @When("I enter lender email ID of user who set the privacy in my universe include as private in me tab")
         @Alias("I enter lender email ID of user who set the privacy in my universe include")
    public void enterEmailIdOfLenderUserMyUniverseIncludePrivate()  {
        loginRealConnexPage.enterEmailIdOfUsers(19);
    }

    @When("I enter email ID of user with role as deal sponsor and sub role as developer with deal/fund size")
        @Alias("I enter email id of deal sponsor with same location")
    public void enterEmailIdOfDealSponsorDeveloperSubRole() {
        loginRealConnexPage.enterEmailIdOfUsers(12);
    }

    @When("I enter email ID of user with same location")
    public void enterEmailIdOfUserWithSameLocation() {
        loginRealConnexPage.enterEmailIdOfUsers(35);
    }

    @When("I enter email ID of deal sponsor user with no filters")
    public void enterEmailIdOfDealSponsorWithNoFilters() {
        loginRealConnexPage.enterEmailId(32);
    }

    @When("I enter email ID of deal sponsor user with subrole as fund sponsor")
    public void enterEmailIdOfDealSponsorWithFundSponsor() {
        loginRealConnexPage.enterEmailId(33);
    }

    @When("I enter email ID of deal sponsor user with deal/fund size")
    public void enterEmailIdOfDealSponsorWithDealOrFundSize() {
        loginRealConnexPage.enterEmailId(34);
    }

    @When("I enter email ID of user with role as investor and sub role as advisor")
    public void enterEmailIdOfInvestorAdvisorSubRole(){
        loginRealConnexPage.enterEmailIdOfUsers(13);
    }

    @When("I enter email ID of user with role as lender and sub role as family office")
    public void enterEmailIdOfLenderFamilyOfficeSubRole() {
        loginRealConnexPage.enterEmailIdOfUsers(14);
    }

    @When("I enter email ID of user with role as real estate advisor and sub role as advisor")
    public void enterEmailIdOfRealEstateAdvisorAdvisorSubRole() {
        loginRealConnexPage.enterEmailIdOfUsers(15);
    }

    @When("I enter password of user")
    public void enterPasswordOfUser() throws Exception {
       loginRealConnexPage.enterPasswordOfUser(2);
    }

    @When("I enter deal sponsor email id for jv partner search")
        @Aliases(values = {"I enter deal sponsor email id for new business search",
                "I enter email id of user with deal sponsor role and developer subrole","I enter email id of user with deal sponsor role,developer subrole and location"})
    public void enterEmailIdOfDealSponsorOfJVPartnerSearch() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(36);
    }

    @When("I enter deal sponsor email id who has created the jv requirement")
    @Aliases(values = {"I enter deal sponsor email id with deal sponsor subrole and different location"})
    public void enterEmailIdOfDealSponsorOfJVPartner() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(37);
    }

    @When("I enter lender email id who has created the jv requirement in project")
    public void enterEmailIdOfInvestorOfJVPartner() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(38);
    }

    @When("I enter email id of user who has created the jv requirement and lighthouse is off")
    public void enterEmailIdOfInvestorOfJVPartner_LighthouseOff() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(39);
    }

    @When("I enter lender email id who has created the jv requirement")
    public void enterEmailIdOfLenderOfJVPartner() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(40);
    }

    @When("I enter real estate user email id who has created the jv requirement")
    public void enterEmailIdOfREAOfJVPartner() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(41);
    }

    @When("I enter deal sponsor email id who has created the jv requirement in jv search other")
    public void enterEmailIdOfDSOfJVPartner() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(42);
    }

    @When("I enter deal sponsor user email id for new business loan search")
    public void enterEmailIdOfDSOfNewBusinessLoanSearch() throws Exception {
        loginRealConnexPage.enterEmailIdOfUsers(43);
    }

    @When("I enter the email id of the user whose lighthouse search is off in new business loan search")
    public void enterEmailIdOfUserWhoseLightHouseSearchOffInLoanSearch(){
        loginRealConnexPage.enterEmailIdOfUsers(39);
    }

    @When("I enter email ID of user with deal sponsor and developer role and deal/fund size of 20 to 30")
    public void enterEmailIdOfDealSponsorDeveloperSubRoleWithDifferentDealSize() {
        loginRealConnexPage.enterEmailIdOfUsers(44);
    }

    @When("I enter user email ID with deal sponsor role,8 to 9 deal fund size and location")
    public void enterEmailIdOfUserWithDealSponsorDealSizeAndLocation() {
        loginRealConnexPage.enterEmailIdOfUsers(45);
    }

    @When("I enter user email ID with deal sponsor role,5 to 6 deal fund size and location")
    public void enterEmailIdOfUserWithDealSponsorDealSizeOf5to6AndLocation() {
        loginRealConnexPage.enterEmailIdOfUsers(46);
    }

    @When("I enter email ID of real estate advisor user for creating the requirement")
    public void enterEmailIdREAUserToCreateRequirement(){
        loginRealConnexPage.enterEmailIdOfUsers(47);
    }

    @When("I enter email ID of real estate advisor user for creating the requirement and verifying the number of matches")
    public void enterEmailIdOfREAUserToCreateRequirement(){
        loginRealConnexPage.enterEmailIdOfUsers(48);
    }

    @When("I click on control F")
    public void clickCntrlF() throws AWTException {
        loginRealConnexPage.clickCntrlF();
    }

    @Then("I verify 'Confirmation needed' message pop up is displayed")
    public void verifyConfirmationNeeded(){
        loginRealConnexPage.verifyConfirmationNeeded();
    }

    @When("I click on 'Ok' button and verify 'Sign In to RealConnex' pop up is displayed")
    public void clickOkButtonAndVerifySignInRealConnexIsDisplayed(){
        loginRealConnexPage.clickOkButtonAndVerifySignInRealConnexIsDisplayed();
    }
}
