package maintask;

import maintask.data.CollectionFromRootFile;
import maintask.data.CollectionFromTxtFile;

import java.io.*;
import java.util.ArrayList;

public class MainTaskRunnerDifferentData {
    public static void main(String[] args) {
        if (args.length == 1) {
            String stringRootPath = args[0];
            File file = new File(stringRootPath);
            CollectionFromRootFile collectionsFromRootFile = new CollectionFromRootFile(file);
            collectionsFromRootFile.saveCollectionsFromRootFile();

            try (FileWriter writer = new FileWriter("src/maintask/data/rootfilepath.txt");
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                bufferedWriter.write(stringRootPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (args.length == 2 & args[1].equals("src/maintask/data/filestostring.txt")) {
            ArrayList<String> stringsFromRootFilePath = new ArrayList<>();
            try (FileReader reader = new FileReader("src/maintask/data/rootfilepath.txt");
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                bufferedReader.lines().forEach(stringsFromRootFilePath::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (stringsFromRootFilePath.size() == 1 & args[0].equals(stringsFromRootFilePath.get(0))) {
                CollectionFromTxtFile collectionsFromFile = new CollectionFromTxtFile();

                try (FileReader reader = new FileReader("src/maintask/data/filestostring.txt");
                     BufferedReader bufferedReader = new BufferedReader(reader)) {
                    ArrayList<String> strings = new ArrayList<>();
                    bufferedReader.lines().forEach(strings::add);
                    for (String fileToString : strings) {
                        collectionsFromFile.addString(fileToString);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                collectionsFromFile.printData();
            }
        } else {
            throw new IllegalArgumentException("wrong input data");
        }
    }
}