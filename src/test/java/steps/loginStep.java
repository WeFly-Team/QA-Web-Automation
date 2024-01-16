package steps;

import factories.driverManager;
import helpers.keyword;
import pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {

    private loginPage getLoginPage() {
        return new loginPage(driverManager.getInstance().getDriver());
    }

    @When("user input valid email")
    public void inputValidEmail() {
        getLoginPage().inputEmail("sa@dispostable.com");
    }

    @When("user input unregistered email")
    public void inputUnregisteredEmail() {
        getLoginPage().inputEmail("sa@dispostable.com");
    }

    @When("user input email without @")
    public void userinputInvalidEmail() {
        loginPage loginPage = getLoginPage();
        loginPage.clickLogin();
        loginPage.inputEmail("shidqiadiatma.com");
    }

    @And("user input correct password")
    public void inputCorrectPassword() {
        getLoginPage().inputPassword("Password123");
    }

    @And("user input incorrect password")
    public void inputIncorrectPassword() {
        getLoginPage().inputPassword("Password123");
    }

    @And("user click Login button")
    public void clickLoginButton() {
        getLoginPage().clickLogin();
    }

    @Then("user should be successfully login")
    public void userSuccessLogin() {
        getLoginPage().clickCheckbox(); // example
    }

    @Then("user should see an snackbar error message")
    public void userFailedLogin() {
        getLoginPage().alertSnackbarMessage("User not found or password didn't match");
    }

    @Then("user should see an error message indicating empty fields")
    public void userEmptyField() {
        getLoginPage().alertInlineMessageForEmptyScenario("Email is required", "Password is required");
    }

    @Then("user should see an error message indicating invalid email format")
    public void userSeeInlineEmail() {
        getLoginPage().alertInlineMessageForInvalidFormatEmail("Please input a valid email format");
    }
}