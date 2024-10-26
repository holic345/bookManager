package com.example.bookManager.book.presentation.dto.request;

import lombok.Getter;

@Getter
public record CreateBookRequest(

    Long categoryKey,

    String ibsm,

    String name,

    String authorName,

    String publisherName,

    // yyyyMMdd
    String publishDate,

    Integer price,

    Integer totalCnt,

    Boolean isAvailable
) {}
