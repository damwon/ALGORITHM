import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int[][] cp=new int[1001][1001];
		int[] visibleCp = new int[101];
		for(int c=1; c<=N; c++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			for(int i=A; i<A+X; i++) {
				for(int j=B; j<B+Y; j++) {
					cp[i][j]= c;
				}
			}
		}
		for (int j=0; j<1001; j++) {
			for (int k=0; k<1001; k++) {
				if (cp[j][k] != 0)  {
					visibleCp[cp[j][k]] += 1;
				}
			}
		}
		for (int c=1; c<=N; c++) {
			sb.append(visibleCp[c]+"\n");
		}
		System.out.println(sb);
	}
}
