package test;

import member.MemberBean;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :ReflectionTest.java
 * @story  :
*/

public class ReflectionTest {
	public static void main(String[] args) {
//		MemberBean mem = new MemberBean();
		try {
			MemberBean mem = (MemberBean) Class.forName("bank.MemberBean").newInstance();
			mem.setId("hong");
			mem.setName("홍길동");
			mem.setPw("1");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
