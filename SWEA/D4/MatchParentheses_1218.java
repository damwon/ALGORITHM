import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
 
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =10;
        for (int testCase=1; testCase<=T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stk = new Stack<Character>();
            for (int i=0; i<N; i++) {
                char bracket = str.charAt(i);
                if (!stk.isEmpty() && stk.peek() == '(' && bracket == ')') {
                    stk.pop();
                } else if (!stk.isEmpty() && stk.peek() == '[' && bracket == ']') {
                    stk.pop();
                } else if (!stk.isEmpty() && stk.peek() == '{' && bracket == '}') {
                    stk.pop();
                } else if (!stk.isEmpty() && stk.peek() == '<' && bracket == '>') {
                    stk.pop();
                } else {
                    stk.push(bracket);
                }
            }
            int ans;
            if (stk.isEmpty()) {
                ans = 1;
            } else {
                ans = 0;
            }
            System.out.println("#" + testCase + " " + ans);
        }
        br.close();
    }
}