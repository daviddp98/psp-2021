package org.iesvalleinclan.storeproduct.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder

public class ProductVO {
    @Id
    private String id;
    private String name;
    private String reference;
    private String stock;
    private double price;
    private String supplier;
    private String brand;
    private Boolean active;
    private Date modifiedDate;
}