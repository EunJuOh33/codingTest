package programmers.lv_2.phoneNumList;

import java.util.Arrays;

public class Solution {
	/*
	 * < 프로그래머스 Level2 전화번호 목록 (해시) >
	 * 
	 * 한 번호가 다른 번호의 접두어가 있는지 확인하려 한다.
	 * 아래와 같은 경우, 구조대 번호는 영석이 번호의 접두사이다.
	 * - 구조대 : 119
	 * - 박준영 : 97674223
	 * - 지영석 : 1195524421
	 * 
	 * String[] phone_book : 전화번호부에 적인 전화번호를 담은 String 배열
	 * return : 번호가 다른 번호의 접두어인 경우가 '있으면' false, '그렇지 않으면' true를 retrun 하시오.
	 * 
	 * 팁 : "노가다 문자열 비교 작업"이 필요하다면 해시를 떠올려라!
	 * startsWith() : 어떤 문자열이 특정 문자열로 시작하는지 확인하여 결과를 true 혹은 false로 반환한다.
	 * 				  'abcde'.startsWith( 'a' ) -> abcd가 a로 시작하는지 검사한다.
	 */
	
	
	 public boolean solution(String[] phone_book) {
		 boolean answer = true;
	       
		 Arrays.sort(phone_book);
		 
			 for(int i=0; i < phone_book.length -1; i++) {	// length를 -1 하는 이유는 본인을 제외하고 비교해야 하기 때문
				 	if(phone_book[i+1].startsWith(phone_book[i])) {
				 			answer = false;
					 
					 break;
				 }
			 }
	        
	     return answer;
	}

	 
	 
	 
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		String[] phone_book1 = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"123", "456", "789"};
		String[] phone_book3 = {"12", "123", "1235", "567", "88"};
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(phone_book1));
		System.out.println(sol.solution(phone_book2));
		System.out.println(sol.solution(phone_book3));
	}

}
