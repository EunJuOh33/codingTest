package programmers.lv_1.gcdlcm;

public class Solution {
	/*
	 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수를 완성하라.
	 * 배열의 맨 앞이 최대 공약수, 그다음 최소공배수를 넣어 반환
	 * 
	 * 최소 공배수 : 규칙을 만들어야 한다. 두 수의 곱을 최대 공약수로 나누면 된다.
	 */
	
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int big, small;
        
        if(n > m) {
        	big = n;
        	small = m;
        } else {
        	big = m;
        	small = n;
        }
        
        answer[0] = gcd(big, small);
        answer[1] = big*small / answer[0];	// 최소공배수는 두 수의 곱에서 최대공약수를 나눈 값이다.
        
        return answer;
    }
	
	public int gcd(int a, int b) {
		if(a % b == 0) {	// 만약 두 수를 나누어서 나머지가 0이라면, 두 수 중 작은 수가 최대공약수일 것이다.
			return b;
		}
		
		return gcd(b, a%b);	// 두 수의 나머지가 0이 아니라면, while문처럼 gcd함수를 반복한다.
	}

	
	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		int n1 = 3;
		int n2 = 2;
		int n3 = 4;
		int m1 = 12;
		int m2 = 5;
		int m3 = 18;
		
		Solution sol = new Solution();
		int[] answer = sol.solution(n3, m3);
		
		for(int i=0; i < 2; i++) {
			System.out.println(answer[i]);
		}
	}

}
