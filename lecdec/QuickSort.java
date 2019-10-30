package lecdec;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 20, 10, 30, 15, 3, 88, 80, 0 };

		quickSort(arr, 0, arr.length - 1);

		for (int val : arr) {
			System.out.println(val);
		}

	}

	public static void quickSort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}
		// partitioning
		int left = low;
		int right = high;

		int mid = (low + high) / 2;
		int pivot = mid;

		while (left <= right) {

			while (arr[left] < arr[pivot]) {
				left++;
			}
			while (arr[right] > arr[pivot]) {
				right--;
			}

			if (left <= right) {
				int c = arr[left];				//to check case of 50 40 60 30
				arr[left] = arr[right];
				arr[right] = c;
				left++;
				right--;

			}
		}
		quickSort(arr, low, right);
		quickSort(arr, left, high);
	}
}
