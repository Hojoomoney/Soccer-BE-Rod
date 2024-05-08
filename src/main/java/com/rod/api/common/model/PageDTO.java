package com.rod.api.common.model;

import com.querydsl.core.annotations.QueryProjection;
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

    private Long pageSize;
    private static Long BLOCK_SIZE = 10L;

    private Long totalCount;
    private Long blockCount;
    private Long pageCount;

    private Long startRow;
    private Long endRow;

    private Long startPage;
    private Long endPage;

    private Long nextBlock;
    private Long prevBlock;

    private Long blockNum;
    private Long pageNumber;

    private Boolean existPrev;
    private Boolean existNext;


//    @QueryProjection
//    public PlayerDTO(String playerName, String height, String weight) {
//        this.playerName = playerName;
//        this.height = height;
//        this.weight = weight;
//    }


}
