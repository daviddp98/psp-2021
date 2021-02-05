package org.iesvalleinclan.storeproduct.config;

import org.apache.commons.lang3.RandomStringUtils;
import org.iesvalleinclan.storeproduct.model.ProductVO;
import org.iesvalleinclan.storeproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class LoadBBDD {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void loadProducts() {
        repository.insert(createProduct("1", 10D));
        repository.insert(createProduct("2", 20D));
        repository.insert(createProduct("3", 30D));
        repository.insert(createProduct("4", 40D));
        repository.insert(createProduct("5", 50D));
        repository.insert(createProduct("6", 60D));
        repository.insert(createProduct("7", 70D));
        repository.insert(createProduct("8", 80D));
        repository.insert(createProduct("9", 90D));
        repository.insert(createProduct("10", 100D));
    }

    private ProductVO createProduct(final String productNumber, final double price) {
        return ProductVO.builder()
                .active(true)
                .name("Product" + productNumber)
                .price(price)
                .reference(RandomStringUtils.randomAlphabetic(10))
                .supplier("Supplier" + productNumber)
                .build();
    }
}