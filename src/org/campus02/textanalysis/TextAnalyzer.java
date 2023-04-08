package org.campus02.textanalysis;

import java.io.*;

public class TextAnalyzer {

    private ResultManager resultManager;
    private String path;

    public TextAnalyzer(ResultManager resultManager, String path) {
        this.resultManager = resultManager;
        this.path = path;
    }

    public void read() {

       // try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {
        try (BufferedReader bis = new BufferedReader(new FileReader(path))) {

            int byteRead;
            while ((byteRead = bis.read()) != -1) {
                char c = (char) byteRead;

                if (!Character.isLetterOrDigit(c))
                    continue;

                if (resultManager.getCharacters().containsKey(c)){
                    int value = resultManager.getCharacters().get(c);
                    value++;
                    resultManager.getCharacters().put(c, value);
                } else {
                    resultManager.getCharacters().put(c, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
