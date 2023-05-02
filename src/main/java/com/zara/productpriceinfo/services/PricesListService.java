package com.zara.productpriceinfo.services;

import com.zara.productpriceinfo.dto.PriceResponse;
import com.zara.productpriceinfo.model.PricesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PricesListService  {
    PriceResponse getProductPrices(long brandId, long productId, LocalDateTime date);


}
