package leetcode;

import java.util.Stack;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed.
 * 
 */
public class SolutionReverseNodesinkGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> reverseNodeStack = new Stack<ListNode>();
		
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode findNode = dummyNode;
		
		
		while (findNode != null) {
			
			reverseNodeStack.push(findNode);
			
			if (reverseNodeStack.size() == k) {
				
				if (findNode.next == null) {
					break;
				}
				
				ListNode reverseNodeRoot = findNode.next;
				ListNode reverseNodeRootFind = reverseNodeRoot;
				ListNode reverseNodeNodex = reverseNodeRoot.next;
				
				while (reverseNodeStack.size() > 1) {
					reverseNodeRootFind.next = reverseNodeStack.pop();
					reverseNodeRootFind = reverseNodeRootFind.next;
				}
				reverseNodeStack.pop().next = reverseNodeRoot;
				reverseNodeRootFind.next = reverseNodeNodex;
				
				findNode = reverseNodeRootFind;
				reverseNodeStack.push(findNode);
			}
				
			findNode = findNode.next;
			
		}
		
		return dummyNode.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
