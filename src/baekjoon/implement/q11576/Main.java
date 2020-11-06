package baekjoon.implement.q11576;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	/*
	 * < 백준 11576번 문제 : Base Conversion > - 2015 인하대 프로그래밍 경시대회 B번
	 * 
	 * A진법으로 나타낸 숫자를 B진법으로 변환시켜주는 프로그램
	 * 
	 * N진법이란, 한 자리에서 숫자를 표현할 때 쓸 수 있는 숫자의 가짓수가 N이라는 뜻이다. 
	 * 예를 들어 N은 17일 때 한 자릿수에서 사용할 수 있는 수는 0, 1, 2, ... , 16으로 총 17가지가 된다.
	 * 
	 * - 첫 줄에는 미래세계에서 사용하는 진법 A와 정이가 사용하는 진법 B가 공백을 구분으로 주어진다.
	 * - A와 B는 모두 2이상 30이하의 자연수
	 * - 두 번째 줄에는 A진법으로 나타낸 숫자의 자리수의 개수 m(1 ≤ m ≤ 25)이 주어진다.
	 * - 세 번째 줄에는 A진법을 이루고 있는 숫자 m개가 공백을 구분으로 높은 자릿수부터 차례대로 주어진다.
	 * - 각 숫자는 0이상 A미만임이 보장된다. 또한 수가 0으로 시작하는 경우는 존재하지 않는다.
	 * 
	 * 풀이법 : A진법 -> 10진법 -> B진법으로 변환한다. (10진법과 8진법 등을 알고 있어야 한다.)
	 */
	
	static Stack<Integer> stack = new Stack<>();
	
	static void convertBase(int decimalNum, int B) {
	    while (decimalNum != 0) {
	        int r = decimalNum % B;	// 10진법 수를 B진법의 B로 나누었을 때, 나머지가 r이 된다.
	        decimalNum /= B;			// sum을 B로 나누어서 값을 다시 sum에 대입
	        stack.push(r);
	    }
	 }

	public static void main(String[] args) {
		// 1. 입력받는다.
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();	// 미래세계에서 사용하는 진법
		int B = sc.nextInt();	// 정이가 사용하는 진법
		int m = sc.nextInt();	// A진법으로 나타낸 숫자의 자리수의 개수 m(1 ≤ m ≤ 25) 예) 123이라면 3자리.
		
		
		// 2. A진법으로 표현된 숫자를 10진법으로 바꾼다.
		int decimalNum = 0;
		for(int i = m-1; i >= 0; i--){
	        int x = sc.nextInt();
	        decimalNum += x * Math.pow(A, i);
	    }
		
		
		// 3. 10진법으로 표현된 숫자를 B진법으로 바꾼다.
		convertBase(decimalNum, B);
		
		int size = stack.size();
	    for(int i = 0; i<size; i++){
	        if(i == size-1) {
	            System.out.print(stack.pop());
	        } else {
	            System.out.print(stack.pop() + " ");
	        }     
	    }
	}

}
