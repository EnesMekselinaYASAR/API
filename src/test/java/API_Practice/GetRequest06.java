package API_Practice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

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
        JsonPath json = response.jsonPath();
        assertEquals("Deneme",json.getString("firstName"));
        assertEquals("Last",json.getString("lastName"));
        assertEquals("ma34@gmail.com",json.getString("email"));
        assertEquals("123-123-3434",json.getString("mobilePhoneNumber"));

    }
}
