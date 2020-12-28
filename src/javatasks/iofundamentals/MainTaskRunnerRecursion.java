package javatasks.iofundamentals;


import javatasks.iofundamentals.maintaskrecursion.CollectionFromTxtFile;
import javatasks.iofundamentals.maintaskrecursion.FilesSaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MainTaskRunnerRecursion {
    public static void main(String[] args) {
        try {
            if (args[0].length() != 0) {
                String stringRootPath = args[0];
                File txtFileForOutputData = new File("src/resources/filestostring.txt");
                File fileFromInputData = new File(stringRootPath);
                if (fileFromInputData.exists() && fileFromInputData.isDirectory() &&
                        !fileFromInputData.getAbsolutePath().equals(txtFileForOutputData.getAbsolutePath())) {
                    FilesSaver.cleanFile();
                    visitAllDirsAndFiles(fileFromInputData, 0, new ArrayList<>());
                } else if (fileFromInputData.isFile() &&
                        fileFromInputData.getAbsolutePath().equals(txtFileForOutputData.getAbsolutePath())) {
                    CollectionFromTxtFile collectionFromTxtFile = new CollectionFromTxtFile();
                    try (FileReader reader = new FileReader(txtFileForOutputData);
                         BufferedReader bufferedReader = new BufferedReader(reader)) {
                        ArrayList<String> strings = new ArrayList<>();
                        bufferedReader.lines().forEach(strings::add);
                        for (String fileToString : strings) {
                            collectionFromTxtFile.addString(fileToString);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    collectionFromTxtFile.printData();
                } else {
                    throw new IllegalArgumentException("wrong input data");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No data in args");
        }
    }

    public static void visitAllDirsAndFiles(File dir, int levelDependOfDir, ArrayList<File> listFiles) {
        FilesSaver.saveCollectionsFromRootFile(dir, levelDependOfDir, listFiles);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            ArrayList<File> listChildrenFiles = new ArrayList<>(Arrays.asList(Objects.requireNonNull(dir.listFiles((File::isFile)))));
            for (int i = 0; i < Objects.requireNonNull(children).length; i++) {
                visitAllDirsAndFiles(new File(dir, children[i]), levelDependOfDir + 1, listChildrenFiles);
            }
        }
    }
}