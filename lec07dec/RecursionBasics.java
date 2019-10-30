package lec07dec;

import java.util.ArrayList;

public class RecursionBasics {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// int[] arr = { 10, 20, 30, 80, 60, 90, 80, 88 };

		// displayArray(arr, 0);

		// System.out.println(arrayMax(arr, 0));

		// System.out.println(itemIndex(arr, 0,80));

		// System.out.println(lastIndex(arr, 0, 80));

		// int[] result=findAllIndices(arr,0,80,0);
		// for(int val: result) {
		// System.out.print(val+" ");
		// }

		// printBox(1,1,4);

		System.out.println(subString("abc"));
	}

	public static void displayArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		System.out.println(arr[vidx]);
		displayArray(arr, vidx + 1);
	}

	public static int arrayMax(int[] arr, int vidx) {

		if (vidx == arr.length - 1) {
			return arr[vidx];
		}
		int max = arr[vidx];
		int spmax = arrayMax(arr, vidx + 1);

		if (spmax > max) {
			max = spmax;
		}

		return max;
	}

	public static int itemIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}
		if (arr[vidx] == item) {
			return vidx;
		} else {
			return itemIndex(arr, vidx + 1, item);
		}
	}

	public static int lastIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}
		int sp = lastIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && sp == -1) {
			return vidx;
		} else
			return sp;
	}

	public static int[] findAllIndices(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] bcArray = new int[count];
			return bcArray;
		}

		if (arr[vidx] == item) {
			int[] sp = findAllIndices(arr, vidx + 1, item, count + 1);
			sp[count] = vidx;
			return sp;
		} else {
			int[] sp = findAllIndices(arr, vidx + 1, item, count);
			return sp;
		}
	}

	public static void printBox(int row, int col, int n) {

		if (row > n) {
			return;
		}
		if (col > n) {
			System.out.println();
			printBox(row + 1, 1, n);
			return;
		}
		System.out.print("*");
		printBox(row, col + 1, n);
	}

	public static ArrayList<String> subString(String str) {

		if (str.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recresult = new ArrayList<>();
		
		recresult = subString(ros);
		
		ArrayList<String> myans = new ArrayList<>();
		for (String val : recresult) {
			myans.add(val);
			myans.add(val + ch);
		}

		return myans;
	}

}
