package lec22dec;

import java.util.ArrayList;

public class Permutations {
	public static void main(String[] args) {
		System.out.println(getPermutation("abcd"));
	}
	public static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutation(ros); // recursive result

		ArrayList<String> mr = new ArrayList<>(); // my result

		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}
		return mr;
	}
}
