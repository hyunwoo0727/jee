/**
 * 
 */
package bank;


/**
 * @date   : 2016. 6. 15.
 * @author : HyunWoo Lee
 * @file   : Bank.java 
 * @story  : 
*/
public class Bank {
		
	public static void main(String[] args) {
		for(int i=0; i < 20; i++){
			int accountNo = (int) (Math.random()*1000000+100000);
			if(accountNo > 1000000){
				System.out.println("으악" + accountNo);
				accountNo -= 100000;
			
			}
			System.out.println(accountNo);
		}
	}
	
}
