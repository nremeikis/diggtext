package com.diggtext.editors;

import com.diggtext.model.Category;
import com.diggtext.service.CategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Will convert ID from combobox to category's instance.
 */
public class CategoryEditor extends PropertyEditorSupport {

    private CategoryService categoryService;

    public CategoryEditor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
    	Category category = categoryService.findById(text);
        setValue(category);
    }
}