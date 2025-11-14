package com.madias.visitor.visitor;

public interface FSVisitor {
    void visit(FileItem file);

    void visit(FolderItem folder);
}