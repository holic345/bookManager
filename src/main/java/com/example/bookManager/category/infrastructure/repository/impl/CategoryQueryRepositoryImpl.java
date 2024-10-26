package com.example.bookManager.category.infrastructure.repository.impl;

import com.example.bookManager.category.domain.mapper.CategoryMapper;
import com.example.bookManager.category.domain.model.Category;
import com.example.bookManager.category.domain.repository.CategoryQueryRepository;
import com.example.bookManager.category.infrastructure.persistence.entity.CategoryEntity;
import com.example.bookManager.category.infrastructure.repository.CategoryJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryQueryRepositoryImpl implements CategoryQueryRepository {

    private final CategoryJpaRepository _jpaRepository;

    @Override
    public Category findByKey(final Long key) {

        CategoryEntity entity = _jpaRepository.findById(key)
            .orElseThrow(EntityNotFoundException::new);

        return CategoryMapper.INSTANCE.toDomain(entity);
    }

    @Override
    public long countByKey(Long key) {
        return _jpaRepository.countByKey(key);
    }
}
