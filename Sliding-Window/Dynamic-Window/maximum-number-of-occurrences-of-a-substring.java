//https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

/* 
Key observation for this problem

A famous optimization is:

You only need to check substrings of length minSize.

Why?

If a longer substring of length k > minSize occurs x times, then its prefix of length minSize also occurs at least x times.

Therefore the maximum frequency answer is always obtainable from substrings of length minSize.
 */
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        HashMap<String,Integer> count = new HashMap<>();
        HashMap<Character,Integer> freq = new HashMap<>();

        int left = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if(right - left + 1 > minSize) {
                char remove = s.charAt(left++);
                freq.put(remove, freq.get(remove) - 1);

                if(freq.get(remove) == 0)
                    freq.remove(remove);
            }

            if(right - left + 1 == minSize &&
               freq.size() <= maxLetters) {

                String sub = s.substring(left, right + 1);

                int c = count.getOrDefault(sub, 0) + 1;
                count.put(sub, c);

                ans = Math.max(ans, c);
            }
        }

        return ans;
    }
}
