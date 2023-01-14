package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class StepDefinition {

    @Steps
    NestaSubStep nestaSubStep;

    @Given("New user is created")
    public void new_user_is_created() {
        nestaSubStep.createNewUser();
    }

    @Given("List all posts for a user")
    public void list_all_posts_for_a_user() {
        nestaSubStep.listPosts();
    }

    @When("^User create post with name (.*)$")  //creates, post
    public void user_create_post_with_request(String name1) {
        nestaSubStep.createPost(name1);
    }

    @Then("^The post with name (.*) is (.*)$")
    public void the_comment_with_name_is(String name, String action) {
        nestaSubStep.validateResponseTitle(name);
    }

    @When("^User update post with name (.*)$")
    public void user_update_post_with_request(String name2) {
        nestaSubStep.updateComment(name2);
    }

    @And("^The API call is success with a (.*) status code$")
    public void the_api_call_is_success_with_a_status_code(int statusCode) {
        nestaSubStep.validateStatusCodeStep(statusCode);
    }

    @And("^(.*) in response body is (.*)$")
    public void id_in_response_body_is(String key, int value) {
        nestaSubStep.verifyResponseBodyInt(key, value);
    }

    @When("^User delete post with delete request$")
    public void userPostWithRequest() {
        nestaSubStep.deletePost();
    }
}