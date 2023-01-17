package step_definitions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import java.io.InputStream;


public class SubSteps {

    protected Response response;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Step("Send Get Request")
    public void sendGetRequest(String path) {
        response = SerenityRest.given().when().get(path);
        response.prettyPrint();
    }

    @Step("Send Post Request")
    public void sendPostRequest(Object object, String path) {
        response = SerenityRest.given().contentType(ContentType.JSON)
                .body(object).log().all().when().post(path);
        response.prettyPrint();
    }

    @Step("Send Put Request")
    public void sendPutRequest(Object object, String path) {
        response = SerenityRest.given().contentType(ContentType.JSON)
                .body(object).log().all().when().put(path);
        response.prettyPrint();
    }

    @Step("Send Delete Request")
    public void sendDeleteRequest(String path) {
        response = SerenityRest.given().contentType(ContentType.JSON)
                .log().all().when().delete(path);
        response.prettyPrint();
    }

    @Step("Validate Status Code")
    public void validateStatusCode(int statusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(statusCode));
        response.prettyPrint();
    }

    //??
    public JsonPath rawToJson() {
        JsonPath js1 = new JsonPath((InputStream) response);
        return js1;
    }

    @Step("Get Status Code")
    public int getStatusCode() {
        return response.getStatusCode();
    }

    @Step("Verify Response Body")
    public void verifyResponseBody(String key, String value) {
//        SerenityRest.restAssuredThat(response -> response.body(key, Matchers.equalTo(value)));
        response.then().body(key, Matchers.equalTo(value));
    }

    @Step("Verify Response Body Integer")
    public void verifyResponseBodyInt(String key,int value) {
        response.then().body(key, Matchers.equalTo(value));
    }
}
