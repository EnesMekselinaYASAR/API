package API_Practice;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 extends Authentication {
    @Test
    public void test06() {

        String url = " http://www.gmibank.com/api/tp-customers/126294";
        Response response = given().headers("Authorization", "Bearer "+generateToken()).when().get(url);

        response.prettyPrint();

        //Matcher Class ile müşteri bilgilerini doğrulayalım
        response.then().assertThat().body("firstName",equalTo("Deneme"),
                "lastName",equalTo("Last"),
                "email",equalTo("ma34@gmail.com"),
                "mobilePhoneNumber",equalTo("123-123-3434"));

        //JsonPath ile müşteri bilgilerini doğrulama

    }
}
