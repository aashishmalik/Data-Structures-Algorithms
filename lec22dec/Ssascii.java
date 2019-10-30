package lec22dec;

import java.util.ArrayList;

public class Ssascii {

	public static void main(String[] args) {

		System.out.println(getSSASCII("abc"));

	}

	public static ArrayList<String> getSSASCII(String str) {

		if (str.length() == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			bresult.add("");
			return bresult;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recresult = new ArrayList<>();
		recresult = getSSASCII(ros);
		ArrayList<String> myans = new ArrayList<>();

		for (String val : recresult) {
			myans.add(val);
			myans.add(val + ch);
			myans.add(val + (int) ch);
		}
		return myans;

	}

}
