package member;

public class MemberServiceImpl implements MemberService{
	MemberBean memberBean;
	MemberDAO dao;
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		dao =  MemberDAO.getInstance();
	}
	
	@Override
	public String regist(MemberBean mBean) {
		StringBuffer sb = new StringBuffer();
		sb.append("insert into member(id,pw,name,regDate,ssn) ");
		sb.append("values('"
				+ mBean.getId()
				+"','"+ mBean.getPw()
				+ "','" + mBean.getName()
				+ "','" + mBean.getRegDate()
				+ "','" + mBean.getSsn()
				+ "')");
		return dao.exeUpdate(sb.toString())!=0?"성공":"실패";
	}
	@Override
	public String find() {
		return memberBean.toString();
	}
	@Override
	public void update(MemberBean mBean) {
		memberBean.setPw(mBean.getPw());
	}
	@Override
	public void delete() {
		memberBean = null;
	}
	@Override
	public boolean checkPassword(MemberBean mBean){
		return memberBean.getPw().equals(mBean.getPw()) ? true : false;
	}
	public static MemberServiceImpl getInstance() {
		return instance;
	}
}
