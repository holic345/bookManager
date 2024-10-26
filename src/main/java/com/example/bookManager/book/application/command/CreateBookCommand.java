package com.example.bookManager.book.application.command;

import lombok.Getter;

@Getter
public record CreateBookCommand(

    Long categoryKey,

    String ibsm,

    String name,

    String authorName,

    String publisherName,

    String publishDate,

    Integer price,

    Integer totalCnt,

    Boolean isAvailable
) {}
