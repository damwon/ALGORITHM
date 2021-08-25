import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// delta를 사용하면 코드가 간결해지지만 실행시간은 더 오래걸린다.
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] deltas = {{0,1}, {1,0}, {1,-1}, {1,1}}; // 0: 가로, 1: 세로, 2: 왼쪽 대각선, 3: 오른쪽 대각선
		int T = Integer.parseInt(br.readLine());
		int N;
		char[][] map;
		for (int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			boolean omok = false;
			for (int i=0; i<N; i++) {
				String str = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			int cnt=0;
			int nx;
			int ny;
			for (int i=0; i<N; i++) {	// 가로 오목 판단
				for (int j=0; j<N; j++) {
					if (map[i][j] == 'o') {
						for (int d=0; d<4; d++) {
							cnt = 1;
							nx = i;
							ny = j;
							for (int k=1; k<5; k++) {
								nx += deltas[d][0];
								ny += deltas[d][1];
								if (nx<N && nx>=0 && ny>=0 && ny<N && map[nx][ny] == 'o') {
									cnt++;
								} else {
									cnt = 0;
									break;
								}
							}
							if (cnt==5) {
								omok = true;
								break;
							}
						}
					}
					if (cnt==5) {
						omok = true;
						break;
					}
				}
			}
			sb.append("#"+testCase+" ").append(omok ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}
}
