import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, max;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb=new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=N/2; i<=N; i++) {
			check(i);
		}
		
		sb.append(max+"\n");
		for(int i : result) {
			sb.append(i+" ");
		}
		System.out.print(sb);
		sc.close();
	}
	private static void check(int i) {
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(N);
		
		int now = N;
		int pre = i;
		
		while (true) {
			if (now<0) {
				break;
			}
			int temp = now;
			if (pre >= 0) {
				a.add(pre);
			}
			
			now = pre;
			pre = temp - now;
		}
		if(max<a.size()) {
			max = a.size();
			result = a;
		}
	}
}
