import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int margin = C - B;
		if (margin == 0) {
			System.out.println(-1);
			return;
		}
		int N = (int) (Math.floor(A / margin) + 1);
		System.out.println(margin<0 ? -1 : N);
	}
}
