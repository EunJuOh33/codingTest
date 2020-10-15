package programmersLv_1.player;

import java.util.HashMap;

public class Solution2 {
		/*
		 * 한 명의 선수를 제외하고는 모든 선수가 마라톤 완주
		 * 
		 * - 선수의 수 : 1 <= num <= 100,000
		 * - completion의 길이는 participant의 길이보다 1 작다.
		 * - 참가자의 이름은 1 <= name <= 20 알파벳 소문자
		 * - 참가자 중 동명이인이 있을 수 있다.
		 * 
		 * participant : 마라톤에 참여한 선수들의 이름이 담긴 배열
		 * completion  : 마라톤을 완주한 선수들의 이름이 담긴 배열
		 * return : 완주하지 못한 선수의 이름 
		 */
		
		public String solution(String[] participant, String[] completion) {
			String answer = "";
			HashMap<String, Integer> hm = new HashMap<>();
			
			// 1. 전체 참가자 수만큼 for문을 돌며 참가자 이름을 'key'로, 동일한 이름의 참가자를 가진 수만큼 '값(vlue)'으로 넣음
	        for (String player : participant) {
	        	hm.put(player, hm.getOrDefault(player, 0) + 1);
	        	// ( aaa, )
	        }
	        
	        // 2. 완주자의 수 만큼 for문을 돌며 map의 key가 완주자와 동일하면 값을 1씩 뺀다.
	        for (String player : completion) {
	        	hm.put(player, hm.get(player) - 1);
	        }

	        for (String key : hm.keySet()) {
	            if (hm.get(key) != 0) {
	                answer = key;
	            }
	        }
			
			return answer;
		}

		
		/* 테스트 - 실행2 */
		public static void main(String[] args) {
			String[] participant = {"mislav", "stanko", "mislav", "ana"};
			String[] completion = {"stanko", "mislav", "ana"};
			
			// HashMap<String, Integer> hm = new HashMap<String, Integer>();
			// HashMap<String, Integer> hm = new HashMap<>(10);	// 초기 용량(capacity) 지정 
			// HashMap<String, Integer> hm = new HashMap<String, Integer>() {
			//	 put("a", "b");	// 초기 값 지정
			// };
			// HashMap<String, Integer> hm = new HashMap<>();	// new에서 타입, 파라미터 생략 가능
			
			// hm.put("사과", 1);
			// hm.put("배", 2);
			
			Solution sol = new Solution();
			System.out.println(sol.solution(participant, completion));
		}

}
