import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[] ws = new int[w+1];
		int[] hs = new int[h+1];
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int category = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (category == 1) {
				ws[idx] = 1;
			} else {
				hs[idx] = 1;
			}
		}
		int maxW = 0;
		int maxH = 0;
		int cnt = 0;
		for (int i=0; i<w+1; i++) {
			if (ws[i]==1 || i == w) {
				maxW = Math.max(maxW, cnt);
				cnt = 1;
			} else if (ws[i] == 0) {
				cnt++;
			}
		}
		cnt = 0;
		for (int i=0; i<h+1; i++) {
			if (hs[i]==1 || i == h) {
				maxH = Math.max(maxH, cnt);
				cnt = 1;
			} else if (hs[i] == 0) {
				cnt++;
			}
		}
		System.out.println(maxW*maxH);
	}
}
