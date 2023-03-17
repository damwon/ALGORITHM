import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[101][101];
		
		for (int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int a=y1; a<y2; a++) {
				for (int b=x1; b<x2; b++) {
					arr[a][b] = 1;
				}
			}
		}
		
		int cnt = 0;
		for (int i=0; i<101; i++) {
			for (int j=0; j<101; j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		

		System.out.print(cnt);
	}
}
