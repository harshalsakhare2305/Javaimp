//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            } 
            else if (ch == ')') {
                curr.reverse();
                curr = stack.pop().append(curr);
            } 
            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}
