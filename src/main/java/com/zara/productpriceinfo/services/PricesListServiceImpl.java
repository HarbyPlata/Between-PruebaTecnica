package com.zara.productpriceinfo.services;

import com.zara.productpriceinfo.dto.PriceResponse;
import com.zara.productpriceinfo.model.PricesModel;
import com.zara.productpriceinfo.repository.PricesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PricesListServiceImpl implements PricesListService {
    private final PricesRepository pricesRepository;
    @Override
    public PriceResponse getProductPrices(long brandId, long productId, LocalDateTime inputDate) {

        PriceResponse priceResponse = new PriceResponse();
        final String STATUS_CODE_OK = "0";
        final String STATUS_CODE_DESC_OK = "Transaccion Exitosa";
        final String STATUS_CODE_ERROR = "1";
        final String STATUS_CODE_DESC_ERROR = "No se encontró información válida para los datos ingresados";
        List<PricesModel> pricesList = pricesRepository.findByProductIdAndBrandIdAndDate(productId,brandId,inputDate);
        if (pricesList.isEmpty()){
            priceResponse.setStatusCode(STATUS_CODE_ERROR);
            priceResponse.setStatusCodeDesc(STATUS_CODE_DESC_ERROR);
        }else{
            pricesList.sort(Comparator.comparingInt(PricesModel::getPriority).reversed());
            priceResponse.setStatusCode(STATUS_CODE_OK);
            priceResponse.setStatusCodeDesc(STATUS_CODE_DESC_OK);
            priceResponse.setProductId(pricesList.get(0).getProductId());
            priceResponse.setBrandId(pricesList.get(0).getBrandId());
            priceResponse.setPrice(pricesList.get(0).getPrice());
            priceResponse.setPriceList(pricesList.get(0).getPriceList());
            priceResponse.setDate(inputDate);
        }
        return priceResponse;
    }
}
