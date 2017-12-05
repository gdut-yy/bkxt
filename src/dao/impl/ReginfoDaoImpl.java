package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.ReginfoDao;
import db.ConnectionFactory;
import entity.Major;
import entity.Reginfo;

public class ReginfoDaoImpl implements ReginfoDao {

	@Override
	public int add(Reginfo reginfo) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "insert into reginfo(sname,idcode,ssex,nation,political,homeaddr,source,school,gradutetime,isnew,aos,major,cet,mname,mobile,telphone,zipcode,conaddr,receiver,isconfirm,username) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pre = con.prepareStatement(sql);
			pre.setString(21, reginfo.getUsername());
			pre.setString(1, reginfo.getSname());
			pre.setString(2, reginfo.getIdcode());
			pre.setString(3, reginfo.getSsex());
			pre.setString(4, reginfo.getNation());
			pre.setString(5, reginfo.getPolitical());
			pre.setString(6, reginfo.getHomeaddr());
			pre.setString(7, reginfo.getSource());
			pre.setString(8, reginfo.getSchool());
			pre.setString(9, reginfo.getGradutetime());
			pre.setString(10, reginfo.getIsnew());
			pre.setString(11, reginfo.getAos());
			pre.setString(12, reginfo.getMajor());
			pre.setString(13, reginfo.getCet());
			pre.setString(14, reginfo.getMname());
			pre.setString(15, reginfo.getMobile());
			pre.setString(16, reginfo.getTelphone());
			pre.setString(17, reginfo.getZipcode());
			pre.setString(18, reginfo.getConaddr());
			pre.setString(19, reginfo.getReceiver());
			pre.setInt(20, 0);
			rows = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public Reginfo findByUser(String username) {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		Reginfo reg = new Reginfo();
		String sql = "select username,sname,idcode,ssex,aos,cet,conaddr,gradutetime,homeaddr,isnew,major,mname,mobile,nation,political,receiver,school,source,telphone,zipcode,testcardnum,examroom,seatnum from reginfo where username=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();

			if (rs.next()) {
				reg.setUsername(rs.getString(1));
				reg.setSname(rs.getString(2));
				reg.setIdcode(rs.getString(3));
				reg.setSsex(rs.getString(4));
				reg.setAos(rs.getString(5));
				reg.setCet(rs.getString(6));
				reg.setConaddr(rs.getString(7));
				reg.setGradutetime(rs.getString(8));
				reg.setHomeaddr(rs.getString(9));
				reg.setIsnew(rs.getString(10));
				reg.setMajor(rs.getString(11));
				reg.setMname(rs.getString(12));
				reg.setMobile(rs.getString(13));
				reg.setNation(rs.getString(14));
				reg.setPolitical(rs.getString(15));
				reg.setReceiver(rs.getString(16));
				reg.setSchool(rs.getString(17));
				reg.setSource(rs.getString(18));
				reg.setTelphone(rs.getString(19));
				reg.setZipcode(rs.getString(20));
				reg.setTestcardnum(rs.getString(21));
				reg.setExamroom(rs.getString(22));
				reg.setSeatnum(rs.getString(23));
			}
			return reg;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reginfo findByIdcode(String idcode) {
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		Reginfo reg = new Reginfo();
		String sql = "select sname,idcode,ssex,isnew,mname,mobile,piclocation,isconfirm from reginfo where idcode=?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, idcode);
			ResultSet rs = pre.executeQuery();

			if (rs.next()) {
				reg.setSname(rs.getString(1));
				reg.setIdcode(rs.getString(2));
				reg.setSsex(rs.getString(3));
				reg.setIsnew(rs.getString(4));
				reg.setMname(rs.getString(5));
				reg.setMobile(rs.getString(6));
				reg.setPiclocation(rs.getString(7));
				reg.setIsconfirm(rs.getInt(8));
			}
			return reg;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Reginfo> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Reginfo> array = new ArrayList();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "select username,sname,idcode,ssex,aos,cet,conaddr,gradutetime,homeaddr,isnew,major,mname,mobile,"
					+ "nation,political,receiver,school,source,telphone,zipcode,isconfirm,testcardnum,examroom,seatnum from reginfo";
			pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			Reginfo reg = new Reginfo();

			while (rs.next()) {
				reg.setUsername(rs.getString(1));
				reg.setSname(rs.getString(2));
				reg.setIdcode(rs.getString(3));
				reg.setSsex(rs.getString(4));
				reg.setAos(rs.getString(5));
				reg.setCet(rs.getString(6));
				reg.setConaddr(rs.getString(7));
				reg.setGradutetime(rs.getString(8));
				reg.setHomeaddr(rs.getString(9));
				reg.setIsnew(rs.getString(10));
				reg.setMajor(rs.getString(11));
				reg.setMname(rs.getString(12));
				reg.setMobile(rs.getString(13));
				reg.setNation(rs.getString(14));
				reg.setPolitical(rs.getString(15));
				reg.setReceiver(rs.getString(16));
				reg.setSchool(rs.getString(17));
				reg.setSource(rs.getString(18));
				reg.setTelphone(rs.getString(19));
				reg.setZipcode(rs.getString(20));
				reg.setIsconfirm(rs.getInt(21));
				reg.setTestcardnum(rs.getString(22));
				reg.setExamroom(rs.getString(23));
				reg.setSeatnum(rs.getString(24));
			}
			array.add(reg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return array;
	}

	@Override
	public int addCode(String username, String testcardnum) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "update reginfo set testcardnum=? where username=?";
			pre = con.prepareStatement(sql);
			pre.setString(2, username);
			pre.setString(1, testcardnum);
			rows = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public ArrayList<Reginfo> findByIncrease() {
		// TODO Auto-generated method stub
		ArrayList<Reginfo> array = new ArrayList();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "select username,testcardnum from reginfo where isconfirm=1 order by testcardnum";
			pre = con.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			Reginfo reg = new Reginfo();

			while (rs.next()) {
				reg.setUsername(rs.getString(1));
				reg.setTestcardnum(rs.getString(2));
			}
			array.add(reg);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return array;
	}

	@Override
	public HashMap<String, Integer> staticByMajor(ArrayList<Major> majors) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			for (Major major : majors) {
				String sql = "select count(*) from reginfo where mname=?";
				pre = con.prepareStatement(sql);
				pre.setString(1, major.getMname());
				ResultSet rs = pre.executeQuery();

				while (rs.next()) {
					result.put(major.getMname(), rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int update(Reginfo reginfo) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "update reginfo set sname=?,idcode=?,ssex=?,nation=?,political=?,homeaddr=?,source=?,school=?,gradutetime=?,isnew=?,aos=?,major=?,cet=?,mname=?,mobile=?,telphone=?,zipcode=?,conaddr=?,receiver=?,isconfirm=? where username=?";
			pre = con.prepareStatement(sql);
			pre.setString(21, reginfo.getUsername());
			pre.setString(1, reginfo.getSname());
			pre.setString(2, reginfo.getIdcode());
			pre.setString(3, reginfo.getSsex());
			pre.setString(4, reginfo.getNation());
			pre.setString(5, reginfo.getPolitical());
			pre.setString(6, reginfo.getHomeaddr());
			pre.setString(7, reginfo.getSource());
			pre.setString(8, reginfo.getSchool());
			pre.setString(9, reginfo.getGradutetime());
			pre.setString(10, reginfo.getIsnew());
			pre.setString(11, reginfo.getAos());
			pre.setString(12, reginfo.getMajor());
			pre.setString(13, reginfo.getCet());
			pre.setString(14, reginfo.getMname());
			pre.setString(15, reginfo.getMobile());
			pre.setString(16, reginfo.getTelphone());
			pre.setString(17, reginfo.getZipcode());
			pre.setString(18, reginfo.getConaddr());
			pre.setString(19, reginfo.getReceiver());
			pre.setInt(20, 0);
			rows = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int update(String idcode, int confirm) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "update reginfo set isconfirm=? where idcode=?";
			pre = con.prepareStatement(sql);
			pre.setString(2, idcode);
			pre.setInt(1, confirm);
			rows = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int update(String str, String username) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "update reginfo set piclocation=? where username=?";
			pre = con.prepareStatement(sql);
			pre.setString(2, username);
			pre.setString(1, str);
			rows = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	@Override
	public int update(String username, String examroom, int seatnum) {
		// TODO Auto-generated method stub
		int rows = 0;
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pre = null;
		try {
			String sql = "update reginfo set examroom=?, seatnum=? where username=?";
			pre = con.prepareStatement(sql);
			pre.setString(3, username);
			pre.setInt(2, seatnum);
			pre.setString(1, examroom);
			System.out.println(sql);
			rows = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

}
