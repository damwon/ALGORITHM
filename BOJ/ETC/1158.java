import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q= new LinkedList<>();
		for (int i=1; i<N+1; i++) {
			q.add(i);
		}
		int a;
		while(!q.isEmpty()) {
			for (int i=1; i<K; i++) {
				a=q.poll();
				q.add(a);
			}
			sb.append(q.poll()+", ");
		}
		sb.setLength(sb.length() - 2);
		System.out.println("<"+sb+">");
	}
}
