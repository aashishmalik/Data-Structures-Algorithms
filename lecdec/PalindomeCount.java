package lecdec;

//math.pow is of log complexity
public class PalindomeCount {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// n,x
		calculatePolynomial(6, 2);// in n complexity
	}

	public static void calculatePolynomial(int n, int x) {
		int sum = 0;
		int m = x;
		for (int i = n; i >= 1; i--) {

			sum += (i * m);
			m *= x;
		}
		System.out.println(sum);
	}
}