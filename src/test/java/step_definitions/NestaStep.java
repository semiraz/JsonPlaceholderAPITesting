package step_definitions;

import company.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;

import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class NestaStep {

    @Steps
    SubSteps subSteps;
    protected Response response;
    protected NewUser newUser;
    protected Book book;
    protected Album album;
    protected Photo photo;
    protected int idUser;
    protected int idAlbum;
    protected int idPhoto;

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
        JsonPath js = subSteps.rawToJson();
        idUser = js.get("id");
    }


    @Step("Create post for a user")
    public void createPost() {
        book = new Book.BookBuilder().setTitle("post 1").setBody("Description").build();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        subSteps.sendPostRequest(book, "/users/" + (idUser-1) + "/posts");
    }

    @Step("Get all posts fo a user")
    public void getAllPosts() {
        System.out.println("idUser = ***" + idUser);
        subSteps.sendGetRequest("posts/" + (idUser-1));
        subSteps.validateStatusCode(200);
    }

    @Step("Create an album for a user")
    public void createAlbum() {
        album = new Album.AlbumBuilder().setTitle("album1").build();
        subSteps.sendPostRequest(album, "/users/" + (idUser-1) + "/albums");
        idAlbum = album.getId();
        subSteps.verifyResponseBodyInt("id", album.getId());
        subSteps.validateStatusCode(201);
    }

    @Step("Get an album for a user")
    public void getAlbum() {
        subSteps.sendGetRequest("/albums/" + (idAlbum-1));
        subSteps.verifyResponseBodyInt("id", idAlbum-1);
        subSteps.validateStatusCode(200);
    }

    @Step("Post a photo")
    public void postAPhoto() {
        photo = new Photo.PhotoBuilder().setTitle("dog photo").setUrl("https://via.placeholder.com/600/92c952")
                .setThumbnailUrl("https://via.placeholder.com/150/92c952").build();
        subSteps.sendPostRequest(photo, "/albums/" + (idAlbum-1) + "/photos");
        idPhoto = photo.getId();
        subSteps.verifyResponseBodyInt("id", album.getId());
        subSteps.validateStatusCode(201);
    }

    @Step("Get a photo for a user")
    public void getPhoto() {
        subSteps.sendGetRequest("/photos/" + (idPhoto-1));
        subSteps.verifyResponseBodyInt("id", idPhoto-1);
        subSteps.validateStatusCode(200);
    }

    @Step("Validate if request was successful")
    public void validateResponseTitle(String name) {
        Assert.assertEquals(book.getTitle(), name);
    }


    @Step("Update post")
    public void updatePost() {
        book = new Book.BookBuilder().setTitle("post 2").setBody("Description89").setUserId("1").build();
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        subSteps.sendPutRequest(book, "/posts/" + (idUser-1));
        subSteps.verifyResponseBody("title", book.getTitle());
        subSteps.validateStatusCode(200);
    }

    @Step("Delete post")
    public void deletePost() {
        subSteps.sendDeleteRequest("/posts/100");
    }

    @Step("Validate status Code")
    public void validateStatusCodeStep(int code) {
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        subSteps.validateStatusCode(code);
    }

    @Step("Validate response body")
    public void validateResponseBody(String value) {
        subSteps.verifyResponseBody(book.getTitle(), value);
    }
}