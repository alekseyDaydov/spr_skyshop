package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.ProductBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service

public class BasketService {
//    @Autowired
    private final ProductBasket productBasket;

//    @Autowired
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }


}
