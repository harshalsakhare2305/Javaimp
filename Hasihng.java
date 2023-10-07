import java.util.HashSet;
import java.util.Iterator;



public class Hasihng {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        
        set.add(5);
        set.add(9);
        set.add(8);
        set.add(7);
        set.add(8);
        System.out.println(set);

        // if(set.contains(9)){
        //     System.out.println("set Constains 9 ");
        // }
        // if(!set.contains(15))
        //   System.out.println("does not contain 15");


        
        //   System.out.println(set.size());

         


          Iterator value =set.iterator();

          while(it.hasNext()){
           System.out.print( it.next()+" ");
          }

          



    }
}
