package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

public final class BasketItem {
    private  Product product;
    private  Integer count;

    public BasketItem(Product product, Integer count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setInr(Integer count) {
        this.count = count;
    }
}
