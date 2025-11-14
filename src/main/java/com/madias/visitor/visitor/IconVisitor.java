package com.madias.visitor.visitor;

public class IconVisitor implements FSVisitor {
    private String result;

    @Override
    public void visit(FileItem file) {
        result = "\uD83D\uDCC4";
    }

    @Override
    public void visit(FolderItem folder) {
        result = "\uD83D\uDCC1";
    }

    public String getResult() {
        return result;
    }
}