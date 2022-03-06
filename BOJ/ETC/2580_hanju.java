import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class 스도쿠 {
   
   static List<Node> sudokus;
   static int[][] map;
   
   
   static class Node {
      int x, y;

      public Node(int x, int y) {
         super();
         this.x = x;
         this.y = y;
      }
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      sudokus = new ArrayList<>();
      map = new int[9][9];
      
      int num;
      for(int i = 0; i < 9; i++) {
         for(int j = 0; j < 9; j++) {
            num = sc.nextInt();
            if(num == 0) sudokus.add(new Node(i,j));
            map[i][j] = num;
         }
      } // 입력 완료
      
      dfs(0);
      
      
   } // end of main

   private static void dfs(int dep) {
      // TODO Auto-generated method stub
      if(dep == sudokus.size()) {
         for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
               System.out.print(map[i][j] + " ");
            }
            System.out.println();
         }
         
         System.exit(0);
      } else {
         for(int i = 1; i < 10; i++) {
            int x = sudokus.get(dep).x;
            int y = sudokus.get(dep).y;
            
            if(isRow(i, x) && isCol(i, y) && isOk(i, x, y)) {
               map[x][y] = i;
               dfs(dep + 1);
               map[x][y] = 0;
            }
            
         }
      }
      
      
      
   }

   // 3x3
   private static boolean isOk(int num, int row, int col) {
      int start_row = (row/3)*3;
      int start_col = (col/3)*3;
      
      for(int i = start_row ; i < start_row+3 ; i ++) {
         for(int j = start_col ; j < start_col +3 ; j++) {
            if(map[i][j] == num)
               return false;
         }
      }
      return true;
   }

   // 열기준
   private static boolean isCol(int num, int col) {
      for(int i = 0; i < 9; i++) {
         if(num == map[i][col]) {
            return false;
         }
      }
      
      return true;
   }

   // 행 기준 확인
   private static boolean isRow(int num, int row) {
      for(int i = 0; i < 9; i++) {
         if(num == map[row][i]) {
            return false;
         }
      }
      
      return true;
   }
} // end of class