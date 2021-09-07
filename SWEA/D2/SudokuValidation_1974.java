import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            int[][] board = new int[9][9];
             
            for (int i = 0; i < 9; i++) {
            	str = br.readLine();
                for (int j = 0; j < 9; j++) {
                    board[i][j] = str.charAt(2*j)-'0';
                }
            }
             
            // solve
            boolean isOkay = true;
             
            // 세로 확인
            for (int i = 0; i < 9; i++) {
                int[] check = new int[10];
                 
                for (int j = 0; j < 9; j++) {
                    check[board[i][j]] = 1;
                }
                 
                for (int j = 1; j <= 9; j++) {
                    if (check[j] != 1) {
                        isOkay = false;
                        break;
                    }
                }
            }
             
            if (!isOkay) {
                sb.append("#" + tc + " " + 0 + "\n");
                continue;
            }
             
            // 가로 확인
            for (int j = 0; j < 9; j++) {
                int[] check = new int[10];
                 
                for (int i = 0; i < 9; i++) {
                    check[board[i][j]] = 1;
                }
                 
                for (int i = 1; i <= 9; i++) {
                    if (check[i] != 1) {
                        isOkay = false;
                        break;
                    }
                }
            }
 
            if (!isOkay) {
            	sb.append("#" + tc + " " + 0 + "\n");
                continue;
            }
             
            // 3 x 3 체크
            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    int[] check = new int[10];
                     
                    for (int w = i; w < i + 3; w++) {
                        for (int h = j; h < j + 3; h++) {
                            check[board[w][h]] = 1;
                        }
                    }
                     
                    for (int k = 1; k <= 9; k++) {
                        if (check[k] != 1) {
                            isOkay = false;
                            break;
                        }
                    }
                }
            }
             
            if (!isOkay) {
            	sb.append("#" + tc + " " + 0 + "\n");
                continue;
            }
            else {
            	sb.append("#" + tc + " " + 1 + "\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}