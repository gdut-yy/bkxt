package dao;

import java.util.ArrayList;

import entity.Course;

public interface CourseDao {
  public int add(Course course);
  public int deleteByCcode(String ccode);
  public ArrayList<Course> findAll();
  public ArrayList<Course> findByCmname(String cmname);
  public Course findByCcode(String ccode);
  public String findCcode(String cname);
}
