package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class MaxFreqChar {

	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		String str = sc.next();

		System.out.println(MaxFreq(str));

	}

	private static char MaxFreq(String str) {

		HashMap<Character, Integer> map = new HashMap<>(); // default null

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (map.containsKey(c)) {
				int val = map.get(c);
				map.put(c, val++);
			} else {
				map.put(c, 1);
			}
		}
		int max = 0;
		char ch = 'a';
		for (int i = 0; i < str.length(); i++) {
			if (map.get(str.charAt(i)) > max) {
				max = map.get(str.charAt(i));
				ch = str.charAt(i);
			}

		}

		return ch;
	}

}
