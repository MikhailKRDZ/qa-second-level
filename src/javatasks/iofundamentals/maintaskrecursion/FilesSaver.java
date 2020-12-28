package javatasks.iofundamentals.maintaskrecursion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FilesSaver {
    public static void cleanFile() {
        try (FileWriter writer = new FileWriter("src/resources/filestostring.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCollectionsFromRootFile(File dir, int levelDependOfDir, ArrayList<File> listFiles) {
        try (FileWriter writer = new FileWriter("src/resources/filestostring.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            if (dir.isDirectory() && levelDependOfDir == 0) {
                bufferedWriter.write(" " + dir.getName() + "\n");
            } else if (dir.isDirectory() && levelDependOfDir != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < levelDependOfDir; i++) {
                    stringBuilder.append("  |");
                }
                bufferedWriter.write(stringBuilder + "---" + dir.getName() + "\n");
            } else if (dir.isFile()) {
                int counter = listFiles.indexOf(dir) + 1;
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < levelDependOfDir - 1; i++) {
                    stringBuilder.append("  |");
                }
                bufferedWriter.write(stringBuilder + "  " + String.format("%02d", counter) + " " + dir.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
