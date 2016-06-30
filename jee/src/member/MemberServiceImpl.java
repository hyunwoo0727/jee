package member;

public class MemberServiceImpl implements MemberService{
	MemberBean stuBean;
	
	@Override
	public void registStudent(String name, String id, String pw, String ssn) {
		stuBean = new MemberBean(name, id, pw, ssn);
	}

	@Override
	public String findStudent() {
		return stuBean.toString();
	}

	@Override
	public void updateStudent(String pw) {
		stuBean.setPw(pw);
	}
	@Override
	public void deleteStudent() {
		stuBean = null;
	}
	@Override
	public boolean checkPassword(String pw2){
		return stuBean.getPw().equals(pw2) ? true : false;
	}
	
}
