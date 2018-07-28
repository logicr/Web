import java.util.*;
public class Solution6 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            StringBuilder tmp = new StringBuilder();
            char [] strchar = str.toCharArray();
            for(int i = 0; i < strchar.length; i++){
                if(strchar[i] < '0' || strchar[i] > '9'){
                    tmp.append('c');
                }else{
                    tmp.append(strchar[i]);
                }
            }
            String[] ret = tmp.toString().split("c");
            int length = 0;
            int index = 0 ;
            for (int i = 0 ;i < ret.length; i++){
                if(ret[i].length() > length){
                    length =ret[i].length() ;
                    index = i;
                }
            }
            System.out.println(ret[index]);
        }
    }
} 