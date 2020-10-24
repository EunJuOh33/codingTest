package programmers.lv_2.skilltree;

public class Solution {
	/*
	 * < 프로그래머스 Lvel2 스킬트리 >
	 * 
	 * 선행 스킬 : 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬
	 * 선행 스킬 순서가 a -> b -> c 일 때, c를 배우려면 먼저 b를 배워야 하고, b를 배우려면 먼저 a을 배워야 한다.
	 * 위 순서가 없는 다른 스킬은 순서에 상관없이 배울 수 있다.
	 * 선행 스킬 순서 skill, 유저들이 만든 스킬트리를 담은 배열 skill_trees가 매개변수
	 * 가능한 스킬트리 개수를 return 하라.
	 * 
	 * - 스킬은 알파벳 대문자로 표기, 모든 문자열은 알파벳 대문자. skill 길이는 1이상 26이하
	 * - 스킬순서, 스킬트리는 문자열 표기
	 * - skill_trees는 길이 1이상 20 이하 배열
	 * - skill_trees는 스킬이 중복해 주어지지 않는다.
	 */
	
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // 1. skill_trees의 길이만큼 for문을 돌려준다.
        for(int i=0; i < skill_trees.length; i++){
            boolean flag = true;
            String[] skills = skill_trees[i].split("");		// skill_trees[i]의 String을 하나씩 잘라서 skills 배열 안에 넣는다. 예) {B, A, C, D, E}
            int cnt = 0;

            // 2. 유저가 만든 스킬트리 하나의 길이(skills.length)만큼 for문을 돌린다.  
            for(int j=0; j < skills.length; j++) {
            	
            	// 3. skills에 skill에 해당하는 문자가 있을 경우 cnt++ 하지만, 순서가 바뀌어 있는 경우 flag를 false로 만들어 answer++ 되지 못하도록 한다.
                if(cnt < skill.indexOf(skills[j])) {		// indexOf(문자열) => 특정 문자열의 인덱스 값을 리턴, 찾는 문자열이 없을 때는 -1 리턴하는 점을 이용한 것.
                											// 예) skill.indexOf(skills[0]) = skill.indexOf(B) => 1 라면 if문이 실행되어 flag = fals가 되고 break
                    flag = false;
                    break;
                    
                } else if(cnt == skill.indexOf(skills[j])) {	// {C, B, D, F}일 때, skill.indexOf(C) => 0 으로 cnt와 같은데, 이 때 cnt++를 해준다.
                												// 따지고보면 둘의 값이 같은 경우는 0 == 0, 1 == 1 이렇게 순서대로 커진다. 
                    cnt++;
                }
            }

            if(flag){
                answer++;
                
            }	// 2번 for문 끝
            
        }	// 1번 for문 끝
        
        return answer;
    }
	

	
	
	/* 테스트 - 실행 */
	public static void main(String[] args) {
		String skill1 = "CBD";
		String[] skill_trees1 = {"BACDE", "CBADF", "AECB", "BDA", "AFE"};	// 3
		
		Solution sol = new Solution();
		
		System.out.println(sol.solution(skill1, skill_trees1));
	}

}
