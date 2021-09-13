import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int numL = 0;
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == 'L') {
				numL++;
			}
		}
		if (numL != 0) {
			System.out.println(N - (numL/2 - 1));
		} else {
			System.out.println(N);
		}
	}
}
