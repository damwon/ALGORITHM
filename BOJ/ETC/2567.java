import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] paper = new int[101][101];
		int N = Integer.parseInt(br.readLine());
		
		for (int p=0; p<N; p++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i=x; i<x+10; i++) {
				for (int j=y; j<y+10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		
		int length = 0;
		for (int i=1; i<101; i++) {
			for (int j=1; j<101; j++) {
				if (paper[i][j] == 1) {
					if (paper[i-1][j] == 0) {
						length++;
					}
					if (paper[i+1][j] == 0) {
						length++;
					}
					if (paper[i][j-1] == 0) {
						length++;
					}
					if (paper[i][j+1] == 0) {
						length++;
					}
				}
			}
		}
		System.out.print(length);
	}
}
