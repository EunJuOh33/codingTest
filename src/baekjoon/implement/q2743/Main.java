package baekjoon.implement.q2743;

import java.util.Scanner;

public class Main {
	/*
	 * < 백준 2743번 문제 : 단어 길이 재기 > - 문자열, 구현
	 * 
	 * 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다.
	 * 단어의 길이는 최대 100
	 * 단어의 길이를 출력하라.
	 */
	
	public static void main(String[] args) {
		// 1. Scanner로 단어를 입력받는다.
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		
		// 2. 단어의 길이를 계산하여 출력한다.
		System.out.println(S.length());
	}

}
