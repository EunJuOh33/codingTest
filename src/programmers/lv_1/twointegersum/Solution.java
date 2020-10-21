package programmers.lv_1.twointegersum;

public class Solution {
	/*
	 * < 프로그래머스 Level1 두 정수 사이의 합 >
	 * 
	 * 두 정수 a, b가 주어졌을 때,
	 * a와 b 사이에 속한 모든 정수의 합을 리턴하는 합수
	 * 
	 * -  a와 b가 같은 경우 둘 중 아무 수나 리턴
	 * -  a와 b는 -10,000,000 <= a,b <= 10,000,000 정수
	 * -  a와 b의 대소관계는 정해져있지 않음
	 */
	
	
	/* 나의 풀이 */
	public long solution(int a, int b) {
        long answer = 0;
        
        // 여기서 a > b 인 경우와 a = b 인 경우 둘 다 계산할 수 있다.
        if(a >= b) {
        	for(int i=b; i <= a; i++) {
        		answer += i;
        	}
        	
        } else {
        	for(int i=a; i <= b; i++) {
        		answer += i;
        	}
        }
        
        return answer;
    }

	
	
	
	/* 다른 사람들 풀이 */
	public long solution2(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
        // sumAtoB 함수를 리턴한다. 
     	// Math.min은 인자로 들어온 수 중 작은 수를 리턴하고, Math.max는 인자로 들어온 수 중 큰 수를 리턴한다.
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
        // '등차수열의 합' 공식을 이용한 것.
        // 1부터 10까지 수를 더하라고 한다면, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 이렇게 수가 있으면
        // 1+10=11, 2+9=11 ... 5+6=11 이렇게 11x5=55 가 된다.
        // 1부터 11까지 수를 더하라고 한다면, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 이렇게 수가 있으면
        // 1+11=12, 2+10=12 ... 5+7=12 + 6
        // 이런 느낌이다..
    }

	
	
    
	/* 테스트 -실행 */
	public static void main(String[] args) {
		int a1 = 3;
		int a2 = 5;
		int b1 = 3;
		int b2 = 5;
		
		Solution sol = new Solution();

		System.out.println(sol.solution(a1, b1));
		System.out.println(sol.solution(a1, b2));
		System.out.println(sol.solution(a2, b1));
		
		System.out.println(sol.solution2(a1, b1));
		System.out.println(sol.solution2(a1, b2));
		System.out.println(sol.solution2(a2, b1));
		
		System.out.println(Math.max(9, 9));		// Math.max는 같은 숫자가 인자로 들어오면 수를 그대로 리턴한다. 
	}

	
}
