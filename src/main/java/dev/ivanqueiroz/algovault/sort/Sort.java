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

}
