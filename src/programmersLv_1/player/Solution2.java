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
			
	        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
	        
	        for (String player : completion) hm.put(player, hm.get(player) - 1);

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
			
			Solution sol = new Solution();
			System.out.println(sol.solution(participant, completion));
		}

}
