package bank2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @date   :2016. 7. 8.
 * @author :HyunWoo Lee
 * @file   :IteratorEx.java
 * @story  :
*/

public class IteratorEx {
	public static void main(String[] args) {
		Map<?,?> map = new HashMap<String,AccountMemberBean>();
		AccountDAO dao = AccountDAO.getInstance();
		map = dao.selectMap();
		Iterator<?> it  = map.keySet().iterator();
		List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
		while (it.hasNext()) {
			String key = (String) it.next();
//			System.out.println(map.get(key));
		}
		Collection<?> accounts = map.values();
		it = accounts.iterator();
		while (it.hasNext()) {
			AccountMemberBean obj = (AccountMemberBean) it.next();
			list.add(obj);
		}
//		System.out.println(list);
		
		Collections.sort(list, new AccountNoAscSort2());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
