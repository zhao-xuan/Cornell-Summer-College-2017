package Lecture09;

public class Lecture09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {12, 45, 23, 35, 74, 24, 64, 92, 81, 39};
		new BubbleSort().bubble_sort(arr1);
		for (int i : arr1)
			System.out.println(i);
	}
}