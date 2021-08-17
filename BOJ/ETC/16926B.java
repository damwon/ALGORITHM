import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// deltas 풀이
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] nums = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = Math.min(N, M)/2;
		for (int i=0; i<R; i++) {
			for (int j=0; j<cnt; j++) {
				int temp = nums[j][j];
				int x = j;
				int y = j;
				int dir = 0;
				while (dir < 4) {
					int dx = x + deltas[dir][0];
					int dy = y + deltas[dir][1];
					if (dx>=j && dy>=j && dx<N-j && dy<M-j) {
						nums[x][y] = nums[dx][dy];
						x = dx;
						y = dy;
					} else {
						dir++;
					}
				}
				nums[j+1][j] = temp;
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}
}