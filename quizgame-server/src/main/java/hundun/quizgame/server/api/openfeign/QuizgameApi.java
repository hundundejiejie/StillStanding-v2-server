package hundun.quizgame.server.api.openfeign;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import hundun.quizgame.core.dto.ApiResult;
import hundun.quizgame.core.dto.match.MatchConfigDTO;
import hundun.quizgame.core.dto.match.MatchSituationDTO;
import hundun.quizgame.core.dto.team.TeamConstInfoDTO;

/**
 * @author hundun
 * Created on 2021/05/10
 */
public interface QuizgameApi {
    
    @RequestLine("POST /createEndlessMatch")
    @Headers("Content-Type: application/json")
    ApiResult<MatchSituationDTO> createEndlessMatch(
            MatchConfigDTO matchConfigDTO
            );
    
    @RequestLine("POST /createPreMatch")
    @Headers("Content-Type: application/json")
    ApiResult<MatchSituationDTO> createPreMatch(
            MatchConfigDTO matchConfigDTO
            );
    
    @RequestLine("POST /createMainMatch")
    @Headers("Content-Type: application/json")
    ApiResult<MatchSituationDTO> createMainMatch(
            MatchConfigDTO matchConfigDTO
            );
            
    
    @RequestLine("POST /start?sessionId={sessionId}")
    ApiResult<MatchSituationDTO> start(
            @Param("sessionId") String sessionId
            );
    
    @RequestLine("POST /nextQustion?sessionId={sessionId}")
    ApiResult<MatchSituationDTO> nextQustion(
            @Param("sessionId") String sessionId
            );
    
    @RequestLine("POST /answer?sessionId={sessionId}&answer={answer}")
    ApiResult<MatchSituationDTO> teamAnswer(
            @Param("sessionId") String sessionId,
            @Param("answer") String answer
            );
    
    @RequestLine("POST /use-skill?sessionId={sessionId}&skillName={skillName}")
    ApiResult<MatchSituationDTO> teamUseSkill(
            @Param("sessionId") String sessionId,
            @Param("skillName") String skillName
            );
    
    @RequestLine("GET /listTeams")
    ApiResult<List<TeamConstInfoDTO>> listTeams(
            
            );
    
    @RequestLine("POST /updateTeam")
    @Headers("Content-Type: application/json")
    ApiResult<List<TeamConstInfoDTO>> updateTeam(
            TeamConstInfoDTO teamConstInfoDTO
            );
}
