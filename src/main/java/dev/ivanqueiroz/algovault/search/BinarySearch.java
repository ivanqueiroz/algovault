package dev.ivanqueiroz.algovault.search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearch {

    public static final String LOG_PATTER_INFO = "Position {}, value {}, key {}, left {}, right {}";

    private BinarySearch() {
    }

    public static int search(int[] vector, int key, int size) {

        var lowLimit = 0;
        var highLimit = size - 1;

        while (lowLimit <= highLimit) {
            log.info("Calculating middle.");
            var middle = middleCalc(lowLimit, highLimit);
            log.info("Middle index {}, value {}", middle, vector[middle]);
            if (key == vector[middle]) {
                log.info("Middle is the element {}", key);
                return middle;
            }

            if (key < vector[middle]) {
                log.info("Middle value {} bigger than element {} will go to left", vector[middle], key);
                log.info(LOG_PATTER_INFO, middle, vector[middle], key, vector[lowLimit], vector[highLimit]);
                highLimit = middle - 1;
            } else {
                log.info("Middle value {} less than element {} will go to right", vector[middle], key);
                log.info(LOG_PATTER_INFO, middle, vector[middle], key, vector[lowLimit], vector[highLimit]);
                lowLimit = middle + 1;
            }
        }
        log.info("Not found element {}", key);
        return -1;
    }

    private static int middleCalc(int lowLimit, int highLimit) {
        return (lowLimit + highLimit) / 2;
    }

    public static int searchRecursive(int key, int[] vector, int left, int right) {
        log.info("Calculating middle.");
        var middle = middleCalc(left, right);
        log.info("Middle index {}, value {}", middle, vector[middle]);
        if (vector[middle] == key) {
            log.info("Middle is the element {}", key);
            log.info(LOG_PATTER_INFO, middle, vector[middle], key, vector[left], vector[right]);
            return middle;
        }
        if (left >= right) {
            log.info("Not found element {}", key);
            return -1;
        } else if (vector[middle] < key) {
            log.info("Middle value {} less than element {} will go to right", vector[middle], key);
            log.info(LOG_PATTER_INFO, middle, vector[middle], key, vector[left], vector[right]);
            return searchRecursive(key, vector, middle + 1, right);
        } else {
            log.info("Middle value {} bigger than element {} will go to left", vector[middle], key);
            log.info(LOG_PATTER_INFO, middle, vector[middle], key, vector[left], vector[right]);
            return searchRecursive(key, vector, left, middle - 1);
        }
    }
}
