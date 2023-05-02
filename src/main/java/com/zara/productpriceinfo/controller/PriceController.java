package com.zara.productpriceinfo.controller;

import com.zara.productpriceinfo.dto.PriceResponse;
import com.zara.productpriceinfo.dto.PriceResponseError;
import com.zara.productpriceinfo.model.PricesModel;
import com.zara.productpriceinfo.services.PricesListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/ProductPriceInfoInquiry/getProductPrice")
@RequiredArgsConstructor
public class PriceController {

    private final PricesListService pricesListService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getProductPrice(
            @RequestParam("brandId") Long brandId,
            @RequestParam("productId") Long productId,
            @RequestParam("date") LocalDateTime date) {

        PriceResponse priceResponse = pricesListService.getProductPrices(brandId,productId,date);

        if (priceResponse.getStatusCode().equals("1")) {
            PriceResponseError priceResponseError = new PriceResponseError();
            priceResponseError.setStatusCode(priceResponse.getStatusCode());
            priceResponseError.setStatusCodeDesc(priceResponse.getStatusCodeDesc());
            return  ResponseEntity.ok(priceResponseError);
        }else{
            return ResponseEntity.ok(priceResponse);
        }

    }
}
