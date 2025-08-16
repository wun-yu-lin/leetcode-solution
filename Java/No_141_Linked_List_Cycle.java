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
}
