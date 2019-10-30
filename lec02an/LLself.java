package lec02an;

public class LLself {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL empty");
		}

		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid");
		}
		Node temp = this.head;
		int i = 1;
		while (i <= idx) {
			temp = temp.next;
			i++;
		}

		return temp.data;
	}

	public Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL empty");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid");
		}

		Node temp = this.head;

		int i = 1;
		while (i <= idx) {
			temp = temp.next;
			i++;
		}
		return temp;
	}

	public void display() throws Exception {
		Node temp = this.head;

		if (this.size == 0) {
			throw new Exception("LL empty");
		}
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void addLast(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (this.size > 0) {
			this.tail.next = nn;
		}

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;

		}

	}

	public void addFirst(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (this.size > 0) {
			nn.next = this.head;
		}

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}
	}

	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;
			nm1.next = nn;
			nn.next = np1;

			this.size++;

		}
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}

	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {

			Node nn = getNodeAt(this.size - 2);
			nn.next = null;
			this.tail = nn;
			this.size--;
		}
		return rv;

	}

	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			removeFirst();
		} else if (idx == this.size - 1) {
			removeLast();
		} else {
			Node nn = getNodeAt(idx - 1);
			Node p = nn.next;
			Node m = p.next;
			nn.next = m;
			this.size--;

			return p.data;

		}
		return idx;

	}

}
