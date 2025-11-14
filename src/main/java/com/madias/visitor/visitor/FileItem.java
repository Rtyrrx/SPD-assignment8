package com.madias.visitor.visitor;

public class FileItem implements FSItem {
    private final String name;
    private final long size;

    public FileItem(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    @Override
    public void accept(FSVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }
}