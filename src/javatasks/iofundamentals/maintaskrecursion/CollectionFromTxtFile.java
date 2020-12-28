package javatasks.iofundamentals.maintaskrecursion;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionFromTxtFile {
    private int numberFolders;
    private int filesNameLengthSum;
    private final LinkedList<String> filesToStringLinkedList = new LinkedList<>();
    private final LinkedList<String> allItemToStringLinkedList = new LinkedList<>();

    public int getNumberFolders() {
        return this.numberFolders;
    }

    public int getNumberFiles() {
        return this.filesToStringLinkedList.size();
    }

    public double getAverageFilesInFolders() {
        return (double) getNumberFiles() / getNumberFolders();
    }

    public double getAverageFilesNameLength() {
        return (double) this.filesNameLengthSum / getNumberFiles();
    }

    public void printData() {
        System.out.println("allItemToStringLinkedList size:" + allItemToStringLinkedList.size());
        System.out.println("Number Folders:" + getNumberFolders());
        System.out.println("Number Files:" + getNumberFiles());
        System.out.println("Average number Files in Folders:" + getAverageFilesInFolders());
        System.out.println("Average  files name length:" + getAverageFilesNameLength());
    }

    public void addString(String string) {
        Pattern pattern = Pattern.compile("(?:\\^|\\s+)\\d+\\s+");
        Matcher matcher = pattern.matcher(string);
        this.allItemToStringLinkedList.add(string);
        if (matcher.find()) {
            this.filesToStringLinkedList.add(string);
            setFilesNameLengthSum(string);
        }
        if (string.contains("---")) {
            numberFolders = numberFolders + 1;
        }
    }

    private void setFilesNameLengthSum(String pagesToString) {
        int indexOfCh = pagesToString.lastIndexOf('.');
        int indexOfFirstNamesLetter = pagesToString.lastIndexOf(' ') + 1;
        int fileNameLength = 0;
        if ((indexOfCh > 0) && (indexOfCh < pagesToString.length() - 1)) {
            fileNameLength = pagesToString.substring(indexOfFirstNamesLetter, indexOfCh).length();
        }
        this.filesNameLengthSum = this.filesNameLengthSum + fileNameLength;
    }
}