package lec02an;

import lec29dec.Queue;

public class DynamicQueue extends Queue {

	@Override
	public void enqueue(int item) throws Exception {

		if (isFull()) {

			int[] na = new int[2 * this.data.length];				//new array

			for (int i = 0; i < this.data.length; i++) {
				

				na[i]=(int) this.data[i+front %this.data.length];

			}
			this.data = na;
			this.front = 0;
		}

		super.enqueue(item);

	}

}
