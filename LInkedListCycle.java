import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (head == null) return false;
        ListNode node = head.next;
        while (node != null) {
            if (set.contains(node)) return true;
            set.add(node);
            node = node.next;
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}