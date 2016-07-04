package member;

/**
 * @date   :2016. 7. 4.
 * @author :HyunWoo Lee
 * @file   :Test.java
 * @story  :
*/

public class Test {
	public static void main(String[] args) {
		MemberBean2 m1 = MemberBean2.getInstance();
		MemberBean2 m2 = MemberBean2.getInstance();
		m1.setId("hi");
		m2.setId("h2");
		System.out.println(m1);
		System.out.println(m2);
	}
}
