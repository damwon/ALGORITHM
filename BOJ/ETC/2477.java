import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 아이디어: 변들의 곱을 차례대로 배열에 담은 후
//   		 가장 큰 넓이와 인덱스가 3번째 차이나는 넓이가 빼줘야 하는 넓이다. 
public class KMelonField_2477 {
	// 배열을 사용한 풀이법
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		int[] area = new int[6];
		int[] length = new int[6];
		
		for (int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			length[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxArea = 0;
		int tempArea = 0;
		int maxAreaIdx = 0;
		for (int i=0; i<6; i++) {
			maxArea = Math.max(maxArea, length[(i+6)%6]*length[(i+1)%6]);
			area[i] = length[(i+6)%6]*length[(i+1)%6];
			if (tempArea != maxArea) {
				maxAreaIdx = i;
				tempArea = maxArea;
			}
		}
		System.out.println(K*(maxArea - area[(maxAreaIdx+3)%6]));
	}
	// ArrayList를 사용한 풀이법
/*	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> area = new ArrayList<Integer>();
		int[] length = new int[6];
		
		for (int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			length[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxArea = 0;
		for (int i=0; i<6; i++) {
			if (i == 5) {
				maxArea = Math.max(maxArea, length[i]*length[0]);
				area.add(length[i]*length[0]);
				break;
			}
			maxArea = Math.max(maxArea, length[i]*length[i+1]);
			area.add(length[i]*length[i+1]);
		}

		int maxAreaIdx = area.indexOf(maxArea);
		int subArea;
		if (maxAreaIdx < 3) {
			subArea = area.get(maxAreaIdx+3);
		} else {
			subArea = area.get(maxAreaIdx-3);
		}
		
		System.out.println(K*(maxArea - subArea));
	}*/
}
