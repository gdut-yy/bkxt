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
import entity.Reginfo;
import entity.SupGrade;
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

	@Override
	public PageModel<Reginfo> pageReginfo(String mname, String isconfirm, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		String sql = "select idcode,sname,ssex,mname,isconfirm from reginfo";
		if (!mname.equals("all") && !isconfirm.equals("all")) {
			sql += " where mname='" + mname + "' and isconfirm=" + isconfirm;
		} else if (!mname.equals("all")) {
			sql += " where mname='" + mname + "'";
		} else if (!isconfirm.equals("all")) {
			sql += " where isconfirm=" + isconfirm;
		}

		ArrayList<Reginfo> reginfos = new ArrayList<Reginfo>();
		PageModel<Reginfo> pm = new PageModel<Reginfo>(pageSize, pageNo,
				total(sql));

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = con.prepareStatement(sql + " limit " + (pm.getPageNo() - 1)
					* pm.getPageSize() + "," + pm.getPageSize());
			rs = pre.executeQuery();
			while (rs.next()) {
				Reginfo reginfo = new Reginfo();
				reginfo.setIdcode(rs.getString(1));
				reginfo.setSname(rs.getString(2));
				reginfo.setSsex(rs.getString(3));
				reginfo.setMname(rs.getString(4));
				reginfo.setIsconfirm(rs.getInt(5));
				reginfos.add(reginfo);
			}
			pm.setData(reginfos);
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
		return pm;
	}

	@Override
	public PageModel<SupGrade> pageByLogname(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		String sql = "select grade.testcardnum,reginfo.username,course.cname,score,note from grade,course,reginfo where grade.gradeid=course.ccode and grade.testcardnum = reginfo.testcardnum";
	    ArrayList<SupGrade> supgrades = new ArrayList<SupGrade>();
	    PageModel<SupGrade> pm = new PageModel<SupGrade>(pageSize, pageNo, total(sql));
	    
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	    	System.out.println(pm.getPageNo());
	      pre = con.prepareStatement(sql+" limit " + (pm.getPageNo() - 1) * pm.getPageSize() + "," + pm.getPageSize());
	      rs = pre.executeQuery();
	      while(rs.next()){
	    	 SupGrade supgrade = new SupGrade();
	    	 supgrade.setTestcardnum(rs.getString(1));
	    	 supgrade.setSname(rs.getString(2));
	    	 supgrade.setCname(rs.getString(3));
	    	 supgrade.setScore(Integer.parseInt(rs.getString(4)));
	    	 supgrade.setNote(rs.getString(5));
	    	 supgrades.add(supgrade);
	      }
	      pm.setData(supgrades);
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
	    return pm;
	}

	@Override
	public PageModel<Reginfo> pageReginfo(int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		String sql = "select idcode,sname,testcardnum,mname from reginfo";
	    ArrayList<Reginfo> reginfos = new ArrayList<Reginfo>();
	    PageModel<Reginfo> pm = new PageModel<Reginfo>(pageSize, pageNo, total(sql));
	    
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	    	System.out.println(pm.getPageNo());
	      pre = con.prepareStatement(sql+" limit " + (pm.getPageNo() - 1) * pm.getPageSize() + "," + pm.getPageSize());
	      rs = pre.executeQuery();
	      while(rs.next()){
	    	  Reginfo reginfo = new Reginfo();
	    	  reginfo.setIdcode(rs.getString(1));
	    	  reginfo.setSname(rs.getString(2));
	    	  reginfo.setTestcardnum(rs.getString(3));
	    	  reginfo.setMname(rs.getString(4));
	    	  reginfos.add(reginfo);
	      }
	      pm.setData(reginfos);
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
	    return pm;
	}
}
