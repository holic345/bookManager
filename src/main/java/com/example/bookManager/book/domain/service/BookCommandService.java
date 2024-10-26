package com.example.bookManager.book.domain.service;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.domain.mapper.BookMapper;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.repository.BookCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookCommandService {

    private final BookCommandRepository _commandRepository;

    public Book createBook(final CreateBookCommand command) {

        Book book = BookMapper.INSTANCE.toNewBookDomain(command);

        return _commandRepository.createBook(BookMapper.INSTANCE.toEntity(book));
    }

    public int updateBook(final Book book) {
        return _commandRepository.updateBookNameAndStatus(book.getKey(), book.getName(), book.getStatus());
    }

    public void deleteBook(final Long key) {
        _commandRepository.deleteByKey(key);
    }
}
