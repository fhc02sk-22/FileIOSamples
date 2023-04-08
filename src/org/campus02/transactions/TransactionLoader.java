package org.campus02.transactions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionLoader {
    public static ArrayList<Transaction> loadTransactions(String path)
            throws LoadException {

        ArrayList<Transaction> result = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine(); // ignore, kopfzeile
            if (line == null)
                return null;
            while ((line = br.readLine()) != null){
                String[] columns = line.split(";");
                double price = Double.parseDouble(columns[2]);

                Transaction t = new Transaction(
                        columns[0], columns[1], price, columns[3],columns[4],
                        columns[5], columns[6], columns[7] );

                result.add(t);
            }
            return result;

        } catch (FileNotFoundException e) {
            throw new LoadException("Datei: " + path, e);
        } catch (IOException e) {
            throw new LoadException("Datei: " + path, e);
        }
    }
}
