package dao;

import java.util.ArrayList;

import entity.SupGrade;

public interface GradeDao {
	public int gradeAdd(SupGrade supgrade);
	public ArrayList<SupGrade> findByCardnum(String testcardnum);
}
