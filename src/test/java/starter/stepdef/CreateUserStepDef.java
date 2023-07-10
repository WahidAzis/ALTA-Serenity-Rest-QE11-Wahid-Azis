package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //POST Create User
    @Given("Post create new user with valid json")
    public void postCreateNewUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"Create/ValidJobAndName.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int create) {
        SerenityRest.then().statusCode(create);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job){
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate post create user json schema")
    public void validatePostCreateUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"Create/CreateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create new user without request body")
    public void postCreateNewUserWithoutRequestBody() {
        File json = new File(Constants.REQ_BODY+"Create/WithoutReqBody.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post create new user without job")
    public void postCreateNewUserWithoutJob() {
        File json = new File(Constants.REQ_BODY+"Create/WithoutJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Post create new user without name")
    public void postCreateNewUserWithoutName() {
        File json = new File(Constants.REQ_BODY+"Create/WithoutName.json");
        reqresAPI.postCreateUser(json);
    }
}
