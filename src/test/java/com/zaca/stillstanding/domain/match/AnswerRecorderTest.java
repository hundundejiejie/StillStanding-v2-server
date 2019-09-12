package com.zaca.stillstanding.domain.match;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author hundun
 * Created on 2019/09/07
 */
public class AnswerRecorderTest {

    static AnswerRecorder recorderSingle = new AnswerRecorder();
    
    
    @BeforeClass
    public static void beforeClass() {
        recorderSingle.addRecord("t1", "", "", true);
        recorderSingle.addRecord("t1", "", "", false);
        recorderSingle.addRecord("t1", "", "", true);
        recorderSingle.addRecord("t1", "", "", false);
        recorderSingle.addRecord("t1", "", "", false);
    }
    
    @Test
    public void isSumAtLeastByTeam() {
        assertEquals(true, recorderSingle.isSumAtLeastByTeam("t1", 4));
        assertEquals(true, recorderSingle.isSumAtLeastByTeam("t1", 5));
        assertEquals(false, recorderSingle.isSumAtLeastByTeam("t1", 6));
    }
    
    @Test
    public void isConsecutiveWrongAtLeastByTeam() {
        assertEquals(true, recorderSingle.isConsecutiveWrongAtLeastByTeam("t1", 1));
        assertEquals(true, recorderSingle.isConsecutiveWrongAtLeastByTeam("t1", 2));
        assertEquals(false, recorderSingle.isConsecutiveWrongAtLeastByTeam("t1", 3));
    }

}