package com.zaca.stillstanding.domain.match;

import com.zaca.stillstanding.domain.buff.BuffModel;
import com.zaca.stillstanding.domain.buff.BuffEffect;
import com.zaca.stillstanding.domain.buff.ScoreScaleBuffEffect;
import com.zaca.stillstanding.domain.event.MatchEvent;
import com.zaca.stillstanding.domain.event.MatchEventFactory;
import com.zaca.stillstanding.domain.question.AnswerType;
import com.zaca.stillstanding.domain.team.HealthType;
import com.zaca.stillstanding.domain.team.Team;
import com.zaca.stillstanding.exception.TeamDeadException;
import com.zaca.stillstanding.service.BuffService;
import com.zaca.stillstanding.service.QuestionService;
import com.zaca.stillstanding.service.RoleSkillService;
import com.zaca.stillstanding.service.TeamService;

/**
 * @author hundun
 * Created on 2019/09/10
 */
public class MainMatch extends BaseMatch {
    


    public MainMatch(
            QuestionService questionService, 
            TeamService teamService, 
            RoleSkillService roleSkillService,
            BuffService buffService
            ) {
        super(questionService, teamService, roleSkillService, buffService,
                HealthType.CONSECUTIVE_WRONG_AT_LEAST
                );
    }

    
    @Override
    protected MatchEvent checkSwitchTeamEvent() {
        /*
         * 每一题换队（被调用一定换）
         */
        Team lastTeam = currentTeam;
        switchToNextTeam();
        return MatchEventFactory.getTypeSwitchTeam(lastTeam, currentTeam);
    }


    @Override
    protected int calculateCurrentHealth() {
        int fullHealth = 1;
        /*
         * 连续答错数, 即为健康度的减少量。
         */
        int currentHealth = fullHealth - recorder.countConsecutiveWrong(currentTeam.getName(), fullHealth);
        return currentHealth;
    }

}
