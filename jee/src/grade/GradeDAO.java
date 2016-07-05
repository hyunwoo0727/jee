package grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import global.Constants;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :GradeDao.java
 * @story  :
*/

public class GradeDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private static GradeDAO instance = new GradeDAO();
	
	private GradeDAO() {
	}
	public static GradeDAO getInstance(){
		return instance;
	}
	public int insert(GradeBean grade) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO GRADE ");
		sb.append("VALUES(");
		sb.append("seq.nextval,'"+grade.getGrade()+"',"+grade.getJava()+","+grade.getSql()+","+grade.getHtml()
		+","+grade.getJavascript()+",'"+grade.getId()+"','"+grade.getExamDate()+"'");
		sb.append(")");
		return exeUpdate(sb.toString());
	}
	public int update(String[] uData) {
		// TODO Auto-generated method stub
		String sql = "UPDATE GRADE SET " + uData[0] + "=" + uData[1] + " WHERE SEQ=" + uData[2];
		int result = exeUpdate(sql);
		if(result!=0){
			GradeBean tempBean = findBySeq(uData[2]);
			tempBean.setGrade(GradeServiceImpl.getGrade(tempBean));
			sql = "UPDATE GRADE SET GRADE='" +tempBean.getGrade()+"' WHERE SEQ=" + uData[2];
			result = exeUpdate(sql);
		}
		return result;
	}
	public int delete(String seq) {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM GRADE WHERE SEQ="+seq);
		return exeUpdate(sb.toString());
	}
	
	public int exeUpdate(String sql){
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PW);
			stmt = conn.createStatement();
			updateResult = stmt.executeUpdate(sql);
			conn.commit();
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
	public List<GradeBean> findSeqById(String id) {
		// TODO Auto-generated method stub
		List<GradeBean> tempList = new ArrayList<GradeBean>();
		String sql = "";
	
		if(id!=null){
			 sql = "SELECT * FROM GRADE WHERE ID='"+id+"'";
		}else{
			 sql = "SELECT * FROM GRADE ORDER BY SEQ";
		}
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				//String id, String examDate, String java, String sql, String html, String javascript
				GradeBean gBean = new GradeBean(rs.getString("ID"),rs.getString("EXAM_DATE"),
						rs.getString("JAVA"),rs.getString("SQL"),rs.getString("HTML"),rs.getString("JAVASCRIPT"));
				gBean.setSeq(rs.getInt("SEQ"));
				gBean.setGrade(rs.getString("GRADE"));
				tempList.add(gBean);
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
	}
	public List<GradeBean> list() {
		// TODO Auto-generated method stub
		return findSeqById(null);
	}
	public GradeBean findBySeq(String seq) {
		String sql = "SELECT * FROM GRADE WHERE SEQ="+seq;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				GradeBean tempBean = new GradeBean(rs.getString("ID"),rs.getString("EXAM_DATE"),
				rs.getString("JAVA"),rs.getString("SQL"),rs.getString("HTML"),rs.getString("JAVASCRIPT"));
				tempBean.setSeq(rs.getInt("SEQ"));
				tempBean.setGrade(rs.getString("GRADE"));
				return tempBean;
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
		
		return null;
	}
	public int count(String examDate) {
		String sql = "SELECT COUNT(*) CNT FROM GRADE WHERE EXAM_DATE='"+examDate+"'";
		int cnt = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PW);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("CNT");
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
		return cnt;
	}
}
