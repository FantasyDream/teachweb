package com.teachweb.service.impl;

import com.teachweb.dao.SubjectsDao;
import com.teachweb.model.Subjects;
import com.teachweb.service.SubjectsService;
import com.teachweb.utils.Check;
import com.teachweb.utils.Expression;
import com.teachweb.utils.NumTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    SubjectsDao subjectsDao;

    @Override
    public void addSubjects(Subjects subjects) {
        subjectsDao.addSubjects(subjects);
    }

    @Override
    public void deleteSubjects(Subjects subjects) {
        subjectsDao.deleteSubjects(subjects);
    }

    @Override
    public void updateSubjects(Subjects subjects) {
        subjectsDao.updateSubjects(subjects);
    }

    @Override
    public Subjects getSubjects(Subjects subjects) {
        return subjectsDao.getSubjects(subjects);
    }

    @Override
    public List<Subjects> createSubject(int range, int subject_no) throws NumberFormatException{
        Expression e = new Expression();
        Check ch = new Check();
        ArrayList<Subjects> test = new ArrayList<Subjects>();
        for (int i = 1; i <= subject_no; i++) {
            ArrayList<Object> list = e.createExpression(3, range);
            ArrayList<Object> right = e.toRPN(list);
            NumTree tree = new NumTree();
            tree = tree.createTree(right);
            if (ch.checkRPN(tree.toString(tree)) && ch.checkAnswer(tree.getValue())) {
                Subjects subjects = new Subjects();
                subjects.setExpression(Expression.toString(list));
                subjects.setAnswer(tree.getValue().toString());
                subjectsDao.addSubjects(subjects);
                subjects.setId(subjectsDao.getLastInsertId());
                test.add(subjects);
            } else {
                i--;
            }
        }
        return test;
    }
}
