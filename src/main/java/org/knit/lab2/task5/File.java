package org.knit.lab2.task5;

public class File extends FileSystemComponent {

    public File(String name, int size){
        super(name, size);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getSize() {
        return super.getSize();
    }

    @Override
    protected void add(FileSystemComponent component) {
        System.out.println("File не может хранить в себе другие файлы.");
    }

    @Override
    protected void remove(FileSystemComponent component) {
        System.out.println("File не хранит в себе другие файлы.");
    }

    @Override
    protected void display(String name) {
        System.out.println(name + getName() + " (" + getSize() + " bytes)");
    }
}
