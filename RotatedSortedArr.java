public class RotatedSortedArr {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 1, 2, 3, 4 };
        int n = arr.length;
        int si = 0;
        int ei = n - 1;
        int ans = -1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] > arr[n - 1]) {// mid lie in first sorted array ie. {5,6,7,8}
              
            si = mid + 1;     //chnaging the position of the si 

            } else if (arr[mid] < arr[n - 1]) {// mid lie in second sorted array{1,2,3,4}
                ans = mid; // may be mid is our minimum element
                ei = mid - 1;    //changing the position of the ei 
            } else {

                System.out.println("the element doesnot exist");
            }
        }
        System.out.println("the minimum element found at index  " + ans + " is " + arr[ans]);
    }
}
