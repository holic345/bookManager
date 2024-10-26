package com.example.bookManager.book.domain.service;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.domain.mapper.BookInventoryMapper;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.domain.repository.BookInventoryCommandRepository;
import com.example.bookManager.book.infrastructure.persistence.entity.BookInventoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookInventoryCommandService {

    private final BookInventoryCommandRepository _commandRepository;

    public BookInventory createInventory(final Book book, final CreateBookCommand command) {

        BookInventoryEntity newBookInventoryEntity = BookInventoryMapper.INSTANCE.toNewBookInventoryEntity(book, command);

        return _commandRepository.createBookInventory(newBookInventoryEntity);
    }
}
