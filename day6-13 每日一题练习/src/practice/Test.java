package practice;


import java.util.Iterator;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 分段排序链表，且相对位置不变
 */
public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        partition(head,0);
    }
    public static ListNode partition(ListNode head, int x) {
            if (null == head){
                return null;
            }
            ListNode befor = null;
            ListNode bfTmp = befor;
            ListNode after = null;
            ListNode afTmp = after;
            ListNode tmp = head;
            while (null != tmp){

                if (x < tmp.val){


                    if( null == befor){
                        befor = new ListNode(tmp.val);
                        bfTmp = befor;
                    }else {
                        bfTmp.next = new ListNode(tmp.val);
                        bfTmp = bfTmp.next;
                    }


                }else {
                    if (null == after){
                        after = new ListNode(tmp.val);
                        afTmp = after;
                    }else {
                        afTmp.next = new ListNode(tmp.val);
                        afTmp = afTmp.next;
                    }
                }
                tmp = tmp.next;
            }
            if (null == befor){
                return after;
            }
            bfTmp = befor;
            while (null !=bfTmp.next){
                bfTmp = bfTmp.next;
            }
            bfTmp.next = after;
            return  befor;
    }

}
