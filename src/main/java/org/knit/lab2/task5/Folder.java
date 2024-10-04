package org.knit.lab2.task5;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent {
    private int size;
    List<FileSystemComponent> files;
    public Folder(String name) {
        super(name);
        files = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int result = 0;
        for (FileSystemComponent file : files) {
            result += file.getSize();
        }
        return result;
    }

    @Override
    protected void add(FileSystemComponent component) {
        files.add(component);
    }

    @Override
    protected void remove(FileSystemComponent component) {
        files.remove(component);
    }

    @Override
    protected void display(String name) {
        name = name.isEmpty() ? " " : name;
        System.out.println(name + getName());
        for (FileSystemComponent file : files) {
            file.display(name + name);
        }
    }
}
