package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SchoolDao;
import db.ConnectionFactory;
import entity.School;

public class SchoolDaoImpl implements SchoolDao {

	//添加学校
	@Override
	public int add(School school) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "insert into school(shcode,shname,shaddr,shzip,shtel,shtest,shyear) values(?,?,?,?,?,?,?)";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, school.getShcode());
	        pre.setString(2, school.getShname());
	        pre.setString(3, school.getShaddr());
	        pre.setString(4, school.getShzip());
	        pre.setString(5, school.getShtel());
	        pre.setString(6, school.getShtest());
	        pre.setString(7, school.getShyear());
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

	// 获取学校基本信息
	@Override
	public School getSchool() {
		// TODO Auto-generated method stub
		School school = new School();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try {
	      pre = con.prepareStatement("select shcode,shname,shaddr,shzip,shtel,shtest,shyear from school order by shid desc limit 1");
	      rs = pre.executeQuery();
	      while (rs.next()) {
	        school.setShcode(rs.getString(1));
	        school.setShname(rs.getString(2));
	        school.setShaddr(rs.getString(3));
	        school.setShzip(rs.getString(4));
	        school.setShtel(rs.getString(5));
	        school.setShtest(rs.getString(6));
	        school.setShyear(rs.getString(7));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
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
	    return school;
	  }
}
