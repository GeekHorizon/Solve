package study;

import java.util.Arrays;

public class MergeSort {
	
	
	public static void main(String[] args) {
		
		int[] items = new int[] {9, 2, 1, 8, 4, 6, 4, 9, 0, 1};
		
		MergeSort ms = new MergeSort();
		
		ms.mergeSort(items, 0, items.length - 1);
		
		System.out.println(Arrays.toString(items));
	}
	
	public int[] mergeSort(int[] items, int left, int right) {
		if (left < right) {
			mergeSort(items, left, (right - left) / 2 + left);
			mergeSort(items, (right - left) / 2 + left + 1, right);
			return merge(items, left, (right - left) / 2 + left, (right - left) / 2 + left + 1, right);
		} 
		
		return items;
	}

	private int[] merge(int[] items, int leftX, int rightX, int leftY, int rightY) {
		int indexX = leftX;
		int indexY = leftY;
		int index = 0;
		
		int[] sorted = new int[rightY - leftX + 1];
		
		while (indexX <= rightX && indexY <= rightY) {
			if (items[indexX] > items[indexY]) {
				sorted[index++] = items[indexY++];
			} else {
				sorted[index++] = items[indexX++];
			}
		}
		while (indexX <= rightX) {
			sorted[index++] = items[indexX++];
		}
		while (indexY <= rightY) {
			sorted[index++] = items[indexY++];
		}
		
		index = 0;
		for (int idx = leftX; idx <= rightY; idx++) {
			items[idx] = sorted[index++];
		}
		
		return items;
	}
}
 