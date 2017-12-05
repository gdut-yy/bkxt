package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MajorDao;
import db.ConnectionFactory;
import entity.Major;

public class MajorDaoImpl implements MajorDao {

	//添加新的专业记录
	@Override
	public int add(Major major) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "insert into major(mcode,mname,plannum) values(?,?,?)";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, major.getMcode());
	        pre.setString(2, major.getMname());
	        pre.setInt(3, major.getPlannum());
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

	//按照专业代码删除专业记录
	@Override
	public int deleteByMcode(String mcode) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "delete from major where mcode=?";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, mcode);
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
	public ArrayList<Major> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Major> majors = new ArrayList<Major>();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select mcode,mname,applynum,plannum from major");
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Major major=new Major();
	          major.setMcode(rs.getString(1));
	          major.setMname(rs.getString(2));
	          major.setApplynum(rs.getInt(3));
	          major.setPlannum(rs.getInt(4));
	          majors.add(major);
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
	    return majors;
	}

	@Override
	public int update(int mcode) {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("");
	    //  pre.setString(1, );
	      rs = pre.executeQuery();
	      while(rs.next()){
	    	  mcode = Integer.parseInt(rs.getString(1)); 
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
		return 0;
	}

	//专业代码查找记录
	@Override
	public Major findByMcode(String mcode) {
		// TODO Auto-generated method stub
		Major major = null;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select mcode,mname,plannum from major where mcode=? limit 1");
	      pre.setString(1, mcode);
	      rs = pre.executeQuery();
	      while(rs.next()){
	          major=new Major();
	          major.setMcode(rs.getString(1));
	          major.setMname(rs.getString(2));
	          major.setPlannum(rs.getInt(3));
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
	    return major;
	}

	@Override
	public int getByName(String mname) {
		// TODO Auto-generated method stub
		int mcode = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select mcode from major where mname=? limit 1");
	      pre.setString(1, mname);
	      rs = pre.executeQuery();
	      while(rs.next()){
	    	  mcode = Integer.parseInt(rs.getString(1)); 
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
	    return mcode;
	}

}
