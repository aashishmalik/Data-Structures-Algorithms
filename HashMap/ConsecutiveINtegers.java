package HashMap;

import java.util.HashMap;

public class ConsecutiveINtegers {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 8, 56, 45, 46, 78, 79, 80, 81, 3, 4, 82, 83, 84, 5, 6, 7 };
		consecitiveSum(arr);
	}

	private static void consecitiveSum(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}
		}

		int maxlen = 0;
		int startInt = 0;

		for (Integer key : map.keySet()) {

			if (map.get(key)) {
				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxlen) {
					maxlen = count;
					startInt = key;
				}
			}
		}
		for (int i = startInt; i <= maxlen; i++) {
			System.out.println(i);
		}

	}

}
