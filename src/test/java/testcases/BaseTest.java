package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;


public class BaseTest {

    protected Response response;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }


    public void sendGetRequest(String path) {
        response = SerenityRest.given().when().get(path);
        response.prettyPrint();
    }

    public void sendPostRequest(Object object, String path) {
        response = SerenityRest.given().contentType(ContentType.JSON)
                .body(object).log().all().when().post(path);
        response.prettyPrint();
    }

    public void sendPutRequest(Object object, String path) {
        response = SerenityRest.given().contentType(ContentType.JSON)
                .body(object).log().all().when().put(path);
        response.prettyPrint();
    }

    public void sendDeleteRequest(String path) {
        response = SerenityRest.given().contentType(ContentType.JSON)
                .log().all().when().delete(path);
        response.prettyPrint();
    }

    public void validateStatusCode(int statusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(statusCode));
        response.prettyPrint();
    }

//    public JsonPath rawToJson(String response) {
//        JsonPath js1 = new JsonPath(response);
//        return js1;
//    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    //if is it map:
    public void verifyResponseBody(String key, String value) {
        SerenityRest.restAssuredThat(response -> response.body(key, Matchers.equalTo(value)));
    }

    public void verifyResponseBodyInt(String key,int value) {
        response.then().body(key, Matchers.equalTo(value));
    }
}
