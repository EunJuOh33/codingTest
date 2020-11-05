package baekjoon.implement.q10808;

import java.util.Scanner;

public class Main {
	/*
	 * 알파벳 소문자로만 이루어진 단어 S
	 * 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하라.
	 * - 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
	 * - 단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력
	 */
	
	public static void main(String[] args) {
		// 1. Scanner로 입력받는다.
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();		// next() : 문자 또는 문자열을 공백을 기준으로 한 단어 또는 한문자씩 입력받는다. 예) Hellow Java -> Hellow만 입력받음
									// nextLine() : 문자 또는 문장 전체를 입력받는다. 예) Hellow Java -> Hellow Java 입력받음
		
		
		// 2. a ~ z 까지 알파벳의 개수를 담을 배열 생성
		int[] arr_alphabet = new int[26];	// 알파벳 소문자 총 갯수는 26개
											// 자바에서 배열을 선언하면 자동으로 모든 요소의 값이 초기화 된다. {0, 0, 0, 0, 0......} 이런식으로
	
		for(int i=0; i < S.length(); i++) {
			char ch = S.charAt(i);		// charAt(index) :  index로 주어진 값에 해당하는 문자를 리턴. 존재하지 않는 index를 인자로 전달하면 공백이 출력
										// S = "apple"이라면, ch="a", ch="p", ch="p"... 이렇게 대입된다.
			arr_alphabet[ch - 'a']++;	// [] <- 자리에는 인덱스 번호가 와야 한다.
										// char 'a'는 숫자로 97. 알파벳 소문자는 아스키코드 97부터 시작하므로 97을 빼주는 것.
										// ch가 'b'일 때, arr_alphabet['b' - 'a'] = arr_alphabet[98 - 97] = arr_alphabet[1] 이다. 이 자리에 +1을 하며 개수를 세는 것.
		}
		
		
		// 3. 출력
		for(int i : arr_alphabet) {
            System.out.print(i + " ");
        }
		
		 sc.close();
	}

}
