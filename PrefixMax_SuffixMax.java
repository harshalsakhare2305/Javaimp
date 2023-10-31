public class Prefixmax {
    public static int[] prefixMaxArray(int[]height){
          int n =height.length;
       int prefixmax =Integer.MIN_VALUE;
       int [] prefix =new int[n];
       for(int i=0;i<n;i++){
        if(height[i]>=prefixmax){
            prefix[i]=height[i];
            prefixmax=height[i];
        }else{
            prefix[i]=prefixmax;
        }
       }

       return prefix;
    }

     public static int[] SuffixMaxArray(int[]height){
          int n =height.length;
       int suffixmax =Integer.MIN_VALUE;
       int [] suffix =new int[n];
       for(int i=n-1;i>=0;i--){
        if(height[i]>=suffixmax){
            suffix[i]=height[i];
            suffixmax=height[i];
        }else{
            suffix[i]=suffixmax;
        }
       }

       return suffix;
    }
    public static void main(String[] args) {
        int[] height ={0,1,0,2,1,0,1,3,2,1,2,1};
        int n =height.length;
        int [] prefix =prefixMaxArray(height);
        int [] suffix =SuffixMaxArray(height);
       
    

       for(int i=0;i<n;i++){
        System.out.print(prefix[i] +" ");
       }
   System.out.println();
       for(int i=0;i<n;i++){
        System.out.print(suffix[i] +" ");
       }

       
}
}
