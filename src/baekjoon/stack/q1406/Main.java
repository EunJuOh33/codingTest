package baekjoon.stack.q1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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

	public static void main(String[] args) throws IOException {		// BifferedReader 사용하려면 IOExeption 해야 함
		// 1. 명령의 수(M)와 문자열을 입력받는다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder str = new StringBuilder(reader.readLine());	// 첫째 줄 : 문자열
		int n = Integer.parseInt(reader.readLine());				// 둘째 줄 : 명령의 수
        
        
        // 2. 입력받은 문자열(str)을 lSack에 한글자씩 넣는다.
		Stack lStack = new Stack<>();	// 문자열이 들어있는 Stack
		Stack rStack = new Stack<>();	// 
        
		for(int i = 0; i < str.length(); i++) {
			lStack.add(str.charAt(i));
		}
		
		
		// 3. 명령을 수행한다.
		while(n-- > 0) {
			String cmd = reader.readLine();	// 셋째 줄부터 명령이 들어온다.

			if(cmd.contains("P")) {
				lStack.add(cmd.charAt(2));	// 예) cmd = P x 이면 인덱스 번호 2가 x가 된다.
			
			} else {
				switch(cmd) {
					case "L": 	// L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
						if(!lStack.isEmpty()) {	// 그냥 예외처리
							rStack.add(lStack.pop());	// pop : 스택의 가장 위에 있는 데이터를 삭제와 동시에 출력한다.
						}	
						break;
					case "D": 	// D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
						if(!rStack.isEmpty()) {
							lStack.add(rStack.pop());
						}	
						break;
					case "B": 	// B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
						if(!lStack.isEmpty()) {
							lStack.pop();
						}	
						break;
				}
			}
		}	// while문 끝
		while(!lStack.isEmpty()) rStack.add(lStack.pop());
		while(!rStack.isEmpty()) System.out.print(rStack.pop());
	}
	
}	
