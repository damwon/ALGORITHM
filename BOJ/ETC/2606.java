import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static boolean visit[];
	static int n, m;
	static int cnt = 0;
		
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			map[a][b] = map[b][a]= 1;
		}
		
		System.out.println(dfs(1));
	}
	
	public static int dfs(int i) {
		visit[i] = true;
		
		for(int j=1; j<=n; j++) {
			if(map[i][j] == 1 && visit[j] == false) {
				cnt ++;
				dfs(j);
			}
		}
		return cnt;
	}
}