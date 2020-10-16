package programmers.lv_2.bigNum;

public class Solution {
	/*
	 * < 프로그래머스 레벨2 _ 큰 수 만들기 >
	 * 
	 * 탐욕법(Greedy)
	 * : 미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 기법
	 * : 예를 들어 마시멜로에서는 그리디 알고리즘이 통하지 않는다. 지금 당장 최선의 선택은 마시멜로 1개를 받는 것이기 때문
	 * 
	 * 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24]를 만들 수 있다.
	 * 이 중 가장 큰 숫자는 94이다.
	 * k = 제거할 수의 개수, number = 문자열 형식 숫자
	 * return = number에서 k개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자 리턴
	 *
	 * < StringBuilder 사용법 및 사용하는 이유 >
	 * String str1 = "abc";, String str2 = "def"; 이렇게 2개의 String 객체가 있을 때,
	 * 만약 str1 + str2; 연산을 하게 되면 새로운 String을 생성한다.
	 * String객체와 String객체를 더하는(+) 행위는 메모리 할당과 메모리 해제를 발생시키며 성능적으로 좋지 않다.
	 * StringBuilder는..
	 * String + String 연산을 할 때 새로운 객체를 생성하는 것이 아니라, 기존의 데이터를 더하는 방식을 사용한다. 속도도 빠르며 상대적으로 부하가 적다.
	 * 긴 문자열을 더하는 상황이 발생할 경우 StringBuilder를 사용하자.
	 * 
	 * < charAt(index) >
	 * 문자열에서 인자로 주어진 값에 해당하는 문자를 리턴한다.
	 * 
	 * < append() >
	 * StringBuffer, StringBuilder에서 사용 가능. 텍스트를 붙일 수 있다.
	 * 
	 * < toString() >
	 * 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
	 */
	
	public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int comp = 0;
        
        // 1. number의 길이에서 k를 뺀 수 만큼 for문을 반복한다. (i가 2가 될 때까지 반복)
        for(int i=0; i < number.length()-k; i++) {
        	comp = 0;
        	
        	// 2. j=jdx는 0부터 시작하고, 문자열 반복한다.
        	for(int j=idx; j <= i+k; j++) {
        		// 3. comp는 0부터 시작하므로 number[0]이 1이므로 if문 실행
        		// i=0, comp=0, idx=0, j=0, number.charAt(0)=1 if문 실행 -> comp=1, idx=1
        		// i=0, comp=0, idx=1, j=1, number.charAt(1)=9 if문 실행 -> comp=9, idx=2
        		// i=0, comp=9, idx=2, j=2, number.charAt(2)=2 if문 실행하지 않음
        		// i=0, comp=9, idx=2, j=2?3?, number.charAt(3)=4 if문 실행하지 않음 -> for문으로 다시 간다. answer.append(9)
        		// i=1, comp=0, idx=2, j=2, number.charAt(2)=2 if문 실행 -> comp=2, idx=3
        		// i=1, comp=2, idx=3, j=3, number.charAt(3)=4 if문 실행 -> comp=4, idx=4 -> for문으로 다시 간다. answer.append(4)
        		if(comp < number.charAt(j)-'0') {
        			comp = number.charAt(j)-'0';
        			idx = j + 1;
        		}
        	}
        	answer.append(comp);
        }
        
        return answer.toString();
    }
	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		String number1 = "1924";
		int k1 = 2;
		
		String number2 = "1231234";
		int k2 = 3;
		
		String number3 = "4177252841";
		int k3 = 4;
		
		Solution sol = new Solution();
		System.out.println(sol.solution(number1, k1));
		System.out.println(sol.solution(number2, k2));
		System.out.println(sol.solution(number3, k3));
	}

}
