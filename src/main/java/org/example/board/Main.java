package org.example.board;

public class Main {
    public static void main(String[] args) {
        CategoryManager categoryManager = new CategoryManager();

        // 카테고리 검색
        Category exoCategory = categoryManager.getCategoryByName("남자");
        System.out.println("카테고리명으로 검색한 하위 카테고리:");
        if (exoCategory != null) {
            for (Category child : exoCategory.getChildren()) {
                System.out.println(child);
            }
        }

        // 식별자 검색
        Category categoryById = categoryManager.getCategoryById(2);
        System.out.println("식별자로 검색한 하위 카테고리: \n" + categoryById);

        // JSON 변환
        String json = categoryManager.toJson();
        System.out.println("JSON: \n" + json);
    }
}
