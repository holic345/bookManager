package com.example.bookManager.book.application.mapper;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.application.command.SearchBookCommand;
import com.example.bookManager.book.application.command.UpdateBookCommand;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.domain.model.BookWithInventory;
import com.example.bookManager.book.presentation.dto.request.CreateBookRequest;
import com.example.bookManager.book.presentation.dto.request.SearchBookRequest;
import com.example.bookManager.book.presentation.dto.request.UpdateBookRequest;
import com.example.bookManager.book.presentation.dto.response.BookResponse;
import com.example.bookManager.book.presentation.dto.response.BookWithInventoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookApplicationMapper {

    BookApplicationMapper INSTANCE = Mappers.getMapper(BookApplicationMapper.class);

    // toCommand
    CreateBookCommand toCreateCommand(CreateBookRequest request);
    SearchBookCommand toSearchCommand(SearchBookRequest request);
    UpdateBookCommand toUpdateCommand(UpdateBookRequest request);

    // toResponse
    BookResponse toBookResponse(Book domain);
    BookWithInventoryResponse toBookWithInventoryResponse(BookWithInventory domain);

    default BookWithInventory toBookWithInventory(Book book, BookInventory bookInventory) {
        return BookWithInventory.builder()
            .key(book.getKey())
            .categoryKey(book.getCategoryKey())
            .ibsn(book.getIbsn())
            .status(book.getStatus())
            .name(book.getName())
            .authorName(book.getAuthorName())
            .publisher(book.getPublisher())
            .regDate(book.getRegDate())
            .modDate(book.getModDate())
            .bookInventory(bookInventory)
            .build();
    }
}
