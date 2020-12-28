package maintask.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollectionFromRootFile {
    private final File rootFile;
    private Set<File> rootFolders;
    private Map<File, LinkedList<File>> childrenFoldersMap;
    private Map<File, ArrayList<File>> childrenPagesMap;
    private AbstractSequentialList<File> allFileLinkedList;

    public CollectionFromRootFile(File rootFile) {
        this.rootFile = rootFile;
        setAllFolders(rootFile);
        setMapChildrenFolders(getRootFolders());
        setMapChildrenPagesFromAllFolderList(getRootFolders());
        setLinkedList(rootFile, getChildrenFoldersMap(), getChildrenPagesMap());
    }

    private void setLinkedList(File rootFile, Map<File, LinkedList<File>> childrenFoldersMap, Map<File, ArrayList<File>> childrenPagesMap) {
        AbstractSequentialList<File> fileLinkedList = new LinkedList<>();
        for (File file : getChildrenFoldersMap().keySet()) {
            if (file.equals(rootFile)) {
                fileLinkedList.add(file);
                fileLinkedList.addAll(getChildrenFoldersMap().get(file));
                fileLinkedList.addAll(getChildrenPagesMap().get(file));

            } else if (fileLinkedList.contains(file)) {
                LinkedList<File> fileLinkedListTemp = new LinkedList<>();
                fileLinkedListTemp.addAll(childrenFoldersMap.get(file));
                fileLinkedListTemp.addAll(childrenPagesMap.get(file));
                int fileIndex = fileLinkedList.indexOf(file) + 1;
                fileLinkedList.addAll(fileIndex, fileLinkedListTemp);
            }
        }
        this.allFileLinkedList = fileLinkedList;
    }

    private void setMapChildrenPagesFromAllFolderList(Set<File> rootFolders) {
        Map<File, ArrayList<File>> folderPagesMap = new LinkedHashMap<>();
        for (File folder : rootFolders) {
            ArrayList<File> listPages = new ArrayList<>(Arrays.asList(Objects.requireNonNull(folder.listFiles(File::isFile))));
            folderPagesMap.put(folder, listPages);
        }
        this.childrenPagesMap = folderPagesMap;
    }

    private void setMapChildrenFolders(Set<File> rootFolders) {
        Map<File, LinkedList<File>> mapChildrenFolders = new LinkedHashMap<>();
        for (File folder : rootFolders) {
            LinkedList<File> listChildrenFolders = new LinkedList<>(Arrays.asList(Objects.requireNonNull(folder.listFiles(File::isDirectory))));
            mapChildrenFolders.put(folder, listChildrenFolders);
        }
        this.childrenFoldersMap = mapChildrenFolders;
    }


    public Map<File, ArrayList<File>> getChildrenPagesMap() {
        return childrenPagesMap;
    }

    public File getRootFile() {
        return rootFile;
    }

    public Set<File> getRootFolders() {
        return rootFolders;
    }

    public Map<File, LinkedList<File>> getChildrenFoldersMap() {
        return childrenFoldersMap;
    }

    public AbstractSequentialList<File> getAllFileLinkedList() {
        return allFileLinkedList;
    }

    private void setAllFolders(File rootDirectory) {
        Set<File> setFolders = new LinkedHashSet<>();
        Stack<File> stack = new Stack<>();
        if (rootDirectory.isDirectory()) {
            stack.push(rootDirectory);
        }
        while (!stack.empty()) {
            File tempFile = stack.pop();
            setFolders.add(tempFile);
            for (File file : Objects.requireNonNull(tempFile.listFiles())) {
                if (file.isDirectory()) {
                    stack.push(file);
                }
            }
        }
        this.rootFolders = setFolders;
    }

    public void saveCollectionsFromRootFile() {
        try (FileWriter writer = new FileWriter("src/maintask/data/filestostring.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(getRootFile().getName() + "\n");
            System.out.println(getRootFile().getName());
            for (File file : getAllFileLinkedList()) {
                if (file.isDirectory() & !file.equals(getRootFile())) {
                    String pathFolderDependOfDir = file.getAbsolutePath().substring(getRootFile().getAbsolutePath().length());
                    int levelDependOfDir = pathFolderDependOfDir.length() - pathFolderDependOfDir.replace(File.separator, "").length();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < levelDependOfDir; i++) {
                        stringBuilder.append("  |");
                    }
                    bufferedWriter.write(stringBuilder + "---" + file.getName() + "\n");
                    System.out.println(stringBuilder + "---" + file.getName());
                } else if (file.isFile()) {
                    String pathParentFolderDependOfDir = file.getParentFile().getAbsolutePath().substring(getRootFile().getAbsolutePath().length());
                    int levelDependOfDir = pathParentFolderDependOfDir.length() - pathParentFolderDependOfDir.replace(File.separator, "").length();
                    int indexFile = getChildrenPagesMap().get(file.getParentFile()).indexOf(file) + 1;
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < levelDependOfDir; i++) {
                        stringBuilder.append("  |");
                    }
                    bufferedWriter.write(stringBuilder + "  " + String.format(" %02d ", indexFile) + " " + file.getName() + "\n");
                    System.out.println(stringBuilder + "  " + String.format(" %02d ", indexFile) + " " + file.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------");
    }
}