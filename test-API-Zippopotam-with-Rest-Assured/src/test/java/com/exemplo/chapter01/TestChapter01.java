package com.exemplo.chapter01;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TestChapter01 {

    @Test
    public void testRequestZipCode63210_000checkInResponseBody_expectMauriti() {
        given().
        when().
                get("https://api.zippopotam.us/BR/63210-000").
        then().
                assertThat().
                statusCode(200). // Verifica se a resposta foi bem-sucedida
                body("places[0].'place name'", equalTo("Mauriti")); // Corrigido o caminho JSON
    }
}
