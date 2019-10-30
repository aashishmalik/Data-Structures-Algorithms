package lec22dec;

import java.util.ArrayList;

public class getMazePath {
	public static void main(String[] args) {
		System.out.println(getMazePath(0, 0, 2, 2));
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {
		if (cc == ec && cr == er) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (cc > ec || cr > er) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrv = getMazePath(cr + 1, cc, er, ec);
		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrh = getMazePath(cr, cc + 1, er, ec);
		for (String val : rrh) {
			mr.add("H" + val);
		}
		return mr;
	}
}