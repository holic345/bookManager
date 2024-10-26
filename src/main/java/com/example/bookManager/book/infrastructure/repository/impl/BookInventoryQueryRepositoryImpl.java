package com.example.bookManager.book.infrastructure.repository.impl;

import com.example.bookManager.book.domain.mapper.BookInventoryMapper;
import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.domain.repository.BookInventoryQueryRepository;
import com.example.bookManager.book.infrastructure.persistence.entity.BookInventoryEntity;
import com.example.bookManager.book.infrastructure.repository.BookInventoryJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookInventoryQueryRepositoryImpl implements BookInventoryQueryRepository {

    private final BookInventoryJpaRepository _jpaRepository;

    @Override
    public BookInventory findByKey(final Long key) {

        BookInventoryEntity entity = _jpaRepository.findById(key)
            .orElseThrow(EntityNotFoundException::new);

        return BookInventoryMapper.INSTANCE.toDomain(entity);
    }

    @Override
    public List<BookInventory> findAllByKey(List<Long> keys) {

        List<BookInventoryEntity> entities = _jpaRepository.findAllById(keys);

        return entities.stream()
            .map(BookInventoryMapper.INSTANCE::toDomain)
            .collect(Collectors.toList());
    }
}
