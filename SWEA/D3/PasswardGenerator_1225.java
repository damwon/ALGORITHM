package com.ssafy.A_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 큐가 아니라 어레이에서 빼고 큐의 가장 첫번째 인덱스만 가리키도록 변수를 둔다.
// 어레이값을 그냥 바꿔주고 마지막 인덱스를 통해 배열을 정렬해준다.
// 8*5 40번의 횟수 이후로 다시 처음부터 반복된다 => 15로 나눈 나머지로 처음 시작해도 똑같다!(매우큰수의 경우의수에 유리)
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =10;
		for (int testCase=1; testCase<=T; testCase++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i=0; i<8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			int finish = 1;
			while(finish != 0) {
				for (int i=1; i<=5; i++) {
					finish = q.poll();
					finish -= i;
					if(finish <= 0) {
						finish = 0;
						q.offer(finish);
						break;
					}
					q.offer(finish);
				}
			}
			System.out.print("#" + testCase + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
		br.close();
	}
}
