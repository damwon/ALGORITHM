import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] ch;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());	// 암호 길이
		C = Integer.parseInt(st.nextToken());	// 문자 개수
		visited = new boolean[C];

		st = new StringTokenizer(br.readLine());
		ch = new char[st.countTokens()];		// 문자 개수만큼 배열 선언
		for (int i=0; st.countTokens()>0; i++) {	// token이 없을때까지 문자 저장
			ch[i] = st.nextToken().charAt(0);
		}
		//ch = br.readLine().replace(" ", "").toCharArray();	//toCahrArray로 한번에 배열에 저장하는 방법
		
		Arrays.sort(ch);	// 사전순 정렬
		/** 순열 */
		permutation(0, 0, "");
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
	
	/** L개짜리 순열 */
	private static void permutation(int depth, int start, String pw) {
		if(depth == L) {
			// 조건검사 -> 조건만족하면 출력
			if(validation(pw)) {
				sb.append(pw).append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permutation(depth + 1, i + 1, pw + ch[i]);
				visited[i] = false;
			}
		}
	}

	
	private static boolean validation (String pw) {	// 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
		int consonant = 0;
		int vowel = 0;
		for (int i=0; i<pw.length(); i++) {
			if(pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o' || pw.charAt(i) == 'u')
				vowel++;
			else
				consonant++;
		}
		return vowel >= 1 ? (consonant >= 2 ? true : false) : false;
	}
}
