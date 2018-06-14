package practice;


/**
 * 节点
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next .next.next= new ListNode(2);
        head.next .next.next.next= new ListNode(4);
        sortList(head);
        while (null != head){
            System.out.print(head.val + " ");
            head = head.next;
        }
/**
 *   1.从中间分开，分啊分
 *   2.合并，怎么合并？当然是比较1.分开之后的两端啊然后合并啊
*/
    }
    public static ListNode sortList(ListNode head){
        /**
         * if语句，递归出口，当前为空或者下一步为空就没必要再递归了，使用短路||
         */
        if (null == head || null ==head.next){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        /**
         * 找中点啊，找啊找
         */
        while (null != fast.next && null != fast.next.next){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode preHead = sortList(head);
        ListNode tailHead = sortList(tmp);
        /**
         * 合并之后，返回递归上层
         */
        return mergerList(preHead,tailHead);
    }
    public static ListNode mergerList(ListNode preHead,ListNode tailHead){
        /**
         * 分割到一个时，有一个传过来就是null，没必要再排序，直接返回非空即可
         */
        if (null == preHead) {
            return  tailHead;
        }
        if (null == tailHead){
            return  preHead;
        }
        /**
         * retuNode用来迭代；实际上是一个带有节点的单链表；
         * tmp用来保存retuNode的头指针，用来返回
         */
        ListNode retuNode = new ListNode(0);
        ListNode tmp = retuNode;
        /**
         * 1.其中一个为空就退出循环，需要注意的是最后把没循环的要追加上
         * 2.每次只比较一个
         * 3.返回tmp的下一个节点，因为这是一个带头节点
         */
        while (null != preHead && null != tailHead){
            if (preHead.val > tailHead.val){
                retuNode.next = tailHead;
                tailHead = tailHead.next;

            } else{
                retuNode.next = preHead;
                preHead = preHead.next;
            }
            retuNode = retuNode.next;
        }
        if (null != tailHead){
            retuNode.next = tailHead;
        }
        if (null != preHead) {
            retuNode.next = preHead;

        }
        return tmp.next;
    }
}
