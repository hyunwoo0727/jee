package grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :GradeDao.java
 * @story  :
*/

public class GradeDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs= null;
	private static GradeDAO instance = new GradeDAO();
	
	private GradeDAO() {
	}
	public GradeDAO getInstance(){
		return instance;
	}
	
}
