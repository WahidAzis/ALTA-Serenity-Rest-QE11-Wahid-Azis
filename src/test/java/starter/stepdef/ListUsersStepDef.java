package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;


public class ListUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //GET LIST User
    @Given("Get list {int} as valid parameter page")
    public void gotListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get list {int} as beyond parameter page")
    public void asBeyondParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @Given("Get list {string} as invalid parameters")
    public void gotListUserWithInvalidParameters(String invalidPrmtr) {
        reqresAPI.getListUsers(invalidPrmtr);
    }

    @Given("Get list with empty parameter")
    public void emptyParameter() {
        reqresAPI.getListUsers("");
    }
}

