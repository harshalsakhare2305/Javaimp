//https://leetcode.com/problems/sliding-window-median/
import java.util.*;

class Pair {
    int ele;
    int idx;

    Pair(int ele, int idx) {
        this.ele = ele;
        this.idx = idx;
    }

    // CHANGE:
    // No equals() / hashCode() needed because TreeSet uses
    // the comparator to identify elements.
}

class Solution {

    TreeSet<Pair> left = new TreeSet<>((a, b) -> {
        if (a.ele != b.ele)
            return Integer.compare(b.ele, a.ele); // Max Set
        return Integer.compare(b.idx, a.idx);

        // CHANGE:
        // Index is used as a tie-breaker so duplicate values
        // can coexist inside TreeSet.
    });

    TreeSet<Pair> right = new TreeSet<>((a, b) -> {
        if (a.ele != b.ele)
            return Integer.compare(a.ele, b.ele); // Min Set
        return Integer.compare(a.idx, b.idx);

        // CHANGE:
        // Index is used as a tie-breaker so duplicate values
        // are treated as different elements.
    });

    // CHANGE:
    // Extracted balancing logic into a separate method.
    // In your code balancing logic was written directly
    // inside the sliding-window loop.
    private void rebalance() {

        // Maintain:
        // left.size() == right.size()
        // OR
        // left.size() == right.size() + 1

        while (left.size() > right.size() + 1) {
            Pair p = left.first();
            left.remove(p);
            right.add(p);
        }

        while (left.size() < right.size()) {
            Pair p = right.first();
            right.remove(p);
            left.add(p);
        }
    }

    // CHANGE:
    // Created a dedicated insertion method.
    // Your code was manually deciding where to insert
    // inside the main loop.
    private void add(Pair p) {

        if (left.isEmpty() || p.ele <= left.first().ele) {
            left.add(p);
        } else {
            right.add(p);
        }

        rebalance();
    }

    // CHANGE:
    // Created a dedicated deletion method.
    // Your code was manually checking contains()
    // and removing inside the main loop.
    private void remove(Pair p) {

        if (left.contains(p)) {
            left.remove(p);
        } else {
            right.remove(p);
        }

        // CHANGE:
        // Rebalance immediately after deletion.
        // In your code balancing happened only after insertion.
        rebalance();
    }

    private double getMedian(int k) {

        if ((k & 1) == 1) {
            return (double) left.first().ele;
        }

        // CHANGE:
        // Cast to long before addition to avoid overflow.
        //
        // Your code:
        // (left.first().ele + right.first().ele)
        //
        // could overflow for large integers.
        long a = left.first().ele;
        long b = right.first().ele;

        return (a + b) / 2.0;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        double[] ans = new double[n - k + 1];

        // CHANGE:
        // Instead of putting all elements in right set and then
        // moving some elements to left, directly insert through
        // add() which automatically balances the sets.
        for (int i = 0; i < k; i++) {
            add(new Pair(nums[i], i));
        }

        ans[0] = getMedian(k);

        int idx = 1;

        for (int i = k; i < n; i++) {

            // CHANGE:
            // Remove outgoing element.
            // Your code used separate l and r pointers.
            // Here current outgoing index is (i-k).
            remove(new Pair(nums[i - k], i - k));

            // CHANGE:
            // Insert incoming element.
            add(new Pair(nums[i], i));

            ans[idx++] = getMedian(k);
        }

        return ans;
    }
}
