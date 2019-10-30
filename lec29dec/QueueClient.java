package lec29dec;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		int[] arr = { -3, -1, 8, 6, -4, -8, -9, 10 };
		/*
		 * q.enqueue(10); q.enqueue(20); q.enqueue(30); q.enqueue(40); q.enqueue(50);
		 */
		/*
		 * System.out.println(q.dequeue()); System.out.println(q.dequeue());
		 * q.enqueue(60); q.enqueue(70); q.display();
		 */
		//reverseQueue(q, 0);
		//actualReverse(q);
		//q.display();

		firstNegativeIntegerOfWindow(arr, 4);

	}

	public static void reverseQueue(Queue q, int count) throws Exception {
		if (q.size() == count) {
			return;
		}
		int temp = q.dequeue();
		q.enqueue(temp);
		reverseQueue(q, count + 1);
		System.out.println(temp);
	}

	public static void actualReverse(Queue q) throws Exception {

		if (q.size() == 0) {
			return;
		}
		int temp = q.dequeue();
		actualReverse(q);
		q.enqueue(temp);
		System.out.println(temp);
	}

	public static void firstNegativeIntegerOfWindow(int[] arr, int k) throws Exception {

		Queue q = new Queue(100);

		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				q.enqueue(i);
			}

		}

		for (int i = k; i < arr.length; i++) {
			if (q.isEmpty()) {
				System.out.println("0");
			} else {
				System.out.println(arr[q.getFront()]);
			}

			while(q.getFront() <= (i - k) && !q.isEmpty()) {
				q.dequeue();
			}
			if (arr[i] < 0) {
				q.enqueue(i);
			}
		}

		if (q.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(arr[q.getFront()]);
		}

	}
}
