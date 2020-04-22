package com.company;
import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //подгружаем файлы
        String sourceFile = "sourceFile.txt";
        String resultFile = "resultFile.txt";
        //загружаем файл для чтения и записи
        BufferedReader br = new BufferedReader(new FileReader(sourceFile));
        FileWriter writer = new FileWriter(resultFile);
        //
        String parsingString = "";
        String line = "";
        while (line != null) {
            parsingString += line;
            line = br.readLine();
        }
        //отправляем
        Helper.cutter(parsingString);
        List<String> tree = Tree.addToFile();
        for(String str:tree) {
            str += "\n";
            writer.write(str);
        }
        br.close();
        writer.flush();
    }
}
