import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
			int cnt = 0;
			for (int i=0; i<N; i++) {	// 가로 오목 판단
				for (int j=0; j<N-4; j++) {
					if (map[i][j] == 'o') {
						cnt++;
						for (int k=1; k<5; k++) {
							if (map[i][j+k] == 'o') {
								cnt++;
							} else {
								cnt = 0;
								break;
							}
						}
					}
					if (cnt==5) {
						omok = true;
						break;
					}
				}
				if (cnt==5) {
					break;
				}
			}
			
			if (omok) {
				sb.append("#"+testCase+" "+"YES"+"\n");
				continue;
			}
			
			cnt = 0;
			for (int i=0; i<N; i++) {	// 세로 오목 판단
				for (int j=0; j<N-4; j++) {
					if (map[j][i] == 'o') {
						cnt++;
						for (int k=1; k<5; k++) {
							if (map[j+k][i] == 'o') {
								cnt++;
							} else {
								cnt = 0;
								break;
							}
						}
					}
					if (cnt==5) {
						omok = true;
						break;
					}
				}
				if (cnt==5) {
					break;
				}
			}
			
			if (omok) {
				sb.append("#"+testCase+" "+"YES"+"\n");
				continue;
			}
			
			cnt = 0;
			for (int i=0; i<N-4; i++) {	// 왼쪽 대각선 판단
				for (int j=4; j<N; j++) {
					if (map[i][j] == 'o') {
						cnt++;
						for (int k=1; k<5; k++) {
							if (map[i+k][j-k] == 'o') {
								cnt++;
							} else {
								cnt = 0;
								break;
							}
						}
					}
					if (cnt==5) {
						omok = true;
						break;
					}
				}
				if (cnt==5) {
					break;
				}
			}
			
			if (omok) {
				sb.append("#"+testCase+" "+"YES"+"\n");
				continue;
			}
			
			cnt = 0;
			for (int i=0; i<N-4; i++) {	// 오른쪽 대각선 판단
				for (int j=0; j<N-4; j++) {
					if (map[i][j] == 'o') {
						cnt++;
						for (int k=1; k<5; k++) {
							if (map[i+k][j+k] == 'o') {
								cnt++;
							} else {
								cnt = 0;
								break;
							}
						}
					}
					if (cnt==5) {
						omok = true;
						break;
					}
				}
				if (cnt==5) {
					break;
				}
			}
			sb.append("#"+testCase+" ").append(omok ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}
}
