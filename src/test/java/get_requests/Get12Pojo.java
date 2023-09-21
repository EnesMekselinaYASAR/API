package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends RestfulBaseUrl {

     /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
         I send GET Request to the URL
     Then
        Status code is 200
     And
        Response body is like:
   {
    "firstname": "Jane",
    "lastname": "Doe",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Extra pillows please"
}
    */

    @Test
    public void get12Pojo(){
        // set the url
        spec.pathParams("first","booking","second",18);

        // set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        System.out.println(bookingDatesPojo.toString());
        BookingPojo expectedData = new BookingPojo("Jane","Doe",111,true,bookingDatesPojo,"Extra pillows please");
        System.out.println("expectedData = " + expectedData);

        // send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // do assertion
        BookingPojo  actualData = response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        // 1.yol
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

        // 2.yol (tavsiye edilen)
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());




    }
}
