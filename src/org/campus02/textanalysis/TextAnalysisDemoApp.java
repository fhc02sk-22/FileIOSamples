package org.campus02.textanalysis;

public class TextAnalysisDemoApp {

    public static void main(String[] args) throws IllegalTextAnalysisFormatException {

        ResultManager rm = new ResultManager("D:\\temp\\textanalysis.txt");

        rm.read();

        TextAnalyzer textAnalyzer = new TextAnalyzer(rm, "D:\\temp\\text.txt");
        textAnalyzer.read();

        rm.write();

/*        Character x1 = 'A';
        Character x2 = 'A';

        System.out.println("x1.hashCode() = " + x1.hashCode());
        System.out.println("x2.hashCode() = " + x2.hashCode());*/


    }
}
