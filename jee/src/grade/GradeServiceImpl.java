package grade;

public class GradeServiceImpl implements GradeService{
	GradeBean gradeBean;
	int cnt;
	@Override
	public String getGrade() {
		switch (getAvg()/10) {
		case 10: case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
	@Override
	public int getTotal() {
		return gradeBean.getKuk() + gradeBean.getEng() + gradeBean.getMath();
	}
	@Override
	public int getAvg() {
		return getTotal()/this.cnt;
	}
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return gradeBean.toString() + " 총점 : " + getTotal() + " 평균 : " + getAvg() + " 결과 : " + getGrade();
	}

	@Override
	public void registStudent(String[] stuSpec) {
		gradeBean = new GradeBean(stuSpec[0]);
		gradeBean.setKuk(Integer.parseInt(stuSpec[1]));
		gradeBean.setEng(Integer.parseInt(stuSpec[2]));
		gradeBean.setMath(Integer.parseInt(stuSpec[3]));
		this.cnt = stuSpec.length-1;
	}
	
	
	
	
	
}
