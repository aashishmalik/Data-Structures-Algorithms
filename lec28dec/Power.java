package lec28dec;

public class Power {

	public static void main(String[] args) {

		System.out.println(power(5, 7));
	}

	public static int power(int x,int n) {
		
		if(n==0) return 1;
		int m=power(x,n/2);
		
		if(n%2==0)
			return m*m;
		else
			return m*m*x;
	}
}