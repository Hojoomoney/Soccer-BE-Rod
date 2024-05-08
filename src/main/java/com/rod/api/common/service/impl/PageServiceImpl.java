package com.rod.api.common.service.impl;

import com.rod.api.common.model.PageDTO;
import com.rod.api.common.service.PageService;
import com.rod.api.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PageServiceImpl implements PageService {
    Long BLOCK_SIZE = PageDTO.BLOCK_SIZE;
    public PageDTO getPageDTO(Long totalCount, Long pageNumber, Long pageSize){

        Long pageCount = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
        Long blockCount = pageCount % BLOCK_SIZE == 0 ? pageCount/BLOCK_SIZE : pageCount/BLOCK_SIZE + 1;

        Long blockNumber = pageNumber % BLOCK_SIZE == 0 ? pageNumber/BLOCK_SIZE : pageNumber/BLOCK_SIZE+1;

        Long startRow = (pageNumber-1)*pageSize;
        Long endRow = startRow+pageSize-1;

        Long startPage = (blockNumber-1) * BLOCK_SIZE + 1;
        Long endPage = startPage+BLOCK_SIZE-1;

        Long nextBlock = blockNumber++;
        Long prevBlock = blockNumber--;

        Boolean existPrev = prevBlock > 0;
        Boolean existNext = nextBlock < blockCount;

        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
        log.info("MY-INFO : Controller searchPlayer blockNum is {}", blockNumber);
        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);


        return PageDTO.builder()
                .pageSize(pageSize)
                .pageCount(pageCount)
                .totalCount(totalCount)
                .blockCount(blockCount)
                .pageNumber(pageNumber)
                .blockNumber(blockNumber)
                .startRow(startRow)
                .endRow(endRow)
                .startPage(startPage)
                .endPage(endPage)
                .nextBlock(nextBlock)
                .prevBlock(prevBlock)
                .existNext(existNext)
                .existPrev(existPrev)
                .build();
    }
}
