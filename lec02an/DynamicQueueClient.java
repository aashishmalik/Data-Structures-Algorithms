package lec02an;

import lec29dec.Queue;

public class DynamicQueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Queue q = new DynamicQueue();

		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);

	}

}
