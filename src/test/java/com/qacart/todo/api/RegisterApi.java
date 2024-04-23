package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private static List<Cookie> RestAssuredCookies ;
    private static String accessToken ;


    private static String userId ;
    private static String firstName ;

    public String getToken (){ // cette methode trajja3li el acess token elli private , njibou el token ba3d ma ya3lelha set ml api call
        return  this.accessToken;
    }

    public String getuserId (){
        return  this.userId;
    }
    public String getfirstName (){
        return  this.firstName;
    }

    public  List<Cookie> getRestAssuredCookies () {
        return this.RestAssuredCookies;
    }



    public void register (){


        User user =UserUtils.generateRandomUser();
        Response response =
                given()

                        .baseUri(ConfigUtils.getInstance().getBaseUrl())

                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                        .when()

                        .post(EndPoint.REGISTER_ENDPOINT)
                        .then()
                        .log().all()
                        .extract().response();
        if(response.statusCode()!=201)
        {
            throw  new RuntimeException("somthing is wronf with the request");
        }

        RestAssuredCookies = response.getDetailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");


    }
}
