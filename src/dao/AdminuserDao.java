package dao;

import java.util.ArrayList;

import entity.Adminuser;

public interface AdminuserDao {
	public Adminuser validateLogin(String adminname,String adminpass);
	  public int add(Adminuser adminuser);
	  public int deleteByAdminname(String adminname);
	  public ArrayList<Adminuser> findAll();
	  public Adminuser findByAdminname(String adminname);
	  public int passModify(String adminname,String newpass);
}
