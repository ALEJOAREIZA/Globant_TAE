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
        if(commonMethods.isEndPointEmpty(service.getAllBankUsers())){
            int[] statusCode = service.createBankUsers(20);
            for (int i = 0; i < statusCode.length; i++) {
                Assert.assertEquals(statusCode[i],201);
            }
        }
    }

}