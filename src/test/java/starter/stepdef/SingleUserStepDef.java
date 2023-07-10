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

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //GET SINGLE User
    @Given("Single user with id {int}")
    public void singleUserWithId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"SingleUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response body id was {int} and email was {string}")
    public void responseBodyIdWasAndEmailWas(int id, String email) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID,equalTo(id))
                .body(ReqresResponses.DATA_EMAIL,equalTo(email));
    }

    @And("Response body contains {} {} {} {}")
    public void responseBodyContains(String email, String first_name, String last_name, String avatar) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_EMAIL, equalTo(email))
                .body(ReqresResponses.FIRTS_NAME, equalTo(first_name))
                .body(ReqresResponses.LAST_NAME, equalTo(last_name))
                .body(ReqresResponses.AVATAR, equalTo(avatar));
    }

    @Given("Single user with unregistered id {int}")
    public void singleUserWithUnregisteredId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @Given("Single user with invalid id {string}")
    public void singleUserWithInvalid(String id) {
        reqresAPI.getSingleUser(id);
    }

    @Given("Single with empty id")
    public void singleWithEmptyId() {
        reqresAPI.getSingleUser("");
    }
}
