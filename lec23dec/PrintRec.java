package lec23dec;

public class PrintRec {

	public static void main(String[] args) {
		// PrintSS("abc","");
		// PrintSSA("abc","");
		// PrintKPC("145","");
		// Permutation("abc","");
		// Permutation2("abc", "");
		// Permutation3("abca", "");
		// CoinToss(3,"");
		// CoinToss2(3,"",false);
		BoardPath(0,10,"");
	}

	public static void PrintSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;

		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		PrintSS(roq, ans);// no
		PrintSS(roq, ans + ch);// yes
	}

	public static void PrintSSA(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		int ascii = ch;

		PrintSSA(roq, ans);
		PrintSSA(roq, ans + ch);
		PrintSSA(roq, ans + ascii);
	}

	public static void PrintKPC(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			PrintKPC(roq, ans + code.charAt(i));
		}
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

	public static void Permutation(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			Permutation(roq, ans.substring(0, i) + ch + ans.substring(i));
		}
	}

	public static void Permutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			Permutation2(roq, ans + ch);
		}
	}

	public static void Permutation3(String ques, String ans) {
		// no duplicates permutation

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			boolean flag = true;
			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag = false;
					break;
				}

			}
			if (flag) {
				String roq = ques.substring(0, i) + ques.substring(i + 1);
				Permutation3(roq, ans + ch);
			}
		}
	}

	public static void CoinToss(int n, String ans) {

		if (n == 0) {

			System.out.println(ans);
			return;
		}
		CoinToss(n - 1, ans + "H");
		CoinToss(n - 1, ans + "T");
	}

	public static void CoinToss2(int n, String ans, boolean wasHead) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		if (wasHead) {
			CoinToss2(n - 1, ans + "T", false);
		} else {
			CoinToss2(n - 1, ans + "H", true);
			CoinToss2(n - 1, ans + "T", false);
		}
	}
	public static void BoardPath(int cur, int end,String ans){
		if(cur==end) {
			System.out.println(ans);
		}
		if(cur>end) {
			return;
		}
		for(int dice=1;dice<=6;dice++)
		{
			BoardPath(cur+dice,end ,ans+dice);
		}
	}

}
