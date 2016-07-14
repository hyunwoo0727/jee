package member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank2.AccountMemberBean;
import bank2.AccountService;
import bank2.AccountServiceImp;

public class MemberServiceImpl implements MemberService{
	private Map<?,?> map;
	private MemberDAO dao;
	private MemberBean session;
	AccountService accService = AccountServiceImp.getInstance();
	
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		dao =  MemberDAO.getInstance();
	}
	
	@Override
	public int regist(MemberBean mBean) {
		System.out.println(mBean);
		return dao.insert(mBean);
	}
	
	@Override
	public String update(MemberBean mBean) {
		return dao.updatePw(mBean)!=0? "변경 완료" : "ID/PW를 확인하세요" ;
	}
	@Override
	public String delete(String id) {
		return dao.deleteMember(id)!=0?"삭제완료":"아이디를 확인하세요";
	}
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public MemberBean findById(String id) {
		// TODO Auto-generated method stub
		return dao.findByPK(id);
	}

	@Override
	public List<MemberBean> findBy(String word) {
		// TODO Auto-generated method stub
		return dao.findByWord(word);
	}

	@Override
	public List<MemberBean> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public Map<?, ?> map() {
		this.map = new HashMap<String,AccountMemberBean>(); 
		map = dao.selectMap();
		return map;
	}
	@Override
	public String login(MemberBean mBean) {
		String result = null;
		if(mBean.getId()==null || mBean.getPw()==null){
			return null;
		}
		if(dao.login(mBean)){	
			session = this.findById(mBean.getId());
			result = session.getName();
			accService.map();
		}
		return result;
	}
	public MemberBean getSession() {
		return session;
	}
}
