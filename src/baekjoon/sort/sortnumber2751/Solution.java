package baekjoon.twothousand.sortnumber2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/*
	 * - 첫째 줄에 수의 개수가 주어진다.
	 * - 둘째 줄부터 n개의 줄에는 숫자가 주어진다.
	 * - 수는 
	 * - 수는 중복되지 않는다.
	 * 주의 ! 이 문제는 Arrays.sort 로 풀면 무조건 시간초과가 난다.
	 */
	
	public static void main(String[] args) {
	    
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = in.nextInt();
		
		// list 계열 중 하나를 쓰면 된다.
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}

}
