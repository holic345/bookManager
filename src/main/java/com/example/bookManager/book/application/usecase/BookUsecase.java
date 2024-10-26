package com.example.bookManager.book.application.usecase;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.application.command.SearchBookCommand;
import com.example.bookManager.book.application.command.UpdateBookCommand;
import com.example.bookManager.book.presentation.dto.response.BookResponse;
import com.example.bookManager.book.presentation.dto.response.BookWithInventoryResponse;
import java.util.List;

public interface BookUsecase {

    BookResponse searchBook(final Long key);

    List<BookWithInventoryResponse> searchBooksWithInventoryBySearchConditions(final SearchBookCommand command);

    void createBook(final CreateBookCommand command);

    void updateBook(final Long key, final UpdateBookCommand command);

    void deleteBook(final Long key);
}
