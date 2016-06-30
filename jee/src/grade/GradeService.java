package grade;

public interface GradeService {
	public String getGrade();
	public int getTotal();
	public int getAvg();
	public void registStudent(String[] stuSpec);
	public String getResult();
}
