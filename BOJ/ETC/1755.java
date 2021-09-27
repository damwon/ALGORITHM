import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
0 zero	10
1 o		5
2 two	9
3 three	8
4 four	3
5 five	2
6 six	7
7 seven	6
8 eight	1
9 nine	4
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dictionary = {10, 5, 9, 8, 3, 2, 7, 6, 1, 4};	// 메인클래스 상단 주석처리를 활용해 사전순으로 각 숫자를 인덱스로 하여 번호를 배열에 담음
		int[][] nums = new int[N-M+1][3];	// 0: 해당값, 1: 첫번째숫자값의 사전순 번호, 2: 두번째숫자값의 사전순 번호
		int[] orderedNums = new int[N-M+1];	// 사전순으로 정렬된 숫자를 담기위한 배열
		for (int i=M; i<=N; i++) {
			nums[i-M][0] = i;
			int sum = 0;
			String sNum = i + "";
			for (int j=0; j<sNum.length(); j++) {
				char cNum = sNum.charAt(j);
				if(j == 0) nums[i-M][1] = dictionary[cNum - '0'];
				sum += dictionary[cNum - '0'];
			}
			
			nums[i-M][2] = sum;
		}

		for (int i = 0; i < N-M+1; i++) {	
			int index = 0;
			for (int j = 0; j < N-M+1; j++) {	// 사전순으로 정렬하기위해 자신의 첫번째 숫자의 순서가 다른값보다 클때마다 index 1을더한다.
				if (nums[i][1] > nums[j][1]) {
					index++;
				} else if (nums[i][1] == nums[j][1] && nums[i][2] > nums[j][2]) {
					// 만약 첫번째 숫자의 순서가 같다면 두번째 숫자의 순서를 비교해 다른값보다 크면 index 1 을 더한다.
					index++;
				}
			}
			orderedNums[index] = nums[i][0]; // 해당 인덱스에 본래 입력받은 숫자를 저장한다.
		}

		for (int i = 0; i<orderedNums.length; i++) {	// 한줄에 10개씩 출력하기위한 for문
			sb.append(orderedNums[i] + " ");
			if ((i+1)%10 == 0) {	// 10으로 나눈 나머지가 0, 즉 10번째 숫자라면 개행한다.
				sb.append("\n");
			}
		}
		
		System.out.print(sb);	// 스트링빌더 출력
	}
}