package com.exemplo.aulas;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestXMLResponse {
    @Test
    public void testRequestZipCodeBR63210_000checkInResponseBody_expectMauriti() {
        given().
        when().
                get("https://api.zippopotam.us/BR/63210-000").
        then().
                assertThat().
                body("response.places.place.placeName", equalTo("Mauriti"));
    }
}
