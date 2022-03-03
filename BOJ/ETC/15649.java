import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		result = new int[9];
		used = new boolean[9];
		dfs(0,N,M);
		System.out.println(sb);
	}
	
  private static void dfs(int idx, int n, int m) {
      
      if(idx == m) {
          for(int num : result) {
              if(num != 0) sb.append(num + " ");
          }
          sb.append("\n");
          return;
      }

      for (int i = 1; i <= n; i++) {
          if(used[i]) continue;
          used[i] = true;
          result[idx] = i;
          dfs(idx + 1, n, m);
          used[i] = false;
      }
  }
}
