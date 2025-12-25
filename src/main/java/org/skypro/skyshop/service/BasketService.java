package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductBasket(UUID id) {
        if (storageService.getProductById(id).isEmpty()) {
           throw new NoSuchProductException();
        }
        productBasket.addProductBasket(id);
    }

    public UserBasket getUserBasket() {
        List<BasketItem> userBasketList = productBasket.getAllProductBasket()
                .entrySet()
                .stream()
                .map(element->new BasketItem(
                        storageService.getProductById(element.getKey()).orElseThrow(),
                        element.getValue()))
                .toList();
        return new UserBasket(userBasketList);
    }

}
