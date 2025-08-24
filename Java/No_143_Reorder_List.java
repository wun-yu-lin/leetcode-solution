import java.util.Stack;
import java.util.logging.Logger;

public class No_143_Reorder_List extends BaseLinkedListSolution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = buildListNode(new int[]{1,2,3,4});
        printAllNodeValue(node1);
        solution.reorderList(node1);
        printAllNodeValue(node1);

//        [1,2,3,4,5]
        ListNode node2 = buildListNode(new int[]{1,2,3,4,5});
        printAllNodeValue(node2);
        solution.reorderList(node2);
        printAllNodeValue(node2);
    }

    public static class Solution {
        //fast pointer
        //slow pointer
        public void reorderList(ListNode head) {
//            You are given the head of a singly linked-list. The list can be represented as:
//            L0 → L1 → … → Ln - 1 → Ln
//            Reorder the list to be on the following form:
//            L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

            // null or size <= 2
            if (head == null || head.next == null) {
                return;
            }
            ListNode fast = head;
            ListNode slow = head;
            ListNode slowTail = null;

            //find the end of slow and fast point
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                //prevent infinite loop
                if (slow == fast) {
                    throw new IllegalArgumentException("loop in input list");
                }
            }
            slowTail = slow;

            //reverse fast
            ListNode rFast = reverse(slowTail.next);
            slow.next = null;

            //merge fast & slow
            ListNode second = rFast;
            ListNode first = head;
            while (second != null) {
                ListNode tmp1 = first.next;
                ListNode tmp2 = second.next;

                first.next = second;
                second.next = tmp1;

                first = tmp1;
                second = tmp2;
            }
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null,  curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }
}
