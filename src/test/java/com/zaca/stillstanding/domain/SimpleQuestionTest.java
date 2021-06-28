package com.zaca.stillstanding.domain;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.InitBinder;

import com.zaca.stillstanding.core.question.Question;
import com.zaca.stillstanding.core.question.TagManager;
import com.zaca.stillstanding.core.team.TeamRuntime;
import com.zaca.stillstanding.dto.match.MatchConfigDTO;
import com.zaca.stillstanding.dto.match.MatchStrategyType;
import com.zaca.stillstanding.exception.ConflictException;
import com.zaca.stillstanding.exception.NotFoundException;
import com.zaca.stillstanding.exception.QuestionFormatException;
import com.zaca.stillstanding.exception.StillStandingException;
import com.zaca.stillstanding.service.GameService;
import com.zaca.stillstanding.service.QuestionService;
import com.zaca.stillstanding.service.SessionService;
import com.zaca.stillstanding.service.TeamService;
import com.zaca.stillstanding.tool.QuestionTool;

/**
 *
 * @author hundun
 * Created on 2019/03/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleQuestionTest {
	
    @Autowired
	QuestionService questionService;
    
    @Autowired
	TeamService teamService;
    
    @Autowired
    SessionService sessionService;
    
    @Autowired
    GameService gameService;

	
	@Test
	public void test() throws IOException, StillStandingException {
		
		
		
        // request_0
		MatchConfigDTO matchConfigDTO = new MatchConfigDTO();
		matchConfigDTO.setTeamNames(Arrays.asList(TeamService.DEMO_TEAM_NAME));
		matchConfigDTO.setQuestionPackageName(QuestionTool.TEST_PACKAGE_NAME);
		matchConfigDTO.setMatchStrategyType(MatchStrategyType.ENDLESS);
		String sessionId = gameService.createMatch(matchConfigDTO).getId();
		
		// request_1
        gameService.startMatch(sessionId);
        
        // request_2
        gameService.nextQustion(sessionId);
        
        // request_3
		gameService.teamAnswer(sessionId, "A");
	}


}
