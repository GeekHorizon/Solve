package leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3. Note:
 * 
 * Your algorithm should use only constant extra space. You may not modify the
 * values in the list's nodes, only nodes itself may be changed.
 */
public class SolutionSwapNodesPairs {

	public ListNode swapPairs(ListNode head) {
		
		if (head == null) {
			return null;
		}
		
		ListNode dummyHeader = new ListNode(0);
		dummyHeader.next = head;
		ListNode swapNode = dummyHeader;
		
		while (swapNode != null) {
			if (swapNode.next == null || swapNode.next.next == null) {
				break;
			}
			
			ListNode swapTempNode = swapNode.next;
			
			swapNode.next = swapNode.next.next;
			swapTempNode.next = swapNode.next.next;
			swapNode.next.next = swapTempNode;
			
			swapNode = swapTempNode;
		}
		
		return dummyHeader.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

