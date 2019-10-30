package lec22dec;

import java.util.ArrayList;

public class getMazePathJump {

	public static void main(String[] args) {
		System.out.println(getMazePathDMM(0, 0, 2, 2));

	}

	public static ArrayList<String> getMazePathDMM(int cr, int cc, int er, int ec) {
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
		for (int jump = 1; (cr + jump) <= er; jump++) {
			ArrayList<String> rrv = getMazePathDMM(cr + jump, cc, er, ec);
			for (String val : rrv) {
				mr.add("V" + jump + val);
			}

		}
		for (int jump = 1; (cc + jump) <= ec; jump++) {
			ArrayList<String> rrh = getMazePathDMM(cr, cc + jump, er, ec);
			for (String val : rrh) {
				mr.add("H" + jump + val);
			}

		}

		for (int jump = 1; (cr + jump) <= er&&(cc+jump)<=ec; jump++) {
			ArrayList<String> rrd = getMazePathDMM(cr + jump, cc + jump, er, ec);
			for (String val : rrd) {
				mr.add("D" + jump + val);
			}

		}
		return mr;
	}
}
