package lec22dec;

import java.util.ArrayList;

public class KMP {

	public static void main(String[] args) {

		System.out.println(getSS("145"));
	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {

			for (String val : rr) {
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

}
