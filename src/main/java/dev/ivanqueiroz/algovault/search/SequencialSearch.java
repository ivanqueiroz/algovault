package dev.ivanqueiroz.algovault.search;

import dev.ivanqueiroz.algovault.model.Product;

public class SequencialSearch {

    private SequencialSearch() {
        throw new UnsupportedOperationException();
    }

    public static int searchCheaper(Product[] products, int start, int end) {
        int cheaper = start;
        for(int current = start; current <= end; current++){
            if(products[current].getPrice() < products[cheaper].getPrice()) {
                cheaper = current;

            }
        }
        return cheaper;
    }
}
