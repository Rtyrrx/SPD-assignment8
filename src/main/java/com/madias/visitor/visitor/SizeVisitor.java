package com.madias.visitor.visitor;

public class SizeVisitor implements FSVisitor {
    private long result;

    @Override
    public void visit(FileItem file) {
        result = file.getSize();
    }

    @Override
    public void visit(FolderItem folder) {
        result = folder.getItemCount() * 1024L;
    }

    public long getResult() {
        return result;
    }
}