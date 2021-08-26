import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] input = str.split(" ");
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			if (N%2 == 1) {
				for (int i=0; i<N/2+1; i++) {
					q1.offer(input[i]);
				}
				for (int i=N/2+1; i<N; i++) {
					q2.offer(input[i]);
				}
			} else {
				for (int i=0; i<N/2; i++) {
					q1.offer(input[i]);
				}
				for (int i=N/2; i<N; i++) {
					q2.offer(input[i]);
				}
			}
			sb.append("#"+testCase+" ");
			for (int i=0; i<N; i+=2) {
				sb.append(q1.poll()+" ");
				if (!q2.isEmpty()) {
					sb.append(q2.poll()+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
