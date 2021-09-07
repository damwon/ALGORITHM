import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st;
	    int[][] map;
	    int T = Integer.parseInt(br.readLine());
	    for (int testCase=1; testCase<=T; testCase++) {
	    	st = new StringTokenizer(br.readLine());
	    	int N = Integer.parseInt(st.nextToken());
	    	int K = Integer.parseInt(st.nextToken());
	    	map = new int[N][N];
	    	for (int i=0; i<N; i++) {
	    		String str = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = str.charAt(2*j) - '0';
				}
			}
	    	int ans = 0;
	    	for (int i=0; i<N; i++) {
		    	int cntR = 0;
		    	int cntC = 0;
				for (int j=0; j<N; j++) {
					if (map[i][j] == 1) { // 가로
						cntR++;
					} else {
						if (cntR == K) {
							ans++;
						}
						cntR = 0;
					}

					if (map[j][i] == 1) { // 세로
						cntC++;
					} else {
						if (cntC == K) {
							ans++;
						}
						cntC = 0;
					}
				}
				if (cntR == K) {
					ans++;
				}
				if (cntC == K) {
					ans++;
				}
			}
	    	sb.append("#"+testCase+" "+ans+"\n");
		}
	    System.out.println(sb);
	}
}
