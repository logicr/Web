package club.logicr.quickSort;

/**
 * @author Jan
 * 快速排序，找基准数，将小于和大于他的分别放到他两边，再将两边重复此步骤
 */
public class QuickSort {
    static  int times = 1;
    public static void main(String[] args) {
        int [] num = {44,1,22,5,3,77,69,5,78,7,};
//        int [] num = {1,2,22,24,25,77,78,79,80,81,};
//        int [] num = {10,9,8,7,6,5,4,3,2,1};
        sort(num,0,num.length-1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + ",");
        }
    }

    /**
    排序方法
    */
    public static  void sort(int [] num,int le,int ri){
        /* 递归出口 */
        if (le>=ri){
            return;
        }
        int left = le;
        int right = ri;
        /* 基准数 */
        int basic = num[left];
        /*  小的放左边*/
        while (left < right){
            /* 挖坑，内缩
            * 从后往前，找小于basic的数，知道找到为止
            * */
            while (left < right && num[right] > basic){
                right --;
            }
            /* 找不到的话left>=right */
            if (left < right){
                num[left] = num[right];
                /* 填坑，挪一下 */
                left ++;
                /*  test */
                System.out.println(times++);
            }
            /*  从前往后，找大于basic的数*/
            while (left < right && num[left] < basic){
                left ++;
            }
            if (left < right){
                num[right] = num[left];
                right--;
                /* test */
                System.out.println(times++);
            }

        }
        num[left] = basic;
        sort(num,le,left-1);
        sort(num,right+1,ri);
    }
}
