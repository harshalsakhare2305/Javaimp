
// nums=[1,2,1,3,4,3,4]
//output=2
//1^2^1^3^4^3^4=2
class Solution {
    public int singleNumber(int[] nums) {
        // we do collective XOR of all the numbers in array then finally we get that same single integer

        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }

        return xor;
    }
}
