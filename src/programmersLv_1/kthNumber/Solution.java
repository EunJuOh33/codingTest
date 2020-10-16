package programmersLv_1.kthNumber;

import java.util.*;

public class Solution {
	/*
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 '정렬', k 번째에 있는 수를 구하려고 한다.
	 * 1. array = [ 1, 5, 2, 6, 3, 7, 4 ], i = 2, j = 5, k = 3 이라면
	 * 2. 2번째(i)에서 5번째(j)까지 자르면 [ 5, 2, 6, 3]
	 * 3. 2에서 나온 배열의 3번째 숫자(k)는 5. 
	 * 
	 * commands [] [] -> i, j, k 를 원소로 가지는 2차원 배열.
	 * return -> 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하라.  
	 */ 
	
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // 처음에 int[] answer = {}; 라고 잘못 설정하여 애를 먹었다.
        
        // 우리는 commands[?][0], commands[?][1] i와 k가 인덱스0, 인덱스1번째에 있다는 것을 알고 있다.
        // 하지만 commands = { {i,j,k}, {i,j,k}, {i,j,k} ... } 50개 이하이므로 알 수 없음
        // answer 배열의 길이는 commands배열의 ([] [])첫번째 배열길이?와 같다.
        for(int i = 0; i < commands.length; i++){
        	int temp[] = Arrays.copyOfRange(array, commands[i][0] -1, commands[i][1]);	// { 5, 2, 6, 3}
	        Arrays.sort(temp);	// 정렬하라고 했으니 꼭 정렬한다. -> { 2, 3, 5, 6 }
	        
	        answer[i] = temp[commands[i][2] -1];	// 2는 k이다.
        }

        return answer;
    }
    
    
    /* 테스트 - 실행 */
    public static void main(String[] args) {
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands = { 
    							{2, 5, 3}, 
    							{4, 4, 1}, 
    							{1, 7, 3} 
    						};
    	
    	Solution test = new Solution();
    	int answer[] = test.solution(array, commands);
    	
    	System.out.println(answer[0]);	// [ 5, 6, 3] 이 나와야 성공
    	System.out.println(answer[1]);
    	System.out.println(answer[2]);
    }
}
