public class BaseLinkedListSolution extends BaseSolution {

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

}
