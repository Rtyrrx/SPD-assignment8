package com.madias.visitor.visitor;

public class FolderItem implements FSItem {
    private final String name;
    private final int itemCount;

    public FolderItem(String name, int itemCount) {
        this.name = name;
        this.itemCount = itemCount;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getItemCount() {
        return itemCount;
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