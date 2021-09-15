import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		cal(p, q, w, h, t);
		System.out.print(sb);
	}
	
	private static void cal(int p, int q, int w, int h, int t) {
		p = (p+t)%(2*w);
		q = (q+t)%(2*h);
		
		if(p>w) {
			p = 2*w - p;
		}
		if(q>h) {
			q = 2*h - q;
		}
		sb.append(p+" "+q);
	}
}
