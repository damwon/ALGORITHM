import java.util.Arrays;

// 조합 : 4개중에 2개를 반드시 뽑으며 순서는 상관없음.
public class combination {
	static int N=4, R=3;
	static String[] cards = {"A","B","C","D"};
	static boolean[] result = new boolean[cards.length];
	
	public static void main(String[] args) {
		comb(0, 0);
	}
	
	static void comb(int target, int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			System.out.print("[");
			for(int i=0; i<cards.length; i++) {
				if(result[i])
					System.out.print(cards[i]+" ");
			}
			System.out.println("]");
			return;
		}
		
		if(target == N)
			return;
		
		result[target] = true;
		comb(target+1,cnt+1);
		result[target] = false;
		comb(target+1,cnt);
	}
}
