
//https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/
class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for (int num : nums) {
            int curr = num;

            while (!st.isEmpty() && gcd(st.peek(), curr) > 1) {
                curr = lcm(st.pop(), curr);
            }

            st.push(curr);
        }

        return new ArrayList<>(st);
    }
}
