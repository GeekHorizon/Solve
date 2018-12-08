package leetcode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 *
 */
public class SolutionRemoveNthFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode root = new ListNode(0);
        root.next = head;
        ListNode prevNode = root;
        ListNode searchNode = head;
        
		for (int i = 0; i < n; i++) {
			searchNode = searchNode.next;
		}
        
		while (searchNode != null) {
			searchNode = searchNode.next;
			prevNode = prevNode.next;
		}
		
        prevNode.next = prevNode.next.next;
        
		return root.next;
	}

	
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
