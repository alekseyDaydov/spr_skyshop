package org.skypro.skyshop.model.basket;

import java.util.List;

public final class UserBasket {
    private final List<BasketItem> basketItems;
    private final int total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
        this.total = getTotalSum();
    }

    private Integer getTotalSum() {
        return basketItems.stream().
                mapToInt(element -> element.getProduct().getPrice() * element.getCount())
                .sum();
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public int getTotal() {
        return total;
    }
}

