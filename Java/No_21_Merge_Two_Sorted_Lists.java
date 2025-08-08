import java.util.Arrays;
import java.util.List;

public class No_21_Merge_Two_Sorted_Lists extends BaseLinkedListSolution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode c1 = list1;
            ListNode c2 = list2;
            ListNode head = null;
            ListNode curr = null;
            ListNode pre = null;
            if (c1 == null) return c2;
            if (c2 == null) return c1;

            while (c1 != null || c2 != null) {
                Integer v = null;
                if (c1 == null) {
                    v = c2.val;
                    c2 = c2.next;
                } else if (c2 == null) {
                    v = c1.val;
                    c1 = c1.next;
                } else if (c2.val >= c1.val) {
                    v = c1.val;
                    c1 = c1.next;
                } else {
                    v = c2.val;
                    c2 = c2.next;
                }
                curr = new ListNode(v);
                if (head == null) {
                    pre = curr;
                    head = curr;
                } else {
                    pre.next = curr;
                    pre = curr;
                }

            }
            return head;
        }
    }

    static class Solution2 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode vHead = new ListNode(Integer.MIN_VALUE);
            ListNode c1 = list1;
            ListNode c2 = list2;
            ListNode c = vHead;
            while (c1 != null && c2 != null) {
                if (c1.val <= c2.val) {
                    c.next = new ListNode(c1.val);
                    c1 = c1.next;
                }else {
                    c.next = new ListNode(c2.val);
                    c2 = c2.next;
                }
                c = c.next;
            }

            if (c1 == null) {
                c.next = c2;
            } else {
                c.next = c1;
            }
            return vHead.next;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode list1;
        ListNode list2;
//        Example 1:
//        Input: list1 = [1,2,4], list2 = [1,3,4]
//        Output: [1,1,2,3,4,4]
        list1 = buildListNode(new int[] {1,2,4});
        list2 = buildListNode(new int[] {1,3,4});
        printAllNodeValue(list1);
        printAllNodeValue(list2);
        printAllNodeValue(solution.mergeTwoLists(list1, list2));


//        Example 2:
//        Input: list1 = [], list2 = []
//        Output: []
        list1 = buildListNode(new int[0]);
        list2 = buildListNode(new int[0]);
        printAllNodeValue(list1);
        printAllNodeValue(list2);
        printAllNodeValue(solution.mergeTwoLists(list1, list2));

//        Example 3:
//        Input: list1 = [], list2 = [0]
//        Output: [0]
        list1 = buildListNode(new int[0]);
        list2 = buildListNode(new int[]{0});
        printAllNodeValue(list1);
        printAllNodeValue(list2);
        printAllNodeValue(solution.mergeTwoLists(list1, list2));

    }




}
