package com.teachweb.model;


public class Grade {

  private int id;
  private int testid;
  private int studentid;
  private double grade;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTestid() {
    return testid;
  }

  public void setTestid(int testid) {
    this.testid = testid;
  }


  public int getStudentid() {
    return studentid;
  }

  public void setStudentid(int studentid) {
    this.studentid = studentid;
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

}
