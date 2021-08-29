import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);		// 완전탐색을 위한 오름차순 정렬
		
		int zero = 0;
		for (int c : card) {	// 0의 개수세기
			if (c==0) {
				zero += 1;
			}
		}
		int zeroCopy = zero;	// 0의 개수 초기화를 위한 copy

		int startIdx = 0;
		int tempN = 0;
		for (int i=0; i<N; i++) {	// start포인트 초기화 및 일시적인 수를 저장하기위한 반복문
			if (card[i]!=0) {
				startIdx = i;
				tempN = card[i];
				break;
			}
		}
		if (card[startIdx] == 0) {	// start포인트가 0이라는것은 입력에 0밖에없다는 뜻으로 0의 개수 출력
			System.out.print(zero);
			return;
		}
		
		int maxL = 0;		// maxL 0으로 초기화
		int tempL = 1;		// start포인트가 길이 1이므로 1로 초기화
		for (int i=startIdx+1; i<N; i++) {	// start포인트 다음부터 완전 탐색 시작
			if (tempN+1 == card[i]) {		// start포인트값 + 1 과 다음 인덱스의 값이 같을 때 Length와 Number 1 증가
				if (i == N-1 || startIdx == N-1) {	// 만약 마지막 요소거나 마지막요소가 스타트포인트라면 일시적인 Length에 zero+1 만큼 더해주고 maxL와 비교
					tempL += zero+1;				// 현재 요소의 길이도 더해주어야 하므로 +1
					maxL = Math.max(maxL, tempL);
					break;
				}
				tempL += 1;
				tempN += 1;
				continue;
			} else if (tempN == card[i]) {	// 이전 요소와 값이 동일하면 pass
				continue;
			} else if (zero > 0) {			// 0의 개수가 남아있다면 0의 개수를 1 줄이고 tempL과 tempN에 1을 더해준다
				if (zeroCopy == zero) {		// 0의 개수를 처음 -1 하는 조건(0의 개수가 초기 0의 개수와 같을 때)이라면 startIdx를 바꾸어준다.
					startIdx = i;
				}
				if (i == N-1 || startIdx == N-1) { // 만약 마지막 요소거나 마지막요소가 스타트포인트라면 일시적인 Length에 zero+1 만큼 더해주고 maxL와 비교
					tempL += zero;
					maxL = Math.max(maxL, tempL);
					break;
				}
				zero -= 1;
				tempL += 1;
				tempN += 1;
				i--;						// 이어지지않는 곳을 0으로 초기화했기때문에 다시 기존 요소값과 비교하기위해 i--;
				continue;
			} else {						// 숫자가 이어지지도않고 zero카운트가 0이라면
				if (zeroCopy == zero) {		// 초기 0의 개수가 0이라면 startIdx를 바꾸어준다.
					startIdx = i;
				}
				if (i == N-1 || startIdx == N-1) {	// 만약 마지막 요소거나 마지막요소가 스타트포인트라면 일시적인 Length에 zero+1 만큼 더해주고 maxL와 비교
					tempL += zero;
					maxL = Math.max(maxL, tempL);
					break;
				}
				maxL = Math.max(maxL, tempL);	// maxL과 tempL을 비교 
				zero = zeroCopy;				// 0개수 초기화
				tempN = card[startIdx];			// tempN을 바뀐 start값으로 저장
				tempL = 1;						// tempL 1로 초기화
				i = startIdx;					// start포인트로 돌아가 다시 for문 완전탐색
			}
		}
		System.out.println(maxL);
	}
}
