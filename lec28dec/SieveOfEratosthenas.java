package lec28dec;

import java.util.Arrays;

public class SieveOfEratosthenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SOE(25);
	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {
			// not include already cut values
			if (primes[table]) {
				for (int multiplier = 2; table * multiplier <= n; multiplier++) {
					primes[table * multiplier] = false;
				}

			}
		}

		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) { // if not cut when value is true
				System.out.println(i);
			}
		}
	}
}
