package api;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by wamika on 1/29/16.
 */
public class RestService {

    public void getUserData(String userId) {
        given().
            contentType("application/json").
        when().
            get("http://localhost:8080/user/" + userId).
        then().
            body(containsString("id")).
            body(containsString("login")).
            body(containsString("www")).
            statusCode(200);
    }

    public void addNewUser(String login, String www) {
        given().
            contentType("application/json").
            body("{\"login\":\"" + login + "\",\n" +
                    "\"www\":\"" + www + "\"}").
        when().
            post("/addNewUser").
        then().
            body(containsString("id")).
            body(containsString("login")).
            body(containsString("www")).
            statusCode(200);
    }

    public void getHealthcheckPing() {
        when().get("/ping").
        then().
            log().all().
            body(containsString("pong!"));
    }


}
