package org.campus02.transactions;

import java.util.ArrayList;
import java.util.Collections;

public class TransactionDemoApp {
    public static void main(String[] args) {

        String path = ".\\data\\transactions.csv";

        try {
            ArrayList<Transaction> transactions =
                    TransactionLoader.loadTransactions(path);

            Collections.sort(transactions, new PriceProductComparator());

            for (Transaction t : transactions) {
                System.out.println(t);
            }

        } catch (LoadException e) {
            e.printStackTrace();
        }

    }
}
