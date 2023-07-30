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
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2ODY5MTc4NDF9.x2OcBq7wrJyiIMmPv7HPYn5m-ai0rczw5nJH_imWABLxipYzTj10Qkx3H9_Upmo70odps_CWI80dqnQx1fmtcg";

        Response response = given().headers("Authorization","Bearer "+token).when().get(url);
        response.prettyPrint();

    }

}
