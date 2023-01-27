package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class JsonPlaceholder {

    @Steps
    NestaStep nestaStep;

    @Given("user has created an account")
    public void user_has_created_an_account() {
        nestaStep.createNewUser();
    }

    @And("user has created an album")
    public void user_created_an_album() {
        nestaStep.createAlbum();
        nestaStep.getAlbum();
    }
    @And("^user uploads a photo (.*) with name (.*)$")
    public void user_upload_a_photo(String url, String title) {
        nestaStep.postAPhoto(url, title);
        nestaStep.getPhoto();
    }
    @And("a new album with photos is created")
    public void new_album_with_photos_is_created() {
        nestaStep.verifyIfAlbumWithPhotosIsCreated();
    }
    @When("^user updates a photo (.*) with name (.*)$")
    public void user_updates_photo(String title, String url) {
        nestaStep.updatePhoto(title, url);
    }
    @And("a new photo is uploaded")
    public void new_photo_is_uploaded() {
        nestaStep.getPhoto();
        nestaStep.validateStatusCodeStep(200);
    }
    @Then("user deletes a photo")
    public void user_deletes_photo() {
        nestaStep.deletePhoto();
    }

    @And("^the photo is successfully deleted$")
    public void photo_is_deleted() {
        nestaStep.validateStatusCodeStep(200);
    }
}