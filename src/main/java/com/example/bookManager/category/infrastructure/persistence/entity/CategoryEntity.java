package com.example.bookManager.category.infrastructure.persistence.entity;

import com.example.bookManager.global.domain.BaseTimeEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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

@Entity @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "CATEGORY", indexes = {
    @Index(name = "UQ_CATEGORY_01", unique = true, columnList = "CATEGORY_NAME"),
    @Index(name = "IDX_CATEGORY_01", unique = true, columnList = "CATEGORY_NAME")
})
@AttributeOverrides(value = {
    @AttributeOverride(name = "createdDate", column = @Column(name = "REG_DATE")),
    @AttributeOverride(name = "modifiedDate", column = @Column(name = "MOD_DATE"))
})
@EntityListeners(AuditingEntityListener.class)
public class CategoryEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_KEY")
    private Long key;

    @Column(name = "CATEGORY_NAME")
    private String name;
}
