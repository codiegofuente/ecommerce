package com.app.ecommerce;

import java.time.ZonedDateTime;

public class TestTools {

    public static String exResult(Long brandId, ZonedDateTime startDate, ZonedDateTime endDate, Long priceList,
                                         Long productId, Float price, String curr) {
        return "Id de producto: " + productId + ", id de cadena: " + brandId + ", tarifa a aplicar: " +
                priceList + ", fecha de inicio de tarifa: " + startDate + ", fecha de fin de tarifa: " + endDate + " " +
                "precio final: " + price + curr;
    }
}
