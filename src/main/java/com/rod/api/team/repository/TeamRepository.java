package com.rod.api.team.repository;

import com.rod.api.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> , TeamDAO{

//    -- 001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오.
//select * from team order by team_name;
    @Query("select new map(t.teamName as teamName) from Team t order by t.teamName")
    List<Map<String, Object>> problem1();

//    -- 문제 11
//-- 팀과 연고지를 연결해서 출력하시오
//-- [팀 명]             [홈구장]
//-- 수원[ ]삼성블루윙즈 수원월드컵경기장
//
//select concat(t.region_name, '[ ]', t.team_name) 팀명, s.stadium_name 홈구장
//from stadium s
//    join team t on s.stadium_id = t.stadium_id;
    @Query("select new map(t.teamName as teamName, t.stadium.stadiumName as stadiumName) " +
            "from Team t ")
    List<Map<String, Object>> problem11();


//-- 문제 10
//-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
//-- 선수를 출력하시오
//-- 단 , 팀명, 선수명 오름차순 정렬하시오
//
//select t.team_name, p.player_name, p.position
//from team t
//    join player p on p.team_id = t.team_id
//where p.team_id in ('K02','K10') and p.position = 'GK'
//order by t.team_name, p.player_name;
    @Query("select new map(t.teamName as teamName, p.playerName as playerName, p.position as position ) " +
            "from Team t join t.player p " +
            "where t.id in (:team1, :team2) and p.position = :position " +
            "order by t.teamName, p.playerName")
    List<Map<String, Object>> problem10(@Param("team1") String team1, @Param("team2") String team2, @Param("position") String position);

//    -- 문제 12
//-- 수원팀(K02) 과 대전팀(K10) 선수들 중
//-- 키가 180 이상 183 이하인 선수들
//-- 키, 팀명, 사람명 오름차순
//
//select p.height, t.team_name, p.player_name
//from team t
//    join player p on p.team_id = t.team_id
//where t.team_id in ('K02','K10') and (p.height between 180 and 183)
//order by p.height, t.team_name, p.player_name;
    @Query("select new map(p.height as height, t.teamName as teamName, p.playerName as playerName) " +
            "from Team t join t.player p " +
            "where t.id in (:team1, :team2) and cast(p.height as double) between :height1 and :height2 " +
            "order by p.height, t.teamName, p.playerName")
    List<Map<String, Object>> problem12(@Param("team1") String team1, @Param("team2") String team2, @Param("height1") double height1, @Param("height2") double height2);

//-- 문제 13
//-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
//-- 팀명과 선수이름 출력 둘다 오름차순
//
//select t.team_name, p.player_name, p.position
//from team t
//    join player p using(team_id)
//where p.position = ''
//order by t.team_name, p.player_name;
    @Query("select new map(t.teamName as teamName, p.playerName as playerName) " +
            "from Team t join t.player p " +
            "where p.position = '' " +
            "order by t.teamName, p.playerName")
    List<Map<String, Object>> problem13();

//-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
//-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
//-- 팀ID, 팀명, 평균키 추출
//-- 인천 유나이티스팀의 평균키 -- 176.59
//-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
//-- 포함되지 않도록 하세요.
//
//select team_id 팀ID,
//        (select team_name from team where team_id = player.team_id) 팀명,
//        ROUND(AVG(height), 2) 평균키
//from player
//where height != ''
//group by team_id
//having ROUND(AVG(height), 2) <
//    (SELECT ROUND(AVG(height), 2)
//    FROM player
//    WHERE team_id = 'K04');
    @Query("select new map(t.id as id, t.teamName as teamName, ROUND(AVG(cast(p.height as double)), 2) as avgHeight) " +
            "from Team t join t.player p " +
            "where p.height != ' ' " +
            "group by t.id " +
            "having ROUND(AVG(cast(p.height as double)), 2) < :height")
    List<Map<String, Object>> problem19(@Param("height") double height);
}
