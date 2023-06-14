package org.example.board;

import java.util.List;

public class Result {
    private Category parent;
    private List<Category> children;

    public Result(Category parent, List<Category> children) {
        this.parent = parent;
        this.children = children;
    }
}
