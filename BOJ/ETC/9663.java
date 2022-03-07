import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static int[] col; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		NQueen(0);
		System.out.println(ans);
	}

	private static void NQueen(int row) {
		if(!validity(row)) return;
		
        if(row == N) { 
			ans++;
			return;
		}
        
		for(int i=1; i<=N; i++) {
			col[row+1] = i;
			NQueen(row+1);
		}
	}

	private static boolean validity(int row) {
		for(int i=1; i< row; i++) {
			if(col[row] == col[i] || Math.abs(col[row]-col[i]) == row-i) return false;
		}
		return true;
	}
}