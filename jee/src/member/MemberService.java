/**
 * 
 */
package member;

/**
 * @date   : 2016. 6. 17.
 * @author : HyunWoo Lee
 * @file   : StudentService.java 
 * @story  : 
*/
public interface MemberService {
	public String regist(MemberBean mBean);
	public String find();
	public void update(MemberBean mBean);
	public void delete();
	public boolean checkPassword(MemberBean mBean);
}
