import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
1- Postman'i , manuel API testleri icin kullandik
2- Otomasyon testleri icin de Rest Assuret Library kullanacagiz
3- Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz
    a) Gereksinimleri anlamak,
    b) Test Case yaziyoruz
        i) Test Case yaziminda Gherkin dilini kullanacagiz. Bizler yazilim diline hakim olsak da
            karsimizdaki kisiler hakim olmayabilir ama Gherkin ile yazilan testleri anlamakta zorluk cekmeyeceklerdir.
            Gherkin dilinde kullanacagimiz keywordler;

            - Given: On kosullar
            - When: Yapilacak aksiyonlar icin (get(), put(), post(), patch() ve delete() )
            - Then: Istek yaptiktan (request gonderdikten sonra) dogrulama
            - And: Coklu islemlerde kullanacagiz
  c) Test kodlarimizi yazmaya baslayacagiz

        i)  Set the URL,
        ii) Set the expected Data (beklenen datanin olusturulmasi, post, put, patch)
        iii) Type code to send request (Talep gondermek icin kod yazimi)
        iv) Do Assertion ()dogrulama yapmak

 */

    /**
     * ==>https://restful-booker.herokuapp.com==>baseUrl
     * ==>/booking/101==>endPoint->bizi bir yere yönlendiriyorsa endPoint
     * ==> /booking/101==>Aynı zamanda endPointte yer alan parametreler ayrı ayrı değerlendirildiğinde
     * ==>https://restful-booker.herokuapp.com/booking/101==>tamamına URL veya URI denir endPoint değil
     */

    /*
Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
        //Buraya kadar REQUEST kısmı
***********************************************************************
        //THEN ve sonrası RESPONSE-->Do Assertion ()dogrulama yapmak
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK

 */

    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/101";

        Response response=given().when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

    }
}
