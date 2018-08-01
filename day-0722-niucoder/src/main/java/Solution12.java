import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * @author Jan on 2018/7/31.
 * @version 1.0
 */
public class Solution {
    public String PrintMinNumber(int[] numbers) {
        int len = numbers.length;
        String[] strArray = new String[len];
        /*处理数据更加节省空间，追加不会在堆上开辟新的空间，
        且StringBuilder是异步处理高性能
        虽说有线程安全问题，但是此处并非多线程
        */
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < len; i++) {
            strArray[i] = String.valueOf(numbers[i]);

        }
        Arrays.sort(strArray, new Comparator<String>() {
            public int compare(String str1, String str2) {
                /*这样做说是为了字符串对齐好比较*/
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2);
            }
        });
        for (String s : strArray) {
            ret.append(s);
        }
        return ret.toString();
    }
}