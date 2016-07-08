/**
 * 
 */
package member;


import global.CommonService;

/**
 * @date   : 2016. 6. 17.
 * @author : HyunWoo Lee
 * @file   : StudentService.java 
 * @story  : 
*/
public interface MemberService extends CommonService{
	public String regist(MemberBean mBean);
	public String update(MemberBean mBean);
	public String delete(String id);
	public MemberBean findById(String id);
	public String login(MemberBean mBean);

}
