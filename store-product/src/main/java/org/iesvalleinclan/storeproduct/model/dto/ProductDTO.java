package org.iesvalleinclan.storeproduct.model.dto;

// Se omite la primera parte de package, import y anotaciones

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductDTO {

    String id;

    @Min(0)
    int stock;

    @NotBlank(message = "Name cannot be empty")
    String name;

    @NotBlank(message = "Brand cannot be empty")
    String brand;

    double price;

    @NotBlank(message = "Reference cannot be empty")
    String reference;

    @NotBlank(message = "Supplier cannot be empty")
    String supplier;

    boolean active;
}