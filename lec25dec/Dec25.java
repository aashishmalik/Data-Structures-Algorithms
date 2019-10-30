package lec25dec;

public class Dec25 {

	public static void main(String[] args) {

		// lexicoCounting(0,1000);
		//generateParenthesis(3, "", 0, 0);
		System.out.println(wildCardMatching("abc", "a*"));
	}

	public static void lexicoCounting(int curr, int end) {
		int i = 0;
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		if (curr == 0) {
			i = 1;
		}
		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, end);
		}
	}

	public static void generateParenthesis(int n, String ans, int open, int close) {

		if (open > n || close > n || close > open) {
			return;
		}
		if (open == n && close == n) {
			System.out.println(ans);
		}
		generateParenthesis(n, ans + ")", open, close + 1);
		generateParenthesis(n, ans + "(", open + 1, close);
	}

	public static boolean wildCardMatching(String src, String pattern) {

		if (src.length() == 0 && pattern.length() == 0) {
			return true;
		}
		if (src.length() != 0 && pattern.length() == 0) {
			return false;
		}
		if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}
			return true;
		}
		char srcch = src.charAt(0);
		char patch = pattern.charAt(0);

		String srcros = src.substring(1);
		String patros = pattern.substring(1);

		boolean rr;
		if (srcch == patch || patch == '?') {
			rr = wildCardMatching(srcros, patros);
		} else if (patch == '*') {
			rr = wildCardMatching(srcros, pattern) || wildCardMatching(src, patros);
		} else {
			return false;
		}
		return rr;
	}
}
