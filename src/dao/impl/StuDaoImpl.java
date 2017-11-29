package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.StuDao;
import db.ConnectionFactory;
import entity.Stu;

public class StuDaoImpl implements StuDao{

	//添加一个新的学生
	  public int add(Stu stu) {
	    int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "insert into stu(username,password,regip,regtime) values(?,?,?,NOW())";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, stu.getUsername());
	        pre.setString(2, stu.getPassword());
	        pre.setString(3, stu.getRegip());
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

	//通过用户名查找用户
	@Override
	public Stu findByUsername(String username) {
		// TODO Auto-generated method stub
		Stu stu = null;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select username,regip,regtime from stu where username=? limit 1");
	      pre.setString(1, username);
	      rs = pre.executeQuery();
	      while(rs.next()){
	          stu=new Stu();
	          stu.setUsername(rs.getString(1));
	          stu.setRegip(rs.getString(2));
	          stu.setRegtime(rs.getString(3));
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
	    return stu;
	}

	//验证登录
	@Override
	public Stu validateLogin(String username, String password) {
		// TODO Auto-generated method stub
		Stu stu = null;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select * from stu where username=? and password=? limit 1");
	      pre.setString(1, username);
	      pre.setString(2, password);
	      rs = pre.executeQuery();
	      while(rs.next()){
	          stu=new Stu();
	          stu.setUsername(rs.getString(1));
	          stu.setRegip(rs.getString(2));
	          stu.setRegtime(rs.getString(3));
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
	    return stu;
	}

	//修改个人密码
	@Override
	public int passModify(String username, String newpass) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "update stu set password=? where username=?";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, newpass);
	        pre.setString(2, username);
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

	//按照用户名模糊查找匹配用户，仅显示出前10条
	@Override
	public ArrayList<Stu> findStusLikeUsername(String username) {
		// TODO Auto-generated method stub
		ArrayList<Stu> stus = new ArrayList<Stu>();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      String sql = "select username,regip,regtime from stu where username like ? limit 10" ;
	      pre = con.prepareStatement(sql);
	      pre.setString(1, "%" + username + "%");
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Stu stu=new Stu();
	          stu.setUsername(rs.getString(1));
	          stu.setRegip(rs.getString(2));
	          stu.setRegtime(rs.getString(3));
	          stus.add(stu);
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
	    return stus;
	}

	//按照身份证号模糊查找匹配用户，仅显示出前10条
	@Override
	public ArrayList<Stu> findStusLikeIdcode(String idcode) {
		// TODO Auto-generated method stub
		ArrayList<Stu> stus = new ArrayList<Stu>();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      String sql = "select stu.username,stu.regip,stu.regtime "
	          + "from stu left join reginfo on stu.username=reginfo.username "
	          + "where reginfo.idcode like ? limit 10" ;
	      pre = con.prepareStatement(sql);
	      pre.setString(1, "%" + idcode + "%");
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Stu stu=new Stu();
	          stu.setUsername(rs.getString(1));
	          stu.setRegip(rs.getString(2));
	          stu.setRegtime(rs.getString(3));
	          stus.add(stu);
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
	    return stus;
	  }
	}
