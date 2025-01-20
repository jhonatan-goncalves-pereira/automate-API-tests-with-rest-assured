package com.exemplo.aulas.seriazacaoAndDeserializacao;

import org.junit.jupiter.api.Test;

public class TestLocation {
    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        Location location =
                given().
                when().
                        get("http://api.zippopotam.us/us/90210").
                        as(Location.class);

        Assert.assertEquals(
                "Beverly Hills",
                location.getPlaces().get(0).getPlaceName()
        );
    }

    @Test
    public void sendLvZipCode1050_checkStatusCode_expect200() {

        Location location = new Location();
        location.setCountry("Netherlands");

        given().
                contentType(ContentType.JSON).
                body(location).
                log().body().
        when().
                post("http://localhost:9876/lv/1050").
        then().
                assertThat().
                statusCode(200);
    }

}
