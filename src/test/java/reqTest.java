//made static and added * to call the baseurl and append it to get in next test case
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

//to verify response body
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class reqTest {/*
    @Test(priority = 0)
    void get1(){
        RestAssured.baseURI="https://reqres.in/";
        ValidatableResponse resp = RestAssured.given()
                .get("api/users?page=2")
                    .then().
                        statusCode(200)
                            .body("data.id[0]",equalTo(7));

    }
    @Test(priority = 1)
    void get2(){
        given()
              .get("api/users/2")
                .then().assertThat().statusCode(200);
    }
    @Test(priority = 3)
    void get3List(){
        given()
                .get("api/unknown")
                .then().body("data.name",hasItems("cerulean","fuchsia rose","tigerlily"));
    }
    @Test(priority = 4)
    void post1(){
        JSONObject res = new JSONObject();
        res.put("firstname","Kasun");
        res.put("job" , "QE Cosultant");
        given()
                .body(res.toJSONString())
                .header("Content-Type","application/json")
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }*/
/*
    @Test(priority = 5)
    void newSitePost1(){
        String payload = "{\n" +
                "    \"firstname\" : \"Jamess\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        baseURI="https://restful-booker.herokuapp.com/";
        Response resto = RestAssured
                .given()
                    .header("Content-Type","application/json")
                    .header("Accept","application/json")
                    .body(payload)
                .when()
                    .post("booking");
                //.then()
                   // .log().all();
        System.out.print(resto.getBody().prettyPrint());
    }*/
    @Test
    void newSitePut1(){
        String payload = "{\n" +
                "    \"firstname\" : \"Jamess\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
                given()
                    .header("Accept","application/json")
                    .header("Content-Type","application/json")
                    .auth().preemptive().basic("admin","password123")
                    .param("id","61")
                    .body(payload)
                .when()
                        .put("https://restful-booker.herokuapp.com/booking/:id")
                .then()
                        .statusCode(200);
    }
}
