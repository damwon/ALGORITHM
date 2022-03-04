import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); 						// 두 배열을 이름순으로 정렬
        Arrays.sort(completion); 
        int i;
        for (i=0; i < completion.length; i++) {			// 정렬된 배열의 요소를 비교
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            } 
        }
        return participant[i];	//for문이 끝나면서 i가 participant배열의 가장 끝에 도달
    }							//완주하지 못한 주자가 가장 마지막 요소일때의 예외처리
}