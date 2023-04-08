package org.campus02.addressbook;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddressManager {
    private ArrayList<Address> addresses;// = new ArrayList<>();

    public AddressManager() {
        this.addresses = new ArrayList<>();
    }

    public void add(Address a){
        addresses.add(a);
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void loadFromCsv(String path, String separtor) throws AddressLoadException {

        // 1. Zugriff auf Datei
        //File file = new File(path);
        FileInputStream fileInputStream = null;
        try {
            // 2. FileInputStream
            fileInputStream = new FileInputStream(path);

            String fileContent = "";
            int byteRead = 0;
            ArrayList<String> lines = new ArrayList<>();
            while ((byteRead = fileInputStream.read()) != -1){
                char c = (char) byteRead;
//                String c = Character.toString(byteRead);

                if (c == '\n' || c == '\r'){
                    // Wenn Zeilenumbruch
                    if (fileContent != "")
                        lines.add(fileContent);

                    fileContent = "";
                }
                else
                    fileContent = fileContent + c;

            }

            for (String line : lines) {
                String[] columns = line.split(separtor);
                if (columns.length != 4) {
                    throw new AddressLoadWrongFormatException("Fehler bei Zeile: " + line);
                }
                Address newAddress = new Address(columns[0], columns[1], columns[2], columns[3]);
                add(newAddress);
            }
        } catch (FileNotFoundException e) {
            throw new AddressLoadException(e);
        } catch (IOException e) {
            throw new AddressLoadException(e);
        }
        finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new AddressLoadException(e);
                }
            }
        }
    }

    public void exportToCsv(String path, String separator) throws AddressExportException {
        FileOutputStream fileOutputStream = null;

        File f = new File(path);
        if (f.exists()){
            throw new AddressExportFileAlreadyExistsException("Die Datei '" + path + "' existiert bereits!");
        }

        try {
            fileOutputStream = new FileOutputStream(f);

            for (Address a : addresses) {

                String line = a.getFirstname() + separator + a.getLastname()
                                    + separator + a.getMobileNumber() + separator + a.getEmail() ;

                char[] bytes = line.toCharArray();
                for (char c : bytes){
                    fileOutputStream.write(c);
                }
                fileOutputStream.write(13); // Zeilenumbruch
                fileOutputStream.flush();
            }
        } catch (FileNotFoundException e) {
            throw new AddressExportException(e);
        } catch (IOException e) {
            throw new AddressExportException(e);
        }
        finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new AddressExportException(e);
                }
            }
        }
    }
}
