import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String str;
        
        for (int testCase=1; testCase<=T; testCase++) {
            LinkedList<Integer> cardS = new LinkedList<Integer>();
            LinkedList<Integer> cardD = new LinkedList<Integer>();
            LinkedList<Integer> cardH = new LinkedList<Integer>();
            LinkedList<Integer> cardC = new LinkedList<Integer>();
            str = br.readLine();
            boolean isError = false;
            int[] ans = new int[4];
            for (int i=0; i<str.length(); i+=3) {
				char pattern = str.charAt(i);
				int num;
				if (str.charAt(i+1) == '0') {
					num = str.charAt(i+2) - '0';
				} else {
					String subString = str.substring(i+1, i+3);
					num = Integer.parseInt(subString);
				}
				switch (pattern) {
					case 'S' : 
						if (cardS.contains(num)) {
							isError = true;
							break;
						}
						cardS.offer(num);
						break;
					case 'D' :
						if (cardD.contains(num)) {
							isError = true;
							break;
						}
						cardD.offer(num);
						break;
					case 'H' :
						if (cardH.contains(num)) {
							isError = true;
							break;
						}
						cardH.offer(num);
						break;
					case 'C' :
						if (cardC.contains(num)) {
							isError = true;
							break;
						}
						cardC.offer(num);
						break;
					
				}
				
				ans[0] = 13 - cardS.size();
				ans[1] = 13 - cardD.size();
				ans[2] = 13 - cardH.size();
				ans[3] = 13 - cardC.size();
				
				if (isError) {
					break;
				} 
			}
			if (isError) {
				sb.append("#"+testCase+" "+"ERROR"+"\n");
			} else {
				sb.append("#"+testCase+" ");
				for (int j=0; j<4; j++) {
					sb.append(ans[j]+" ");
				}
				sb.append("\n");
			}
		}
        System.out.print(sb);
	}
}