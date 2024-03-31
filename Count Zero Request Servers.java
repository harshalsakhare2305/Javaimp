class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        
        // Part 1
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int logStart = 0;
        int logEnd = 0;

        // Part 2
        int[][] queryIndex = new int[queries.length][2];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryIndex[i] = new int[] { queries[i], i };
        }
        Arrays.sort(queryIndex, (a, b) -> a[0] - b[0]);

        // Part 3
        int[] serverCountInWindow = new int[n + 1]; // servers [0(not used), 1, 2 ..... n]
        int uniqueServersInWindow = 0;

        for (int i = 0; i < queryIndex.length; i++) {
            int queryStart = queryIndex[i][0] - x;
            int queryEnd = queryIndex[i][0];

            // add window elements till current queryEnd 
            // OR until all logs have been added in window
            while (logEnd < logs.length && logs[logEnd][1] <= queryEnd) {
                serverCountInWindow[logs[logEnd][0]]++;
                if (serverCountInWindow[logs[logEnd][0]] == 1) // if count was 0 earlier then this is a new server in window
                    uniqueServersInWindow++;
                logEnd++;
            }

            // remove out of window elements before current queryStart 
            // OR until all logs have been removed from window
            while (logStart < logs.length && logs[logStart][1] < queryStart) {
                serverCountInWindow[logs[logStart][0]]--;
                if (serverCountInWindow[logs[logStart][0]] == 0)
                    uniqueServersInWindow--;
                logStart++;
            }
            ans[queryIndex[i][1]] = n - uniqueServersInWindow;
        }
        return ans;
    }

}
