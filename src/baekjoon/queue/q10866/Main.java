package baekjoon.queue.q10866;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	/*
	 * 정수를 저장하는 덱을 구현하고, 입력으로 주어지는 명령을 처리하는 프로그램 작성하라.
	 * 
	 * - push_front X: 정수 X를 덱의 앞에 넣는다.
	 * - push_back X : 정수 X를 덱의 뒤에 넣는다.
	 * - pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * - pop_back : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * - size: 덱에 들어있는 정수의 개수를 출력한다.
	 * - empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	 * - front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * - back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 *  
	 *  - 덱이란?
	 *	양쪽 끝 모두에서 자료를 넣고 뺄 수 있는 자료구조.
	 *  한 쪽에서만 자료를 넣고 빼면 스택처럼 사용할 수 있고 
	 * 	한 쪽에서 자료를 넣고 한 쪽으로 빼면 큐처럼 사용할 수 있다.
	 */
	
	public static void main(String[] args) {
		// 1. 스캐너를 통해 명령의 수(N)와 명령을 입력받는다.
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();	// 명령의 수
        
        
        // 2. 명령을 입력 받으면, 바로 실행한다.
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i=0; i < N; i++) {
        		String input = sc.next();
	        	
        		if(input.equals("push_front")) {
	        		int input2 = sc.nextInt();	// 명령이 "push_front"이면, 바로 다음에 입력하는 정수를 input2에 저장
	        		deque.addFirst(input2);
        		}
        		else if(input.equals("push_back")) {
        			int input3 = sc.nextInt();
	        		deque.addLast(input3);
				}
        		else if(input.equals("pop_front")) {
					System.out.println( deque.isEmpty() ? -1 : deque.pop() );
				}
        		else if(input.equals("pop_back")) {
					System.out.println( deque.isEmpty() ? -1 : deque.removeLast() );	
				}
        		else if (input.equals("size")) {
					System.out.println( deque.size() );
				}
        		else if (input.equals("empty")) {
					System.out.println( deque.isEmpty() ? 1 : 0 );
				}
        		else if (input.equals("front")) {
					System.out.println( deque.isEmpty() ? -1 : deque.peek() );
				}
        		else if (input.equals("back")) {
					System.out.println( deque.isEmpty() ? -1 : deque.peekLast() );
				}
        	
        }
        
        sc.close();
	}

}
