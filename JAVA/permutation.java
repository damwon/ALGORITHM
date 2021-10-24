import java.util.Arrays;

// 순열
public class permutation {
	static int N=4, R=3;
	static String[] cards = {"A","B","C","D"};
	static String[] result = new String[R];
	static boolean[] used = new boolean[N];
	
	public static void main(String[] args) {
		perm(0);
	}
	
	static void perm(int target) {
		if(target==R) { // target을 하나씩 맡은 애들이 R칸을 채웠다는 거임.(0부터니까)
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(used[i]) continue;
			
			result[target] = cards[i];
			used[i] = true;
			perm(target+1);
			used[i] = false;
		}
	}
}


