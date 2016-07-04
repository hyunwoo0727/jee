package member;

import java.util.List;

public class MemberServiceImpl implements MemberService{
	MemberBean memberBean;
	MemberDAO dao;
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		dao =  MemberDAO.getInstance();
	}
	
	@Override
	public String regist(MemberBean mBean) {
		return dao.insert(mBean)!=0?"성공":"실패";
	}
	@Override
	public String find() {
		return memberBean.toString();
	}
	@Override
	public String update(MemberBean mBean) {
		return dao.updatePw(mBean)!=0? "변경 완료" : "ID/PW를 확인하세요" ;
	}
	@Override
	public String delete(String id) {
		return dao.deleteMember(id)!=0?"삭제완료":"아이디를 확인하세요";
	}
	@Override
	public boolean checkPassword(MemberBean mBean){
		return memberBean.getPw().equals(mBean.getPw()) ? true : false;
	}
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	@Override
	public int getCount() {
		return dao.count();
	}

	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return dao.findByPK(id);
	}

	@Override
	public List<MemberBean> findByWord(String word) {
		// TODO Auto-generated method stub
		return dao.findByWord(word);
	}

	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}
}
