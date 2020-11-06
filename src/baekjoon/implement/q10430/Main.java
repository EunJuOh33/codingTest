package baekjoon.implement.q10430;

import java.util.Scanner;

public class Main {
	/*
	 * < 백준 10430번 문제 : 나머지 > - 수학, 구현, 사칙연산
	 * 
	 * (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
	 * (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
	 * 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
	 * 
	 * - 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
	 * - 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력
	 */

	public static void main(String[] args) {
		// 1. A, B, C를 입력받는다.
		Scanner sc = new Scanner(System.in);
				
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		
		// 2. 연산한다.
		System.out.println( (A+B) % C );
		System.out.println( ((A%C) + (B%C)) % C );
		System.out.println( (A*B) % C );
		System.out.println( ((A%C) * (B%C)) % C );		
	}

}
