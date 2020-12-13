package dev.ivanqueiroz.algovault.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class BinarySearchTest {

    @Test void searchTest() {
        int[] vector = {10, 12, 67, 3, 8, 90, 1, 2, 6, 9, 40, 45};
        log.info("Raw vector: {}", Arrays.toString(vector));
        Arrays.sort(vector);
        log.info("Sorted vector: {}", Arrays.toString(vector));
        var element = 12;
        final int index = BinarySearch.search(vector, element, vector.length);
        log.info("Index of {} is {}", element, index);
        assertEquals(7, index);
    }

    @Test void searcRecursivetest() {
        int[] vector = {10, 12, 67, 3, 8, 90, 1, 2, 6, 9, 40, 45};
        log.info("Raw vector: {}", Arrays.toString(vector));
        Arrays.sort(vector);
        log.info("Sorted vector: {}", Arrays.toString(vector));
        var element = 12;
        final int index = BinarySearch.searchRecursive(element, vector, 0, vector.length - 1);
        log.info("Index of {} is {}", element, index);
        assertEquals(7, index);
    }
}
