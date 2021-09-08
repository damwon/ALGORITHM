import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int map[][];
	static int c,r,k;
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int cnt=1;
	   
    public static void main(String[] args) throws IOException {
	    st = new StringTokenizer(br.readLine());
	    c = Integer.parseInt(st.nextToken());
	    r = Integer.parseInt(st.nextToken());
	    map = new int[r][c];
	    
	    k = Integer.parseInt(br.readLine());
	    if(r*c<k) {
	    	sb.append(0);
	    	System.out.print(sb);
	    	return;
	    }
	    
	    int cnt=1;
	    int x = r-1;
		int y = 0;
		int dir= 0;
		while(cnt != k) {
			map[x][y]=cnt;
			int nx = x+deltas[dir][0];
			int ny = y+deltas[dir][1];
			
			if(nx<0 || ny<0 || nx>=r || ny>=c || map[nx][ny] !=0) {
				dir++;
				dir %= 4;
				nx = x+deltas[dir][0];
				ny = y+deltas[dir][1];
			}
			x=nx;
			y=ny;
			
			cnt++;
	    }
		sb.append((y+1)+ " "+(r-x));
		System.out.print(sb);
   }
}
