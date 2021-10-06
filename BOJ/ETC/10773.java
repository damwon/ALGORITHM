import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		for (int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				sum -= list.get(list.size()-1);
				list.remove(list.size()-1);
			} else {
				list.add(num);
				sum += num;
			}
		}
		System.out.println(sum);
	}
}
