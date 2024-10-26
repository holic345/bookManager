package com.example.bookManager.book.infrastructure.persistence.entity;

import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.infrastructure.persistence.Publisher;
import com.example.bookManager.global.domain.BaseTimeEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "BOOK", indexes = {
    @Index(name = "UQ_BOOK_01", unique = true, columnList = "BOOK_KEY, CATEGORY_KEY"),
    @Index(name = "UQ_BOOK_02", unique = true, columnList = "BOOK_IBSN"),
    @Index(name = "IDX_BOOK_01", columnList = "BOOK_STATUS"),
    @Index(name = "IDX_BOOK_02", columnList = "BOOK_NAME"),
    @Index(name = "IDX_BOOK_03", columnList = "AUTHOR_NAME"),
    @Index(name = "IDX_BOOK_04", columnList = "PUBLISH_NAME")
})
@AttributeOverrides(value = {
    @AttributeOverride(name = "createdDate", column = @Column(name = "REG_DATE")),
    @AttributeOverride(name = "modifiedDate", column = @Column(name = "MOD_DATE"))
})
@EntityListeners(AuditingEntityListener.class)
public class BookEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_KEY")
    private Long key;

    @Column(name = "CATEGORY_KEY")
    private Long categoryKey;

    @Column(name = "BOOK_IBSN")
    private String ibsn;

    @Enumerated(EnumType.STRING)
    @Column(name = "BOOK_STATUS")
    private BookStatus status;

    @Column(name = "BOOK_NAME")
    private String name;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "name", column = @Column(name = "PUBLISH_NAME")),
        @AttributeOverride(name = "date", column = @Column(name = "PUBLISH_DATE"))
    })
    private Publisher publisher;
}
