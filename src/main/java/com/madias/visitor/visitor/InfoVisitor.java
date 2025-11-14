package com.madias.visitor.visitor;

public class InfoVisitor implements FSVisitor {
    private String result;

    @Override
    public void visit(FileItem file) {
        result = String.format("File: %s, size: %d bytes", file.getName(), file.getSize());
    }

    @Override
    public void visit(FolderItem folder) {
        result = String.format("Folder: %s, items: %d", folder.getName(), folder.getItemCount());
    }

    public String getResult() {
        return result;
    }
}