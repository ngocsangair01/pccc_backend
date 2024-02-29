package org.example.buoi3.services;

import org.example.buoi3.outputs.category.CategoryDataOutput;

import java.util.List;

public interface CategoryService {
    CategoryDataOutput getDetail(Long id);
    List<CategoryDataOutput> getListCategory();
}
