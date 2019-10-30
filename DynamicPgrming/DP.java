package DynamicPgrming;

import java.util.Arrays;

public class DP {

	public static void main(String[] args) {
		int n = 1000;

		int[] arr = { 2, 3, 5, 1, 4 };

		System.out.println(fibBU(n, new long[n + 1]));
		System.out.println(fibTD(n, new long[n + 1]));
		System.out.println(fibBUSpaceEff(n, new long[3]));
		System.out.println(BoardPathTD(0, 10, new int[n + 1]));
		System.out.println(BoardPathBU(0, 10, new int[10 + 6]));
		System.out.println(BoardPathBUSpaceEff(0, 10, new int[6]));
		System.out.println(MazePath(0, 0, 3, 3, new int[3 + 1][3 + 1]));
		System.out.println(MazePathBU(0, 0, 3, 3, new int[3 + 2][3 + 2]));
		System.out.println(MazePathBUSE(0, 0, 3, 3, new int[3 + 1]));
		System.out.println(LCS("abcd", "bcgdef"));
		System.out.println(LCSBU("abcdgg", "bcgdefggh"));
		System.out.println(LCSTD("abcdgg", "bcgdefggh", new int[6 + 1][9 + 1]));
		System.out.println(EditDistance("abcd", "agcfd"));
		System.out.println(EditDistanceBU("abcd", "agcfd"));
		System.out.println(MCM(arr, 0, arr.length - 1));
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCMBU(arr));

		System.out.println(WineProblem(arr, 0, arr.length - 1, 1));
		System.out.println(WineProblemTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(WineProblemBU(arr));

		int[] weight = { 1, 3, 4, 7 };
		int[] price = { 1, 4, 5, 7 };
		System.out.println(knapsack(weight, price, 7, 0, new int[weight.length][7 + 1])); // 7+1=capacity +1

	}

	private static long fibTD(int n, long[] strg) {
		if (n == 1 || n == 0) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		long fn = fibTD(n - 1, strg) + fibTD(n - 2, strg);
		strg[n] = fn;
		return strg[n];

	}

	private static long fibBU(int n, long[] strg) {

		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	private static long fibBUSpaceEff(int n, long[] strg) {

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			long sum = strg[1] + strg[0];
			strg[0] = strg[1];
			strg[1] = sum;
		}
		return strg[1];
	}

	public static int BoardPathTD(int cur, int end, int[] strg) {
		if (cur == end) {
			return 1;
		}
		if (cur > end) {
			return 0;
		}
		if (strg[cur] != 0) {
			return strg[cur];
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += BoardPathTD(cur + dice, end, strg);
		}

		strg[cur] = count;

		return count;
	}

	public static int BoardPathBU(int cur, int end, int[] strg) {

		strg[10] = 1;

		for (int i = end; i <= strg.length - 1; i++) {
			strg[i] = 0; // by default ZERO
		}
		for (int i = end - 1; i >= 0; i--) {

			for (int j = i; j <= i + 5; j++) {
				strg[i] += strg[j + 1];
			}
		}
		return strg[cur];

	}

	public static int BoardPathBUSpaceEff(int cur, int end, int[] strg) {

		strg[0] = 1;
		for (int i = 1; i <= end; i++) {
			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}
		return strg[0];
	}

