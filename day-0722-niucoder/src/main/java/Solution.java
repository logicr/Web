import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Jan on 2018/7/22.
 * @version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            char [] strArray = scanner.next().toCharArray();
//            StringBuilder biu = new StringBuilder();
//            Set<Character> set = new HashSet<Character>();
//            for (int i = 0; i < strArray.length; i++) {
////                char c = strArray[i];
//                if (set.add(strArray[i])){
//                    biu.append(strArray[i]);
//                }
//            }
//            System.out.println(biu.toString());
            strcon(strArray);

        }
    }
    public static void strcon (char [] strArray){
        int[] collection = new int[256];
        StringBuilder retStr = new StringBuilder();
//        System.out.println(collection[10]);
        for (int i = 0 ; i < strArray.length ; i++){
//            System.out.println(strArray[i]);
            collection[strArray[i]]++;
            if (1 == collection[strArray[i]]){
//                System.out.println(strArray[i]);
                retStr.append(strArray[i]);
            }
        }
        System.out.println(retStr.toString());

    }
}

