package org.skypro.skyshop.model.basket;

import java.util.List;

public final class UserBasket {
    private final List<BasketItem> basketItems;
    private final Integer total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        this.total = getTotal();
    }

    private Integer getTotal() {
        return basketItems.stream().
                mapToInt(element -> element.getProduct().getPrice() * element.getCount())
                .sum();
    }
}

