package lecdec;
//MERGE SORT
public class SortingRec {

	public static void main(String[] args) {
	
		int[] arr = { 20, 10, 30, 5, 3, 88, 80, 0 };
		int[] sorted = mergeSort(arr, 0, arr.length-1);

		for (int val : sorted) {
			System.out.println(val);
		}
	}

	public static int[] mergeTwoSortedArray(int[] one, int[] two) {

		int i = 0, j = 0, k = 0;
		int[] merged = new int[one.length + two.length];
		while (i < one.length && j < two.length) {

			if (one[i] > two[j]) {
				merged[k] = two[j];
				k++;
				j++;
			}
				//IF BOTH "IF" BOTH WILL EXECUTE
			else if(one[i] <=two[j]) {
				merged[k] = one[i];
				k++;
				i++;
			}
		}

		while (i < one.length) {
			merged[k] = one[i];
			k++;
			i++;
		}
		while (j < two.length) {
			merged[k] = two[j];
			k++;
			j++;
		}

		return merged;
	}

	public static int[] mergeSort(int[] arr, int low, int high) {

		if (low == high) {
			int[] bs = new int[1];
			bs[0] = arr[low];
			return bs;
		}
		int mid = (low + high) / 2;

		int[] fh = mergeSort(arr, low, mid);
		int[] sh = mergeSort(arr, mid + 1, high);

		int[] ans = mergeTwoSortedArray(fh, sh);

		return ans;
	}

}
