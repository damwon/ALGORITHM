import java.util.Arrays;
import java.util.Scanner;
 
import javax.print.attribute.standard.PrinterLocation;
 
class Solution {
    private static char[][] game(char[][] field, String cmd, int H, int W) {
        if (cmd.length() == 0) {
            return field;
        }
        char c = cmd.charAt(0);
        cmd = cmd.substring(1);
        switch (c) {
        case 'U': if (H-1>=0 && field[H-1][W] == '.') {
                    field[H-1][W] = '^';
                    field[H][W] = '.';
                    H -= 1;
                  } else {
                      field[H][W] = '^';
                  }
                  return game(field, cmd, H, W);
        case 'D': if (H+1<field.length && field[H+1][W] == '.') {
                    field[H+1][W] = 'v';
                    field[H][W] = '.';
                    H += 1;
                  } else {
                      field[H][W] = 'v';
                  }
                  return game(field, cmd, H, W);
        case 'L': if (W-1>=0 &&field[H][W-1] == '.') {
                    field[H][W-1] = '<';
                    field[H][W] = '.';
                    W -= 1;
                  } else {
                      field[H][W] = '<';
                  }
                  return game(field, cmd, H, W);
        case 'R': if (W+1<field[H].length &&field[H][W+1] == '.') {
                    field[H][W+1] = '>';
                    field[H][W] = '.';
                    W += 1;
                  } else {
                      field[H][W] = '>';
                  }
                  return game(field, cmd, H, W);
        case 'S': if (field[H][W] == '^') {
                    for (int i = 1; H-i>=0; i++) {
                        if (field[H-i][W] == '#') break;
                        if (field[H-i][W] == '*') {
                            field[H-i][W] = '.';
                            break;
                        }
                    }
                    return game(field, cmd, H, W);
                  } else if (field[H][W] == 'v') {
                    for (int i = 1; H+i<field.length; i++) {
                        if (field[H+i][W] == '#') break;
                        if (field[H+i][W] == '*') {
                            field[H+i][W] = '.';
                            break;
                        }
                    }
                    return game(field, cmd, H, W);
                  } else if (field[H][W] == '<') {
                    for (int i = 1; W-i>=0; i++) {
                        if (field[H][W-i] == '#') break;
                        if (field[H][W-i] == '*') {
                            field[H][W-i] = '.';
                            break;
                        }
                    }
                    return game(field, cmd, H, W);
                  } else if (field[H][W] == '>') {
                    for (int i = 1; W+i<field[H].length; i++) {
                        if (field[H][W+i] == '#') break;
                        if (field[H][W+i] == '*') {
                            field[H][W+i] = '.';
                            break;
                        }
                    }
                    return game(field, cmd, H, W);
                  }
                  return game(field, cmd, H, W);
        default: System.out.println("Invalid Value");
                 break;
        }
        return game(field, cmd, H, W);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();   // testCase
        for (int testCase = 1; testCase<=T; testCase++) {
            int H = sc.nextInt();   // 높이
            int W = sc.nextInt();   // 너비
            char[][] field = new char[H][W];
            int tankH = 0;  //탱크 위치
            int tankW = 0;
            for (int i = 0; i < H; i++) {                // field배열에 인풋값 채우기
                String tempStr = sc.next();
                for (int j = 0; j < W; j++) {
                    field[i][j] = tempStr.charAt(j);
                    if (tempStr.charAt(j) == '^' ||
                            tempStr.charAt(j) == 'v' ||
                            tempStr.charAt(j) == '<' ||
                            tempStr.charAt(j) == '>') {      // 탱크 위치 및 방향 찾기
                        tankH = i;
                        tankW = j;
                    }
                }
            }
            int cmdNum = sc.nextInt();
            String cmd = sc.next();
             
            field = game(field, cmd, tankH, tankW);
            System.out.print("#"+testCase+" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }
}