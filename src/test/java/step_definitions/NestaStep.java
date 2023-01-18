package step_definitions;

import company.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;

import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class NestaStep {

    @Steps
    SubSteps subSteps;
    protected NewUser newUser;
    protected Book book;
    protected Album album;
    protected Photo photo;
    protected int idUser;
    protected int idAlbum;
    protected int idPhoto;
    protected JsonPath js;
    protected String titlePhoto;

    @Step("Create new user")
    public void createNewUser() {
        Geo geo = new Geo();
        geo.setLat("123 857");
        geo.setLng("859 854");
        Address address = new Address();
        address.setCity("Sarajevo");
        address.setStreet("Mein Street 85");
        address.setGeo(geo);
        Company company = new Company();
        company.setName("Company Name Nice");

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        newUser = new NewUser.NewUserBuilder().setName("Mini Max")
                .setEmail("mini_m@gmail.com").setUserName("miniMa").setPhone("123859-85")
                .setAddress(address).setCompany(company)
                .setWebsite("some@website.cpm").build();
        subSteps.sendPostRequest(newUser, "/users");

        Assert.assertEquals(201, subSteps.getStatusCode());
        subSteps.verifyResponseBodyInt("id", 11);
        js = subSteps.rawToJson();
        idUser = js.get("id");
    }
//
//    @Step("Create post for a user")
//    public void createPost() {
//        book = new Book.BookBuilder().setTitle("post 1").setBody("Description").build();
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
//        subSteps.sendPostRequest(book, "/users/" + (idUser-1) + "/posts");
//    }

    @Step("Create an album for a user")
    public void createAlbum() {
        album = new Album.AlbumBuilder().setTitle("album1").build();
        subSteps.sendPostRequest(album, "/users/" + (idUser-1) + "/albums");
        js = subSteps.rawToJson();
        idAlbum = js.get("id");
        subSteps.verifyResponseBodyInt("id", idAlbum);
        subSteps.validateStatusCode(201);
    }

    @Step("Get an album for a user")
    public void getAlbum() {
        subSteps.sendGetRequest("/albums/" + (idAlbum-1));
        subSteps.verifyResponseBodyInt("id", idAlbum-1);
        subSteps.validateStatusCode(200);
    }

    @Step("Post a photo")
    public void postAPhoto(String url, String title) {
        photo = new Photo.PhotoBuilder().setTitle(title).setUrl(url)
                .setThumbnailUrl("https://via.placeholder.com/150/92c952").build();
        subSteps.sendPostRequest(photo, "/albums/" + (idAlbum-1) + "/photos");
        js = subSteps.rawToJson();
        idPhoto = js.get("id");
        titlePhoto = js.get("title");
        subSteps.verifyResponseBodyInt("id", idPhoto);
        subSteps.verifyResponseBody("title", titlePhoto);
        subSteps.validateStatusCode(201);
    }

    @Step("Update photo")
    public void updatePhoto(String title, String url) {
        photo = new Photo.PhotoBuilder().setTitle(title).setUrl(url)
                .setThumbnailUrl("https://via.placeholder.com/150/92c952").build();
        subSteps.sendPutRequest(photo, "/photos/" + (idPhoto - 1));
        js = subSteps.rawToJson();
        titlePhoto = js.get("title");
        subSteps.verifyResponseBody("title", titlePhoto);
        subSteps.validateStatusCode(200);
    }

    @Step("Get a photo for a user")
    public void getPhoto() {
        subSteps.sendGetRequest("/photos/" + (idPhoto-1));
        subSteps.verifyResponseBodyInt("id", idPhoto-1);
        subSteps.validateStatusCode(200);
    }

    @Step("New album with photos is created")
    public void verifyIfAlbumWithPhotosIsCreated() {
        subSteps.verifyResponseBodyInt("id", idPhoto-1);
        subSteps.validateStatusCode(200);
        js = subSteps.rawToJson();
        titlePhoto = js.get("title");
    }

    @Step("Delete photo")
    public void deletePhoto() {
        subSteps.sendDeleteRequest("/photos/" + (idPhoto-1));
        subSteps.validateStatusCode(200);
    }

    @Step("Validate status Code")
    public void validateStatusCodeStep(int code) {
        subSteps.validateStatusCode(code);
    }

    @Step("Validate response body")
    public void validateResponseBody(String value) {
        subSteps.verifyResponseBody(book.getTitle(), value);
    }
}