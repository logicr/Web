import java.util.Arrays;

/**
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,
 * 3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过
 * 数组长度的一半，因此输出2。如果不存在则输出0。
 * @author Jan on 2018/7/30.
 * @version 1.0
 */
public class Solution11 {
    public static void main(String[] args) {
        int[] array = {5,6,5,6};

        // write code here
        int len = 0;
        Arrays.sort(array);
        /*若存在，那么数一定在数组长度的一半处，只需要判断一半处是不是即可*/
        int ret = array[(array.length )/ 2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[i + 1]) {
                len++;
                if (ret == array.length/2){
                    len++;
                }
            }
        }
        if (len <= array.length / 2) {
            ret = 0;
        }
        return ret;
    }
}
