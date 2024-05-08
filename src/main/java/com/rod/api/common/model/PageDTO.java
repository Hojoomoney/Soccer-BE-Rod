package com.rod.api.common.model;

import ch.qos.logback.classic.spi.LoggingEventVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component //Object 같은거
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class PageDTO {

    private Long pageSize; // 5개씩 보기 10개씩 보기 등등
    public static final Long BLOCK_SIZE = 10L; // 페이지 수

    private Long totalCount; // rowCount
    private Long pageCount;
    private Long blockCount;

    private Long startRow; //page
    private Long endRow; //page

    private Long startPage; //block
    private Long endPage; //block

    private Long nextBlock;
    private Long prevBlock;

    private Long pageNumber;
    private Long blockNumber;

    private Boolean existPrev;
    private Boolean existNext;

}
