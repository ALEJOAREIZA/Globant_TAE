package academyapi;

import academyapi.Helpers.CommonMethods;
import academyapi.baseservice.BaseService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/**
 * First API test
 *
 * @author Brayhan.Criollo
 */
public class apiTest {
    Response response;

    @Test
    public void testOne()  {
        BaseService service = new BaseService();
        CommonMethods commonMethods = new CommonMethods();
        Assert.assertEquals(service.get().statusCode(),200);
        if(!commonMethods.isServiceEmpty(service.get())){
            int[] statuscode= service.deleteAll();
            for (int i = 0; i < statuscode.length; i++) {
                Assert.assertEquals(statuscode[i],200);
            }
        }
    }
}