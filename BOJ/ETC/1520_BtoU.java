import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Bottom Up
public class Main {
	private static int M,N;
	private static int[][] map, dp;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dp = new int[M][N]; // -1 초기화를 시켜주어야 0이 경로의 개수가 0인지 방문하지 않은것인지 구별할수있다.
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	private static int dfs(int x, int y) {
		
		if(x == M-1 && y == N-1) {
			return 1;
		}
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		
		dp[x][y] = 0; // 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화.
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx > M-1 || ny > N-1) {
				continue;
			}
			
			if (map[x][y] > map[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}

		return dp[x][y];
	}
}
