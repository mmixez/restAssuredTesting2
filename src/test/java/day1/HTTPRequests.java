package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import java.util.HashMap;


/*
given()
    content type, set cookies, add auth, add param, set headers info etc...
    when()
        get, post, put, delete
        then()
            validate status code, extract response, extract headers cookies & response body...
 */

/*
 Get users
 https://reqres.in/api/users?page=2


 post
 https://reqres.in/api/users


{
    "name": "morpheus",
    "job": "leader"
 }

update
https://reqres.in/api/users/2

{
    "name": "morpheus",
    "job": "zion resident"
}

delete
https://reqres.in/api/users/userid

204


 */


public class HTTPRequests {

    int id;

    @Test(priority = 1)
    void getUsers() {
        given()
                .when()
                    .get(" https://reqres.in/api/users?page=2")
                .then()
                    .statusCode(200)
                    .body("page", equalTo(2))
                    .log().all();

    }
//
//    @Test(priority = 2)
//    void createUser() {
//
//        HashMap data = new HashMap();
//        data.put("name", "Jisoo");
//        data.put("job", "trainer");
//
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("https://reqres.in/api/users")
//                .then()
//                .statusCode(201)
//                .log().all();
//
//
//    }


    @Test (priority = 3)
    void createUser() {

        HashMap data = new HashMap();
        data.put("name", "Jisoo");
        data.put("job", "trainer");

        id = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id")
        ;
    }

    @Test (priority = 4,dependsOnMethods = {"createUser"})
    void updateUser() {
        HashMap data = new HashMap();
        data.put("name", "Jane");
        data.put("job", "senior trainer");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/"+id)

                .then()
                .statusCode(200)
                .log().all();
        ;
    }
    @Test (priority = 5)
    void deleteUser() {
        given()

                .when()
                .delete("https://reqres.in/api/users/" + id)

                .then()
                .statusCode(204)
                .log().all();
    }

}
