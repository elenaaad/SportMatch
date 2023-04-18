package com.example.sportmatch;

import java.util.ArrayList;

public class AllCategory {
    String title;

    ArrayList<CategoryItemClass> categoryItemClassList;

    public AllCategory(String title, ArrayList<CategoryItemClass> categoryItemClassList) {
        this.title = title;
        this.categoryItemClassList = categoryItemClassList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<CategoryItemClass> getCategoryItemClassList() {
        return categoryItemClassList;
    }

    public void setCategoryItemClassList(ArrayList<CategoryItemClass> categoryItemClassList) {
        this.categoryItemClassList = categoryItemClassList;
    }


}
