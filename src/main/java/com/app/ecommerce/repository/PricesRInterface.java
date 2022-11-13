package com.app.ecommerce.repository;

import com.app.ecommerce.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface PricesRInterface extends JpaRepository<Price, Long> {
    @Query(value = "SELECT p " +
            "FROM Price p " +
            "JOIN p.brandId b " +
            "WHERE p.productId = :productId " +
            "AND b.id = :brandId " +
            "AND p.startDate <= :date " +
            "AND p.endDate >= :date " +
            "ORDER BY p.priority DESC")
    List<Price> findPriceByDate(ZonedDateTime date, Long productId, Long brandId);
}
