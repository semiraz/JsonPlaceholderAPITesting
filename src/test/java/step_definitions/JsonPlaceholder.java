package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class JsonPlaceholder {

    @Steps
    NestaStep nestaStep;

    @Given("User has created an account")
    public void user_has_created_an_account() {
        nestaStep.createNewUser();
    }
    @When("User create a post")
    public void user_create_a_post() {
        nestaStep.createPost();
        nestaStep.getAllPosts();
    }
    @And("Create an album")
    public void create_an_album() {
        nestaStep.createAlbum();
        nestaStep.getAlbum();
    }
    @And("Post a photo")
    public void post_a_photo() {
        nestaStep.postAPhoto();
        nestaStep.getPhoto();
    }
    @Then("New album with photos is created")
    public void new_album_with_photos_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User update a post")
    public void user_update_a_post() {

    }
    @Then("Post is successfully changed")
    public void post_is_successfully_changed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

//    @When("^User delete post with delete request$")
//    public void userPostWithRequest() {
//        nestaStep.deletePost();
//    }
}