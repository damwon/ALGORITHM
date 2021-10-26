import java.util.Arrays;

public class subset {
	static String[] cards = {"A","B","C","D"};
	static boolean[] result = new boolean[cards.length];
	
	public static void main(String[] args) {
		subset(0);
	}
	
	static void subset(int target) {
		if(target == cards.length) {
			System.out.print("[");
			for(int i=0; i<cards.length; i++) {
				if(result[i])
					System.out.print(cards[i]+" ");
			}
			System.out.println("]");
			
			return;
		}
		
		result[target] = true;
		subset(target+1); // 
		result[target] = false;
		subset(target+1);
	}
}
