package com.app.ecommerce.controller;

import com.app.ecommerce.entity.Price;
import com.app.ecommerce.enums.ErrorC;
import com.app.ecommerce.exceptions.ErrorEx;
import com.app.ecommerce.service.EcommerceS;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/ecommerce")
@Tag(name = "Ecommerce controller", description = "Look for product information.")
@Slf4j
public class EcommerceC {

    private final EcommerceS ecommerceS;

    @Autowired
    public EcommerceC(EcommerceS ecommerceS){
        this.ecommerceS = ecommerceS;
    }

    @GetMapping("/product/info")
    @Operation(summary = "Return product information.")
    @ResponseBody
    public ResponseEntity<String> getProductInfo(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime date,
            @RequestParam(name = "productId", required = false) Long productId,
            @RequestParam(name = "brandId", required = false) Long brandId
    ){
        String body;
        parseInputs(date, productId, brandId);
        log.info("Get product info by application date: " + date.toString() + ", product id: " + productId.toString() +
                ", string id: " + brandId.toString());

        Price price = ecommerceS.getProductInfo(date, productId, brandId);
        body = price.getProductId() == null ? "No se ha encontrado el producto para las fechas indicadas." :
                "Id de producto: " + price.getProductId().toString() + ", id de cadena: " +
                        price.getBrandId().getId().toString() + ", tarifa a aplicar: " +
                        price.getPriceList().toString() + ", fecha de inicio de tarifa: " +
                        price.getStartDate().toString() + ", fecha de fin de tarifa: " +
                        price.getEndDate().toString() + " precio final: " + price.getPrice().toString() +
                        price.getCurr().toString();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    private void parseInputs(ZonedDateTime date, Long productId, Long brandId) {
        if (date == null) {
            throw new ErrorEx(HttpStatus.BAD_REQUEST, ErrorC.DATE_ERROR.getCode());
        }

        if (productId == null || productId < 0){
            throw new ErrorEx(HttpStatus.BAD_REQUEST, ErrorC.PRODUCT_ID_ERROR.getCode());
        }

        if (brandId == null || brandId < 0){
            throw new ErrorEx(HttpStatus.BAD_REQUEST, ErrorC.BRAND_ID_ERROR.getCode());
        }
    }
}
