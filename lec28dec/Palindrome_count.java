package lec28dec;

public class Palindrome_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palcount("abbaca"));

	}

	public static int palcount(String str) {

		int count = 0;

		// odd length

		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else
					break;
			}
		}

		// even length

		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis + orbit < str.length() && axis - orbit >= 0; orbit++) {
				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else
					break;
			}
		}
		return count;
	}

}
