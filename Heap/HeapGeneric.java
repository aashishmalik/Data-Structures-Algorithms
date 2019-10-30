package Heap;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public void add(T item) {

		this.data.add(item);
		int ci = this.data.size() - 1;
		upheapify(ci);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void swap(int ci, int pi) {

		T temp = this.data.get(ci);
		this.data.set(ci, this.data.get(pi));
		this.data.set(pi, temp);
	}

	public T remove() {

		T rv = this.data.get(0);
		swap(0, this.size() - 1);
		this.data.remove(this.size() - 1);
		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	public void display() {
		System.out.println(data);
	}
	public boolean isEmpty() {
		return this.data.size() == 0;
	}
	
	public T getHP() {
		return this.data.get(0);
	}

	public int isLarger(T o1, T o2) {
		return o2.compareTo(o1);
	}
}
