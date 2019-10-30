package Generics;

import java.util.Comparator;

public class CPComp implements Comparator<Cars> {

	public int compare(Cars o1, Cars o2) {
		return o1.price - o2.price;
	}

}
