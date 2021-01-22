package study;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		
		int[] items = new int[] {9, 2, 1, 101, 8, 4, 6, 4, 9, 0, 1, 100};
		
		QuickSort qs = new QuickSort();
		
		qs.quickSort(items, 0, items.length - 1);
		
		System.out.println(Arrays.toString(items));
	}
	
	public int[] quickSort(int[] items, int left, int right) {
		
		if (left < right) {
			
			int pivot = items[left];
			int low = left + 1;
			int hight = right;
			
			
			while (low < hight) {
				while (low <= right && items[low] < pivot) {
					low++;
				}
				
				while (hight >= left && items[hight] > pivot) {
					hight--;
				}
				
				if (low < hight) {
					swap(items, low, hight);
				}
			}
			
			swap(items, left, hight);
			
			quickSort(items, left, hight - 1);
			quickSort(items, hight + 1, right);
			return items;
			
		}
		
		return items;
	}
	
	private void swap(int[] items, int x, int y) {
		int temp = items[x];
		items[x] = items[y];
		items[y] = temp;
	}
	
}
