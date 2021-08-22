import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] price = new int[n];
			for (int i=0; i<n; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			long max = price[n-1];
			long sum = 0;
			for (int i=n-1; i>-1; i--) {
				if (price[i] > max) {
					max = price[i];
				} else if (price[i] < max){
					sum += (max - price[i]);
				}
			}
			System.out.println("#"+testCase+" "+sum);
		}
	}
}
