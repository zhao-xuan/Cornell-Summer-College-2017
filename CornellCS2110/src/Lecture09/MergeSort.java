package Lecture09;

public class MergeSort {
	
	public void merge_sort(int[] arr) {
		int length = arr.length;
		int[] result = new int[length];
		merge_sort(arr, result, 0, length - 1);
	}
	public void merge_sort(int arr[], int[] result, int start, int end) {
		if (start >= end) {
			return;
		}
		int start1 = start, end1 = (start + end) / 2;
		int start2 = (start + end) / 2 + 1, end2 = end;
		merge_sort(arr, result, start1, end1);
		merge_sort(arr, result, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2) {
			result[k++] = (arr[start1] >= arr[start2]) ? arr[start2++] : arr[start1++];
		}
		while (start1 <= end1) {
			result[k++] = arr[start1++];
		}
		while (start2 <= end2) {
			result[k++] = arr[start2++];
		}
		for (k = start; k <= end; k++) {
			arr[k] = result[k];
		}
	}

}
