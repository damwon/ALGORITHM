import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			int[] nums = new int[10];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<10; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(nums);
			float sum = 0;
			for (int i=1; i<9; i++) {
				sum += nums[i];
			}
			sb.append("#"+testCase+" "+Math.round(sum/8)+"\n");
		}
		
		System.out.println(sb);
	}
}
