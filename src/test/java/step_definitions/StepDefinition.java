package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefinition {

    @Steps
    NestaSubStep nestaSubStep;

    @Steps
    SubSteps subSteps;

    @Given("New user is created")
    public void new_user_is_created() {
        nestaSubStep.createNewUser();
    }
    @When("^User (.*) comments with (.*) request$")  //creates, post
    public void user_comments_with_request(String action, String requestMethod) {
        if (action.equalsIgnoreCase("create")) {
            System.out.println("create Comment");
            nestaSubStep.createComment();
        } else if (action.equalsIgnoreCase("update")) {
            System.out.println("update Comment");
            nestaSubStep.updateComment();
        }
    }
    @Then("^The comment with name (.*) is (.*)$")
    public void the_comment_with_name_is(String name1, String action) {
        System.out.println("Then");
    }
    @And("^The API call is success with a (.*) status code$")
    public void the_api_call_is_success_with_a_status_code(int statusCode) {
        nestaSubStep.validateStatusCodeStep(statusCode);
    }

    @When("^User (.*) comment to (.*) with (.*) request$")
    public void user_comment_to_with_request(String action, String name, String requestMethod) {
        System.out.println("When");
    }
    @And("^(.*) in response body is (.*)$")
    public void id_in_response_body_is(String key,int value) {
        System.out.println("nestaSubStep.verifyResponseBodyInt(key, value);");
        nestaSubStep.verifyResponseBodyInt(key, value);
    }

    @When("^User (.*) post with (.*) request$")
    public void userPostWithRequest(String action, String requestMethod) {
    }
}

//feature fajl treba samo smoke biti flow - given when than and (edited)
//to treba da poziva klasu kao STEP metodu koja sadrzi @When("bla bla bla bla"), ispod toga metoda naravno
//u toj metodi ide pozivi na drugu klasu nazovi je NestaSubStep
//u tome radis onda sta zelis sa resursima
//to bi bilo npr NestedSubStep.createBody() koaj kreira body u toj. klasi
//onda iams drugu metodu npr NestesSubStep.postBlaBlaBla(Body onaj) ona uzme taj body i sta jos vec ti treba i uradi post itd