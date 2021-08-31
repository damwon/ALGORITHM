import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] deltas = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for (int i=0; i<N; i++) {
				String str = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = str.charAt(2*j);
				}
			}
			
			int max = 0;
			int temp = 0;
			int nx = 0;
			int ny = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					temp = 0;
					if (map[i][j] == 'W') {
						for (int d=0; d<8; d++) {
							nx = i + deltas[d][0];
							ny = j + deltas[d][1];
							if (nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] == 'W') {
								temp++;
							}
						}
						max = Math.max(max, temp);
					}
				}
			}
			max = max == 0 ? 1 : max;
			sb.append("#"+testCase+" "+max+"\n");
		}
		System.out.print(sb);
	}
}
