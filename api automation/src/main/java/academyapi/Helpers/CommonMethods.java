package academyapi.Helpers;
import academyapi.pojos.apiPojo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CommonMethods {

    public boolean isEndPointEmpty(@NotNull Response reponse){
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            apiPojo[] apiList = mapper.readValue(reponse.getBody().asString(),apiPojo[].class);
            return apiList.length <= 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String randomPhoneNumber(){
        Faker faker = new Faker();
        return faker.phoneNumber().cellPhone();
    }
    public static String randomName(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }
    public static String randomLastname(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }
    public static String randomCountry(){
        Faker faker = new Faker();
        return faker.address().country();
    }
    public static ArrayList<String> randomEmail(int numberofemails){
        String email;
        ArrayList<String> emails = new ArrayList<>();
        Faker faker = new Faker();
        while(!(emails.size() ==numberofemails)){
            for (int i = 0; i <numberofemails; i++) {
                email = faker.superhero().name().replace(" ","")+"@tae.com";
                //email = "example@gmail.com";
                while (!emails.contains(email)) {
                    emails.add(email);
                    System.out.println(i + 1 + ". email added: " + email);
                }
            }
        }
        return emails;
    }
    public static String accountNumber(){
        Faker faker = new Faker();
        return String.valueOf(faker.number().numberBetween(100000,500000));

    }
    public static String amount(){
        Faker faker = new Faker();
        return  String.valueOf(faker.number().numberBetween(1000000,50000000));
    }
}
