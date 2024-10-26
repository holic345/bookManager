package com.example.bookManager.book.application.command;

import com.example.bookManager.book.domain.model.BookStatus;
import lombok.Getter;

@Getter
public record SearchBookCommand(

    String ibsn,

    String name,

    BookStatus status
) {}
