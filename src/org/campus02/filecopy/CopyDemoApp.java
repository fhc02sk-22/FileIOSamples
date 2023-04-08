package org.campus02.filecopy;

import java.io.*;

public class CopyDemoApp {

    public static void main(String[] args) {

        String source = "D:\\temp\\jre-8u281-windows-x64.exe";
        String destination = "D:\\temp\\copy-file.exe";

        try {
            System.out.println("Starting to copy " + source + " >> to >> " + destination);
            copyFiles(source, destination);
            System.out.println("finished");
        } catch (FileAlreadyExistsException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFiles(String source, String destination) throws FileAlreadyExistsException, IOException {

        File sourceFile = new File(source);
        File destinationFile = new File(destination);
        long length = sourceFile.length();

        if (destinationFile.exists()){
            throw new FileAlreadyExistsException("Destination exists already: " + destination);
            //return;
        }

        BufferedInputStream fileInputStream = null;
        BufferedOutputStream fileOutputStream = null;

        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            fileInputStream = new BufferedInputStream(fis);
            fileOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFile, false));

            int byteRead = 0;

            int counter = 0;
            int percent = 0;
            int lastpercent = 0;
            System.out.print("writing ... ");
            while ((byteRead = fileInputStream.read()) != -1) {
                fileOutputStream.write(byteRead);
                counter++;
                percent = (int) ((counter / (length *1.0)) * 100);

                if (percent != lastpercent) {
                    lastpercent = percent;
                    System.out.print(percent + "%.");
                }
            }
            fileOutputStream.flush();
        } finally {
            try {
                fileInputStream.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }

            try {
                fileOutputStream.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }
}
