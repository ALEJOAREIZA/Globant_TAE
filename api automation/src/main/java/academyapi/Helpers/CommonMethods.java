package academyapi.Helpers;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.regex.Pattern;

public class CommonMethods {

    public boolean isServiceEmpty(Response reponse){
        String body = reponse.getBody().asString().replaceAll("[\\[-\\]]","");
        return body.isEmpty();
    }
}
