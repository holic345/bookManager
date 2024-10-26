package com.example.bookManager.book.infrastructure.persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BookInventoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_INVENTORY_KEY")
    private Long key;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "BOOK_INVENTORY_BOOK_KEY", referencedColumnName = "BOOK_KEY", foreignKey = @ForeignKey(name = "FK_BOOK_INVENTORY_TO_BOOK"))
    private BookEntity book;

    @Column(name = "AVAILABLE_YN")
    private Boolean isAvailable;

    @Column(name = "TOTAL_CNT")
    private Integer totalCnt;

    @Column(name = "SOLD_CNT")
    private Integer soldCnt;

    @Column(name = "REMAIN_CNT")
    private Integer remainCnt;

    @CreatedDate
    @Column(name = "REG_DATE")
    private LocalDateTime createdDate;
}
