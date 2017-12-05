package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.StageDao;
import db.ConnectionFactory;
import entity.Stage;

public class StageDaoImpl implements StageDao {

	@Override
	public int add(Stage stage) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "insert into stage(stagenum,stagename,starttime,endtime,note) values(?,?,?,?,?)";
	        pre = con.prepareStatement(sql);
	        pre.setInt(1, stage.getStagenum());
	        pre.setString(2, stage.getStagename());
	        pre.setString(3, stage.getStarttime());
	        pre.setString(4, stage.getEndtime());
	        pre.setString(5, stage.getNote());
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
	public int deleteByStagenum(int stagenum) {
		// TODO Auto-generated method stub
		int rows = 0;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    try {
	        String sql = "delete from stage where stagenum=?";
	        pre = con.prepareStatement(sql);
	        pre.setInt(1, stagenum);
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
	public ArrayList<Stage> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Stage> stages = new ArrayList<Stage>();
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select stagenum,stagename,starttime,endtime,note from stage order by stagenum");
	      rs = pre.executeQuery();
	      while(rs.next()){
	          Stage stage=new Stage();
	          stage.setStagenum(rs.getInt(1));
	          stage.setStagename(rs.getString(2));
	          stage.setStarttime(rs.getString(3));
	          stage.setEndtime(rs.getString(4));
	          stage.setNote(rs.getString(5));
	          stages.add(stage);
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
	    return stages;
	}

	@Override
	public Stage findByStagenum(int stagenum) {
		// TODO Auto-generated method stub
		Stage stage = null;
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement pre = null;
	    ResultSet rs = null;
	    try{
	      pre = con.prepareStatement("select stagenum,stagename,starttime,endtime,note from stage where stagenum=? limit 1");
	      pre.setInt(1, stagenum);
	      rs = pre.executeQuery();
	      while(rs.next()){
	          stage=new Stage();
	          stage.setStagenum(rs.getInt(1));
	          stage.setStagename(rs.getString(2));
	          stage.setStarttime(rs.getString(3));
	          stage.setEndtime(rs.getString(4));
	          stage.setNote(rs.getString(5));
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
	    return stage;
	  }
	

}
