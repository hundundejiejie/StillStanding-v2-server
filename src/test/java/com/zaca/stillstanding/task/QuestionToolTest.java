package com.zaca.stillstanding.task;

import java.util.HashSet;

import org.junit.Test;

import com.zaca.stillstanding.tool.QuestionTool;

public class QuestionToolTest {
	
	@Test
	public void task() {
		//System.out.println(QuestionTool.replaceFileNamesInFolder("data/questions/动画", "动画_", ""));
	    System.out.println(QuestionTool.obfuscateFolder("data/questions", "data/questions_test", new HashSet<>()));
	}

}