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
		int[] temperature = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		for (int i=0; i<K; i++) {
			sum += temperature[i];
		}
		
		int max=sum;
		for (int i=0; i<N-K; i++) {
			sum -= temperature[i];
			sum += temperature[i+K];
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
/*		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		
		int max= Integer.MIN_VALUE;
		for (int i=0; i<N-K+1; i++) {
			int sum=0;
			for (int j=0; j<K; j++) {
				sum += temperature[i+j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);*/
	}
}
