package baekjoon.stack.q1406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	/*
	 * < 백준 1406번 문제 : 에디터 > - 자료구조, 스택, 덱, 연결 리스트
	 * 
	 * 길이가 N인 문자열이 있으면, 커서가 위치할 수 있는 곳은 N+1가지 경우
	 * 영어 소문자만 입력, 길이는 100,000을 넘지 않는다.
	 * 둘째 줄에는 입력할 명령어의 개수를 나타내는 정수 M(1 ≤ M ≤ 500,000)이 주어진다. 
	 * 셋째 줄부터 M개의 줄에 걸쳐 입력할 명령어가 순서대로 주어진다. 명령어는 네 가지 중 하나의 형태로만 주어진다.
	 * 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열은 ?
	 * 
	 * - L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
	 * - D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
	 * - B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
			 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
	 * - P $ : $라는 문자를 커서 왼쪽에 추가함	
	 * - 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치 
	 */

	public static void main(String[] args) {
		// 1. 스캐너를 통해 명령의 수(M)와 문자열을 입력받는다.
        Scanner sc = new Scanner(System.in);
 
        String str = sc.next();	// 첫째 줄 : 문자열
        int M = sc.nextInt();	// 둘째 줄 : 명령의 수
        
        
        // 2. 입력받은 문자열을 List에 한글자씩 넣는다.
        String[] arr_str;
        arr_str = str.split("");	// 문자열을 String 배열로 변환
        
        List<String> list_str = new ArrayList<String>( Arrays.asList(arr_str) );	// 배열을 list로 전환
        
        
        // 3. 명령을 수행한다.
        for(int i=0; i < M; i++) {					// 명령의 개수(M)만큼 반복한다.
        		int cursor = list_str.size();		// 커서 위치. 커서는 문장의 맨 뒤에 위치. 예) str = abcd 라면 cursor = 4
        		String input = sc.next();			// 셋째 줄부터 M개의 명령이 들어온다.
	        	
        		if(input.equals("P")) {
	        		String input2 = sc.next();
	        		list_str.add(cursor, input2);	// index cursor에 데이터 input2 추가
	        		cursor++;						// 커서는 한 칸 뒤로 밀린다.
        		}
        		else if(input.equals("B")) {		// B : 커서 왼쪽에 있는 문자를 삭제
        			if(cursor != 0) {				// '커서가 맨 앞에 있다면'을 표현하기 위함
        				list_str.remove(cursor); 	// index cursor 제거	        
        			}
				}
        		else if(input.equals("D")) {
					if( cursor != (list_str.size() -1) ) {
						cursor++;
					}
				}
        		else if(input.equals("L")) {	// L : 커서를 왼쪽으로 한 칸 옮김
        			if(cursor != 0) {
						cursor--;
					}	
				}
        }
        
        
        // 4. 출력
        for(String output : list_str) {
        	System.out.print(output);
        }
        
        sc.close();
	}

}
