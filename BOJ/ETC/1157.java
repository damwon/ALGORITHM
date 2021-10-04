import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] voca = br.readLine().toUpperCase().toCharArray();
		
		int[] cnt = new int[26];
		int[] cntDup = new int[26];
		for (int i=0; i<voca.length; i++) {
			cnt[voca[i] - 65]++;
			cntDup[voca[i] - 65]++;
		}
		
		Arrays.sort(cnt);
	    int max = cnt[cnt.length-1];    // 배열내 최댓값 구함
	    int maxCnt = 0;
	    String answer = "";
	    for (int i=0; i<cnt.length; i++){ // 문제 조건에 맞게 answer에 저장
	        if( max == cntDup[i]) {
	            maxCnt++;
	            answer += (char)(i+65);
	        }
	    }

	    if(maxCnt != 1) {
	        answer = "?";
	    }
	    System.out.print(answer);
	}
}
