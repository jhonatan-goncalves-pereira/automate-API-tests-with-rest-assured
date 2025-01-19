package com.exemplo.aulas;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GPathAndHamcrestExploration {

    @Test
    public void testRequestZipCodeBR63210_000checkInResponseBody_expectMauriti() {
        given().
        when().
                get("https://api.zippopotam.us/BR/63210-000").
        then().
                assertThat().
                statusCode(200).
                body("places[0].'place name'", equalTo("Mauriti"));
    }

    @Test
    public  void testRequestZipCodeBR63210_000checkStatusCode_expectHttp200(){
        given()
        .when().
                get("https://api.zippopotam.us/BR/63210-000")
        .then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testRequestZipCodeBR63210_000checkContentType_expectApplicationJson(){
        given()
        .when().
                get("https://api.zippopotam.us/BR/63210-000")
        .then().
            assertThat()
            .contentType(ContentType.JSON);
    }

    @Test
    public void testRequestZipCodeBR63210_000logRequestAndResponseDetails(){
        given().
                log().all()
        .when().
                get("https://api.zippopotam.us/BR/63210-000")
        .then().
                log().body();
    }
}
