package programmers.lv_2.truck;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Solution {
	/*
	 * < 프로그래머스 Lvel2 다리를 지나는 트럭 >
	 * 
	 * 트럭 여러 대가 다리를 '정해진 순'으로 건너려 한다.	// 순서가 이미 정해져 있으니 truck_weights를 재정렬 하면 안될 것 같다.
	 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내라.
	 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고, 다리는 무게 weight까지 견딘다.
	 */
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;										// 다리 위에 있는 트럭들의 무게 합
        Queue<Integer> q = new ConcurrentLinkedQueue<>();	// 큐는 다리를 나타낸다.
        
        for(int t : truck_weights) {
        	
        	// while문은 break 하지 않는 이상 무한루프한다.
        	while(true) {
        		// 1. 큐가 비어있다면 (다리를 지나고 있는 트럭이 없다면)
        		if(q.isEmpty()) {	// isEmpty : 비어 있으면 true, 비어있지 않으면 false 반환						
        			q.add(t);
        			sum += t;
        			answer++;		// 트럭 한 대가 다리위로 올라오니 1초가 지나감
        			break;
        			
        		// 2. 큐의 길이가 다리 길이와 같다면 => 다리 위에 트럭이 가득 찬 경우
        		} else if(q.size() == bridge_length) {
        			sum -= q.poll();	// poll() : 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환하고, 해당 요소를 큐에서 제거함.
        								// 만약 큐가 비어있으면 null을 반환
        		
        		// 3. 트럭이 다리 위에 있지만 다리가 가득차지 않은 경우	
        		} else {
        			if(sum + t > weight) {	// 다리 위에 있는 트럭 무게의 합 + 새로 진입할 트럭무게(t) > weight(다리가 버틸 수 있는 무게)
        				answer++;			// 무게 때문에 트럭이 한 대 더 못올라간다고 하더라도, 원래 다리 위 트럭들은 앞으로 나아가기 때문에 1초 지나감
        				q.add(0);			// add() : 괄호 안의 아이템을 리스트의 끝에 추가. break하지 않음
        			
        			} else {		// 다리 위의 트럭 무게의 합 + t 가 버틸 수 있는 무게라면
        				q.add(t);
        				sum += t;
        				answer++;	// t가 다리 위에 올라왔으니 1초 지나감
        				break;
        			}
        		}
        	}
        	
        }	// for문 끝
        return answer + bridge_length;	// 모든 트럭이 다리에 진입하는 것까지 구현, 마지막에 다리의 길이만큼 더해준다.
    }

	
	
	
	/* 실행 - 테스트 */
	public static void main(String[] args) {
		int bridge_length1 = 2;
		int weight1 = 10;
		int[] truck_weights1 = {7, 4, 5, 6};
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(bridge_length1, weight1, truck_weights1));
	}

}
