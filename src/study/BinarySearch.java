package study;

public class BinarySearch {
	public static void main(String[] args) {
		
		BinarySearch bs = new BinarySearch();
		
		System.out.println(bs.binarySearch(new int[] {1, 4, 7, 9, 10, 11, 23, 28}, 23));
	}
	
	
	public int binarySearch(int[] items, int item) {
		int left = 0; 
		int right = items.length - 1;
		
		while (left <= right) {
			int mid = (right + left) / 2;
			if (items[mid] < item) {
				left = mid + 1;
			} else if (items[mid] > item) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
	
	
	
}
