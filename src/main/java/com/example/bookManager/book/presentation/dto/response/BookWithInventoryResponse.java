package com.example.bookManager.book.presentation.dto.response;

import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.infrastructure.persistence.Publisher;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public record BookWithInventoryResponse (

    Long key,

    Long categoryKey,

    String ibsn,

    BookStatus status,

    String name,

    String authorName,

    Publisher publisher,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime regDate,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime modDate,

    BookInventoryResponse bookInventory
) {}
