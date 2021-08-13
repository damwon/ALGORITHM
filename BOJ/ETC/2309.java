import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int[] nonDwarf = new int[2];
	private static void makeCombination(int toSelect, int[] selected, int startIdx, int[] dwarfH, int sumH) {
		if(toSelect == 2) {
			if (sumH-selected[0]-selected[1] == 100) {
				nonDwarf[0] = selected[0];
				nonDwarf[1] = selected[1];
			}
			return;
		}
		for(int i=startIdx; i<dwarfH.length; i++) {
			selected[toSelect]=dwarfH[i];
			makeCombination(toSelect+1, selected, i+1, dwarfH, sumH);
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int [] dwarfH = new int[9];
		int sumH = 0;
		for (int i = 0; i < dwarfH.length; i++) {
			dwarfH[i] = sc.nextInt();
			sumH += dwarfH[i];
		}
		makeCombination(0, new int[2], 0, dwarfH, sumH);
		int [] dwarf = new int[7];
		int cnt=0;
		for (int i = 0; i < 9; i++) {
			if (dwarfH[i]==nonDwarf[0] || dwarfH[i]==nonDwarf[1]) {
				continue;
			}
			dwarf[cnt] = dwarfH[i];
			cnt++;
		}
		Arrays.sort(dwarf);
		String ans = "";
		for (int i = 0; i < dwarf.length; i++) {
			ans += dwarf[i] + "\n";
		}
		System.out.println(ans);
	}
}
