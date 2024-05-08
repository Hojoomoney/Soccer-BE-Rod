package com.rod.api.player.web;

import com.rod.api.common.model.Box;
import com.rod.api.common.model.PageDTO;
import com.rod.api.player.repository.PlayerRepository;
import com.rod.api.player.service.PlayerService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/player")
@RequiredArgsConstructor
@Slf4j
public class PlayerController {
    private final PlayerRepository repository;
    private final PlayerRouter router;
    private final PlayerService service;

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "q") String q,
            @RequestParam(value = "playerName", required = false) String playerName,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "teamId", required = false) String teamId,
            @RequestParam(value = "regionName", required = false) String regionName,
            @RequestParam(value = "height", required = false) String height,
            @RequestParam(value = "team1", required = false) String teamName1,
            @RequestParam(value = "team2", required = false) String teamName2,
            @RequestParam(value = "min", required = false) String min,
            @RequestParam(value = "max", required = false) String max,
            Pageable pageable
    ){
        log.info("MY-INFO : Controller searchPlayer q is {}", q);
        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort().toString());

        // nowPage, rowCount, pageSize, blockSize 외부주입.. count, size 1 부터, number 는 0부터
        int totalCount = service.countAllPlayers().intValue(); //db에서 뒤져서 가져오기 갯수
        int blockCount = 0;
        int pageCount = 0;

        int startRow = 0;
        int endRow = 0;

        int startPage = 0;
        int endPage = 0;

        int nextBlock = 0;
        int prevBlock = 0;

        int blockNum = 0;
        int pageNumber = pageable.getPageNumber();

        int pageSize = 10;
        int BLOCK_SIZE = 10;

        boolean existPrev = false;
        boolean existNext = false;

        blockCount = totalCount%(pageSize*BLOCK_SIZE)==0? totalCount/(pageSize*BLOCK_SIZE): totalCount/(pageSize*BLOCK_SIZE)+1 ;
        pageCount = totalCount%pageSize==0? totalCount/pageSize: totalCount/pageSize+1;

        startRow = pageNumber*pageSize-pageSize;
        endRow = startRow+pageSize-1;

        blockNum = pageNumber%BLOCK_SIZE==0?  pageNumber/BLOCK_SIZE : pageNumber/BLOCK_SIZE+1;

        startPage = blockNum*BLOCK_SIZE-BLOCK_SIZE+1;
        endPage = blockNum*BLOCK_SIZE;

        nextBlock = blockNum+1;
        prevBlock = blockNum-1;

        existPrev = blockNum > 1;
        existNext = blockNum < blockCount;


        log.info("MY-INFO : Controller searchPlayer totalCount is {}", totalCount);
        log.info("MY-INFO : Controller searchPlayer pageCount is {}", pageCount);
        log.info("MY-INFO : Controller searchPlayer blockCount is {}", blockCount);
        log.info("MY-INFO : Controller searchPlayer startRow is {}", startRow);
        log.info("MY-INFO : Controller searchPlayer endRow is {}", endRow);
        log.info("MY-INFO : Controller searchPlayer blockNum is {}", blockNum);
        log.info("MY-INFO : Controller searchPlayer startPage is {}", startPage);
        log.info("MY-INFO : Controller searchPlayer endPage is {}", endPage);
        log.info("MY-INFO : Controller searchPlayer existPrev is {}", existPrev);
        log.info("MY-INFO : Controller searchPlayer existNext is {}", existNext);
        log.info("MY-INFO : Controller searchPlayer nextBlock is {}", nextBlock);
        log.info("MY-INFO : Controller searchPlayer prevBlock is {}", prevBlock);

        List<?> o = router.execute(q,playerName,position,teamId,regionName,
                                                        height, teamName1,teamName2,min,max);
        PageDTO page = null;

        Box box = new Box();//빌더만들어야된다.
        box.setPageDTO(page);
        box.setList(o);

        return ResponseEntity.ok(box);
    }

//    @GetMapping(path = "/findAll")
//    public ResponseEntity<?> findAll(){
//        return ResponseEntity.ok(repository.getAllPlayers());
//    }


}


