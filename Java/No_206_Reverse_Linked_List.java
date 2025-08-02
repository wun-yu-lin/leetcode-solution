import java.util.logging.Logger;

public class No_206_Reverse_Linked_List {

    private static final Logger logger = Logger.getLogger(No_206_Reverse_Linked_List.class.getName());

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        **Example 1:**
//        Input: head = [1,2,3,4,5]
//        Output: [5,4,3,2,1]
        ListNode s1 = buildListNode(new int[] {1,2,3,4,5});
        printAllNodeValue(s1);
        printAllNodeValue(solution.reverseList(s1));

//
//        **Example 2:**
//        Input: head = [1,2]
//        Output: [2,1]
        ListNode s2 = buildListNode(new int[] {1,2});
        printAllNodeValue(s2);
        printAllNodeValue(solution.reverseList(s2));
//
//
//        **Example 3:**
//        Input: head = []
//        Output: []
        ListNode s3 = buildListNode(new int[] {});
        printAllNodeValue(s3);
        printAllNodeValue(solution.reverseList(s3));
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }j
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode buildListNode(int[] arr){
        ListNode curr = new ListNode();
        if (arr.length == 0) {
            return curr;
        }
        ListNode head = curr;
        ListNode next;
        for (int i : arr) {
            next = new ListNode(i);
            curr.next = next;
            curr = next;
        }
        return head;
    }
    public static void printAllNodeValue(ListNode listNode) {
        ListNode n = listNode;
        while (n != null) {
            System.out.print(n.val);
            System.out.print(",");
            n = n.next;
        }
        System.out.println(" ");
    }

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            ListNode next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = pre;

                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    public static class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode n = null;
            ListNode curr = head;
            ListNode pre = null;
            ListNode next = null;
            while (curr != null) {
                if (n == null) {
                    n = new ListNode(curr.val, pre);
                } else {
                    next = new ListNode(curr.val, n);
                    n = next;
                }
                pre = curr;
                curr = curr.next;

            }
            return n;
        }
    }
}