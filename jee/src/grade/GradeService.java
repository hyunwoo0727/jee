package grade;

import java.util.List;

public interface GradeService {
	// 총 7가지 패턴 
	// exeU 
	//1.추가 2.수정 3.삭제 4.전체조회 5.학점을 포함한 시험내역 조회(SEQ) 6.시퀀스 조회(ID로)7.응시생수
	public String insert(GradeBean grade);
	public String delete(String seq);
	// exeQ
	public List<GradeBean> list();
	public int count(String examDate);
	public String numberCheck(String[] scores);
	public GradeBean findBySeq(String seq);
	public List<GradeBean> findById(String id);
	public String update(String sData);
}
