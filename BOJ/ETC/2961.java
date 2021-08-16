import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int[][] twoTaste;
	static long diffMin = Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		twoTaste = new int[T][2];
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			twoTaste[i][0] = Integer.parseInt(st.nextToken());
			twoTaste[i][1] = Integer.parseInt(st.nextToken());
		}
		subSet(0,1,0,0);
		System.out.println(diffMin);
	}
	private static void subSet(int cnt,int sour,int bitter,int idx) {
		if(cnt==T) {
			if(diffMin>Math.abs(sour-bitter) && idx!=0) {
				diffMin=Math.abs(sour-bitter);
			}
			return;
		}
		subSet(cnt+1, sour*twoTaste[cnt][0], bitter+twoTaste[cnt][1], idx+1);
		subSet(cnt+1, sour, bitter, idx);
	}
}