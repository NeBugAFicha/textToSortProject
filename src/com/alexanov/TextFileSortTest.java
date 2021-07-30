package com.alexanov;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class TextFileSortTest {

    @Test
    public void textFileGeneratorTest1() {
        try {
            File file = TextFileSort.textFileGenerator(3, 5);
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String str;
            int linesCount = 0, sumOfSymbols = 0;
            while((str = reader.readLine())!=null){
                linesCount++;
                sumOfSymbols+=str.length();
            }
            Assert.assertEquals(linesCount,3);
            Assert.assertEquals(sumOfSymbols, 3*5);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void textFileGeneratorTest2() {
        try {
            File file = TextFileSort.textFileGenerator(500, 500);
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String str;
            int linesCount = 0, sumOfSymbols = 0;
            while((str = reader.readLine())!=null){
                linesCount++;
                sumOfSymbols+=str.length();
            }
            Assert.assertEquals(linesCount,500);
            Assert.assertEquals(sumOfSymbols, 500*500);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void textFileGeneratorTest3() {
        try {
            File file = TextFileSort.textFileGenerator(1, 1);
            BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            String str;
            int linesCount = 0, sumOfSymbols = 0;
            while((str = reader.readLine())!=null){
                linesCount++;
                sumOfSymbols+=str.length();
            }
            Assert.assertEquals(linesCount,1);
            Assert.assertEquals(sumOfSymbols, 1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void mainTest1() throws IOException{
        File file = TextFileSort.textFileGenerator(444,444);
        if(file.delete()) file.createNewFile();
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
        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String str = reader.readLine(),nextLine = null;
        boolean isFail = false;
        while((nextLine = reader.readLine())!=null){
            if(str.compareTo(nextLine)>0){
                isFail = true;
            }
        }
        if(!isFail)Assert.assertEquals(true,true);
        else Assert.fail();
    }
}