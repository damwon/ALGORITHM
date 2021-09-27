import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int N,cnt,max;
	private static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		String str = br.readLine();
		for (int i=0; i<N; i++) {
			nums[i] = str.charAt(i*2) - '0';
		}
		cnt = 1;
		max = 1;
		for(int i=0;i<N-1;i++) {
			if(nums[i]<=nums[i+1]) {
				cnt++;
			} else { 
				cnt = 1;
			} 
			max = Math.max(max, cnt);
		}
		cnt = 1;
		for(int i=0;i<N-1;i++) {
			if(nums[i]>=nums[i+1]) {
				cnt++;
			} else { 
				cnt = 1;
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}
}
