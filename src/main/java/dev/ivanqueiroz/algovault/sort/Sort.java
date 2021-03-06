package dev.ivanqueiroz.algovault.sort;

import dev.ivanqueiroz.algovault.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static dev.ivanqueiroz.algovault.search.SequencialSearch.searchCheaper;

@Slf4j
public class Sort {

    private Sort() {
        throw new UnsupportedOperationException();
    }

    public static void selectionSort(Product[] products, int elementsQuantity) {
        if (products != null) {
            for (int current = 0; current < elementsQuantity - 1; current++) {
                log.info("Position {}", current);

                int cheaper = searchCheaper(products, current, elementsQuantity - 1);
                switchElements(products, current, cheaper);
            }
            log.info("Ordered array: {}", Arrays.toString(products));
        }
    }

    public static void insertionSort(Product[] products, int elementsQuantity) {
        if (products != null) {
            for (int current = 1; current < elementsQuantity; current++) {
                int target = current;
                log.info("Position {}", current);
                while (target > 0 && products[target].getPrice() < products[target - 1].getPrice()) {
                    log.info("Checking left element.");
                    log.info("Left element cheaper -> {}.", products[target]);
                    switchElements(products, target, target - 1);
                    target--;
                }
            }
            log.info("Ordered array: {}", Arrays.toString(products));
        }
    }

    private static void switchElements(Product[] products, int target, int i) {
        Product targetProduct = products[target];
        Product beforeTarget = products[i];

        log.info("Switch {} for {}", targetProduct, beforeTarget);
        products[target] = beforeTarget;
        products[i] = targetProduct;
    }

    public static Product[] merge(Product[] products1, Product[] products2) {
        int length = products1.length + products2.length;
        Product[] result = new Product[length];
        int current = 0;
        int indexProduct1 = 0;
        int indexProduct2 = 0;
        while (indexProduct1 < products1.length && indexProduct2 < products2.length) {
            log.info("Checking left element.");
            Product product1 = products1[indexProduct1];
            Product product2 = products2[indexProduct2];
            if (product1.getPrice() < product2.getPrice()) {
                result[current] = product1;
                indexProduct1++;
            } else {
                result[current] = product2;
                indexProduct2++;
            }
            current++;
        }
        while (indexProduct1 < products1.length) {
            result[current] = products1[indexProduct1];
            indexProduct1++;
            current++;
        }
        while (indexProduct2 < products2.length) {
            result[current] = products2[indexProduct2];
            indexProduct2++;
            current++;
        }
        log.info("Merged array: {}", Arrays.toString(result));
        return result;
    }

    public static void intercalate(Product[] products, int start, int midpoint, int end) {
        final int auxLenght = end - start;
        Product[] auxArray = new Product[auxLenght];
        int mainPosition = 0;
        int indexProduct1 = start;
        int indexProduct2 = midpoint;

        while (indexProduct1 < midpoint && indexProduct2 < end) {
            Product product1 = products[indexProduct1];
            Product product2 = products[indexProduct2];
            if (product1.getPrice() < product2.getPrice()) {
                auxArray[mainPosition] = product1;
                indexProduct1++;
            } else {
                auxArray[mainPosition] = product2;
                indexProduct2++;
            }
            mainPosition++;
        }
        while (indexProduct1 < midpoint) {
            auxArray[mainPosition] = products[indexProduct1];
            indexProduct1++;
            mainPosition++;
        }
        while (indexProduct2 < end) {
            auxArray[mainPosition] = products[indexProduct2];
            indexProduct2++;
            mainPosition++;
        }

        if (mainPosition >= 0)
            System.arraycopy(auxArray, 0, products, start, mainPosition);
    }

    public static void sorting(Product[] products, int start, int end) {
        int lenght = end - start;
        if (lenght > 1) {
            int middle = (start + end) / 2;
            sorting(products, start, middle);
            sorting(products, middle, end);
            intercalate(products, start, middle, end);
        }
    }

}
