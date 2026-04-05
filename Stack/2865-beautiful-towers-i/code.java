//https://leetcode.com/problems/beautiful-towers-i/
class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;

        int[] pse = new int[n]; // previous smaller
        int[] nse = new int[n]; // next smaller

        Stack<Integer> st = new Stack<>();

        // 🔹 Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // 🔹 Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        // 🔥 Treat each index as peak
        for (int j = 0; j < n; j++) {

            long sum =0;

            // 🔹 LEFT SIDE (jump via PSE)
            int curr = j;
            while (pse[curr] != -1) {
                int prev = pse[curr];
                sum += (long) (curr - prev) * heights[curr];
                curr = prev;
            }
            sum += (long) (curr + 1) * heights[curr];

            // 🔹 RIGHT SIDE (jump via NSE)
            curr = j;
            while (nse[curr] != n) {
                int next = nse[curr];
                sum += (long) (next - curr) * heights[curr];
                curr = next;
            }
            sum += (long) (n - curr) * heights[curr];

            // remove double counted peak
            sum -= heights[j];

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
