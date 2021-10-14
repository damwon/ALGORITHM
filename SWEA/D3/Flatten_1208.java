package com.ssafy.A_0803;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int[] col = new int[100];
		for (int testCase = 1; testCase <= T; testCase++) {
			int dump = sc.nextInt();
			int diff;
			int maxIdx=0;
			int minIdx=0;
			for (int i=0; i<col.length; i++) {
				col[i] = sc.nextInt();
			}
			for (int i = 0; i <= dump; i++) {
				int max = 0;
				int min = 101;
				if (i != 0) {
					col[maxIdx]--;
					col[minIdx]++;
				} 
				for (int j = 0; j < 100; j++) {
					if (max < col[j]) { 
						max = col[j];
						maxIdx = j; 
					} 
					if (min > col[j]) {
						min = col[j];
						minIdx = j; 
					} 
				} 
				diff = max - min;
				if (diff == 0 || diff == 1) {
					System.out.println("#"+testCase+" "+diff);
					break;
				}
				if (i == dump && diff !=0 && diff != 1) {
					System.out.println("#"+testCase+" "+diff);
				}
			}
		}
	}
}