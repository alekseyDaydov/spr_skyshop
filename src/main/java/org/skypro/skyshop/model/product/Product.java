package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;


public abstract class Product implements Searchable {
    private final String TERM_PRODUCT = "PRODUCT";

    private final UUID id;
    private final String name;

    public Product(UUID id, String name) {
        if (("null" == name) || name.isBlank()) {
            throw new IllegalArgumentException("Поле Имя не может быть пустым");
        }
        this.name = name;
        this.id = id;
    }

    public abstract boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String getName() {
        return name;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getName();
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return TERM_PRODUCT;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "<" + name + ">:";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        Searchable product = (Searchable) other;
        return Objects.equals(name, product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
