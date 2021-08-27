import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			char[][] words = new char[5][];
			int maxLength = 0;
			for (int i=0; i<5; i++) {
				String str = br.readLine();
				words[i] = new char[str.length()];
				words[i] = str.toCharArray();
				
				maxLength = Math.max(maxLength, words[i].length);
			}

			sb.append("#"+testCase+" ");
			for (int i = 0; i <maxLength; i++) {
				for (int j=0; j<5; j++) {
					if (i < words[j].length) {
						sb.append(words[j][i]);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
