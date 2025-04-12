import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RequestMethodsTests {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.config = RestAssuredConfig.config()
                .encoderConfig(EncoderConfig.encoderConfig()
                        .defaultContentCharset("UTF-8"));
    }

    @Test
    public void testGetMethod() {
        Response response = RestAssured.given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get");

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals("bar1", jsonPath.getString("args.foo1"));
        assertEquals("bar2", jsonPath.getString("args.foo2"));
        assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", jsonPath.getString("url"));
    }

    @Test
    public void testPostMethod() {
        String requestBody = "Тестовое сообщение";

        Response response = RestAssured.given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .post("/post");

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals(requestBody, jsonPath.getString("data"));
        assertEquals("https://postman-echo.com/post", jsonPath.getString("url"));
    }

    @Test
    public void testPostFormMethod() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .body("foo1=bar1&foo2=bar2")
                .post("/post");

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals("bar1", jsonPath.getString("form.foo1"));
        assertEquals("bar2", jsonPath.getString("form.foo2"));
        assertEquals("bar1", jsonPath.getString("json.foo1"));
        assertEquals("bar2", jsonPath.getString("json.foo2"));
    }

    @Test
    public void testPutMethod() {
        String requestBody = "Тестовое сообщение";

        Response response = RestAssured.given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .put("/put");

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals(requestBody, jsonPath.getString("data"));
        assertEquals("https://postman-echo.com/put", jsonPath.getString("url"));
    }

    @Test
    public void testPatchMethod() {
        String requestBody = "Тестовое сообщение";

        Response response = RestAssured.given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .patch("/patch");

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals(requestBody, jsonPath.getString("data"));
        assertEquals("https://postman-echo.com/patch", jsonPath.getString("url"));
    }

    @Test
    public void testDeleteMethod() {
        String requestBody = "Тестовое сообщение";

        Response response = RestAssured.given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .delete("/delete");

        assertEquals(200, response.getStatusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals(requestBody, jsonPath.getString("data"));
        assertEquals("https://postman-echo.com/delete", jsonPath.getString("url"));
    }
}