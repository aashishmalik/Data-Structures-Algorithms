package Heap;

import java.util.ArrayList;

public class Heap {// MIN HEAP

	ArrayList<Integer> data = new ArrayList<>();

	public int size() {
		return this.data.size();
	}

	public void add(int item) {

		this.data.add(item);
		int ci = this.data.size() - 1;
		upheapify(ci);

	}

	private void upheapify(int ci) {

		int pi = (ci - 1) / 2;

		if (this.data.get(ci) < this.data.get(pi)) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private void swap(int ci, int pi) {

		int temp = this.data.get(ci);
		this.data.set(ci, this.data.get(pi));
		this.data.set(pi, temp);
	}

	public int remove() {

		int rv = this.data.get(0);
		swap(0, this.size() - 1);
		this.data.remove(this.size() - 1);
		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;

		if (lci < this.size() && this.data.get(lci) < this.data.get(mini)) {
			mini = lci;
		}

		if (rci < this.size() && this.data.get(rci) < this.data.get(mini)) {
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
}
