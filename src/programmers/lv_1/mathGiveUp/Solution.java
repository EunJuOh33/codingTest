package programmers.lv_1.mathGiveUp;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 * < 프로그래머스 Lvel1 모의고사 >
	 * 완전탐색 문제
	 * 
	 * 1번 수포자가 찍는 방식 : [ 1, 2, 3, 4, 5 ... ]
	 * 2번 수포자가 찍는 방식 : [2, 1, 2, 3, 2, 4, 2, 5 ... ]
	 * 3번 수포자가 찍는 방식 : [3, 3, 1, 1, 2, 2, 4, 4, 5, 5 ... ]
	 * 
	 * answers 배열 : 1번 문제부터 마지막 문제까지 정답이 순서대로 담긴 배열
	 * return : 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하라.
	 * 
	 *  - 문제의 정답은 1, 2, 3, 4, 5 중 하나이다.
	 *  - 시험은 최대 10,000 문제로 구성되어 있다.
	 *  - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순으로 정렬
	 */
	
	public int[] solution(int[] answers) {
		
    	// 1. 수포자들의 찍기 패턴
    	int[] one = {1, 2, 3, 4, 5};
    	int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    	int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    	
    	// 2. 수포자1, 2, 3이 맞춘 정답 개수(= 점수) 구하기
    	// int[] point = {수포자1이 맞춘 정답 개수, 수포자2가 맞춘 정답 개수, 수포자3이 맞춘 정답 개수}  
    	int[] point = new int[3];	// {0, 0, 0}
    	
    	for(int i=0; i < answers.length; i++) {
    		if(answers[i] == one[i%5]) {	// %는 나머지를 구하는 것. 만약 answers[10] 이라면 one[0]과 비교하게 된다.
    			point[0]++;
    		}
    		if(answers[i] == two[i%8]) {
    			point[1]++;
    		}    		
    		if(answers[i] == three[i%10]) {
    			point[2]++;
    		}    		
    	}
    	
    	// 3. 가장 정답을 많이 맞춘 수포자 구하기
    	// 먼저 수포자1의 점수인 point[0]을 변수 winPoint에 할당하고, 
    	// 배열 num에 들어있는 수포자1, 2, 3의 점수를 차례대로 비교한다. winPoint(수포자1의 점수)보다 크다면 winPoint에 그 점수를 대입한다.
    	int winPoint = point[0];
    	for(int i=0; i < point.length; i++) {
    		if(winPoint < point[i]) {
    			winPoint = point[i];
    		}
    	}
    	
    	// 4. winPoint = 10, point = {10, 8, 10}일 수도 있다. 똑같이 가장 높은 점수를 받은 학생이 있을 수 있으니 찾아보자.
    	List<Integer> win = new ArrayList<Integer>();
    	
    	if(winPoint == point[0]) {
    		win.add(1);
    	}
    	if(winPoint == point[1]) {
    		win.add(2);
    	}
    	if(winPoint == point[2]) {
    		win.add(3);
    	}
    	
    	// 5. win은 리스트이므로, answers 배열에 담자.
    	int[] answer = new int[win.size()];	// list의 크기는 length가 아니라 size이다.
    	for(int i=0; i < win.size(); i++) {
    		answer[i] = win.get(i);			// get은 인자로 list를 받는다. 이 인덱스의 위치에 있는 객체를 리턴한다.
    	}
    	
    	
		return answer;
	}

	
	
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		int[] answers1 = {1, 2, 3, 4, 5};
		int[] answers2 = {1, 3, 2, 4, 2};
		
		Solution sol = new Solution();
		int[] temp1 = sol.solution(answers1);
		int[] temp2 = sol.solution(answers2);
		
		for(int i=0; i < temp1.length; i++) {
			System.out.print(temp1[i]);
		}
		
		System.out.println();
		
		for(int i=0; i < temp2.length; i++) {
			System.out.print(temp2[i]);
		}
	}

}
