import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase=1; testCase<=T; testCase++) {
			String str = br.readLine();
			String subString1, subString2, subString3, subString4, subString5;
			for (int i=1; i<=10; i++) {
				if (i == 1) {
					subString1 = str.substring(0,1);
					for (int j=1; j<10; j++) {
						if (!subString1.equals(str.substring(j,j+1))) {
							break;
						} else if (j==9 && subString1.equals(str.substring(9,10))) {
							sb.append("#"+testCase+" "+i+"\n");
						} else {
							continue;
						}
					}
				} else if (i == 2 || i == 3) {
					subString1 = str.substring(0, i);
					subString2 = str.substring(i, 2*i);
					subString3 = str.substring(2*i, 3*i);
					subString4 = str.substring(3*i, 4*i);
					subString5 = str.substring(4*i, 5*i);
					if (subString1.equals(subString2) && subString2.equals(subString3)
						&& 	subString3.equals(subString4) && subString4.equals(subString5)
						) {
						sb.append("#"+testCase+" "+i+"\n");
						break;
					}
				} else {
					subString1 = str.substring(0, i);
					subString2 = str.substring(i, 2*i);
					subString3 = str.substring(2*i, 3*i);
					if (subString1.equals(subString2) && subString2.equals(subString3)) {
						sb.append("#"+testCase+" "+i+"\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}