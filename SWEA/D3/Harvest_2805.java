package com.ssafy.A_0804;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] farm;
		for (int testCase = 1; testCase<=T; testCase++) {
			int N = sc.nextInt();
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {	// farm 이중배열에 인풋값 저장
				String temp = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = temp.charAt(j)-'0';
				}
			}
			int sum = 0;
			for(int i=0; i<N; i++) {		// 합계구하는 이중포문
				for(int j=Math.abs(N/2-i); j<N-Math.abs(N/2-i); j++) {
					sum += farm[i][j];
				}
			}
			System.out.println("#"+testCase+" "+sum);
		}
	}
}
