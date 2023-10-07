import java.util.HashSet;

public class Union {

    public static void union1(int [] arr1 ,int[] arr2 ){
        HashSet<Integer> set =new HashSet<>();

        int count1=0;// common elements
        int count2=0;

        int n1=arr1.length;
        int n2=arr2.length;

        for(int i=0;i<n1;i++){
            set.add(arr1[i]);
        }

          for(int i=0;i<n2;i++){
          if(set.contains(arr2[i])){
                count1++;
                set.remove(arr2[i]);
          }else{
            count2++;
          }

          }
    System.out.println(count1);
    } 
    public static void main(String[] args) {
        int[] arr1 ={1,5,9,3,6,4};
        int[] arr2 ={2,6,9,5,4,1,5,9};
        union1(arr1, arr2);
    }
}
