package com.springframework.msscbeerservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 35, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID io;
    @Version
    private Long version;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    private String lastModifiedDate;
    private String beerName;
    private String beerStyle;
    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
    private Integer miniOnHand;
    private Integer quantityToBrew;
}
