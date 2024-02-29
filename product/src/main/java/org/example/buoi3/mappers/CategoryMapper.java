package org.example.buoi3.mappers;

import org.example.buoi3.models.Category;
import org.example.buoi3.outputs.category.CategoryDataOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "id",source = "category.id"),
            @Mapping(target = "name",source = "category.name")
    })
    CategoryDataOutput toCategoryOutput(Category category);

    List<CategoryDataOutput> toCategoryOutputList(List<Category> categories);

}
