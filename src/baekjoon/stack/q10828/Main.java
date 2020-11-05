package baekjoon.stack.q10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	/*
	 * push X : 정수 X를 스택에 넣는 연산 -> 아무것도 출력하지 않음
	 * pop : 스택에서 가장 위에 있는 정수를 빼서 출력한다. 만약 스택에 아무것도 없다면 -1을 출력한다.
	 * size : 스택에 들어있는 정수의 개수 출력
	 * empty : 스택이 비어있으면 1, 아니면 0 출력
	 * top : 스택의 가장 위에 있는 정수 출력. 만약 스택에 들어있는 정수가 없는 경우 -1 출력
	 * 참고 - 스택은 '후입선출', 물컵을 생각하라. pop 수행 시 나중에 push된 데이터가 먼저 나온다.
	 */

	public static void main(String[] args) {
	
		// 1. 스캐너를 통해 명령의 수(N)와 명령을 입력받는다.
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();	// 명령의 수
        
        
        // 2. 명령을 입력 받으면, 바로 실행한다.
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        
        for(int i=0; i < N; i++) {
        		String input = sc.next();
	        	
        		if(input.contains("push")) {
	        		int input2 = sc.nextInt();	// 명령에 "push"가 포함되어 있으면, 바로 다음에 오는 정수를 input2에 저장
	        		stack.push(input2);
        		}
        		else if(input.equals("pop")) {
					System.out.println( stack.isEmpty() ? -1 : stack.pop() );	
					// isEmpty : 스택에 비어있으면 true, 원소가 있으면 false 반환
					// pop : 스택의 가장 위에 있는 데이터를 삭제와 동시에 출력한다.
				}
        		else if(input.equals("size")) {
					System.out.println( stack.size() );	// size 메소드는 stack의 size를 반환한다.
				}
        		else if(input.equals("empty")) {
					System.out.println( stack.isEmpty() ? 0 : 1 );	
				}
        		else if (input.equals("top")) {
					System.out.println( stack.isEmpty() ? -1 : stack.peek() );
					// peek : 스택에서 top이 가리키는 데이터를 읽는 작업. stack 안의 값 변화는 없다.
				}
        	
        }
        
        sc.close();
	}

}
