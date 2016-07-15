package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	public static MemberServiceImpl getInstance() {
		return instance;
	}
	@Override
	public int regist(MemberBean mBean) {
		return dao.insert(mBean);
	}
	@Override
	public int update(MemberBean mBean) {
		System.out.println(mBean);
		this.map();
		return dao.updatePw(mBean);
	}
	@Override
	public int delete(String id) {
		int result = dao.deleteMember(id);
		if(result==1){
			session = null;
		}
		return result;
	}
	@Override
	public int count() {
		return map.values().size();
	}
	@Override
	public MemberBean findById(String id) {
		return dao.findByPK(id);
	}
	@Override
	public List<MemberBean> findBy(String word) {
		List<MemberBean> findList = new ArrayList<MemberBean>();
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		while(it.hasNext()){
			MemberBean tempBean = (MemberBean) map.get(it.next());
			if(tempBean.getName().equals(word)){
				findList.add(tempBean);
			}
		}
		return findList;
	}
	
	@Override
	public ArrayList<MemberBean> list() {
		ArrayList<MemberBean> allList = new ArrayList<MemberBean>();
		Set<?> keys = map.keySet();
		Iterator<?> it = keys.iterator();
		while(it.hasNext()){
			allList.add((MemberBean) this.map.get(it.next()));
		}
		
		return allList;
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
		if(this.checkLogin(mBean)){	
			this.map();
			session = (MemberBean) map.get(mBean.getId());
			result = session.getName();
			accService.map();
		}
		return result;
	}
	public MemberBean getSession() {
		return session;
	}
	
	public void setSession(MemberBean session) {
		this.session = session;
	}
	public boolean checkLogin(MemberBean mBean) {
		boolean loginOk = false;
		MemberBean m = dao.findByPK(mBean.getId());
		if(m!=null && m.getPw().equals(mBean.getPw())){
			loginOk = true;
		}
		return loginOk;
	}
}
