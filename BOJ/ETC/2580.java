import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static int[][] map = new int[9][9];
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		sudoku(0, 0);
	}
 
	private static void sudoku(int r, int c) {
		if (c == 9) {
			sudoku(r + 1, 0);
			return;
		}

		if (r == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			return;
		}

		if (map[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (validity(r, c, i)) {
					map[r][c] = i;
					sudoku(r, c + 1);
				}
			}
			map[r][c] = 0;
			return;
		}
		sudoku(r, c + 1);
	}
 
	private static boolean validity(int r, int c, int value) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == value) return false;
		}

		for (int i = 0; i < 9; i++) {
			if (map[i][c] == value) return false;
		}

		int r3 = (r / 3) * 3;
		int c3 = (c / 3) * 3;
		for (int i = r3; i < r3 + 3; i++) {
			for (int j = c3; j < c3 + 3; j++) {
				if (map[i][j] == value) return false;
			}
		}
		return true;
	}
}