package com.zara.productpriceinfo.repository;

import com.zara.productpriceinfo.model.PricesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository  extends JpaRepository<PricesModel,Long>{

    @Query("SELECT p FROM PricesModel p WHERE p.brandId = :brandId AND p.productId = :productId AND :inputDate BETWEEN p.startDate AND p.endDate")
    List<PricesModel> findByProductIdAndBrandIdAndDate(@Param("productId") Long productId, @Param("brandId")Long brandId, @Param("inputDate") LocalDateTime inputDate);
}
