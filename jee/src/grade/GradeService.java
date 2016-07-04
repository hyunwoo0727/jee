package grade;

import java.util.List;

public interface GradeService {
	// 총 7가지 패턴 
	// exeU
	public int insert(GradeBean grade);
	public int update(GradeBean grade);
	public int delete(GradeBean grade);
	// exeQ
	public List<GradeBean> list();
	public List<GradeBean> findByHakjum(String hakjum);
	public GradeBean findBySeq(int seq);
	public int count();
}
