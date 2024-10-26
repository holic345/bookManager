package com.example.bookManager.book.domain.repository;

import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.infrastructure.persistence.entity.BookInventoryEntity;

public interface BookInventoryCommandRepository {

    BookInventory createBookInventory(final BookInventoryEntity entity);
}
