package org.campus02.transactions;


import java.util.Comparator;

public class PriceProductComparator
        implements Comparator<Transaction> {

    @Override
    public int compare(Transaction o1, Transaction o2) {

        int comp = ((Double)o1.getPrice()).compareTo(o2.getPrice());
        if (comp == 0){
            return o2.getProduct().compareTo(o1.getProduct());
        }

        return comp;
    }
}
