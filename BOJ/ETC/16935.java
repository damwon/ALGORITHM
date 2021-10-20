package com.ssafy.hwalgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] arr;
	static int[][] shiftedArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<R; i++) {
			int cmd = Integer.parseInt(st.nextToken()); 
			switch (cmd) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				R90Rotate();
				break;
			case 4:
				L90Rotate();
				break;
			case 5:
				operation5();
				break;
			case 6:
				operation6();
				break;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" "); 
			}
			System.out.println();
		}
	}
	
	private static void upDown() {
		shiftedArr = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				shiftedArr[N-i-1][j] = arr[i][j];
			}
		}
		arr = shiftedArr;
		
	}
	
	private static void leftRight() {
		shiftedArr = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				shiftedArr[i][M-j-1] = arr[i][j];
			}
		}
		arr = shiftedArr;
	}
	
	private static void R90Rotate() {
		shiftedArr = new int[M][N];
		int cnt =N-1;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				shiftedArr[j][cnt] = arr[i][j];
			}
			cnt--;
		}
		int temp = N;
		N = M;
		M = temp;
		arr = shiftedArr;
	}
	
	private static void L90Rotate() {
		shiftedArr = new int[M][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				shiftedArr[M-j-1][i] = arr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		arr = shiftedArr;
	}
	
	private static void operation5() {
		shiftedArr = new int[N][M];
		int N_mid = N/2;
		int M_mid = M/2;
		for(int i=0;i<N_mid;i++) {
			for(int j=0;j<M_mid;j++) {
				shiftedArr[i][M_mid+j] = arr[i][j];
			}
		}
		for(int i=0;i<N_mid;i++) {
			for(int j=M_mid;j<M;j++) {
				shiftedArr[N_mid+i][j] = arr[i][j];
			}
		}
		for(int i=N_mid;i<N;i++) {
			int C = 0;
			for(int j=M_mid;j<M;j++,C++) {
				shiftedArr[i][C] = arr[i][j];
			} 
		}
		int Row = 0;
		for(int i=N_mid;i<N;i++, Row++) {
			for(int j=0;j<M_mid;j++) {
				shiftedArr[Row][j] = arr[i][j]; 
			}
		}
		arr = shiftedArr;
	}
	
	private static void operation6() {
		shiftedArr = new int[N][M];
		int N_mid = N/2;
		int M_mid = M/2;
		for(int i=0;i<N_mid;i++) {
			for(int j=0;j<M_mid;j++) {
				shiftedArr[N_mid+i][j] = arr[i][j];
			}
		}
		for(int i=N_mid;i<N;i++) {
			for(int j=0;j<M_mid;j++) {
				shiftedArr[i][M_mid+j] = arr[i][j];
			}
		}
		int Row = 0;
		for(int i=N_mid;i<N;i++,Row++) {
			for(int j=M_mid;j<M;j++) {
				shiftedArr[Row][j] = arr[i][j];
			}
		}
		for(int i=0;i<N_mid;i++) {
			int C = 0;
			for(int j=M_mid;j<M;j++,C++) {
				shiftedArr[i][C] = arr[i][j];
			}
		}
		arr = shiftedArr;
	}
}
