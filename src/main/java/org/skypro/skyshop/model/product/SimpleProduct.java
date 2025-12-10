package org.skypro.skyshop.model.product;


import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;
    private final UUID id;

    public SimpleProduct(UUID id, String name, int amount) {
        super(name);
        this.id = id;
        if (amount < 1) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = amount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "<" + price + ">";
    }
}
