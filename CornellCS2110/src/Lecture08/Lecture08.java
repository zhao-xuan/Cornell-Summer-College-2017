package Lecture08;

public class Lecture08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, 36, 24, 74, 64, 79, 10, 98, 27, 72};
		merge_sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	public static void merge_sort(int[] arr) {
		int length = arr.length;
		int[] result = new int[length];
		merge_sort_recursive(arr, result, 0, arr.length - 1);
	}
	public static void merge_sort_recursive(int[] arr, int[] result, int s, int e) {
		if (s >= e) {
			return;
		}
		int len = e - s, mid = (len >> 1) + s;
		int start1 = s, end1 = mid;
		int start2 = mid + 1, end2 = e;
		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		int k = s;
		while (start1 <= end1 && start2 <= end2) {
			result[k++] = arr[start1] <= arr[start2] ? arr[start1++] : arr[start2++];
		}
		while (start1 <= end1) {
			result[k++] = arr[start1++];
		}
		while (start2 <= end2) {
			result[k++] = arr[start2++];
		}
		for (k = s; k <= e; k++) {
			arr[k] = result[k];
		}	
	}
}
