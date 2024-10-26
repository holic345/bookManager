package com.example.bookManager.book.domain.mapper;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.infrastructure.persistence.entity.BookInventoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookInventoryMapper {

    BookInventoryMapper INSTANCE = Mappers.getMapper(BookInventoryMapper.class);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "book.createdDate", ignore = true)
    @Mapping(target = "book.modifiedDate", ignore = true)
    BookInventoryEntity toEntity(BookInventory domain);

    @Mapping(source = "entity.createdDate", target = "regDate")
    @Mapping(source = "entity.book.key", target = "bookKey")
    @Mapping(source = "entity.book.modifiedDate", target = "book.modDate")
    BookInventory toDomain(BookInventoryEntity entity);

    default BookInventory toNewBookInventoryDomain(final Book book, final CreateBookCommand command) {
        return BookInventory.builder()
            .book(book)
            .isAvailable(command.isAvailable())
            .totalCnt(command.totalCnt())
            .soldCnt(0)
            .remainCnt(command.totalCnt())
            .build();
    }

    default BookInventoryEntity toNewBookInventoryEntity(final Book book, final CreateBookCommand command) {
        return toEntity(toNewBookInventoryDomain(book, command));
    }
}
