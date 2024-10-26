package com.example.bookManager.book.domain.repository;

import com.example.bookManager.book.application.command.SearchBookCommand;
import com.example.bookManager.book.domain.model.Book;
import java.util.List;

public interface BookQueryRepository {

    Book findByKey(final Long key);

    List<Book> findAllBySearchConditions(final SearchBookCommand searchCondition);
}
