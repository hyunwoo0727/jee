package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :MemberDao.java
 * @story  :
*/

public class MemberDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	public int insert(MemberBean mBean){
		
		StringBuffer sb = new StringBuffer();
		sb.append("insert into member(id,pw,name,regDate,ssn) ");
		sb.append("values('"
				+ mBean.getId()
				+"','"+ mBean.getPw()
				+ "','" + mBean.getName()
				+ "','" + mBean.getRegDate()
				+ "','" + mBean.getSsn()
				+ "')");
		return exeUpdate(sb.toString());
	}
	public int updatePw(MemberBean mBean){
		StringBuffer sb = new StringBuffer();
		sb.append("update member ");
		sb.append("set pw='"+mBean.getPw()+"' ");
		sb.append("where id='"+mBean.getId()+"'");
		return exeUpdate(sb.toString());
	}
	public int deleteMember(String id){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from member ");
		sb.append("where id='"+id+"'");
		return exeUpdate(sb.toString());
	}
	public int exeUpdate(String sql){
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return updateResult;
	}
	public MemberBean findByPK(String pk){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM MEMBER WHERE ID='"+pk+"'");
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sb.toString());
			if(rs.next()){
				MemberBean mem = new MemberBean();
				mem.setId(rs.getString("ID"));
				mem.setPw(rs.getString("PW"));
				mem.setName(rs.getString("NAME"));
				mem.setRegDate(rs.getString("REGDATE"));
				mem.setSsn(rs.getString("SSN"));
				return mem;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	} // id
	public List<MemberBean> list(){
		List<MemberBean> tempList = new ArrayList<>();
		String sql = "select * from member";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				MemberBean mem = new MemberBean();
				mem.setId(rs.getString("ID"));
				mem.setPw(rs.getString("PW"));
				mem.setName(rs.getString("NAME"));
				mem.setRegDate(rs.getString("REGDATE"));
				mem.setSsn(rs.getString("SSN"));
				tempList.add(mem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return tempList;
	} // findall
	public List<MemberBean> findByWord(String name){
		List<MemberBean> tempList = new ArrayList<MemberBean>();
		String sql = "SELECT * FROM MEMBER WHERE NAME='" + name +"'";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				MemberBean mem = new MemberBean();
				mem.setId(rs.getString("ID"));
				mem.setPw(rs.getString("PW"));
				mem.setName(rs.getString("NAME"));
				mem.setRegDate(rs.getString("REGDATE"));
				mem.setSsn(rs.getString("SSN"));
				tempList.add(mem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tempList;
	} // find not pk
	public int count(){
		String sql = "select count(*) cnt from member";
		int result = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	} // count 
	public boolean login(MemberBean mBean) {
		boolean loginOk = false;
		MemberBean m = findByPK(mBean.getId());
		if(m!=null && m.getPw().equals(mBean.getPw())){
			loginOk = true;
		}
		return loginOk;
	}
	public Map<?, ?> selectMap() {
		// TODO Auto-generated method stub
		return null;
	}
}
