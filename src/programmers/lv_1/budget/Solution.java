package programmers.lv_1.budget;

import java.util.Arrays;

public class Solution {
	/*
	 * <이분탐색>
	 * 반씩 쪼개서 범위를 줄여나가는 탐색기법
	 * 
	 * 배열 d : 부서별로 신청한 금액이 들어있는 배열
	 * 변수 budget : 예산
	 * return : 최대 몇 개의 부서에 물품을 지원할 수 있는지 리턴하시오.
	 */
	
	public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        
        Arrays.sort(d);
        
        for(int i=0; i < d.length; i++) {
        	sum += d[i];
        	
        	if(sum > budget) {
        		break;
        	}
        	answer++;
        }
        
        return answer;
    }

	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		int[] d1 = {4, 11, 2, 10, 3, 1};	// -> 정렬후 {1, 2, 3, 4, 10, 11}
		int budget1 = 20;
		
		int[] d2 = {2, 2, 3, 3};
		int budget2 = 10;
		
		int[] d3 = {5, 100, 250, 80};	// -> 정렬후 {5, 80, 100, 250}
		int budget3 = 200;
		
		Solution sol = new Solution();
		System.out.println(sol.solution(d1, budget1));
		System.out.println(sol.solution(d2, budget2));
		System.out.println(sol.solution(d3, budget3));
	}

}
