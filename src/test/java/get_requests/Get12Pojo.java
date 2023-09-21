package get_requests;

import base_urls.RestfulBaseUrl;
import org.junit.Test;

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


    }
}
