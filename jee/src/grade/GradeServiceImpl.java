package grade;

import java.util.List;

public class GradeServiceImpl implements GradeService{
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	
	private GradeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	@Override
	public String insert(GradeBean grade) {
		// TODO Auto-generated method stub
		grade.setGrade(getGrade(grade));
		return dao.insert(grade)!=0?"입력 완료":"입력 실패";
	}
	@Override
	public String update(String[] uData) {
		// TODO Auto-generated method stub
		return dao.update(uData) != 0 ? "수정성공":"수정실패";
	}
	@Override
	public String delete(String seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq)!=0?"삭제 성공":"삭제 실패 시퀀스를 확인바랍니다";
	}
	@Override
	public List<GradeBean> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
	@Override
	public GradeBean findBySeq(String seq) {
		// TODO Auto-generated method stub
		return dao.findBySeq(seq);
	}
	@Override
	public List<GradeBean> findSeqById(String id) {
		// TODO Auto-generated method stub
		return dao.findSeqById(id);
	}
	@Override
	public int count(String examDate) {
		// TODO Auto-generated method stub
		return dao.count(examDate);
	}
	public static String getGrade(GradeBean bean){
		String grade = "";
		switch ((bean.getJava()+bean.getSql()+bean.getHtml()+bean.getJavascript())/4/10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		return grade;
	}
	
}
