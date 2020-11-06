package baekjoon.implement.q10809;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 알파벳 소문자로만 이루어진 단어 S
	 * 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를 출력 예 ) baekjoon -> b는 0번째에 등장한다.
	 * 포함되어 있지 않은 경우에는 -1을 출력
	 * - 첫째 줄에 단어 S가 주어진다.
	 * - 단어의 길이는 100을 넘지 않고, 소문자로만 이루어짐
	 * - 주의! 동일문자가 포함되어 있는 경우, 처음 나타난 위치로 나타내야 한다.
	 */

	public static void main(String[] args) {
		// 1. Scanner로 입력받는다.
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		
		// 2. a ~ z 까지 알파벳의 개수를 담을 배열 생성
		int[] arr_alphabet = new int[26];	// 알파벳 소문자 총 갯수는 26개, 자바에서 배열을 선언하면 자동으로 모든 요소의 값이 0으로 초기화 된다.
		Arrays.fill(arr_alphabet, -1);		// 배열을 특정한 값으로 모두 초기화 하는 메소드
	
		for(int i=0; i < S.length(); i++) {
			char ch = S.charAt(i);	// S = apple 일 경우, ch=a, ch=p, ch=p .. 이렇게 대입된다. a는 아스키코드로 97
			
			if( arr_alphabet[ch - 'a'] == -1 ) {
				arr_alphabet[ch - 'a'] = i;
			}
		}
		
		
		// 3. 출력
		for(int i : arr_alphabet) {
            System.out.print(i + " ");
        }
		
		 sc.close();
	}

}
