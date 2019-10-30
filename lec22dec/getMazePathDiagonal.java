package lec22dec;

import java.util.ArrayList;

public class getMazePathDiagonal {
	public static void main(String[] args) {
		System.out.println(getMazePathD(0, 0, 2, 2));
	}

	public static ArrayList<String> getMazePathD(int cr, int cc, int er, int ec) {
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
		ArrayList<String> rrv = getMazePathD(cr + 1, cc, er, ec);
		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrh = getMazePathD(cr, cc + 1, er, ec);
		for (String val : rrh) {
			mr.add("H" + val);
		}
		ArrayList<String> rrD = getMazePathD(cr + 1, cc + 1, er, ec);
		for (String val : rrD) {
			mr.add("D" + val);
		}
		return mr;
	}
}
