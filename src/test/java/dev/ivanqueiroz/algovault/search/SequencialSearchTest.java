package dev.ivanqueiroz.algovault.search;

import dev.ivanqueiroz.algovault.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class SequencialSearchTest {

    private Product[] products;

    @BeforeEach void setUp() {
        products = new Product[] {new Product("Lamborghini", 1000000), new Product("Jipe", 46000), new Product("Brasília", 16000), new Product("Smart", 46000),
            new Product("Fusca", 17000)};
    }

    @Test void searchCheaper() {
        final int cheaper = SequencialSearch.searchCheaper(products, 0, products.length - 1);
        log.info("Cheaper: {}", products[cheaper].getName());
        Assertions.assertEquals(2, cheaper);
    }
}
