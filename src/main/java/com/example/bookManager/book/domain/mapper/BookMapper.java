package com.example.bookManager.book.domain.mapper;

import com.example.bookManager.book.application.command.CreateBookCommand;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.infrastructure.persistence.Publisher;
import com.example.bookManager.book.infrastructure.persistence.entity.BookEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    BookEntity toEntity(Book domain);

    @Mapping(source = "entity.createdDate", target = "regDate")
    @Mapping(source = "entity.modifiedDate", target = "modDate")
    Book toDomain(BookEntity entity);

    default Book toNewBookDomain(final CreateBookCommand command) {
        return Book.builder()
            .categoryKey(command.categoryKey())
            .ibsn(command.ibsm())
            .status(BookStatus.STABLE)
            .name(command.name())
            .authorName(command.authorName())
            .publisher(Publisher.builder()
                           .name(command.publisherName())
                           .date(LocalDate.parse(command.publishDate(), DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay()).build())
            .build();
    }
}
