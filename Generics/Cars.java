package Generics;

public class Cars implements Comparable<Cars> {

	int price;
	int speed;
	String color;

	public Cars(int price, int speed, String color) {
		this.price = price;
		this.speed = speed;
		this.color = color;
	}

	public String toString() {
		return "P: " + this.price + " S: " + this.speed + " C: " + this.color;
	}

	public int compareTo(Cars o) {
		 return this.speed-o.speed;
		// return o.price-this.price;
		//return this.color.compareTo(o.color);
	}
}
