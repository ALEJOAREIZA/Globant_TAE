package academyapi.baseservice;

import academyapi.Helpers.CommonMethods;
import academyapi.pojos.apiPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.tools.xjc.reader.Ring.add;


public class BaseService {

    public Response getAllBankUsers() {
        return RestAssured.get("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users");
    }
    public ArrayList<String> getAllBankUsersemails() {
        try {
            ArrayList<String> usersEmails = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            apiPojo[] bankUsers= mapper.readValue(RestAssured.get("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users").getBody().asString(),apiPojo[].class);
            for (int i = 0; i < bankUsers.length; i++) {
                usersEmails.add(bankUsers[i].getEmail());
            }
            return usersEmails;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public int[] deleteAllBankUsers() {
        try {
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            apiPojo[] bankUserList = mapper.readValue(RestAssured.get("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users").getBody().asString(),apiPojo[].class);
            int[] statusCodearray = new int[bankUserList.length];
            for (int i = 0; i < bankUserList.length; i++) {
                int statusCode=  RestAssured.delete("https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users/"+bankUserList[i].getId()).getStatusCode();
                statusCodearray[i]=statusCode;
            }
            return statusCodearray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[0];
    }
    public int[] createrandomBankUsers(int numberofusers) {
        ArrayList allBankUsersemail = getAllBankUsersemails();
        RestAssured.baseURI = "https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        String bankUserJson = null;
        ObjectMapper Obj = new ObjectMapper();
        ArrayList<String> Email = CommonMethods.randomEmail(numberofusers,allBankUsersemail);
        int[] statusCodearray = new int[numberofusers];
        for (int i = 0; i < numberofusers; i++) {
            apiPojo bankUser = new apiPojo();
            String firstName = CommonMethods.randomName();
            String lastName = CommonMethods.randomLastname();
            String accountNumber = CommonMethods.accountNumber();
            String amount = CommonMethods.amount();
            String PhoneNumber = CommonMethods.randomPhoneNumber();
            String Country = CommonMethods.randomCountry();
            bankUser.setFirst_Name(firstName);
            bankUser.setLast_Name(lastName);
            bankUser.setAccount_Number(accountNumber);
            bankUser.setAmount(amount);
            bankUser.setTransaction_type("any type");
            bankUser.setEmail(Email.get(i));
            bankUser.setActive(true);
            bankUser.setCountry(Country);
            bankUser.setTelephone(PhoneNumber);
            try {
                bankUserJson = Obj.writeValueAsString(bankUser);
                request.body(bankUserJson);
                int statusCode= request.post().getStatusCode();
                statusCodearray[i]=statusCode;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return statusCodearray;
    }
    public int createmanualBankUsers(String myemail) {
        ArrayList allBankUsersemail = getAllBankUsersemails();
        RestAssured.baseURI = "https://5f84baf6c29abd001618fe7c.mockapi.io/api/TAE_bank/bank_users/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        String bankUserJson = null;
        ObjectMapper Obj = new ObjectMapper();
        String Email = CommonMethods.manualEmail(myemail,allBankUsersemail);
        apiPojo bankUser = new apiPojo();
        String firstName = CommonMethods.randomName();
        String lastName = CommonMethods.randomLastname();
        String accountNumber = CommonMethods.accountNumber();
        String amount = CommonMethods.amount();
        String PhoneNumber = CommonMethods.randomPhoneNumber();
        String Country = CommonMethods.randomCountry();
        bankUser.setFirst_Name(firstName);
        bankUser.setLast_Name(lastName);
        bankUser.setAccount_Number(accountNumber);
        bankUser.setAmount(amount);
        bankUser.setTransaction_type("any type");
        bankUser.setEmail(Email);
        bankUser.setActive(true);
        bankUser.setCountry(Country);
        bankUser.setTelephone(PhoneNumber);
            try {
                bankUserJson = Obj.writeValueAsString(bankUser);
                request.body(bankUserJson);
                return request.post().getStatusCode();

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        return 0;
    }
}