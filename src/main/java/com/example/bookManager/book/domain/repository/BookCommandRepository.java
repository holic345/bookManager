package com.example.bookManager.book.domain.repository;

import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.infrastructure.persistence.entity.BookEntity;

public interface BookCommandRepository {

    Book createBook(final BookEntity entity);

    int updateBookNameAndStatus(final Long key, final String name, final BookStatus status);

    void deleteByKey(final Long key);
}
