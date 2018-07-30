/**
 * @author Jan on 2018/7/29.
 * @version 1.0
 */


public class Solution10 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("run");
    }

    public static void main(String[] args) {
        Solution10 example = new Solution10();
        example.start();
        System.out.print("main");
    }
}
