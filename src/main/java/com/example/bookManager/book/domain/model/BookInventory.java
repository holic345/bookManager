package com.example.bookManager.book.domain.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookInventory {

    private Long key;

    private Book book;

    private Boolean isAvailable;

    private Integer totalCnt;

    private Integer soldCnt;

    private Integer remainCnt;

    private LocalDateTime regDate;
}