	private static int MazePath(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr > er || cc > ec) {
			return 0;
		}
		if (cr == er && cc == ec)
			return 1;
		if (strg[cr][cc] != 0)
			return strg[cr][cc];
		int ch = MazePath(cr + 1, cc, er, ec, strg);
		int cv = MazePath(cr, cc + 1, er, ec, strg);
		strg[cr][cc] = ch + cv;
		return strg[cr][cc];
	}

	private static int MazePathBU(int cr, int cc, int er, int ec, int[][] strg) {
		for (int i = er; i >= cr; i--) {
			for (int j = ec; j >= cc; j--) {
				if (i == er && j == ec) {
					strg[i][j] = 1;
				} else {
					strg[i][j] = strg[i][j + 1] + strg[i + 1][j];

				}
			}
		}
		return strg[cr][cc];
	}

	private static int MazePathBUSE(int cr, int cc, int er, int ec, int[] strg) {

		Arrays.fill(strg, 1);

		for (int row = er - 1; row >= 0; row--) {

			for (int col = ec - 1; col >= 0; col--) {
				strg[col] = strg[col] + strg[col + 1];
			}
		}
		return strg[cr];
	}

	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (c1 == c2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);
			ans = Math.max(o1, o2);
		}
		return ans;
	}

	private static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {
					int o1 = strg[row + 1][col];
					int o2 = strg[row][col + 1];
					strg[row][col] = Math.max(o1, o2);
				}
			}
		}
		return strg[0][0];
	}

	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0)
			return 0;

		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}
		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (c1 == c2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCSTD(s1, ros2, strg);
			int o2 = LCSTD(ros1, s2, strg);
			ans = Math.max(o1, o2);
		}
		strg[s1.length()][s2.length()] = ans;
		return ans;
	}

	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0)
			return Math.max(s1.length(), s2.length());

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return EditDistance(ros1, ros2) + 1;
		} else {
			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);
			return Math.min(i, Math.min(d, r));
		}
	}

	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}
				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];
					strg[row][col] = Math.min(i, Math.min(d, r)) + 1;
				}
			}

		}
		return strg[0][0];

	}

	public static int MCM(int[] arr, int si, int ei) {
		int min = Integer.MAX_VALUE;
		if (si + 1 == ei)
			return 0;
		for (int k = si + 1; k <= ei - 1; k++) {
			int fc = MCM(arr, si, k);
			int sc = MCM(arr, k, ei);
			int sw = arr[si] * arr[ei] * arr[k]; // multiply of result matrix order with other matrix
			int total = fc + sc + sw;
			if (total < min)
				min = total;
		}
		return min;
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {
		int min = Integer.MAX_VALUE;
		if (si + 1 == ei)
			return 0;
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		for (int k = si + 1; k <= ei - 1; k++) {
			int fc = MCM(arr, si, k);
			int sc = MCM(arr, k, ei);
			int sw = arr[si] * arr[ei] * arr[k]; // multiply of result matrix order with other matrix
			int total = fc + sc + sw;
			if (total < min)
				min = total;
		}
		strg[si][ei] = min;
		return min;
	}

	public static int MCMBU(int[] arr) {
		int n = arr.length;

		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fc = strg[si][k];

					int sc = strg[k][ei];

					int sw = arr[si] * arr[ei] * arr[k]; // multiply of result matrix order with other matrix

					int total = fc + sc + sw;
					if (total < min)
						min = total;
				}
				strg[si][ei] = min;
			}
		}
		return strg[0][n - 1];
	}

	public static int WineProblem(int[] arr, int si, int ei, int yr) {

		if (si == ei)
			return arr[si] * yr;

		int fsell = WineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int lsell = WineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;
		int ans = Math.max(fsell, lsell);

		return ans;

	}

	public static int WineProblemTD(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - ei + si;
		if (si == ei)
			return arr[si] * yr;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int fsell = WineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int lsell = WineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;
		int ans = Math.max(fsell, lsell);

		strg[si][ei] = ans;
		return ans;

	}

	public static int WineProblemBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;
				int yr = n - ei + si;

				if (si == ei)
					strg[si][ei] = arr[si] * yr;
				else {

					int fsell = strg[si][ei - 1] + arr[ei] * yr;
					int lsell = strg[si + 1][ei] + arr[si] * yr;

					int ans = Math.max(fsell, lsell);
					strg[si][ei] = ans;
				}
			}

		}
		return strg[0][n - 1];
	}

	public static int knapsack(int[] weight, int[] prices, int cap, int vidx, int[][] strg) {

		if (vidx == weight.length)
			return 0;

		if (strg[vidx][cap] != 0)
			return strg[vidx][cap];
		int exclude = knapsack(weight, prices, cap, vidx + 1, strg);

		int include = 0;
		if (cap >= weight[vidx]) {
			include = knapsack(weight, prices, cap - weight[vidx], vidx + 1, strg) + prices[vidx];
		}

		int ans = Math.max(include, exclude);

		strg[vidx][cap] = ans;
		return ans;
	}

}
