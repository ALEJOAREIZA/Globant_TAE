package com.shopping.APIautomation.baseService;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.APIautomation.pojos.apiPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.jboss.netty.handler.codec.base64.Base64Encoder;
import org.testng.Assert;


import java.util.ArrayList;

import static io.restassured.RestAssured.given;


public class shoppingService  {

    public void createProduct(){

        String apiproductJson = null;
        ObjectMapper Obj = new ObjectMapper();
        apiPojo apiproduct = new apiPojo();

        RestAssured.baseURI = "http://34.205.174.166/wp-json/wc/v3/products";

        RequestSpecification request = RestAssured.given();
        apiproduct.setname("AlejandroAreiza");
        apiproduct.settype("simple");
        apiproduct.setregular_price("10.99");
        apiproduct.setdescription("Tae");
        apiproduct.setshort_description("Tae");

       try {
            apiproductJson = Obj.writeValueAsString(apiproduct);
            request.auth().basic("c2hvcG1hbmFnZXI=","YXhZMiByaW1jIFN6TzkgY29iZiBBWkJ3IE5Mblg=");
            request.contentType("application/json");
            request.body(apiproductJson);
            int statusCode= request.post().getStatusCode();
           //Assert.assertEquals(statusCode,200);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

//    public Response createProduct(){
//
//    }
//    public Response deleteProduct(){
//
//    }

}
