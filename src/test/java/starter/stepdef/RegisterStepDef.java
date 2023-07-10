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

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //POST Register User
    @Given("Register new user with valid json")
    public void registerNewUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+ "Register/ValidInputReqBody.json");
        reqresAPI.registerUser(json);
    }

    @When("Send post register user")
    public void sendPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Response body token exist")
    public void responseBodyTokenExist() {
        SerenityRest.and().body(ReqresResponses.TOKEN, notNullValue());
    }

    @And("Validate successful post register user json schema")
    public void validateSuccessfulPostRegisterUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+ "Register/SuccessfulRegister.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Register new user without request body email")
    public void registerNewUserWithoutRequestBodyEmail() {
        File json = new File(Constants.REQ_BODY+ "Register/WithoutEmailReqBody.json");
        reqresAPI.registerUser(json);
    }

    @And("Response body error message was {string}")
    public void responseBodyErrorMessageWas(String errorMssge) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(errorMssge));
    }

    @And("Validate unsuccessful post register user json schema")
    public void validatePostUnsuccessfulRegisterUser() {
        File json = new File(Constants.JSON_SCHEMA + "Register/UnsuccessfulRegister.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Register new user without request body password")
    public void registerNewUserWithoutRequestBodyPassword() {
        File json = new File(Constants.REQ_BODY+ "Register/WithoutPasswordReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user empty request body")
    public void registerNewUserWithoutRequestBodyEmailAndPassword() {
        File json = new File(Constants.REQ_BODY+ "Register/WithoutReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with invalid format email")
    public void registerNewUserWithInvalidFormatEmail() {
        File json = new File(Constants.REQ_BODY+ "Register/InvalidEmailReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with invalid password")
    public void registerNewUserWithInvalidPassword() {
        File json = new File(Constants.REQ_BODY+ "Register/InvalidPasswordReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with invalid email and password")
    public void registerNewUserWithInvalidEmailAndPassword() {
        File json = new File(Constants.REQ_BODY+ "Register/InvalidEmailAndPassword.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with empty password")
    public void registerNewUserWithEmptyPassword() {
        File json = new File(Constants.REQ_BODY+ "Register/EmptyPasswordReqBody.json");
        reqresAPI.registerUser(json);
    }

    @Given("Register new user with empty email")
    public void registerNewUserWithEmptyEmail() {
        File json = new File(Constants.REQ_BODY+ "Register/EmptyEmailReqBody.json");
        reqresAPI.registerUser(json);
    }
}
