package maintask.data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionFromTxtFile {
    private final LinkedList<String> allItemToStringLinkedList = new LinkedList<>();

    public int getNumberFolders() {
        int sum = 0;
        for (String fileToString : this.allItemToStringLinkedList) {
            if (fileToString.contains("---")) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public int getNumberFiles() {
        int sum = 0;

        for (String fileToString : this.allItemToStringLinkedList) {
            Pattern pattern = Pattern.compile("\\s\\d\\d\\s");
            Matcher matcher = pattern.matcher(fileToString);
            if (matcher.find()) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public double getAverageFilesInFolders() {
        return (double) getNumberFiles() / getNumberFolders();
    }

    public double getAverageFilesNameLength() {
        Iterator<String> pagesIterator = this.allItemToStringLinkedList.iterator();
        int sum = 0;
        while (pagesIterator.hasNext()) {
            String pagesName = pagesIterator.next();
            Pattern pattern = Pattern.compile("\\s\\d\\d\\s");
            Matcher matcher = pattern.matcher(pagesName);
            if (!matcher.find()) {
                pagesIterator.remove();
            } else {
                int indexOfCh = pagesName.lastIndexOf('.');
                int indexOfFirstNamesLetter = pagesName.lastIndexOf(' ') + 1;
                int fileNameLength = 0;
                if ((indexOfCh > 0) && (indexOfCh < pagesName.length() - 1)) {
                    fileNameLength = pagesName.substring(indexOfFirstNamesLetter, indexOfCh).length();
                }
                sum = sum + fileNameLength;
            }
        }
        return (double) sum / getNumberFiles();
    }

    public void printData() {
        System.out.println("allItemToStringLinkedList size:" + allItemToStringLinkedList.size());
        System.out.println("Number Folders:" + getNumberFolders());
        System.out.println("Number Files:" + getNumberFiles());
        System.out.println("Average number Files in Folders:" + getAverageFilesInFolders());
        System.out.println("Average  files name length:" + getAverageFilesNameLength());
    }

    public void addString(String string) {
        this.allItemToStringLinkedList.add(string);
    }
}