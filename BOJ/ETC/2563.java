import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] cp=new int[100][100];
		int ans=0;
		for(int c=0; c<N; c++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			for(int i=X; i<X+10; i++) {
				for(int j=Y; j<Y+10; j++) {
					if(cp[i][j]==0) {
						cp[i][j]=1;
						ans++;
					}
				}
			}
			
		}
		System.out.println(ans);
	}
}