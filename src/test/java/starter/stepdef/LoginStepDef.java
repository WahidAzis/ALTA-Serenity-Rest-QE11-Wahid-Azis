package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //POST Login User
    @Given("Login user with valid json")
    public void loginUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+ "Login/ValidInputReqBody.json");
        reqresAPI.loginUser(json);
    }

    @When("Send post login user")
    public void sendPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Response body token exist for login")
    public void responseBodyTokenExistForLogin() {
        SerenityRest.and().body(ReqresResponses.TOKEN, notNullValue());
    }

    @And("Validate successful post login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+ "Login/SuccessfulLoginJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user without request body password")
    public void loginUserWithoutRequestBodyPassword() {
        File json = new File(Constants.REQ_BODY+ "Login/WithoutPasswordReqBody.json");
        reqresAPI.loginUser(json);
    }

    @And("Response body error message was {string} for login")
    public void responseBodyErrorMessageWasForLogin(String errorMssge) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(errorMssge));
    }

    @And("Validate post unsuccessful login user json schema")
    public void validatePostUnsuccessfulLoginUser() {
        File json = new File(Constants.JSON_SCHEMA+ "Login/UnsuccessfulLoginJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Login user without request body email")
    public void loginUserWithoutRequestBodyEmail() {
        File json = new File(Constants.REQ_BODY+ "Login/WithoutEmailReqBody.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user without request body email and password")
    public void loginUserWithoutRequestBodyEmailAndPassword() {
        File json = new File(Constants.REQ_BODY+ "Login/WithoutReqBody.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login for unregistered user")
    public void loginForUnregisteredUser() {
        File json = new File(Constants.REQ_BODY+ "Login/UnregisteredUser.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user with invalid format email")
    public void loginUserWithInvalidFormatEmail() {
        File json = new File(Constants.REQ_BODY+ "Login/InvalidEmailReqBody.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user with email number type data")
    public void loginUserWithEmailNumberTypeData() {
        File json = new File(Constants.REQ_BODY+ "Login/NumberEmailReqBody.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user with invalid password")
    public void loginUserWithInvalidPassword() {
        File json = new File(Constants.REQ_BODY+ "Login/InvalidPasswordReqBody.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user with invalid email and password")
    public void loginUserWithInvalidEmailAndPassword() {
        File json = new File(Constants.REQ_BODY+ "Login/InvalidEmailAndPassword.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user with empty password")
    public void loginUserWithEmptyPassword() {
        File json = new File(Constants.REQ_BODY+ "Login/EmptyPasswordReqBody.json");
        reqresAPI.loginUser(json);
    }

    @Given("Login user with empty email")
    public void loginUserWithEmptyEmail() {
        File json = new File(Constants.REQ_BODY+ "Login/EmptyEmailReqBody.json");
        reqresAPI.loginUser(json);
    }
}
