package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :MemberDao.java
 * @story  :
*/

public class MemberDao {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "create table member("
				+ "id varchar2(20),"
				+ "pw varchar2(20),"
				+ "name varchar2(20),"
				+ "gender varchar2(2),"
				+ "regDate date,"
				+ "ssn varchar2(8),"
				+ "age number(3)"
				+ ")";
		String sqlDrop = "drop table member";
		int updateResult = 0;
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
				System.out.println("DB다녀온 결과 : " + (updateResult==0 ? "성공":"실패"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
