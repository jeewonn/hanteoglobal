package org.example.board;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.stream.Collectors;

class CategoryManager {
    private final Map<Integer, Category> categoryMap;

    public CategoryManager() {
        categoryMap = new HashMap<>();

        // 카테고리 추가
        addCategory(1, "남자", -1);
        addCategory(2, "엑소", 1);
        addBoard(1, addCategory(3, "공지사항", 2));
        addBoard(2, addCategory(4, "첸", 2));
        addBoard(3, addCategory(5, "백현", 2));
        addBoard(4, addCategory(6, "시우민", 2));

        addCategory(7, "방탄소년단", 1);
        addBoard(5, addCategory(8, "공지사항", 7));
        addBoard(6, addCategory(9, "익명게시판", 7));
        addBoard(7, addCategory(10, "뷔",7));

        addCategory(11, "여자", -1);
        addCategory(12, "블랙핑크", 11);
        addBoard(8, addCategory(13, "공지사항", 12));
        addBoard(6, addCategory(14, "익명게시판", 12));
        addBoard(9, addCategory(15, "로제", 12));
    }

    public Category addCategory(int id, String name, int parentId) {
        Category category = new Category(id, name, parentId);
        categoryMap.put(id, category);

        if (parentId != -1) {
            Category parentCategory = categoryMap.get(parentId);
            if (parentCategory != null) {
                parentCategory.addChild(category);
            }
        }
        return category;
    }

    public void addBoard(int boardId, Category category){
        new Board(boardId, category);
    }

    public List<Category> getCategories() {
        return categoryMap.values().stream()
                .filter(category -> category.getParentIdx() == -1)
                .collect(Collectors.toList());
    }

    public Category getCategoryById(int id) {
        return categoryMap.get(id);
    }

    public Category getCategoryByName(String name) {
        return categoryMap.values().stream()
                .filter(category -> category.getName().equals(name)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this.getCategories());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
