package leetcode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 *
 */
public class SolutionMergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		}
		
		int interval = 1; 
		int length = lists.length;
		
		while (interval < length) {
			
			for (int i = 0; i < length - interval; i += interval * 2) {
				lists[i] = mergeList(lists[i], lists[i + interval]);
			}
			
			interval *= 2;
		}
		
		
		return lists[0];
	}
	
	private ListNode mergeList(ListNode l1, ListNode l2) {
		ListNode header = new ListNode(0);
		header.next = l1;
		ListNode addNode = header; 
		
		while (l1 != null &&  l2 != null) {
			if (l1.val < l2.val) {
				addNode.next = l1;
				
				l1 = l1.next; 
			} else {
				addNode.next = l2;
				l2 = l2.next; 
			}
			addNode = addNode.next;
		}
		
		if (l1 != null) {
			addNode.next = l1;
		} else {
			addNode.next = l2;
		}
		
		return header.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
