package com.example.bookManager.book.presentation.dto.response;

import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.infrastructure.persistence.Publisher;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public record BookResponse (

    Long key,

    Long categoryKey,

    String ibsn,

    BookStatus status,

    String name,

    String authorName,

    Publisher publisher,

    LocalDateTime regDate,

    LocalDateTime modDate
) {}
