package dao;

import java.util.ArrayList;

import entity.Stage;

public interface StageDao {
	public int add(Stage stage);
	  public int deleteByStagenum(int stagenum);
	  public ArrayList<Stage> findAll();
	  public Stage findByStagenum(int stagenum);
}
