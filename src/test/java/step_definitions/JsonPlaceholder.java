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
    @And("^Post a photo with title (.*)$")
    public void post_a_photo(String title) {
        nestaStep.postAPhoto(title);
    }
    @Then("New album with photos is created")
    public void new_album_with_photos_is_created() {
        nestaStep.getPhoto();
    }
    @When("User update a post and delete a photo")
    public void user_update_a_post_and_delete_a_photo() {
        nestaStep.updatePost();
        nestaStep.deletePhoto();
    }
    @Then("Post is successfully changed")
    public void post_is_successfully_changed() {
        nestaStep.validateStatusCodeStep(200);
    }

    @When("^Photo is successfully deleted$")
    public void photo_is_deleted() {
        nestaStep.validateStatusCodeStep(200);
    }
}