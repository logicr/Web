package practice;

import java.util.ArrayList;

/**
 * 集合栈，已经通过编译
 *
 */
//
//public class SetOfStacks {
//    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
//        ArrayList<ArrayList <Integer>> list = new ArrayList<>();
//        ArrayList<Integer> stack = null;
//        for (int i = 0; i < ope.length; i++) {
//            int ints = ope[i][0];
//            /**
//             * push
//             */
//            if(1 == ints){
//                /**
//                 * 判断当前栈是否满，满则存
//                 */
//                if (null == stack || size == stack.size()){
//                    stack = new ArrayList<>();
//                    list.add(stack);
//                }
//                stack.add(ope[i][1]);
//            }
//            /**
//             * pop
//             */
//            else if(0 == ints) {
//                if (stack.isEmpty()){
//                    /**
//                     * 从0开始的
//                     */
//                   stack = list.remove(list.size()-1);
//                }
//                    stack.remove(stack.size()-1);
//            }
//
//        }
//        return list;
//
//    }
//}
//
public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        ArrayList<ArrayList <Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> stack = null;
        for (int[] anOpe : ope) {
            int ints = anOpe[0];
            if (1 == ints) {
                /*
                 * 这里用null的判断可以将stack一开始就入list，避免了最后一个stack不能入list
                 */
                if (null == stack || size == stack.size()) {

                    stack = new ArrayList<>();
                    list.add(stack);
                }
                stack.add(anOpe[1]);
            } else {
                if (stack.isEmpty()) {
                    /*
                     * 因为每个Stack都是在list中的，所以取删除后的下一个
                     */
                    list.remove(list.size() - 1);
                    stack = list.get(list.size() - 1);
                }
                stack.remove(stack.size() - 1);
            }
        }
        return list;
    }
}