package org.knit.lab2.task5;

public abstract class FileSystemComponent {
    private String name;
    private int size;

    public FileSystemComponent(String name, int size){
        this.name = name;
        this.size = size;
    }
    public FileSystemComponent(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
    protected abstract void add(FileSystemComponent component);
    protected abstract void remove(FileSystemComponent component);
    protected abstract void display(String name);

}
