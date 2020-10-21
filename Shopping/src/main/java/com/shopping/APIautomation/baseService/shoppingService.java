package com.shopping.APIautomation.baseService;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static com.sun.tools.xjc.reader.Ring.add;



public class shoppingService  {

    public void authenticate(int id){

                given().auth()
                        .basic("shopmanager", "axY2 rimc SzO9 cobf AZBw NLnX")
                        .when()
                        .header("Accept", ContentType.JSON.getAcceptHeader())
                        .contentType(ContentType.JSON)
                        .get("http://34.205.174.166/wp-json/wc/v3/products/");
//                        .then()
//                        .assertThat()
//                        .statusCode(HttpStatus.SC_OK);
    }
    public Response getProducts(int id){
            Response product =  RestAssured.get("/wp-json/wc/v3/products"+id);
            //Assert.assertEquals(product.getStatusCode(),200);
            return product;
    }
//    public Response createProduct(){
//
//    }
//    public Response deleteProduct(){
//
//    }

}
