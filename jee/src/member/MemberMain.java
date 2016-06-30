package member;

/**
 * @date   :2016. 6. 30.
 * @author :HyunWoo Lee
 * @file   :MemberMain.java
 * @story  :
*/

public class MemberMain {
	public static void main(String[] args) {
		MemberBean m = new MemberBean();
		MemberBean m2 = new MemberBean();
		try {
			MemberBean m4 = (MemberBean)  Class.forName("member.MemberBean").newInstance();
			m4.setId("hong");
			m4.setName("홍길동");
			m4.setPw("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
