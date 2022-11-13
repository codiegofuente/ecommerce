package com.app.ecommerce.service;

import com.app.ecommerce.entity.Price;
import java.time.ZonedDateTime;

public interface EcommerceSInterface {
    Price getProductInfo(ZonedDateTime date, Long productId, Long brandId);
}
