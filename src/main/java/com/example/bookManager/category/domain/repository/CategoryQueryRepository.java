package com.example.bookManager.category.domain.repository;

import com.example.bookManager.category.domain.model.Category;
import java.util.Optional;

public interface CategoryQueryRepository {

    Category findByKey(final Long key);

    long countByKey(final Long key);
}
