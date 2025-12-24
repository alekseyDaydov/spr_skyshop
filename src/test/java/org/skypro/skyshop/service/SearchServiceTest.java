package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;
    private final static Product SAUSAGE = new SimpleProduct(UUID.randomUUID(), "Колбаса", 20);
    private final static Product BREAD = new SimpleProduct(UUID.randomUUID(), "Хлеб", 6);
    private final static Product MEAT = new FixPriceProduct(UUID.randomUUID(), "Мясо");
    private final static Map<UUID, Product> DATA_PRODUCT_MAP_IS_NOT_NULL = Map.of(
            SAUSAGE.getId(), SAUSAGE,
            BREAD.getId(), BREAD,
            MEAT.getId(), MEAT
    );
    private final static Map<UUID, Product> DATA_PRODUCT_MAP_IS_EMPTY = Map.of();
    List<Product> TEST_LIST_PRODUCT_IS_EMPTY = new ArrayList<>();
    List<Product> TEST_LIST_PRODUCT_IS_NOT_EMPTY = new ArrayList<>(Arrays.asList(
            SAUSAGE,
            BREAD,
            MEAT
    ));

//    Поиск в случае отсутствия объектов в StorageService
    @Test
    public void whenSerchText_thenGetId() {
//        StorageService mockStorageService = Mockito.mock(StorageService.class);
        Mockito.when(storageService.getAllProduct()).thenReturn(TEST_LIST_PRODUCT_IS_EMPTY);
        List<SearchResult> results = (List<SearchResult>) searchService.search("test");
//        assertThat(true,  results.isEmpty());
assertThat( "false",results.isEmpty());
//        Assert.isTrue("ghj",searchService.search("ght"));
//        UUID id = UUID.randomUUID();
//        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.of(BREAD));

    }


}
