package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageServiceTest {
    StorageService storageService = new StorageService();
//    private final static Product SAUSAGE = new SimpleProduct(UUID.randomUUID(), "Колбаса", 20);
//    private final static Product BREAD = new SimpleProduct(UUID.randomUUID(), "Хлеб", 6);
//    private final static Product MEAT = new FixPriceProduct(UUID.randomUUID(), "Мясо");
//    Product beer = new FixPriceProduct(UUID.randomUUID(), "Пиво");
//    Product tomatoes = new DiscountedProduct(UUID.randomUUID(), "Помидоры", 12, 50);
//    Product potato = new DiscountedProduct(UUID.randomUUID(), "Картофель", 45, 10);
//    Product vegetableFirst = new DiscountedProduct(UUID.randomUUID(), "овощь", 45, 10);
//    Product vegetableSecond = new DiscountedProduct(UUID.randomUUID(), "яблоко", 45, 10);
//
//    private final static Map<UUID, Product> DATA_PRODUCT_MAP = Map.of(
//            SAUSAGE.getId(), SAUSAGE,
//            BREAD.getId(), BREAD,
//            MEAT.getId(), MEAT
//    );
//
//    private final static Map<UUID, Product> TEST_PRODUCT_MAP = Map.of(
//            SAUSAGE.getId(), SAUSAGE,
//            BREAD.getId(), BREAD,
//            MEAT.getId(), MEAT
//    );

   // Поиск в случае отсутствия объектов в
   // StorageService
    @Test
    void whenFindNotObject_ThenStorageServiceReturnNull() {
        String resultNull = "Null";
        Assertions.assertNotEquals(resultNull,storageService.getAllProduct());
    }
//    void whenNameIsGiven_ThenGreeterReturnsHelloName() {
//        String name = "Test";
//        Assertions.assertEquals(TEST_PRODUCT_MAP, Greeter.greet(name));
//    }
}
