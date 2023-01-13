package step_definitions;

import company.*;
import io.cucumber.junit.CucumberSerenityRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import testcases.BaseTest;


@RunWith(SerenityRunner.class)
public class NestaSubStep  extends BaseTest {
//    private static final String basePath = "https://jsonplaceholder.typicode.com";
    protected Response response;


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
        validateStatusCode(201);
    }

    @Step("Delete post")
    public void deletePost() {
        sendDeleteRequest("/posts/101");
    }

    @Step("Create comments with post request")
    public void createComment() {
        Book book = new Book.BookBuilder().setTitle("Title1").setBody("Description").setUserId("1").build();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        sendPostRequest(book, "/users/1/posts");
    }

    @Step("Update comments with post request")
    public void updateComment() {
        Book book = new Book.BookBuilder().setTitle("Title12").setBody("Description89").setUserId("1").build();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        sendPutRequest(book, "/posts/5");
    }

    @Step("Validate status Code")
    public void validateStatusCodeStep(int code) {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        validateStatusCode(code);
    }
}






