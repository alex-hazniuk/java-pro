package com.company.lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
    private final Map<String, List<FileData>> storage = new HashMap<>();

    public void add(String path, FileData fileData) {
        if (path != null
                && fileData != null
                && path.equals(fileData.getPath())) {
            if (storage.containsKey(path)) {
                storage.get(path).add(fileData);
            } else {
                List<FileData> filesByPath = new ArrayList<>();
                filesByPath.add(fileData);
                storage.put(path, filesByPath);
            }
        } else {
            System.out.println("Paths not equal: " + path + ", " + fileData);
        }
    }

    public List<FileData> find(String path) {
        return storage.get(path);
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> filesBySize = new ArrayList<>();
        for (List<FileData> list : storage.values()) {
            for (FileData file : list) {
                if (file.getSize() <= size) {
                    filesBySize.add(file);
                }
            }
        }
        return filesBySize;
    }

    public List<FileData> remove(String path) {
        return storage.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> files = new ArrayList<>();
        for (List<FileData> list : storage.values()) {
            files.addAll(list);
        }
        files.sort(Comparator.comparingInt(FileData::getSize));
        return files;
    }
}
