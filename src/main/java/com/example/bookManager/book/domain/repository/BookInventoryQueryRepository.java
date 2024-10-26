package com.example.bookManager.book.domain.repository;

import com.example.bookManager.book.domain.model.BookInventory;
import java.util.List;

public interface BookInventoryQueryRepository {

    BookInventory findByKey(final Long key);

    List<BookInventory> findAllByKey(final List<Long> keys);
}
