package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    @Mock
    private StorageService storageService;
    @Mock
    private UserBasket userBasket;

    @InjectMocks
    private BasketService basketService;

    //Добавление несуществующего товара в корзину приводит к выбросу исключения.
    @Test
    public void whenAddProductBasket_thenNotProductReturnException() {
        //given
        UUID invalidId = UUID.randomUUID();
        when(storageService.getProductById(invalidId)).thenReturn(Optional.empty());

        // Then
        assertThrows(NoSuchProductException.class, () -> basketService.addProductBasket(invalidId));
    }

    //Добавление существующего товара вызывает метод  addProduct у мока ProductBasket
    @Test
    public void whenAddProductBasket_thenProductExistsReturnSuccess() {
        //given
        UUID existId = UUID.randomUUID();
        when(storageService.getProductById(existId)).thenReturn(Optional.of(mock(Product.class)));

        // When
        basketService.addProductBasket(existId);

        // Then
        verify(productBasket).addProductBasket(existId);
    }

    //Метод getUserBacket возвращает пустую корзину, если ProductBasket пуст.
    @Test
    public void whenGetUserBasket_thenProductBasketIsEmptyReturnsBasketEmpty() {
        //given
        when(productBasket.getAllProductBasket()).thenReturn(Map.of());
        when(userBasket.getTotal()).thenReturn(0);

        // When
        UserBasket results = basketService.getUserBasket();

        // Then
        assertThat(results.getBasketItems()).isEmpty();
        assertThat(userBasket.getTotal()).isZero();
    }

    //    Метод getUserBasket возвращает подходящую корзину, если в ProductBasket есть товары.
    @Test
    public void whenGetUserBasket_thenProductBasketIsNotEmptyReturnsBasketProducts() {
        //given
        UUID productId = UUID.randomUUID();
        Product testProduct = new SimpleProduct(productId, "Хлеб", 6);
        when(productBasket.getAllProductBasket()).thenReturn(Map.of(productId, 2));
        when(storageService.getProductById(productId)).thenReturn(Optional.of(testProduct));

        // When
        UserBasket result = basketService.getUserBasket();

        // Then
        assertThat(result.getBasketItems()).hasSize(1);
        assertThat(result.getBasketItems().get(0).getProduct().getName()).isEqualTo("Хлеб");
        assertThat(result.getBasketItems().get(0).getCount()).isEqualTo(2);
    }
}
