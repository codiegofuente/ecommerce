package com.app.ecommerce.enums;

public enum ErrorC {

    DATE_ERROR("El parámetro fecha es obligatorio."),
    PRODUCT_ID_ERROR("El parámetro productId es obligatorio."),
    BRAND_ID_ERROR("El parámetro brandId es obligatorio.");

    private final String code;

    ErrorC(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ErrorC valueOfCode(String code) {
        for (ErrorC errorC : ErrorC.values()) {
            if (errorC.getCode().equals(code))
                return errorC;
        }

        return null;
    }

}
