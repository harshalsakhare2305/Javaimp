import java.util.Scanner;

public class BinarySearch {
    public static int main(String[] args) {
        int[] arr ={1,5,9,12,15,18};
        int n=arr.length;
        int si=arr[0];
        int ei=arr[n-1];
        
        Scanner sc =new Scanner(System.in);
        int target =sc.nextInt();

        while(si<=ei){
            int mid =si+(ei-si)/2;
            if(target >arr[mid]){
               si =mid +1;

            }else if(target<arr[mid]){
                ei=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
