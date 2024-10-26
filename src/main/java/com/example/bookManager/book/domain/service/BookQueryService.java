package com.example.bookManager.book.domain.service;

import com.example.bookManager.book.application.command.SearchBookCommand;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.repository.BookQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookQueryService {

    private final BookQueryRepository _queryRepository;

    public Book findByKey(final Long key) {
        return _queryRepository.findByKey(key);
    }

    public List<Book> findAllBySearchConditions(final SearchBookCommand command) {
        return _queryRepository.findAllBySearchConditions(command);
    }
}
