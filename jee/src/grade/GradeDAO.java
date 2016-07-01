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
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs= null;
		int updateResult = 1;
		String sql = "create table grade("
				+ "name varchar2(20),"
				+ "kor number(3),"
				+ "eng number(3),"
				+ "math number(3)"
				+ ")";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
		conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PW);
		stmt = conn.createStatement();
		updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
