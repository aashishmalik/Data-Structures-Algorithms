package Generics;

public class LLgeneric {

	public static void main(String[] args) {

		GenericClass<Cars> list = new GenericClass<>();
		Cars[] car = new Cars[5];
		car[0] = new Cars(10, 206, "red");
		car[1] = new Cars(20, 203, "green");
		car[2] = new Cars(600, 210, "black");
		car[3] = new Cars(80, 250, "blue");
		car[4] = new Cars(90, 200, "white");
		list.addLast(car[0]);
		list.addLast(car[1]);
		list.addLast(car[2]);
		list.addLast(car[3]);
		list.addLast(car[4]);
		list.display();

	}
}
