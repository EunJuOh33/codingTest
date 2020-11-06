package baekjoon.sort.q11656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * < 백준 문제 11656번 : 접미사 배열 > - 문자열, 정렬
	 * 
	 * 문자열 S의 모든 접미사를 '사전순으로' 정렬해 놓은 배열이다.
	 * baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지
	 * 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
	 * - S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.
	 */

	public static void main(String[] args) {
		// 1. 스캐너를 통해 문자열을 입력받는다.
        Scanner sc = new Scanner(System.in);
        String S = sc.next();        
        
        // 2. 입력받은 문자열의 접미사를 배열에 저장한다.
        int str_length = S.length();
        String[] str_arr = new String[str_length];			// 접미사를 모두 저장하는 배열. 접미사의 수는 문자의 길이와 같다.
        
        for(int i=0; i < S.length(); i++) {
        	String sub = S.substring(i, str_length);	//문자열 Str의 start위치 부터 end전까지 문자열 발췌
        	str_arr[i] = sub;
        }
                
        // 3. str 배열에 저장된 접미사를 사전순으로 정렬한다.
        Arrays.sort(str_arr);
        
        // 4. 출력
        for(String s : str_arr) {
        	System.out.println(s);
        }
	}

}
