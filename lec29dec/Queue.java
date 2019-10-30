package lec29dec;

public class Queue {

	protected int[] data;
	protected int front;
	protected int size;

	public Queue(){
		this.data = new int[5];
		this.front = 0;
		this.size = 0;
	}
	public Queue(int cap){
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (this.size == this.data.length)
			return true;
		else {
			return false;
		}
	}

	public void enqueue(int n) throws Exception {
		if(isFull()) {
			throw new Exception(" Queue is Full");
		}
		int index = (this.front + this.size) % (this.data.length); // to make circular queue
		this.data[index] = n;
		this.size++;
	}

	public int dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception(" Queue is Empty");
		}
		int rv = this.data[front];
		this.data[front] = 0;
		this.size--;
		front = (front + 1)%(this.data.length);
		return rv;
	}

	public void display() {
		System.out.println("========");
		for (int i = 0; i < size; i++) {
			System.out.println(this.data[(i + front)%this.data.length]);
		}
		System.out.println("    =============");

	}
	public int getFront() throws Exception {
	
		if (this.isEmpty()) {
			throw new Exception("Queue is Empty.");
		}

		int rv = this.data[this.front];
		return rv;
	}
}
