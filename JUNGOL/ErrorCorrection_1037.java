import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		for (int i=0; i<n; i++) {			// map이중배열에 숫자저장
			String str = br.readLine();
			for (int j=0; j<n; j++) {
				map[i][j] = str.charAt(2*j) - '0';
			}
		}
		
		int[] row = new int[n];
		int[] col = new int[n];
		for (int i=0; i<n; i++) {			// row,col 배열에 각 줄 합 저장
			for (int j=0; j<n; j++) {
				row[i] += map[i][j];
				col[i] += map[j][i]; 
			}
		}
		
		int cntR = 0;
		int cntC = 0;
		int errorRow = -1;
		int errorCol = -1;
		for (int i=0; i<n; i++) {
			if (row[i]%2 != 0) {	// row합이 홀수일때 cntR 1증가 및 에러 row 저장
				cntR++;
				errorRow = i;
			}
			if (col[i]%2 != 0) {	// col합이 홀수일때 cntC 1증가 및 에러 col 저장
				cntC++;
				errorCol = i;
			}
		}
		
		if (cntR == 0 && cntC == 0) {		// 각줄의 합이 모두 짝수일때는 OK 출력
			System.out.print("OK");
		} else if (!(cntR == 1 && cntC == 1)) {	// 각각 하나씩 에러가 있지 않다면 Corrupt 출력
			System.out.print("Corrupt");
		} else {							// 저장한 error 좌표를 출력
			System.out.print("Change bit "+"("+(errorRow+1)+","+(errorCol+1)+")");
		}
	}
}
// 1번의 bit change로 에러를 고칠수 있는 경우는 row,col이 각각 한개의 에러만 있는경우이다. 