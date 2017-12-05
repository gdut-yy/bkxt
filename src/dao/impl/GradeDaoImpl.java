package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.GradeDao;
import db.ConnectionFactory;
import entity.SupGrade;

public class GradeDaoImpl implements GradeDao {

	@Override
	public int gradeAdd(SupGrade supgrade) {
		// TODO Auto-generated method stub
		CourseDaoImpl courseImpl = new CourseDaoImpl();
		String ccode = courseImpl.findCcode(supgrade.getCname());
		supgrade.setCcode(ccode);
		 int rows = 0;
		    Connection con = ConnectionFactory.getConnection();
		    PreparedStatement pre = null;
		    try {
		        String sql = "insert into grade(testcardnum,ccode,score,note) values(?,?,?,?)";
		        pre = con.prepareStatement(sql);
		        pre.setString(1, supgrade.getTestcardnum());
		        pre.setString(2, supgrade.getCcode());
		        pre.setInt(3, supgrade.getScore());
		        pre.setString(4, supgrade.getNote());
		        
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
	public ArrayList<SupGrade> findByCardnum(String testcardnum) {
		// TODO Auto-generated method stub
		ArrayList<SupGrade> supgrades = new ArrayList<SupGrade>();
		  Connection con = ConnectionFactory.getConnection();
		    PreparedStatement pre = null;
		    try {
		        String sql = "select ccode,score,note from grade where testcardnum=?";
		        pre = con.prepareStatement(sql);
		        pre.setString(1, testcardnum);
			    ResultSet rs = pre.executeQuery();
			    while(rs.next()){
			    	CourseDaoImpl courseImpl = new CourseDaoImpl();
			    	SupGrade supgrade = new SupGrade();
			    	supgrade.setCcode(rs.getString(1));
			    	supgrade.setScore(Integer.parseInt(rs.getString(2)));
			    	supgrade.setNote(rs.getString(3));
			    	supgrade.setCname(courseImpl.findByCcode(rs.getString(1)).getCname());
			    	supgrades.add(supgrade);
			    }
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
		    return supgrades;
	}

}
