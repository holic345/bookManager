package com.example.bookManager.book.infrastructure.repository.impl;

import com.example.bookManager.book.domain.mapper.BookMapper;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.domain.repository.BookCommandRepository;
import com.example.bookManager.book.infrastructure.persistence.entity.BookEntity;
import com.example.bookManager.book.infrastructure.repository.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookCommandRepositoryImpl implements BookCommandRepository {

    private final BookJpaRepository _jpaRepository;

    @Override
    public Book createBook(final BookEntity entity) {
        return BookMapper.INSTANCE.toDomain(_jpaRepository.saveAndFlush(entity));
    }

    @Override
    public int updateBookNameAndStatus(final Long key, final String name, final BookStatus status) {
        return _jpaRepository.updateBookNameAndStatus(key, name, status);
    }

    @Override
    public void deleteByKey(Long key) {
        _jpaRepository.deleteById(key);
    }
}
