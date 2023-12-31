package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage=new HomePage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();
    }

    @Then("The user verifies welcome miky")
    public void the_user_verifies_welcome_miky() {
        homePage.verifyLogin();
    }
    @When("The user enters {string} and {string} and click login button")
    public void the_user_enters_and_and_click_login_button(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("The user verifies welcome {string}")
    public void the_user_verifies_welcome(String expectedUsername) {
        homePage.verifyLogin(expectedUsername);
    }
    @When("The user enters valid username and password")
    public void the_user_enters_valid_username_and_password(Map<String,String> userInfo) {
        loginPage.login(userInfo.get("username"),userInfo.get("password"));

    }


    @Then("The user verifies invalid access {string}")
    public void theUserVerifiesInvalidAccess(String expectedMessage) {
        loginPage.verifyWithPopUpMessage(expectedMessage);
    }
}

