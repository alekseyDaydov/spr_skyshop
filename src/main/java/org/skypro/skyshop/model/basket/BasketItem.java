package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public final class BasketItem {
    private Product product;
    private Integer inr;

    public BasketItem(Product product, Integer inr) {
        this.product = product;
        this.inr = inr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getInr() {
        return inr;
    }

    public void setInr(Integer inr) {
        this.inr = inr;
    }
}
