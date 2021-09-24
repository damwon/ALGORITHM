import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] F = new int[7];	// 여학생
		int[] M = new int[7];	// 남학생
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int sYear = Integer.parseInt(st.nextToken());
			if (gender == 0) {
				F[sYear] += 1;
			} else {
				M[sYear] += 1;
			}
		}
		
		int room = 0;
		for (int i=1; i<7; i++) {
			if (F[i] > 0 && F[i] <= K) {
				room += 1;
			} else if (F[i] == 0){
			} else {
				room += F[i]/K;
				room = F[i]%K == 0 ? room : room +1;
			}
			if (M[i] > 0 && M[i] <= K) {
				room += 1;
			} else if (M[i] == 0) {
			} else {
				room += M[i]/K;
				room = M[i]%K == 0 ? room : room +1;
			}
		}
		
		System.out.println(room);
	}
}
