package com.example.bookManager.book.infrastructure.repository.impl;


import static com.example.bookManager.book.infrastructure.persistence.entity.QBookEntity.bookEntity;

import com.example.bookManager.book.application.command.SearchBookCommand;
import com.example.bookManager.book.domain.mapper.BookMapper;
import com.example.bookManager.book.domain.model.Book;
import com.example.bookManager.book.domain.model.BookStatus;
import com.example.bookManager.book.domain.repository.BookQueryRepository;
import com.example.bookManager.book.infrastructure.persistence.entity.BookEntity;
import com.example.bookManager.book.infrastructure.repository.BookJpaRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class BookQueryRepositoryImpl implements BookQueryRepository {

    private final BookJpaRepository _jpaRepository;
    private final JPAQueryFactory   _jpaQueryFactory;

    @Override
    public Book findByKey(Long key) {

        BookEntity entity = _jpaRepository.findById(key)
            .orElseThrow(EntityNotFoundException::new);

        return BookMapper.INSTANCE.toDomain(entity);
    }

    @Override
    public List<Book> findAllBySearchConditions(final SearchBookCommand searchCondition) {

        List<BookEntity> entities = Optional.ofNullable(_jpaQueryFactory.selectFrom(bookEntity)
                                                            .where(fetchSearchConditions(searchCondition))
                                                            .fetch())
            .orElse(Collections.emptyList());

        return entities.stream()
            .map(BookMapper.INSTANCE::toDomain)
            .toList();
    }

    private BooleanBuilder fetchSearchConditions(SearchBookCommand searchCondition) {

        BooleanBuilder builder = new BooleanBuilder();

        builder.and(bookNameEq(searchCondition.name()));
        builder.and(bookStatusEq(searchCondition.status()));
        builder.and(ibsnEq(searchCondition.ibsn()));

        return builder;
    }

    private BooleanExpression bookNameEq(String name) {
        return StringUtils.hasText(name) ? bookEntity.name.eq(name) : null;
    }

    private BooleanExpression bookStatusEq(BookStatus status) {
        return status != null ? bookEntity.status.eq(status) : null;
    }

    private BooleanExpression ibsnEq(String ibsn) {
        return StringUtils.hasText(ibsn) ? bookEntity.ibsn.eq(ibsn) : null;
    }
}
