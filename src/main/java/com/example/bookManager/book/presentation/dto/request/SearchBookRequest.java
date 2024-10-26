package com.example.bookManager.book.presentation.dto.request;

import com.example.bookManager.book.domain.model.BookStatus;
import lombok.Getter;

@Getter
public record SearchBookRequest(

    String ibsn,

    String name,

    BookStatus status
) {}
