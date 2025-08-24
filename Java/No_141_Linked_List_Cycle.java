import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class No_141_Linked_List_Cycle extends BaseLinkedListSolution {

    private static final Logger logger = Logger.getLogger(No_141_Linked_List_Cycle.class.getName());


    public static class solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            ListNode curr = head;
            while(curr != null) {
                if(set.contains(curr)) {
                    return true;
                }
                set.add(curr);
                curr = curr.next;
            }
            return false;
        }

    }

    public static class solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }
}
