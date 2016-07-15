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
import global.CommonService;

public class MemberServiceImpl2 implements CommonService{
	private Map<?,?> map;
	private MemberDAO dao;
	private MemberBean session;
	AccountService accService = AccountServiceImp.getInstance();
	
	private static MemberServiceImpl2 instance = new MemberServiceImpl2();
	
	private MemberServiceImpl2() {
		dao =  MemberDAO.getInstance();
		this.map = dao.selectMap();
	}
	public static MemberServiceImpl2 getInstance() {
		return instance;
	}
	
	public int regist(MemberBean mBean) {
		return dao.insert(mBean);
	}
	
	public int update(MemberBean mBean) {
		return dao.updatePw(mBean);
	}

	public int delete(String id) {
		return dao.deleteMember(id);
	}
	@Override
	public int count() {
		return map.values().size();
	}
	
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
	public List<MemberBean> list() {
		List<MemberBean> allList = new ArrayList<MemberBean>();
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
	
	public String login(MemberBean mBean) {
		String result = null;
		if(mBean.getId()==null || mBean.getPw()==null){
			return null;
		}
		if(this.checkLogin(mBean)){	
			session = (MemberBean) map.get(mBean.getId());
			result = session.getName();
			accService.map();
		}
		return result;
	}
	public MemberBean getSession() {
		return session;
	}
	public boolean checkLogin(MemberBean mBean) {
		boolean loginOk = false;
		MemberBean m = (MemberBean) map.get(mBean.getId());
		if(m!=null && m.getPw().equals(mBean.getPw())){
			loginOk = true;
		}
		return loginOk;
	}
}
