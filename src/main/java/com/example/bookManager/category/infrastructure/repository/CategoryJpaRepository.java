package com.example.bookManager.category.infrastructure.repository;

import com.example.bookManager.category.domain.model.Category;
import com.example.bookManager.category.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

    long countByKey(Long key);
}
