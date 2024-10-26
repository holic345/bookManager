package com.example.bookManager.category.domain.service;

import com.example.bookManager.category.domain.model.Category;
import com.example.bookManager.category.domain.repository.CategoryQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryQueryService {

    private final CategoryQueryRepository _queryRepository;

    public Category findByKey(final Long key) {
        return _queryRepository.findByKey(key);
    }

    public long countByKey(final Long key) {
        return _queryRepository.countByKey(key);
    }
}
