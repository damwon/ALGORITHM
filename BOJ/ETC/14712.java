import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [][]map;
    static int N, M;
    static int ans;
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N + 1][M + 1];

        dfs(0);
        System.out.println(ans);
    }
    static void dfs(int cnt) {
        if(cnt == N * M) {
            ans ++;
            return ;
        }
        int y = cnt / M + 1;
        int x = cnt % M + 1;

        if(map[y - 1][x] == 1 && map[y][x - 1] == 1 && map[y - 1][x - 1] == 1) {
            dfs(cnt + 1);
        }
        else {
            dfs(cnt + 1);
            map[y][x] = 1;
            dfs(cnt + 1);
            map[y][x] = 0;
        }
    }
}