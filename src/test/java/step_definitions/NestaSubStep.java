package step_definitions;

import company.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;

import org.junit.Assert;
import org.junit.runner.RunWith;
import testcases.BaseTest;


@RunWith(SerenityRunner.class)
public class NestaSubStep  extends BaseTest {
    protected Response response;
    protected Book book;;

    @Step("List all posts for a user")
    public void listPosts() {
        sendGetRequest("/users/1/posts");
        Assert.assertEquals(200, getStatusCode());
    }

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

        NewUser newUser = new NewUser.NewUserBuilder().setUserId(1).setId(1).setName("Mini Max")
                .setEmail("mini_m@gmail.com").setUserName("miniMa").setPhone("123859-85")
                .setAddress(address).setCompany(company)
                .setWebsite("some@website.cpm").build();
        sendPostRequest(newUser, "/users");
        Assert.assertEquals(201, getStatusCode());
    }

    @Step("Delete post")
    public void deletePost() {
        sendDeleteRequest("/posts/100");
    }

    @Step("Create post for a user")
    public void createPost(String name1) {
        book = new Book.BookBuilder().setTitle(name1).setBody("Description").setUserId("1").build();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        sendPostRequest(book, "/users/1/posts");
    }

    @Step("validate if request was successful")
    public void validateResponseTitle(String name) {
        Assert.assertEquals(book.getTitle(), name);
    }


    @Step("Update comments with post request")
    public void updateComment(String name2) {
        book = new Book.BookBuilder().setTitle(name2).setBody("Description89").setUserId("1").build();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        sendPutRequest(book, "/posts/100");
    }

    @Step("Validate status Code")
    public void validateStatusCodeStep(int code) {
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        validateStatusCode(code);
    }

    @Step("Validate response body")
    public void validateResponseBody(String value) {
        verifyResponseBody(book.getTitle(), value);
    }
}