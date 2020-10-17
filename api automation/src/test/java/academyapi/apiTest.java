package academyapi;

import academyapi.Helpers.CommonMethods;
import academyapi.baseservice.BaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class apiTest {


    @Test(priority = 0)
    public void testOne()  {
        BaseService service = new BaseService();
        CommonMethods commonMethods = new CommonMethods();
        Assert.assertEquals(service.getAllBankUsers().statusCode(),200);
        if(!commonMethods.isEndPointEmpty(service.getAllBankUsers())){
            int[] statuscode= service.deleteAllBankUsers();
            for (int i = 0; i < statuscode.length; i++) {
                Assert.assertEquals(statuscode[i],200);
            }
        }
    }

    @Test(priority = 1)
    public void testTwo() {
        BaseService service = new BaseService();
        CommonMethods commonMethods = new CommonMethods();
        Assert.assertEquals(service.getAllBankUsers().statusCode(),200);
        int[] statusCode = service.createrandomBankUsers(20);
        for (int i = 0; i < statusCode.length; i++) {
            Assert.assertEquals(statusCode[i],201);
        }
    }

    @Test(priority = 2)
    public void testThree() {
        BaseService service = new BaseService();
        CommonMethods commonMethods = new CommonMethods();
        Assert.assertEquals(service.getAllBankUsers().statusCode(),200);
//        int[] statuscode= service.deleteAllBankUsers();
//        for (int i = 0; i < statuscode.length; i++) {
//            Assert.assertEquals(statuscode[i],200);
//        }
        int statusCode1 = service.createmanualBankUsers("example1@gmail.com");
        Assert.assertEquals(statusCode1,201);
        int statusCode2 = service.createmanualBankUsers("example2@gmail.com");
        Assert.assertEquals(statusCode2,201);
        int statusCode3 = service.createmanualBankUsers("example1@gmail.com");
        Assert.assertEquals(statusCode3,201);
        int statusCode4 = service.createmanualBankUsers("example2@gmail.com");
        Assert.assertEquals(statusCode4,201);

    }

}