package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //DELETE User
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Delete user with beyond parameter id {int}")
    public void deleteUserWithExceededParameterId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user with invalid parameter id {}")
    public void deleteUserWithInvalidParameterId(String id) {
        reqresAPI.deleteUser(id);
    }

    @Given("Delete user with empty parameter id")
    public void deleteUserWithEmptyParameterId() {
        reqresAPI.deleteUser("");
    }
}
