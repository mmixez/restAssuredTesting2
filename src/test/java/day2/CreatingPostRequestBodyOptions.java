package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.w3c.dom.CDATASection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

/*
    different options to create POST request body
    1. Using Hashmap
    2. Using Org.JSON
    3. Using POJO class
    4. Using external json file data
    */

public class CreatingPostRequestBodyOptions {

    // 1. using hashmap
//    @Test (priority = 1)
//    void testPostUsingHashMap () {
//        HashMap data = new HashMap();
//
//        data.put("id","4");
//        data.put("name", "Miho");
//        data.put("age", 22);
//        data.put("country", "Japan");
//
//        String courseArr[] = {"Math", "Computer Science", "English"};
//        data.put("courses", courseArr);
//
//        given()
//                    .contentType("application/json")
//                    .body(data)
//                .when()
//                    .post("http://localhost:3000/students")
//                .then()
//                    .statusCode(201)
//                    .body("id",equalTo("4"))
//                    .body("name", equalTo("Miho"))
//                .body("age", equalTo(22))
//                .body("country", equalTo("Japan"))
//                .body("courses[0]", equalTo("Math"))
//                .body("courses[1]", equalTo("Computer Science"))
//                .header("Content-Type","application/json")
//                .log().all();
//
//
//    }
//
//    @Test (priority = 2)
//    void testDelete() {
//
//    given()
//            .when()
//            .delete("http://localhost:3000/students/4")
//            .then()
//            .statusCode(200);
//    }



    // 2. using org.json library

//    @Test (priority = 1)
//    void testPostUsingJsonLibrary () {
//
//        JSONObject data = new JSONObject();
//
//        data.put("name","Miho");
//        data.put("id","4");
//        data.put("age",22);
//        data.put("country", "Japan");
//
//        String courseArr[] = {"Math", "Computer Science", "English"};
//        data.put("courses", courseArr);
//
//        given()
//                .contentType("application/json")
//                .body(data.toString())
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("id",equalTo("4"))
//                .body("name", equalTo("Miho"))
//                .body("age", equalTo(22))
//                .body("country", equalTo("Japan"))
//                .body("courses[0]", equalTo("Math"))
//                .body("courses[1]", equalTo("Computer Science"))
//                .header("Content-Type","application/json")
//                .log().all();
//
//
//    }
//
//    @Test (priority = 2)
//    void testDelete() {
//
//        given()
//                .when()
//                .delete("http://localhost:3000/students/4")
//                .then()
//                .statusCode(200);
//    }


    //3. using POJO class
//    @Test (priority = 1)
//    void testPostUsingPOJO () {
//
//       Pojo_PostRequest data = new Pojo_PostRequest();
//       data.setId("4");
//       data.setName("Miho");
//       data.setCountry("Japan");
//       data.setAge(22);
//       String courseArr[] = {"Math", "Computer Science", "English"};
//       data.setCourses(courseArr);
//
//        System.out.println(Arrays.toString(data.getCourses()));
//
//
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("http://localhost:3000/students")
//                .then()
//                .statusCode(201)
//                .body("id",equalTo("4"))
//                .body("name", equalTo("Miho"))
//                .body("age", equalTo(22))
//                .body("country", equalTo("Japan"))
//                .body("courses[0]", equalTo("Math"))
//                .body("courses[1]", equalTo("Computer Science"))
//                .header("Content-Type","application/json")
//                .log().all();
//
//
//    }
//
//    @Test (priority = 2)
//    void testDelete() {
//
//        given()
//                .when()
//                .delete("http://localhost:3000/students/4")
//                .then()
//                .statusCode(200);
//    }


    //4. using external JSON file
    @Test (priority = 1)
    void testPostUsingExternalJsonFile () throws FileNotFoundException {

        File file = new File(".//body.json");
        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject data = new JSONObject(jsonTokener);

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("id",equalTo("4"))
                .body("name", equalTo("Miho"))
                .body("age", equalTo(22))
                .body("country", equalTo("Japan"))
                .body("courses[0]", equalTo("Math"))
                .body("courses[1]", equalTo("Computer Science"))
                .header("Content-Type","application/json")
                .log().all();

    }

    @Test (priority = 2)
    void testDelete() {

        given()
                .when()
                .delete("http://localhost:3000/students/4")
                .then()
                .statusCode(200);
    }
}
