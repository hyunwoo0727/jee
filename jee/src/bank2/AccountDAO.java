package bank2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.accessibility.internal.resources.accessibility;

import global.Constants;
import global.Database;
import global.DatabaseFactory;
import global.Vendor;
import oracle.net.aso.p;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :BankDao.java
 * @story  :
*/

public class AccountDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static AccountDAO instance = new AccountDAO();
	
	private AccountDAO() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static AccountDAO getInstance() {
		return instance;
	}
	public int openAccount(String id) {
		int result = 0 ;
		String sql = "INSERT INTO ACCOUNT VALUES(accSeq.nextval,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, 0);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public AccountMemberBean findByAccountNo(String accNo) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ACCOUNT_MEMBER WHERE ACCOUNTNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(accNo));
			rs = pstmt.executeQuery();
			if(rs.next()){
				AccountMemberBean accBean = new AccountMemberBean();
				accBean.setAccountNo(rs.getInt("ACCOUNTNO"));
				accBean.setId(rs.getString("ID"));
				accBean.setMoney(rs.getInt("MONEY"));
				accBean.setName(rs.getString("NAME"));
				accBean.setPw(rs.getString("PW"));
				return accBean;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int deposit(AccountMemberBean accBean) {
		int result = 0;
		String sql = "UPDATE ACCOUNT SET MONEY=MONEY+? WHERE ACCOUNTNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accBean.getMoney());
			pstmt.setInt(2, accBean.getAccountNo());
			result = pstmt.executeUpdate();
			if(result==0) return result;
			result = this.getMoney(accBean.getAccountNo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<AccountMemberBean> list(String word) {
		List<AccountMemberBean> tempList = new ArrayList<AccountMemberBean>();
		String sql="";
		if(word==null){
			sql = "SELECT * FROM ACCOUNT_MEMBER";
		}else{
			sql = "SELECT * FROM ACCOUNT_MEMBER WHERE NAME=?";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			if(word!=null){
				pstmt.setString(1, word);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				AccountMemberBean amBean = new AccountMemberBean();
				amBean.setId(rs.getString("ID"));
				amBean.setAccountNo(rs.getInt("ACCOUNTNO"));
				amBean.setMoney(rs.getInt("MONEY"));
				amBean.setPw(rs.getString("PW"));
				amBean.setName(rs.getString("NAME"));
				amBean.setRegDate(rs.getString("REGDATE"));
				amBean.setSsn(rs.getString("SSN"));
				tempList.add(amBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	
	public int getMoney(int accNo){
		int money = 0;
		String sql = "SELECT MONEY FROM ACCOUNT_MEMBER WHERE ACCOUNTNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				money = rs.getInt("MONEY");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	public int withdraw(AccountMemberBean withBean) {
		int result = 0;
		String sql = "UPDATE ACCOUNT SET MONEY=MONEY-? WHERE ACCOUNTNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, withBean.getMoney());
			pstmt.setInt(2, withBean.getAccountNo());
			result = pstmt.executeUpdate();
			if(result==0) return result;
			result = this.getMoney(withBean.getAccountNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int count() {
		int cnt = 0;
		String sql = "SELECT COUNT(*) CNT FROM ACCOUNT";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt("CNT");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public int closeAccount(int accNo) {
		int result = 0;
		String sql = "DELETE FROM ACCOUNT WHERE ACCOUNTNO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int updateAccount(AccountMemberBean uptBean) {
		int result = 0;
		String sql = "UPDATE MEMBER SET PW=? WHERE ID=(SELECT ID FROM ACCOUNT WHERE ACCOUNTNO=?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uptBean.getPw());
			pstmt.setInt(2, uptBean.getAccountNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
