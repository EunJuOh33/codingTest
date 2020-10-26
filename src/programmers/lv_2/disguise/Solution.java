package programmers.lv_2.disguise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	/*
	 * < 프로그래머스 Lvel2 위장 >
	 * 
	 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장한다.
	 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes, 서로 다른 옷의 조합의 수를 return
	 * 
	 * - clothes의 각 행은 [의상의 이름, 의상의 종류]
	 * - 스파이가 가진 의상의 수는 1개 이상 30개 이하
	 * - 같은 이름을 가진 의상은 존재하지 않음
	 * - clothes의 모든 원소는 문자열
	 * - 모든 문자열의 길이는 1이상 20 이하인 자연수
	 * - 스파이는 하루에 최소 한 개의 의상을 입는다.
	 * - 의상의 종류가 몇 종류인지도 정해지지 않았음
	 */
	
	public int solution(String[][] clothes) {
        int answer = 1;
        
        // 1. <의상종류 : 개수> 해시맵 만들기
        HashMap<String, Integer> kindsMap = new HashMap<>();	// <키, 값> <의상 종류 : 개수>
        
        for(int i=0; i < clothes.length; i++) {
        	// put(키, 값)	
        	// {headgear : 2}, {eyewear : 1} 이런식으로 저장된다.
        	// getOrDefault(Object key, defaultValue) : 첫번째 인자의 값이 존재하면 해당 키의 값을 반환, 없으면 기본값 반환
        	// 예를 들어 clothes[0][1] = "headgear" -> <headgear, 값> 이렇게 저장했다. 지금은 값이 들어오지 않은 상태.
        	// 그런데 kindsMap.getOrDefault를 해보니 headgear 키에 값이 존재하지 않는다. 그러면 0을 넣어야 하는데, 어쨌든 의상 종류가 한 개 있다는 것을 표현해야 하기 때문에 +1해서 저장한다.
        	kindsMap.put( clothes[i][1], kindsMap.getOrDefault(clothes[i][1], 0)+1 );
        }
        
        // 2. 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
        for (int val : kindsMap.values()) {		// 해시의 '값'을 차례대로 val에 대입
            answer *= (val + 1);
        }
			
        // 3. 아무것도 입지 않는 경우는 없으니 1을 뺀다.
        return answer-1;
    }
	
	
	
	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		String[][] clothes1 = { 
								{"yellow_hat", "headgear"}, 
								{"blue_sumglasses", "eyewear"}, 
								{"grenn_turban", "headgear"} 
							  };
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(clothes1));
	}

}
