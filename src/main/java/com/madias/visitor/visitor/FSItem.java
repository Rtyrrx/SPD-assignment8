package com.madias.visitor.visitor;

public interface FSItem {
    void accept(FSVisitor visitor);

    String getName();
}