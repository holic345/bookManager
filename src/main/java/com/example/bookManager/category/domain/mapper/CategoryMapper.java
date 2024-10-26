package com.example.bookManager.category.domain.mapper;

import com.example.bookManager.category.domain.model.Category;
import com.example.bookManager.category.infrastructure.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    CategoryEntity toEntity(Category domain);

    @Mapping(source = "entity.createdDate", target = "regDate")
    @Mapping(source = "entity.modifiedDate", target = "modDate")
    Category toDomain(CategoryEntity entity);
}
