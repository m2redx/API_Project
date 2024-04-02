import org.junit.jupiter.api.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import static io.restassured.RestAssured.given;

public class GetRequestTests {

    ExtentReports extent = new ExtentReports();
    ExtentTest test = extent.createTest("GET Request Test", "Test for HTTP GET request");

    @Test
    public void getRequestTest(){
      int statusCode = given()
              .when()
              .get("https://generator.swagger.io/api/gen/clients")
                      .getStatusCode();

        if (statusCode == 200) {
            test.log(Status.PASS, "GET isteği başarıyla tamamlandı! Durum kodu: " + statusCode);
        } else {
            test.log(Status.FAIL, "GET isteği başarısız oldu! Durum kodu: " + statusCode);
        }

        extent.flush();
    }
}
