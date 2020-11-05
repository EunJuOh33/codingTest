package baekjoon.sort.q10825;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	/*
	 * 국어점수가 감소하는 순서(내림차순) -> 영어 점수가 증가하는 순서(오름차순) -> 수학점수가 감소하는 순서(내림차순)
	 * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서 (대문자가 먼저, 소문자 그 다음)
	 * 첫째줄에 반 학생 수, 둘째 줄부터 학생 이름과 국영수 점수가 주어진다.
	 */
	
	public static void main(String[] args) {
		
		// 1. 스캐너를 통해 입력받은 이름과 점수를 저장
        Scanner sc = new Scanner(System.in);
 
        int N = sc.nextInt();				// 반 학생 수
        
    	String[][] arr = new String[N][4];	// 기억!!! 이름과 점수 모두 저장하기 위해서 String 배열 사용
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
            arr[i][2] = sc.next();
            arr[i][3] = sc.next();
        }  
        
        
        // 2. 정렬
        // arr를 특정한 기준에 따라 정렬하기 위해 Comparator 사용
        // Comparator<String[]> 인터페이스를 생성과 동시에 구현
        Arrays.sort(arr, new Comparator<String[]>() {	
        	
        	@Override
            public int compare(String[] o1, String[] o2) {
        		// 매개변수는 String[] o1 = {Junkyu, 50, 60, 100}   String[] o2 = {Junkyu, 50, 60, 100} 와 같이 각각의 1차원 배열로 들어온다.
        		// compare(T o1, T o2) 의 기본 원리
            	//  - o1 < o2   : 음수 리턴
            	//  - o1 == o2  : 0 리턴
            	//  - o1 > o2   : 양수 리턴
            	// 즉, compare가 '반환하는 값에 따라 정렬'된다. (기본 오름차순)
        		
        		if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {	// pareInt함수는 Integer클래스의 static 함수. 숫자형의 문자열을 인자값으로 받으면 해당 값을 10진수의 Integer형으로 반환
	        			if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
		        				if (Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
		        						// (1) 국영수 점수가 모두 같다면 이름 사전순으로 오름차순
		                            	return o1[0].compareTo(o2[0]);	
		                            	// compareTo메소드 : A.compareTo(B) 
		                            	// A = B : 0 반환, A > B : 양수 반환, A < B : 음수 반환 
		                        }
		        				// (2) 국어 점수와 영어 점수가 같을 때, 수학점수로 내림차순
		        				return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));	// 내림차순 정렬은 간단하다. o1과 o1의 순서를 바꾸면 된다.
	        			}
	        			// (3) 국어 점수만 같을 때, 영어 점수로 오름차순
	        			return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
        		}
        		// (4) 국어점수는 내림차순 
        		return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
        	}
        	
        });	// sort 끝
        
        
        // 3. 출력
        for (int i=0; i < N; i++) {
            System.out.println(arr[i][0]);
        }
        
        sc.close();
        
	}	// main 끝

}
