//https://leetcode.com/problems/car-fleet/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        double[][] cars = new double[n][2];

       
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

     
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        Stack<Double> st = new Stack<>();

       
        for (int i = n - 1; i >= 0; i--) {
            double currTime = cars[i][1];

          
            if (st.isEmpty() || currTime > st.peek()) {
                st.push(currTime);
            }
           
        }

        return st.size();
    }
}
