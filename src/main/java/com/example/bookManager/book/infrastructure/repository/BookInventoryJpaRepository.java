package com.example.bookManager.book.infrastructure.repository;

import com.example.bookManager.book.infrastructure.persistence.entity.BookInventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInventoryJpaRepository extends JpaRepository<BookInventoryEntity, Long> {}
