package grade;

public class GradeBean {
	private int kuk,eng,math;
	private String name;
	
	public GradeBean(){
		
	}
	public GradeBean(String name){
		this.name = name;
	}
	public int getKuk() {
		return kuk;
	}
	public void setKuk(int kuk) {
		this.kuk = kuk;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name + " [국어=" + kuk + ", 영어=" + eng + ", 수학=" + math+"]";
	}
}
