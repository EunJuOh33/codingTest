package programmers.lv_1.kimseobang;

public class Solution {
	/*
	 * String형 배열 seoul의 element 중 "Kim"의 위치 x를 찾아,	(x는 인덱스)
	 * "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
	 * seoul배열에 "Kim"은 오직 한 번만 나타나며, 잘못된 값이 입력되는 경우는 없다.
	 */
	
	public String solution(String[] seoul) {
        String answer = "";
        
        for(int i=0; i < seoul.length; i++) {
        	if(seoul[i].equals("Kim")) {
        		answer = "김서방은 " + i + "에 있다.";
        		break;		// 김서방을 찾으면, 더이상 for문을 돌 필요가 없기 때문에 break를 적어주는 것이 좋다.
        	}
        }
        
        return answer;
    }
	
	
	
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		String[] seoul1 = {"Jane", "Kim"};	// "김서방은 1에 있다." 가 출력되어야 함
		String[] seoul2 = {"Jane", "Kim", "Oh", "Eunju"};
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(seoul1));
		System.out.println(sol.solution(seoul2));
	}

}
