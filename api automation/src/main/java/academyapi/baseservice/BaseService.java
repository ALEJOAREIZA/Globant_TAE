package academyapi.baseservice;

import academyapi.pojos.apiPojo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.sun.tools.xjc.reader.Ring.add;


public class BaseService {



    public Response get() {
        return RestAssured.get("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users");
    }
    public int[] deleteAll() {
        try {
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
            apiPojo[] apiList = mapper.readValue(RestAssured.get("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users").getBody().asString(),apiPojo[].class);
            int[] statusCodearray = new int[apiList.length];
            for (int i = 0; i < apiList.length; i++) {
                int statusCode=  RestAssured.delete("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users/"+apiList[i].getId()).getStatusCode();
                statusCodearray[i]=statusCode;
            }
            return statusCodearray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0];
    }
}