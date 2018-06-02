package com.teachweb.service;

import com.teachweb.model.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AnswerServiceTest {

    @Autowired
    AnswerService answerService;
    @Test
    public void addAnswer() {
        Answer answer = new Answer();
        answer.setGradeid(2);
        answer.setSubjectid(1);
        answer.setAnswer("2");
        answerService.addAnswer(answer);
    }

    @Test
    public void deleteAnswer() {
        Answer answer = new Answer();
        answer.setId(1);
        answerService.deleteAnswer(answer);
    }

    @Test
    public void updateAnswer() {
        Answer answer = new Answer();
        answer.setId(2);
        answer.setRight(false);
        answerService.updateAnswer(answer);
    }

    @Test
    public void getAnswer() {
        Answer answer = new Answer();
        answer.setId(2);
        answerService.getAnswer(answer);
        System.out.println(answerService.getAnswer(answer).getAnswer());
    }

    @Test
    public void listAnswer() {
        List<Answer> answers = answerService.listAnswer(2);
        Iterator<Answer> iterator = answers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getId());
        }
    }

}