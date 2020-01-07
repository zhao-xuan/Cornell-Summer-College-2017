package Lecture09;

public class BubbleSort {

	public void bubble_sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 2; j > i; j--) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}