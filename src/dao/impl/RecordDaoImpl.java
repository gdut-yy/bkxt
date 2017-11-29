package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.RecordDao;
import db.ConnectionFactory;
import entity.Record;
import util.PageModel;

public class RecordDaoImpl implements RecordDao{
	//·ÖÒ³²éÑ¯¼ÇÂ¼
	  public PageModel<Record> pageByLogname(String logname, 
	      String usergroup,int pageSize, int pageNo) {
	    String sql = "select logname,usergroup,logtime,logip "
	          + "from record where logname='" 
	          + logname + "' and usergroup='" + usergroup + "' order by rid desc";
	    ArrayList<Record> records = new ArrayList<Record>();
	    PageModel<Record> pm = new PageModel<Record>(pageSize, pageNo, total(sql));
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement(sql+" limit " 
	          + (pm.getPageNo() - 1) * pm.getPageSize() + "," + pm.getPageSize());
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Record record=new Record();
	          record.setLogname(rs.getString(1));
	          record.setUsergroup(rs.getString(2));
	          record.setLogtime(rs.getString(3));
	          record.setLogip(rs.getString(4));
	          records.add(record);
	      }
	      pm.setData(records);
	    }catch (Exception e){
	        e.printStackTrace();
	    }finally{
	        try {
	            if (rs != null){rs.close();}
	            if (pre != null){pre.close();}
	            if (con != null){con.close();}
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return pm;
	  }
	  
	  public int total(String sql) {
		    int recordCount = 0;
		//<<<<<<< RecordDaoImpl.java
//		    String countsql = "select count(*) " + sql.substring(sql.indexOf("from"), sql.length());
		 //   System.out.println(countsql);
		//=======
		    String countsql = "select count(*) " 
		        + sql.substring(sql.indexOf("from"), sql.length());
		//>>>>>>> 1.3
		    Connection con = ConnectionFactory.getConnection();
		    Statement stmt = null;
		    ResultSet rs = null;
		    try {
		      stmt = con.createStatement();
		      rs = stmt.executeQuery(countsql);
		      if (rs.next()) {
		        recordCount = rs.getInt(1);
		      }
		    }catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try{
		            if (rs != null){rs.close();}
		            if (stmt != null){stmt.close();}
		            if (con != null){con.close();}
		        }catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return recordCount;
		  }

	@Override
	public int add(Record record) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "insert into record(logname,usergroup,logtime,logip) values(?,?,NOW(),?)";
	        pre = con.prepareStatement(sql);
	        pre.setString(1, record.getLogname());
	        pre.setString(2, record.getUsergroup());
	        pre.setString(3, record.getLogip());
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
}
