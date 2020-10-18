package programmers.lv_1.middleLetter;

public class Solution {
	/*
	 * < 프로그래머스 Lvel1 가운데 글자 가져오기 >
	 */
	
	/* 내 풀이 */
	public String solution(String s) {
		String answer = "";
		
		// 1. 2로 나누어 떨어진다면 = 짝수라면
		if(s.length() % 2 == 0) {	
			answer = s.substring(s.length()/2 -1 , s.length()/2 +1);
			return answer;
			
		} else {	// 2. 2로 나누어 떨어지지 않는다면 = 홀수라면
			answer = s.substring(s.length() / 2, s.length()/2 +1);
			return answer;
		}
	}
	
	
	/* 다른사람 풀이 */
	public String getMiddle(String word) {
		return word.substring((word.length() -1) / 2, word.length()/2 + 1);
	}

	
	
	
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		String s1 = "abcdefghijk";	// f
		String s2 = "qwer";			// we
		
		Solution sol = new Solution();
		System.out.println(sol.solution(s1));
		System.out.println(sol.solution(s2));
	}

}
