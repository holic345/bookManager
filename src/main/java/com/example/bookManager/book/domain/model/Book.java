package com.example.bookManager.book.domain.model;

import com.example.bookManager.book.infrastructure.persistence.Publisher;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book {

    private Long key;

    private Long categoryKey;

    private String ibsn;

    private BookStatus status;

    private String name;

    private String authorName;

    private Publisher publisher;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    public void changeName(String name) {
        this.name = name;
    }
}
