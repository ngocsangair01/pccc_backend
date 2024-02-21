package org.example.buoi3.mappers;

import org.example.buoi3.inputs.category.CategoryDataInput;
import org.example.buoi3.models.Category;
import org.example.buoi3.outputs.category.CategoryDataOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "name",source = "input.name")
    })
    Category toCategory(CategoryDataInput input,Long id);

    @Mappings({
            @Mapping(target = "id",source = "category.id"),
            @Mapping(target = "name",source = "category.name")
    })
    CategoryDataOutput toCategoryOutputClient(Category category);

    CategoryDataOutput toCategoryOutputAdmin(Category category);
}
