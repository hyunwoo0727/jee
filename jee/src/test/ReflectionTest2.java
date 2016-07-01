package test;

import bank.AccountBean;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :ReflectionTest2.java
 * @story  :
*/

public class ReflectionTest2 {
	public static void main(String[] args) {
		try {
			AccountBean m = (AccountBean) Class.forName("bank.AccountBean").newInstance();
			m.setId("hong");
			m.setName("홍길동");
			m.setPw("1234");
			System.out.println(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
