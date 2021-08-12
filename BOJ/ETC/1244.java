import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) + 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sw = new int[N];
		for (int i=1; i<N; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		int studentCnt = Integer.parseInt(br.readLine());
		int gender, num;
		for (int i=0; i<studentCnt; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st1.nextToken());
			num = Integer.parseInt(st1.nextToken());
			if(gender == 1) {
				for (int j=num; j<N; j+=num) {
					sw[j] ^=1;
				}
			}
			if(gender == 2) {
				int LP = num-1;
				int RP = num+1;
				while(true) {
					if (LP < 0 || RP >= N) {
						break;
					} else if(sw[LP] != sw[RP]) {
						break;
					}
					LP--;
					RP++;
				}
				LP++;
				RP--;
				while(LP<=RP) {
					sw[LP] ^=1;
					LP++;
				}
			}
		}
		for (int i = 1; i < N; i++) {
			System.out.print(sw[i] + " ");
			if (i%20 == 0) {
				System.out.println();
			}
		}
	}
}
