import java.util.HashMap;

public class Hashing {

    public static void majoirity(int[] nums){
        int n=nums.length;
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }


        for(int i: map.keySet()){
           if(map.get(i) > (n/3)){
            System.out.println(i);
           }
        }

    }
    public static void main(String[] args) {
        int [] nums={1,2};
         majoirity(nums);
    }
}
