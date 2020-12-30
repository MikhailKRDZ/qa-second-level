package iofundamentals;

import iofundamentals.maintaskrecursion.CollectionFromTxtFile;
import iofundamentals.maintaskrecursion.FilesSaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MainTaskRunnerRecursion {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("wrong data in args");
        }

        String stringRootPath = args[0];
        File fileFromInputData = new File(stringRootPath);
        String pathForOutputData = "src/main/java/resources/filestostring.txt";

        if (fileFromInputData.isDirectory()) {
            FilesSaver.cleanFile(pathForOutputData);
            visitAllDirsAndFiles(pathForOutputData, fileFromInputData, 0);
        } else if (stringRootPath.equals(pathForOutputData)) {
            CollectionFromTxtFile collectionFromTxtFile = new CollectionFromTxtFile();
            try (FileReader reader = new FileReader(pathForOutputData);
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

    public static void visitAllDirsAndFiles(String fileForOutputData, File dirFile, int levelDependOfDir) {
        if (dirFile.isDirectory()) {
            FilesSaver.saveDirFile(fileForOutputData, dirFile, levelDependOfDir);
            File[] dirFilesChildrenFolders = dirFile.listFiles((File::isDirectory));
            File[] dirFilesChildrenPages = dirFile.listFiles((File::isFile));
            for (File dirFilesChildrenFolder : Objects.requireNonNull(dirFilesChildrenFolders)) {
                visitAllDirsAndFiles(fileForOutputData, dirFilesChildrenFolder, levelDependOfDir + 1);
            }
            for (int i = 0; i < Objects.requireNonNull(dirFilesChildrenPages).length; i++) {
                FilesSaver.saveFileFile(fileForOutputData, dirFilesChildrenPages[i], levelDependOfDir, i + 1);
            }
        }
    }
}