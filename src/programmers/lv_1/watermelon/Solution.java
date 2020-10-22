package programmers.lv_1.watermelon;

public class Solution {
	/* 
	 * < 프로그래머스 Level1 수박수박수박수박수박수? >
	 * 
	 * 길이가 n이고, "수박수박수박수..."와 같은 패턴을 유지하는 문자열을 리턴하라.
	 * 예를들어 n = 4 이면 "수박수박"을 리턴하고 n = 3 이면 "수박수"를 리턴한다.
	 * 
	 * - n은 길이 10,000이하인 자연수
	 */
	
	
	public String solution(int n) {
        String answer = "";
        
        for(int i=0; i < n; i++) {
        		if(i % 2 == 0) {
        			answer += "수";
        		} else {
        			answer += "박";
        		}
        }
        
        return answer;
    }
	
	
	
	
	/* 다른 사람 풀이 */
	public String watermelon(int n){
        return new String(new char [n/2 +1]).replace("\0", "수박").substring(0,n);
        // 빈 char 배열이 생성이 되면 그 안에는 null이 아니라 '\0'으로 먼저 생성되어진다.
        // 예를들어 n = 4 라면, new String(new char[3]) => {\0, \0, \0} 이렇게 생성되는 것. char = "수박수박수박" 이렇게 되는 것 같다.
        // replace([기존문자],[바꿀문자])
        // substring : 0번째 문자열부터 n번째 전까지 자르는 함수
    }
	
	
	
	
	/* 다른 사람 풀이 2 */
	public String solution2(int n) {
	      StringBuilder answer = new StringBuilder("");	// String 객체에 + 연산을 하는 것보다 StringBuilder 객체를 append 하는 과정이 더 빠르다고 한다.
	      
	      for(int i =1; i <= n; i++){
	          if(i%2 == 0){
	              answer.append("박");
	          }else{
	              answer.append("수");
	          }
	      }
	      
	      return answer.toString();	// toString() : 인스턴스의 값을 String으로 변환한다.
	 }
	
	

	
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(4));
		System.out.println(sol.solution(3));
		System.out.println(sol.solution(8));
	}

}
