package org.iesvalleinclan.storeproduct.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document

public class ProductVO {
    @Id
    private String id;
    private String name;
    private String reference;
    private String stock;
    private String price;
    private String supplier;
    private String brand;
    private Boolean active;
    private Date modifiedDate;
}