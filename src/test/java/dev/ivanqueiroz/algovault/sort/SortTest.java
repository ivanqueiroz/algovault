package dev.ivanqueiroz.algovault.sort;

import dev.ivanqueiroz.algovault.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SortTest {

    private Product[] products;
    private Product[] products2;
    private Product[] products3;

    @BeforeEach void setUp() {
        products = new Product[] {new Product("Lamborghini", 1000000), new Product("Jipe", 46000), new Product("Brasília", 16000), new Product("Smart", 46000),
            new Product("Fusca", 17000)};
        products2 = new Product[] {new Product("Porche", 2000000), new Product("Hammer", 56000), new Product("Celta", 26000), new Product("Ecosport", 86000),
            new Product("Cherry QQ", 12000)};
        products3 = Stream.concat(Arrays.stream(products), Arrays.stream(products2)).toArray(Product[]::new);
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

    @Test void merge() {
        Comparator<Product> priceComaparator = Comparator.comparingDouble(Product::getPrice);
        Arrays.sort(products, priceComaparator);
        Arrays.sort(products2, priceComaparator);
        final Product[] mergeProducts = Sort.merge(products, products2);
        final int total = products.length + products2.length;
        assertEquals(total, mergeProducts.length);
        assertEquals("Cherry QQ", mergeProducts[0].getName());
        assertEquals("Porche", mergeProducts[mergeProducts.length - 1].getName());
    }

    @Test void sorting() {

        Sort.sorting(products3, 0, products3.length);
        log.info(Arrays.toString(products3));
        assertEquals("Cherry QQ", products3[0].getName());
    }
}
