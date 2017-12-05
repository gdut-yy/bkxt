package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDao;
import db.ConnectionFactory;
import entity.Course;

public class CourseDaoImpl implements CourseDao {

	//添加新的课程记录
	@Override
	public int add(Course course) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "insert into course(ccode,cname,cmname,cstarttime,cendtime) values(?,?,?,?,?)";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, course.getCcode());
	        pre.setString(2, course.getCname());
	        pre.setString(3, course.getCmname());
	        pre.setString(4, course.getCstarttime());
	        pre.setString(5, course.getCendtime());
	        rows = pre.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try{
	            if (pre!=null)
	                pre.close();
	            if (con != null)
	                con.close();
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return rows;
	}

	//按照课程代码删除专业记录
	@Override
	public int deleteByCcode(String ccode) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "delete from course where ccode=?";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, ccode);
	        rows = pre.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try{
	            if (pre!=null)
	                pre.close();
	            if (con != null)
	                con.close();
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return rows;
	}

	//查找所有专业记录
	@Override
	public ArrayList<Course> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Course> courses = new ArrayList<Course>();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select ccode,cname,cmname,cstarttime,cendtime from course");
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Course course=new Course();
	          course.setCcode(rs.getString(1));
	          course.setCname(rs.getString(2));
	          course.setCmname(rs.getString(3));
	          course.setCstarttime(rs.getString(4));
	          course.setCendtime(rs.getString(5));
	          courses.add(course);
	      }
	  }catch (Exception e){
	      e.printStackTrace();
	  }finally{
	      try {
	          if (rs != null)
	              rs.close();
	          if (pre != null)
	              pre.close();
	          if (con != null)
	              con.close();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	  }
	    return courses;
	}

	@Override
	public ArrayList<Course> findByCmname(String cmname) {
		// TODO Auto-generated method stub
		ArrayList<Course> courses = new ArrayList<Course>();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select ccode,cname,cmname,cstarttime,cendtime from course where cmname=?");
	      pre.setString(1, cmname);
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Course course=new Course();
	          course.setCcode(rs.getString(1));
	          course.setCname(rs.getString(2));
	          course.setCmname(rs.getString(3));
	          course.setCstarttime(rs.getString(4));
	          course.setCendtime(rs.getString(5));
	          courses.add(course);
	      }
	  }catch (Exception e){
	      e.printStackTrace();
	  }finally{
	      try {
	          if (rs != null)
	              rs.close();
	          if (pre != null)
	              pre.close();
	          if (con != null)
	              con.close();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	  }
	    return courses;
	}

	//专业代码查找记录
	@Override
	public Course findByCcode(String ccode) {
		// TODO Auto-generated method stub
		Course course = null;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select ccode,cname,cmname,cstarttime,cendtime from course where ccode=? limit 1");
	      pre.setString(1, ccode);
	      rs = pre.executeQuery();
	      while(rs.next()){
	          course=new Course();
	          course.setCcode(rs.getString(1));
	          course.setCname(rs.getString(2));
	          course.setCmname(rs.getString(3));
	          course.setCstarttime(rs.getString(4));
	          course.setCendtime(rs.getString(5));
	      }
	  }catch (Exception e){
	      e.printStackTrace();
	  }finally{
	      try {
	          if (rs != null)
	              rs.close();
	          if (pre != null)
	              pre.close();
	          if (con != null)
	              con.close();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	  }
	    return course;
	}

	@Override
	public String findCcode(String cname) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String ccode = null;
			    Connection con = ConnectionFactory.getConnection();
			    PreparedStatement pre = null;
			    ResultSet rs = null;
			    try{
			      pre = con.prepareStatement("select ccode from course where cname=?");
			      pre.setString(1, cname);
			      rs = pre.executeQuery();
			      while(rs.next()){
			          ccode = rs.getString(1);
			      }
			  }catch (Exception e){
			      e.printStackTrace();
			  }finally{
			      try {
			          if (rs != null)
			              rs.close();
			          if (pre != null)
			              pre.close();
			          if (con != null)
			              con.close();
			      } catch (SQLException e) {
			          e.printStackTrace();
			      }
			  }
			    return ccode;
	}

}
