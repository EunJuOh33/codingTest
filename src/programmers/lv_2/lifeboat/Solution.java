package programmers.lv_2.lifeboat;

import java.util.Arrays;

public class Solution {
	/*
	 * < 프로그래머스 Level2 구명보트 >
	 * 
	 *  구명보트는 한 번에 최대 2명씩 밖에 탈 수 없고, 무게제한도 있다.
	 *  구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 한다.
	 *  
	 *  예를들어,
	 *  사람들의 몸무게(people) : [70kg, 50kg, 80kg, 50kg] 
	 *  무게제한(limit) : 100kg
	 *  -> 2번째 사람과 4번째 사람만 탈 수 있다.
	 *  
	 *  모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return하라.
	 *  
	 *  - 각 사람의 몸무게는 40kg 이상 240kg 이하
	 *  - 구명보트의 무게 제한은 40kg 이상 240kg 이하
	 *  - 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없다.
	 */
	
	
	public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);		// 작은 수부터 큰수로 오름차순 정렬
        
        int small = 0;				// 가장 몸무게 적은 사람의 인덱스
        int big = people.length -1; // 가장 몸무게 많은 사람의 인덱스
        
        while(small <= big) {		// 인덱스 small과 big이 바뀔 때가 종료시점. small 과 big이 같을 때도 answer을 한 번 더 해줘야 하기 때문에 = 도 넣는다.
        		if(people[small] + people[big] <= limit) {	// if문을 실행하면 한 보트에 두 명 태우는 것과 같다.
        			small++;
        		}
        		
        		big--;	// 큰 수부터 없앤다. 
        				// 두 명이 한꺼번에 탈 수는 없지만 사람 한 명은 반드시 태우기 때문에 제일 몸무게가 많이 나가는 사람 먼저 태우고 나가도록 한다.
        		answer++;
        }
        
        return answer;
    }

	
	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		int[] people1 = {70, 50, 80, 50};				// 정렬 후 {50, 50, 70, 80}
		int[] people2 = {90, 20, 40, 50, 30, 80, 70};	// 정렬 후 {20, 30, 40, 50, 70, 80, 90}
		int limit1 = 100;
		int limit2 = 100;
		
		Solution sol = new Solution();
		System.out.println(sol.solution(people1, limit1));
		System.out.println(sol.solution(people2, limit2));
	}

}
