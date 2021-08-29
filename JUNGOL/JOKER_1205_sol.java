import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main {
	static List<Integer> cards = new ArrayList<>();
	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 카드개수 N
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 숫자적힌 카드 0(조커)은 따로 받는다.
		int joker = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int maxNum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) {
				joker++;
			}else {
				cards.add(num);
				q.offer(num);
			}
			
			// 최대값 찾기
			if(maxNum < num) {
				maxNum = num;
			}
		}
		int jjoker = joker;
		
		if(q.size() == 0) {
			System.out.println(joker);
			return;
		}
		
		// 카드숫자 오름차순 정렬
		Collections.sort(cards);
		
		// numbers에 cards의 숫자들을 채운다. numbers는 1001000개 할당(1000000+1000)
		int numbers[] = new int[1001001];
		for (int i = 0; i < cards.size(); i++) {
			numbers[cards.get(i)] = cards.get(i);
		}
		
		// 0이면 비어있음
		int temp = 0;
		int len = 0;
		int maxLen = 0;
		for (int i = cards.get(0); i <= maxNum +jjoker; i++) {
			if(numbers[i] != 0) {
				len++;
				if(maxLen < len) maxLen = len;
			}
			
			//끊어져있다면
			if(numbers[i] == 0) {
				// 조커있는지 확인
				if(joker != 0) {
					// 조커있으면 메움
//					numbers[i] = -1;
					joker--;
					len++;
					if(maxLen < len) maxLen = len;
					
				// 조커없으면 ㄹㅇ끊어진거
				}else {
					// 조커 다시 복구
					joker = jjoker;
					// start point 변경
					if(!q.isEmpty()) temp = q.poll();
					i = temp -1;
					len = 0;
				}
			}
			
		} // end of for
		System.out.println(maxLen);
		
	}
}