package programmersLv_1.player;

import java.util.Arrays;

public class Solution {
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
		// 정렬을 하는 이유 : participant[i]와 completion[i]를 비교해야 하기 때문 
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		int i;
		for(i=0; i < completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];	
				// return은 실행 중인 구문을 중단시키고 바로 값을 return 시킨다.
			}
		}
		
		return participant[i];
	}
	
	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(participant, completion));
	}
}
