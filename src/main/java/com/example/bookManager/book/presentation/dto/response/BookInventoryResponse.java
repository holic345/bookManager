package com.example.bookManager.book.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record BookInventoryResponse(

    Long key,

    Boolean isAvailable,

    Integer totalCnt,

    Integer soldCnt,

    Integer remainCnt,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDateTime regDate
) {}
