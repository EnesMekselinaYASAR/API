package API_Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {
    @Test
    public void test05(){
        //token oluşturma ve authorized login
        //bütün müşteri bilgilerine bu şekilde ulaşabiliyoruz

        String url ="https://www.gmibank.com/api/tp-customers";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2OTMzMzY3NzZ9.H865q0p_yhhDIJ7Mpl88uLDOU_6OEzhNiO4eNRLPofzdgmznkGlq0g4MVf1MfNaZgfWyJM-pRH6gqU-ONDBZGw";
        Response response = given().headers("Authorization","Bearer "+token).when().get(url);
        response.prettyPrint();

    }

}
