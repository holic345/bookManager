package com.example.bookManager.book.presentation.controller;

import com.example.bookManager.book.application.mapper.BookApplicationMapper;
import com.example.bookManager.book.application.usecase.BookUsecase;
import com.example.bookManager.book.presentation.dto.request.CreateBookRequest;
import com.example.bookManager.book.presentation.dto.request.SearchBookRequest;
import com.example.bookManager.book.presentation.dto.request.UpdateBookRequest;
import com.example.bookManager.book.presentation.dto.response.BookResponse;
import com.example.bookManager.book.presentation.dto.response.BookWithInventoryResponse;
import com.example.bookManager.global.domain.Response;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookUsecase _usecase;

    @GetMapping("{key}")
    public Response<BookResponse> searchBook(@PathVariable Long key) {
        return new Response<>(_usecase.searchBook(key));
    }

    @GetMapping("list")
    public Response<List<BookWithInventoryResponse>> searchBooksWithInventoryBySearchConditions(@ModelAttribute SearchBookRequest request) {
        return new Response<>(_usecase.searchBooksWithInventoryBySearchConditions(BookApplicationMapper.INSTANCE.toSearchCommand(request)));
    }

    @PostMapping("create")
    public void createBook(@RequestBody CreateBookRequest request) {
        _usecase.createBook(BookApplicationMapper.INSTANCE.toCreateCommand(request));
    }

    @PatchMapping("{key}")
    public void updateBook(@PathVariable Long key, @RequestBody UpdateBookRequest request) {
        _usecase.updateBook(key, BookApplicationMapper.INSTANCE.toUpdateCommand(request));
    }

    @DeleteMapping("{key}")
    public void deleteBook(@PathVariable Long key) {
        _usecase.deleteBook(key);
    }
}
