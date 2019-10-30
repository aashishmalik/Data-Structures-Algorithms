package Generics;

import java.util.Comparator;

public class Demo {

	public static void main(String args[]) {

		Integer[] arr = { 10, 20, 30, 40, 50 };
		display(arr);
		Cars[] car = new Cars[5];
		car[0] = new Cars(10, 206, "red");
		car[1] = new Cars(20, 203, "green");
		car[2] = new Cars(600, 210, "black");
		car[3] = new Cars(80, 250, "blue");
		car[4] = new Cars(90, 200, "white");
		System.out.println("================");
		bubblesort(car);
		display(car);
		bubblesort(car, new CPComp());
		System.out.println("================");
		display(car);
		bubblesort(car, new CSComp());
		System.out.println("================");
		display(car);

	}

	private static <T> void display(T[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static <T extends Comparable<T>>   /* to set bound on T*/ 
	void bubblesort(T[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static <T> void bubblesort(T[] arr, Comparator<T> obj) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (obj.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
