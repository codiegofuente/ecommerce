package com.app.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "PRICES")
public class Price {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private Brand brandId;

    @Column(name = "START_DATE")
    private ZonedDateTime startDate;

    @Column(name = "END_DATE")
    private ZonedDateTime endDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST")
    private Long priceList;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRIORITY")
    private Long priority;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "curr")
    private String curr;
}
