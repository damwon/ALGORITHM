import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Top Down
public class Main {
	private static int M,N;
	private static int[][] map, dp;
	private static boolean[][] visit;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visit = new boolean[M][N];
		dp = new int[M][N];
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[M-1][N-1] = 1;
		dfs(0,0);
		
		System.out.println(dp[0][0]);
	}
	
	private static void dfs(int i, int j) {
		if(i==M-1 && j==N-1) {
			return;
		}
		
		if(visit[i][j]) {
			return;
		}
		
		visit[i][j] = true;
		
		for(int k=0; k<4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(nx >=0 && nx <M && ny >=0 && ny <N && map[i][j] > map[nx][ny]) {
				if(dp[nx][ny] != 0) {
					dp[i][j] += dp[nx][ny];
					continue;
				}else {
					dfs(nx,ny);
					dp[i][j] += dp[nx][ny];
				}
			}
		}
	}
}
