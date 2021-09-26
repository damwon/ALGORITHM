public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		boolean[] self = new boolean[10100];	// d(i) 결과값이 10000을 넘길수있으므로 여유있게 선언
		for (int i=1; i<=10000; i++) {
			self[d(i)] = true;
		}
		
		for (int i=1; i<=10000; i++) {
			if (!self[i]) {
				sb.append(i+"\n");
			}
		}
		System.out.print(sb);
	}
	
	private static int d(int n) {
		int num = n;
		int add = 0;
		for (int i=0; i<String.valueOf(n).length(); i++) {
			add += num%10;
			num = (int) Math.floor(num/10);
		}
		return n + add;
	}
}
