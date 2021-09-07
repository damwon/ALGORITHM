import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for (int i = 0; i<N-M+1; i++) {
				for (int j = 0; j<N-M+1; j++) {
					int sum = 0;
					for (int q = 0; q < M; q++) {
						for (int k = 0; k < M; k++) {
							sum += map[i+q][j+k];
						}

					}
					if (max<sum) {
						max = sum;
					}
				}
			}
			sb.append("#"+testCase+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
