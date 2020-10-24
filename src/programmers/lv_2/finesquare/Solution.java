package programmers.lv_2.finesquare;

public class Solution {
	/*
	 * 가로길이 W, 세로길이 H 직사각형 종이
	 * 모든 격자칸은 1cm x 1cm 크기 정사각형
	 * 사용할 수 있는 정사각형의 개수를 구하는 solution 함수
	 * 
	 * - W, H : 1억 이하의 자연수
	 */
	
	public long solution(int w, int h) {
        long answer = 1;
        long w1 = w, h1 = h;
        
        // 1. w와 h의 크기를 비교하고 w와 h의 gcd(최대공약수)를 구한다.
        long small, big;
        
        big = w1 > h1 ? w1 : h1;
        small = w1 < h1 ? w1 : h1;
        
        long gcd = gcd(big, small);
        
        // 2. 총 사각형의 개수에서 사용할 수 없는 사각형의 총 개수를 뺀다.
        long xsquare = w1 + h1 - gcd; 	// 사용할 수 없는 사각형의 총 개수
        long square = w1 * h1;			// 총 사각형의 개수
        
        answer = square - xsquare;
        
        
        return answer;
    }
	
	/* 최대 공약수 구하는 함수 */
	public long gcd(long big, long small) {
		if(big % small == 0) {			// 만약 두 수를 나누어서 나머지가 0이라면, 두 수 중 작은 수가 최대공약수일 것이다.
			return small;
		}
		
		return gcd(small, big%small);	// 두 수의 나머지가 0이 아니라면, while문처럼 gcd함수를 반복한다.
	}

	
	
	
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		System.out.println(sol.solution(8, 12));
	}

}
