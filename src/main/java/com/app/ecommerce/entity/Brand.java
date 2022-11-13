package com.app.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "BRANDS")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_NAME")
    protected String brandName;

    @ToString.Exclude
    @OneToMany(
            mappedBy = "brandId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Price> prices = new ArrayList<>();

    public Brand (Long id) {this.id = id;}
}
