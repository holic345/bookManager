package com.example.bookManager.global.domain;

import lombok.Getter;

@Getter
public record Response<T> (

    T Object
) {}
