import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int T = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=T; testCase++) {
			str = br.readLine();
			char cha = str.charAt(0);
			int cnt = 0;
			if (str.charAt(0) == '1') {
				cnt++;
			}
			for (int i=1; i<str.length(); i++) {
				if(str.charAt(i) != cha) {
					cnt++;
					cha = str.charAt(i);
				}
			}
			System.out.println("#"+testCase+" "+cnt);
		}
	}
}