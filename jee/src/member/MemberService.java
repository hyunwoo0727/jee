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
	public void registStudent(String name,String id,String pw,String ssn);
	public String findStudent();
	public void updateStudent(String pw);
	public void deleteStudent();
	public boolean checkPassword(String newPw);
}
