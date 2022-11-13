package com.app.ecommerce.service;

import com.app.ecommerce.entity.Price;
import com.app.ecommerce.repository.PricesRInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class EcommerceS implements EcommerceSInterface {

    private final PricesRInterface pricesRInterface;

    @Autowired
    public EcommerceS(PricesRInterface pricesRInterface) {this.pricesRInterface = pricesRInterface;}

    @Override
    public Price getProductInfo(ZonedDateTime date, Long productId, Long brandId) {
        List<Price> prices = pricesRInterface.findPriceByDate(date, productId, brandId);
        return prices.isEmpty() ? new Price() : prices.get(0);
    }
}
