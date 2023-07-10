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

public class UpdateUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //PUT Update User
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY+"Update/ValidJobAndName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @And("Response body for update name was {string} and job was {string}")
    public void responseBodyForUpdateNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate put update user json schema")
    public void validatePutUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"Update/UpdateUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user with valid json and invalid id {string}")
    public void putUpdateUserWithValidJsonAndInvalidId(String id) {
        File json = new File(Constants.REQ_BODY+"Update/ValidJobAndName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid json and empty id")
    public void putUpdateUserWithValidJsonAndEmptyId() {
        File json = new File(Constants.REQ_BODY+"Update/ValidJobAndName.json");
        reqresAPI.putUpdateUser("", json);
    }

    @Given("Put update user with empty request body and valid id {int}")
    public void putUpdateUserWithEmptyRequestBodyAndValidId(int id) {
        File json = new File(Constants.REQ_BODY+"Update/WithoutReqBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body without name")
    public void putUpdateUserWithValidIdAndRequestBodyWithoutName(int id) {
        File json = new File(Constants.REQ_BODY+"Update/WithoutName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body without job")
    public void putUpdateUserWithValidIdAndRequestBodyWithoutJob(int id) {
        File json = new File(Constants.REQ_BODY+"Update/WithoutJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with invalid name")
    public void putUpdateUserWithValidIdAndRequestBodyWithInvalidName(int id) {
        File json = new File(Constants.REQ_BODY+"Update/InvalidNameNumberType.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with invalid job")
    public void putUpdateUserWithValidIdAndRequestBodyWithInvalidJob(int id) {
        File json = new File(Constants.REQ_BODY+"Update/InvalidJobNumberType.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with empty name")
    public void putUpdateUserWithValidIdAndRequestBodyWithEmptyName(int id) {
        File json = new File(Constants.REQ_BODY+"Update/EmptyName.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with valid id {int} and request body with empty job")
    public void putUpdateUserWithValidIdAndRequestBodyWithEmptyJob(int id) {
        File json = new File(Constants.REQ_BODY+"Update/EmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @And("Put update user with age {int}")
    public void putUpdateUserWithAge(int age) {
        File json = new File(Constants.REQ_BODY+"Update/AddAge.json");
        reqresAPI.putUpdateUser(age, json);
    }

    @And("Put update user with address {string}")
    public void putUpdateUserWithAddress(String address) {
        File json = new File (Constants.REQ_BODY+"Update/AddAddress.json");
        reqresAPI.putUpdateUser(address, json);
    }
}
