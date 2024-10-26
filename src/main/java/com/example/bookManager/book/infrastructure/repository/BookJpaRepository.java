package com.example.bookManager.book.infrastructure.repository;

import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.infrastructure.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    @Modifying
    @Query("UPDATE BookEntity b SET b.name = :name, b.status = :status WHERE b.key = :key")
    int updateBookNameAndStatus(final Long key, final String name, final BookStatus status);
}
