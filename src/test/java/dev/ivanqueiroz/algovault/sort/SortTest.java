package dev.ivanqueiroz.algovault.sort;

import dev.ivanqueiroz.algovault.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {

    private Product[] products;

    @BeforeEach void setUp() {
        products = new Product[] {new Product("Lamborghini", 1000000), new Product("Jipe", 46000), new Product("Brasília", 16000), new Product("Smart", 46000),
            new Product("Fusca", 17000)};
    }

    @Test void selectionSortTest() {
        Sort.selectionSort(products, products.length);
        sortAssert();
    }

    @Test void insertionSortTest() {
        Sort.insertionSort(products, products.length);
        sortAssert();
    }

    private void sortAssert() {
        assertEquals("Brasília", products[0].getName());
        assertEquals("Lamborghini", products[products.length - 1].getName());
    }
}
