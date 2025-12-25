package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.ArgumentMatchers;
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
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {
    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    private final static Product SAUSAGE = new SimpleProduct(UUID.randomUUID(), "Колбаса", 20);
    private final static Product BREAD = new SimpleProduct(UUID.randomUUID(), "Хлеб", 6);
    private final static Product MEAT = new FixPriceProduct(UUID.randomUUID(), "Мясо");
    List<Product> TEST_LIST_PRODUCT_IS_NOT_EMPTY = new ArrayList<>(Arrays.asList(
            SAUSAGE,
            BREAD,
            MEAT
    ));


    //    Поиск в случае отсутствия объектов в StorageService
    @Test
    public void whenSearchPattern_ThenCollectionEmptyReturnsEmptyCollection() {
        //given
        Mockito.when(storageService.getAllProduct()).thenReturn(Collections.emptyList());
        //when
        Collection<SearchResult> results = searchService.search("pattern");

        // then
        assertThat(results).isEmpty();
    }

    //    Поиск в случае, если объекты в StorageService есть, но нет подходящего.
    @Test
    public void whenSearchPattern_ThenCollectionIsNotEmptyReturnsMatchNotFind() {
        //given
        Mockito.when(storageService.getAllProduct()).thenReturn(TEST_LIST_PRODUCT_IS_NOT_EMPTY);
        //when
        Collection<SearchResult> results = searchService.search("pattern");
        // then
        assertThat(results).isEmpty();
    }

    // Поиск, когда есть подходящий объект в StorageService
    @Test
    public void WhenSearchPattern_ThenCollectionIsNotEmptyReturnsMatchFind() {
        //given
        Mockito.when(storageService.getAllProduct()).thenReturn(TEST_LIST_PRODUCT_IS_NOT_EMPTY);
        //when
        Collection<SearchResult> results = searchService.search("Колбаса");
        // then
        assertThat(results).hasSize(1);
    }

}
