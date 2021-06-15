import java.util.ArrayList;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");
        s.intern();
        String s2 = "ab";
        System.out.println(s == s2);
//        ArrayList<String> arrayList = new ArrayList<String>();
//        arrayList.add("Volvo");
//        arrayList.add("BMW");
//        Iterator<String> iterator = arrayList.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            System.out.println(next);
//        }
    }
}
