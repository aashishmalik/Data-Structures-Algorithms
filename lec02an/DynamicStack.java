package lec02an;

import lec29dec.Stack;

public class DynamicStack extends Stack {

	@Override
	public void push(int n) throws Exception {

		if (isFull()) {

			int[] na = new int[2 * this.data.length];
			int[] oa = this.data;

			for (int i = 0; i < oa.length; i++) {
				na[i] = oa[i];
			}
			this.data=na;//data points to new array made
		}

		super.push(n);

	}

}
