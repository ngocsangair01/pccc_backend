package org.example.buoi3.services.imp;

import org.example.buoi3.exception.NotFoundException;
import org.example.buoi3.mappers.CategoryMapper;
import org.example.buoi3.models.Category;
import org.example.buoi3.outputs.category.CategoryDataOutput;
import org.example.buoi3.repositories.CategoryRepository;
import org.example.buoi3.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImp(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDataOutput getDetail(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new NotFoundException("Not found category");
        }
        return categoryMapper.toCategoryOutput(category.get());
    }

    @Override
    public List<CategoryDataOutput> getListCategory() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()){
            throw new NotFoundException("Have no category");
        }
        return categories.stream().map(categoryMapper::toCategoryOutput).toList();
    }
}
