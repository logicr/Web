import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shopkeeper = scanner.next();
        String customer = scanner.next();
        Integer cusNum = customer.length();
        Integer shNum = shopkeeper.length();
        Integer [] shopNum = new Integer[256];
        for (int i = 0; i < shopNum.length; i++) {
            shopNum[i] = 0;

        }
//        System.out.println(shopNum.length);
//        System.out.println(shopkeeper.charAt(1));
        for (int i = 0; i < shopkeeper.length(); i++){
//            System.out.println(shopkeeper.charAt(i));
            shopNum[shopkeeper.charAt(i)]++;
        }
        for (int i = 0; i < customer.length(); i++) {
           if(shopNum[customer.charAt(i)] !=0){
               cusNum--;
               shopNum[customer.charAt(i)]--;
           }
            if(0 == cusNum){
                System.out.print("Yes "+(shNum-cusNum));
                return;
            }
        }
        System.out.print("No "+(cusNum));
    }
}
