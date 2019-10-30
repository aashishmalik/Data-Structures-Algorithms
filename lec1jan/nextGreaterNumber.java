package lec1jan;

import lec29dec.Stack;

public class nextGreaterNumber {

	public static void main(String[] args) throws Exception {

		int[] arr = { 100, 20, 10, 50, 30, 130 };
		//generateNext(arr);
		int[] ans=generateNext2(arr);
		//int[] ans = stockSpan(arr);
		for (int val : ans) {
			System.out.println(val);
		}
	}

	public static void generateNext(int[] arr) throws Exception {

		Stack s = new Stack(100);
		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && s.peek() < arr[i]) {
				System.out.println(s.pop() + "->" + arr[i]);
			}
			s.push(arr[i]);
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + "-> -1");
		}
	}

	public static int[] generateNext2(int[] arr) throws Exception {

		int[] ans = new int[arr.length];

		Stack stack = new Stack(100);

		for (int i = 0; i < arr.length; i++) {

			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[stack.pop()] = arr[i];
			}

			stack.push(i);

		}

		while (!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}

		return ans;
	}

	public static int[] stockSpan(int[] arr) throws Exception {

		Stack stack = new Stack(100);
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}
}
