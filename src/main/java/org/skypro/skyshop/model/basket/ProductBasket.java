package org.skypro.skyshop.model.basket;

import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new HashMap<>();

    public void addProductBasket(UUID id) {

//        productBasket.put(id, ' ');
    }

    public Map<UUID, Integer> getAllProductBasket() {
        return Collections.unmodifiableMap(productBasket);
    }
}
