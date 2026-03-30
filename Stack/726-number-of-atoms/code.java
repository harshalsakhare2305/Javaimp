
//https://leetcode.com/problems/number-of-atoms/
import java.util.*;

class Solution {

    public String countOfAtoms(String formula) {

        Stack<Integer> valStack = new Stack<>();
        Stack<String> keyStack = new Stack<>();
        TreeMap<String, Integer> mp = new TreeMap<>();

        int i = 0, n = formula.length();

        while (i < n) {
            char ch = formula.charAt(i);

            // ✅ Element start
            if (Character.isUpperCase(ch)) {
                StringBuilder element = new StringBuilder();
                element.append(ch);
                i++;

                // take lowercase letters
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i));
                    i++;
                }

                keyStack.push(element.toString());

                // parse number
                int num = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }

                if (num == 0) num = 1;
                valStack.push(num);
            }

            // ✅ Opening bracket
            else if (ch == '(') {
                keyStack.push("(");
                i++;
            }

            // ✅ Closing bracket
            else if (ch == ')') {
                i++;

                int num = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (num == 0) num = 1;

                keyStack.push(")");
                valStack.push(num);
            }
        }

        // ✅ Process stacks from right to left
        Stack<Integer> multiplierStack = new Stack<>();
        int multiplier = 1;

        while (!keyStack.isEmpty()) {
            String top = keyStack.pop();

            if (top.equals(")")) {
                int val = valStack.pop();
                multiplier *= val;
                multiplierStack.push(val);
            } 
            else if (top.equals("(")) {
                multiplier /= multiplierStack.pop();
            } 
            else {
                int val = valStack.pop();
                int total = val * multiplier;
                mp.put(top, mp.getOrDefault(top, 0) + total);
            }
        }

        // ✅ Build result
        StringBuilder ans = new StringBuilder();
        for (String key : mp.keySet()) {
            ans.append(key);
            if (mp.get(key) > 1) {
                ans.append(mp.get(key));
            }
        }

        return ans.toString();
    }
}
