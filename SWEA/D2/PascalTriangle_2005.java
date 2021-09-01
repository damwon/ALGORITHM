import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] triangle = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<=i; j++) {
					if (i>=2 && 0<j && j<N-1) {
						triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
					} else {
						triangle[i][j] = 1;
					}
				}
			}
			sb.append("#"+testCase+"\n");
			for (int i=0; i<N; i++) {
				for (int j=0; j<=i; j++) {
					sb.append(triangle[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
