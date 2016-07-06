package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :BankDao.java
 * @story  :
*/

public class BankDao {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int updateResult = 0;	
		String sql = "create table account2(accountNo int primary key,"
				+ "name varchar2(20),"
				+ "id varchar2(20),"
				+ "pw varchar2(20),"
				+ "money int"
				+ ")";
		String sqlDrop = "drop table account";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			updateResult = stmt.executeUpdate(sql);
			System.out.println(updateResult+"ㅋㅋ");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				System.out.println("DB다녀온 결과 : " + (updateResult==0 ? "성공":"실패"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(updateResult);
	}
}
