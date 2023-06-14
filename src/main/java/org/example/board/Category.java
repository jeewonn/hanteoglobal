package org.example.board;

import java.util.ArrayList;
import java.util.List;

class Category {
    private int id;
    private String name;
    private int parentIdx;
    private List<Category> children;

    public Category(int id, String name, int parentIdx) {
        this.id = id;
        this.name = name;
        this.parentIdx = parentIdx;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getParentIdx() {
        return parentIdx;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void addChild(Category child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentIdx=" + parentIdx +
                ", children=" + children +
                '}';
    }
}
