/**
 * 
 */
package member;

import java.util.List;

/**
 * @date   : 2016. 6. 17.
 * @author : HyunWoo Lee
 * @file   : StudentService.java 
 * @story  : 
*/
public interface MemberService {
	public String regist(MemberBean mBean);
	public String find();
	public String update(MemberBean mBean);
	public String delete(String id);
	public boolean checkPassword(MemberBean mBean);
	public int getCount();
	public MemberBean findById(String id);
	public List<MemberBean> findByWord(String word);
	public List<MemberBean> list();
}
