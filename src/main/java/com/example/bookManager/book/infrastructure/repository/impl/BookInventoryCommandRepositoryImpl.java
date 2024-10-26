package com.example.bookManager.book.infrastructure.repository.impl;

import com.example.bookManager.book.domain.mapper.BookInventoryMapper;
import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.domain.repository.BookInventoryCommandRepository;
import com.example.bookManager.book.infrastructure.persistence.entity.BookInventoryEntity;
import com.example.bookManager.book.infrastructure.repository.BookInventoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookInventoryCommandRepositoryImpl implements BookInventoryCommandRepository {

    private final BookInventoryJpaRepository _jpaRepository;

    @Override
    public BookInventory createBookInventory(BookInventoryEntity entity) {
        return BookInventoryMapper.INSTANCE.toDomain(_jpaRepository.saveAndFlush(entity));
    }
}
