package com.example.bookManager.book.application.service;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.application.command.SearchBookCommand;
import com.example.bookManager.book.application.command.UpdateBookCommand;
import com.example.bookManager.book.application.mapper.BookApplicationMapper;
import com.example.bookManager.book.application.usecase.BookUsecase;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.domain.model.BookWithInventory;
import com.example.bookManager.book.domain.service.BookCommandService;
import com.example.bookManager.book.domain.service.BookInventoryCommandService;
import com.example.bookManager.book.domain.service.BookInventoryQueryService;
import com.example.bookManager.book.domain.service.BookQueryService;
import com.example.bookManager.book.presentation.dto.response.BookResponse;
import com.example.bookManager.book.presentation.dto.response.BookWithInventoryResponse;
import com.example.bookManager.category.domain.service.CategoryQueryService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookFacadeService implements BookUsecase {

    private final BookQueryService            _bookQueryService;
    private final BookCommandService          _bookCommandService;

    private final BookInventoryQueryService   _bookInventoryQueryService;
    private final BookInventoryCommandService _bookInventoryCommandService;

    private final CategoryQueryService        _categoryQueryService;

    @Override
    public BookResponse searchBook(final Long key) {

        Book book = _bookQueryService.findByKey(key);

        return BookApplicationMapper.INSTANCE.toBookResponse(book);
    }

    @Override
    public List<BookWithInventoryResponse> searchBooksWithInventoryBySearchConditions(final SearchBookCommand command) {

        // 도서 목록 조회 (검색조건)
        List<Book> books = _bookQueryService.findAllBySearchConditions(command);

        if (books.isEmpty()) {
            return Collections.emptyList();
        }

        // 도서 재고 목록 조회
        List<BookInventory> bookInventories = _bookInventoryQueryService.findAllByKeyIn(books.stream()
                                                                                          .map(Book::getKey)
                                                                                          .collect(Collectors.toList()));

        List<BookWithInventoryResponse> responses = new ArrayList<>();

        for (Book book : books) {
            for (BookInventory bookInventory : bookInventories) {
                if (Objects.equals(bookInventory.getBook().getKey(), book.getKey())) {
                    BookWithInventory bookWithInventory = BookApplicationMapper.INSTANCE.toBookWithInventory(book, bookInventory);
                    responses.add(BookApplicationMapper.INSTANCE.toBookWithInventoryResponse(bookWithInventory));

                }
            }
        }

        return responses;
    }

    @Override
    public void createBook(final CreateBookCommand command) {

        // 카테고리가 존재하는지 검증
        long categoryCount = _categoryQueryService.countByKey(command.categoryKey());

        if (categoryCount == 0) {
            throw new IllegalArgumentException("카테고리가 존재하지 않습니다.");
        }

        // 도서 등록
        Book book = _bookCommandService.createBook(command);

        // 재고 등록
        _bookInventoryCommandService.createInventory(book, command);
    }

    @Override
    public void updateBook(final Long key, final UpdateBookCommand command) {

        // 도서 검증
        Book book = _bookQueryService.findByKey(key);

        // 도서 이름 변경
        book.changeName(command.name());

        _bookCommandService.updateBook(book);
    }

    @Override
    public void deleteBook(final Long key) {
        _bookCommandService.deleteBook(key);
    }
}
