package com.rod.api.player.web;

import com.rod.api.common.model.Box;
import com.rod.api.common.model.PageDTO;
import com.rod.api.common.service.PageService;
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
    private final PlayerService service;
    private final PageService pageService;
    private final PlayerRouter router;

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




        List<?> o = router.execute(q,playerName,position,teamId,regionName,
                                                        height, teamName1,teamName2,min,max);
        Long totalCount = service.countAllPlayers();
        Long pageNumber = (long) pageable.getPageNumber();
        Long pageSize = (long) pageable.getPageSize();
        Box box = new Box();
        PageDTO page = pageService.getPageDTO(totalCount,pageNumber,pageSize);
        box.setPageDTO(page);
        box.setList(o);

        return ResponseEntity.ok(box);
    }

//    @GetMapping(path = "/findAll")
//    public ResponseEntity<?> findAll(){
//        return ResponseEntity.ok(repository.getAllPlayers());
//    }


}


