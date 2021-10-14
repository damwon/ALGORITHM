package com.ssafy.A_0803;

import java.util.Arrays;
import java.util.Scanner;
//재귀로 풀기
public class Solution {
	private static int dump(int num, int[] arr) {
	    //종료 조건1: 덤프 횟수 끝나면 최대 높이와 최소높이 차이 return
	    //종료 조건2: 덤프 횟수 이내에 평탄화가 완료되면 더이상 덤프 수행x
	    Arrays.sort(arr);
	    if(num == 0|| arr[arr.length-1]-arr[0]<=1) 
	        return arr[arr.length-1]-arr[0]; 
	    arr[arr.length-1]-=1;    //가장 높은 곳 -1
	    arr[0]+=1;                //가장 낮은 곳 +1
	    Arrays.sort(arr);
	    //System.out.println(num+" Min: "+arr[0]+" MAX: "+arr[arr.length-1]);
	    return dump(num-1, arr);//dump횟수 -1하고 다시 부르기
	}

	public static void main(String[] args) {    
	    Scanner sc = new Scanner(System.in);
	    int dump_n;
	    int[] arr;
	    StringBuilder sb = new StringBuilder();
	    //입력부
	    for(int i = 0; i <10; i++) {
	        dump_n = sc.nextInt();
	        arr = new int[100];
	        for(int j = 0; j < 100; j++) {
	            arr[j] = sc.nextInt();
	        }
	        sb.append("#"+(i+1)+" "+dump(dump_n, arr)+"\n");
	    }
	    
	    //출력부
	    System.out.println(sb);
	}
}
