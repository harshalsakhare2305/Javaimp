//https://leetcode.com/problems/swim-in-rising-water/description/
class DisjointSet {
    private int[] size;
    private int[] parent;

    public DisjointSet(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];

        Arrays.fill(size, 1); // to take care of 1-based indexing as well

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int u) {
        if (u == parent[u])
            return u;
        return parent[u] = findParent(parent[u]);
    }

    public void unionBySize(int u, int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);

        if (up_u == up_v)
            return;

        if (size[up_u] > size[up_v]) {
            parent[up_v] = up_u;
            size[up_u] += size[up_v];
        } else {
            parent[up_u] = up_v;
            size[up_v] += size[up_u];
        }
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = grid.length;

        if (n == 1)
            return 0;

        DisjointSet ds = new DisjointSet(n * n);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map.put(grid[i][j], new int[]{i, j});

        int time = 0;

        while (ds.findParent(0) != ds.findParent(n * n - 1)) {
            int[] node = map.get(time);
            int x = node[0];
            int y = node[1];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nrow = x + dx[i];
                int ncol = y + dy[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && grid[nrow][ncol] <= time)
                    ds.unionBySize(nrow * n + ncol, x * n + y);
            }

            time++;
        }

        return time - 1;
    }
}
