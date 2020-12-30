package iofundamentals.maintaskrecursion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesSaver {

    public static void cleanFile(String pathForOutputData) {
        try (FileWriter writer = new FileWriter(pathForOutputData);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveDirFile(String pathForOutputData, File dirFile, int levelDependOfDir) {
        try (FileWriter writer = new FileWriter(pathForOutputData, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            if (dirFile.isDirectory() && levelDependOfDir == 0) {
                bufferedWriter.write(" " + dirFile.getName() + "\n");
            } else if (dirFile.isDirectory() && levelDependOfDir != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < levelDependOfDir; i++) {
                    stringBuilder.append("  |");
                }
                bufferedWriter.write(stringBuilder + "---" + dirFile.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFileFile(String pathForOutputData, File fileFile, int levelDependOfDir, int indexInChildrenPages) {
        try (FileWriter writer = new FileWriter(pathForOutputData, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < levelDependOfDir; i++) {
                stringBuilder.append("  |");
            }
            bufferedWriter.write(stringBuilder + "  " + String.format("%02d", indexInChildrenPages) + " " + fileFile.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}