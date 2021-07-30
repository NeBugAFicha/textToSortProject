package com.alexanov;

import java.io.*;

public class TextFileSort {

    public static void main(String[] args) throws IOException{
        int linesCount, lineSize;
        do {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            linesCount = Integer.parseInt(consoleReader.readLine());
            lineSize = Integer.parseInt(consoleReader.readLine());
        } while (linesCount <= 0 || lineSize <= 0 || linesCount > 500 || lineSize > 500);
        File file = textFileGenerator(linesCount,lineSize);
        BufferedWriter writerOriginalFile = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
        boolean toggler = true;
        while(true) {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(toggler?"../TextFileSortProject//textToSortBuffer2.txt":"../TextFileSortProject//textToSortBuffer1.txt"))){
                BufferedReader reader = new BufferedReader(new FileReader(toggler?"../TextFileSortProject//textToSortBuffer1.txt":"../TextFileSortProject//textToSortBuffer2.txt"));
                String minStr = null, compareStr = null;
                if ((minStr = reader.readLine()) == null) break;
                while ((compareStr = reader.readLine()) != null) {
                    if (minStr.compareTo(compareStr) > 0) minStr = compareStr;
                }
                reader.close();
                reader = new BufferedReader(new FileReader(toggler ? "../TextFileSortProject//textToSortBuffer1.txt" : "../TextFileSortProject//textToSortBuffer2.txt"));
                while ((compareStr = reader.readLine()) != null) {
                    if (minStr.compareTo(compareStr) == 0) writerOriginalFile.write(minStr + "\n");
                    else writer.write(compareStr + "\n");
                }
            }
            toggler = !toggler;
        }
        writerOriginalFile.flush();
        writerOriginalFile.close();
    }
    public static File textFileGenerator(int linesCount, int lineSize) throws IOException{
            File file = new File("../TextFileSortProject//textToSort.txt"),
                 fileBuffer1 = new File("../TextFileSortProject//textToSortBuffer1.txt"),
                 fileBuffer2 = new File("../TextFileSortProject//textToSortBuffer2.txt");
            if(file.delete()) file.createNewFile();
            fileBuffer1.createNewFile();
            fileBuffer2.createNewFile();
            try(PrintWriter newFile = new PrintWriter(file.getAbsolutePath());
                    PrintWriter bufferFile= new PrintWriter(fileBuffer1.getAbsolutePath())){
                for(int i = 0; i < linesCount; i++) {
                    StringBuilder str = new StringBuilder();
                    for (int j = 0; j < lineSize; j++) {
                        str.append((char) (48 + (int) (Math.random() * 75)));
                    }
                    newFile.write(str.toString() + "\n");
                    bufferFile.write(str.toString() + "\n");
                }
            }
            return file;
    }
}
