import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for (int i=97; i<=122; i++) {
			sb.append(str.indexOf((char)i)+" ");
		}
		System.out.print(sb);
	}
}
