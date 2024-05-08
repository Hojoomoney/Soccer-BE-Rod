//package com.rod.api.common.service.impl;
//
//import com.rod.api.common.model.PageDTO;
//import com.rod.api.common.service.PageService;
//
//public class PageServiceImpl implements PageService {
//    public PageDTO getPageDto(){
//        blockCount = totalCount%(pageSize*BLOCK_SIZE)==0? totalCount/(pageSize*BLOCK_SIZE): totalCount/(pageSize*BLOCK_SIZE)+1 ;
//        pageCount = totalCount%pageSize==0? totalCount/pageSize: totalCount/pageSize+1;
//
//        startRow = pageNumber*pageSize-pageSize;
//        endRow = startRow+pageSize-1;
//
//        blockNum = pageNumber%BLOCK_SIZE==0?  pageNumber/BLOCK_SIZE : pageNumber/BLOCK_SIZE+1;
//
//        startPage = blockNum*BLOCK_SIZE-BLOCK_SIZE+1;
//        endPage = blockNum*BLOCK_SIZE;
//
//        nextBlock = blockNum+1;
//        prevBlock = blockNum-1;
//
//        existPrev = blockNum > 1;
//        existNext = blockNum < blockCount;
//
//        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
//        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
//        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
//        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
//        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
//        log.info("MY-INFO : Controller searchPlayer blockNum is {}", blockNum);
//        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
//        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
//        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
//        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
//        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
//        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);
//
//        return PageDTO.builder()
//
//                .build();
//    }
//}
