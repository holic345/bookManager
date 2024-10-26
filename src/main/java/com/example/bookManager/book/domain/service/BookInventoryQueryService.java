package com.example.bookManager.book.domain.service;

import com.example.bookManager.book.domain.model.BookInventory;
import com.example.bookManager.book.domain.repository.BookInventoryQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookInventoryQueryService {

    private final BookInventoryQueryRepository _queryRepository;

    public List<BookInventory> findAllByKeyIn(final List<Long> keys) {
        return _queryRepository.findAllByKey(keys);
    }
}
