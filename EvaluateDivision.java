import java.util.*;
//https://leetcode.com/problems/evaluate-division/description/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] val, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        int it = 0;

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            if (!map.containsKey(u)) {
                map.put(u, it++);
            }
            if (!map.containsKey(v)) {
                map.put(v, it++);
            }
        }

        int V = map.size();
        double[][] logDis = new double[V][V];
        double max = Double.POSITIVE_INFINITY;

        for (int i = 0; i < V; i++) {
            Arrays.fill(logDis[i], max);
            logDis[i][i] = 0.0;
        }

        for (int i = 0; i < equations.size(); i++) {
            int u = map.get(equations.get(i).get(0));
            int v = map.get(equations.get(i).get(1));
            double wt = val[i];
            logDis[u][v] = Math.log(wt); //To avoid the discripency of small values like 1e-05 etc .which you will get in 27 th test case
            logDis[v][u] = Math.log(1.0 / wt);
        }

        // Floyd-Warshall Algorithm on logDis
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (logDis[i][k] != max && logDis[k][j] != max) {
                        logDis[i][j] = Math.min(logDis[i][j], logDis[i][k] + logDis[k][j]);
                    }
                }
            }
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            if (map.containsKey(queries.get(i).get(0)) && map.containsKey(queries.get(i).get(1))) {
                int u = map.get(queries.get(i).get(0));
                int v = map.get(queries.get(i).get(1));
                ans[i] = (logDis[u][v] == max) ? -1.0 : Math.exp(logDis[u][v]);
            } else {
                ans[i] = -1.0;
            }
        }

        return ans;
    }
}
