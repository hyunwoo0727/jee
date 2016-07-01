package test;

/**
 * @date   :2016. 7. 1.
 * @author :HyunWoo Lee
 * @file   :StaticInit.java
 * @story  :
*/

public class StaticInitClass {
	
	static{
		System.out.println("스태틱 쵝화 블록 ....");
	} // 클래스(클래스 변수 system.out... ) 초기화 블록 
	{
		System.out.println("인스턴스 초기화 블록 ...");
	} // 인스턴스 초기화불록
	public StaticInitClass() {
		System.out.println("생성자 실행중...");
	}
}
