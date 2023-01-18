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

    @And("Created an album")
    public void created_an_album() {
        nestaStep.createAlbum();
        nestaStep.getAlbum();
    }
    @And("^Upload a photo (.*) with name (.*)$")
    public void upload_a_photo(String url, String title) {
        nestaStep.postAPhoto(url, title);
        nestaStep.getPhoto();
    }
    @Then("New album with photos is created")
    public void new_album_with_photos_is_created() {
        nestaStep.verifyIfAlbumWithPhotosIsCreated();
    }
    @When("^User update a photo (.*) with name (.*)$")
    public void user_update_photo(String title, String url) {
        nestaStep.updatePhoto(title, url);
    }
    @Then("New photo is uploaded")
    public void new_photo_is_uploaded() {
        nestaStep.getPhoto();
        nestaStep.validateStatusCodeStep(200);
    }
    @When("User delete a photo")
    public void user_delete_photo() {
        nestaStep.deletePhoto();
    }

    @When("^Photo is successfully deleted$")
    public void photo_is_deleted() {
        nestaStep.validateStatusCodeStep(200);
    }
}