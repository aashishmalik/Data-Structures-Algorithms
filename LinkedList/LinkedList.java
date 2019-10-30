package LinkedList;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;

	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}
		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		Node temp = this.head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void display() {

		System.out.println("---------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next; // not this.head ????
		}

		System.out.println(".");
		System.out.println("---------------");
	}

	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// data members updation
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

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			nn.next = this.head;

		// data members updation
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

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			// attach
			nm1.next = nn;
			nn.next = np1;

			// data members update
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
			Node sm2 = getNodeAt(this.size - 2);
			sm2.next = null;
			this.tail = sm2;
			this.size--;
		}

		return rv;

	}

	public int removeAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;
		}
	}
	public void reverse() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		int f = 0;
		int l = this.size - 1;

		while (f < l) {

			Node temp = getNodeAt(f);
			Node temp2 = getNodeAt(l);
			int x = temp.data;
			temp.data = temp2.data;
			temp2.data = x;
			f++;
			l--;
		}
	}

	public void reverseP() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node f = this.head;
		Node s = this.head.next;

		while (s != null) {
			Node t = s.next;
			s.next = f;
			f = s;
			s = t;
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void reversePR() {

		reversePRR(head, head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePRR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		reversePRR(curr, curr.next);
		curr.next = prev;
	}

	public void reverseDR() {

		reverseDRR(head, head.next, 0);
	}

	private Node reverseDRR(Node left, Node right, int count) {
		{
			if (right == null) {
				return left;
			}
			left = reverseDRR(left, right.next, count + 1);

			if (count >= this.size / 2) {

				Node temp = left;
				left.data = right.data;
				right.data = temp.data;
			}
			left = left.next;
			return left;

		}

	}

	private class HeapMover {
		Node left;
	}

	public void reverseDRHeap() {
		HeapMover mover = new HeapMover();
		mover.left = head;
		reverseDRRHeap(mover, this.head, 0);
	}

	private void reverseDRRHeap(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		reverseDRRHeap(mover, right.next, count + 1);
		if (count >= this.size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;
	}

	public void fold() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;
		fold(mover, this.head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}
		fold(mover, right.next, count + 1);
		if (count > this.size / 2) {

			Node temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;
			mover.left = temp;
		}

		if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public int mid() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node f = this.head;
		Node s = this.head;

		while (s.next != null && s.next.next != null) {
			s = s.next.next;
			f = f.next;
		}
		return f.data;
	}

	public int kthFromLast(int k) {

		Node fast = this.head;
		Node slow = this.head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;
		while (this.size != 0) {

			LinkedList curr = new LinkedList();

			for (int i = 1; i <= k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.size += curr.size;
				prev.tail = curr.tail;
			}
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	public Node midNode() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node f = this.head;
		Node s = this.head;

		while (s.next != null && s.next.next != null) {
			s = s.next.next;
			f = f.next;
		}
		return f;
	}

	public void mergesort() throws Exception {

		if (this.size == 1) {
			return;
		}

		Node midn = midNode();

		Node midnext;
		midnext = midn.next;

		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = midn;
		fh.size = (this.size + 1) / 2;
		midn.next = null;

		LinkedList sh = new LinkedList();
		sh.head = midnext;
		sh.tail = this.tail;
		sh.size = this.size / 2;
		fh.mergesort();
		sh.mergesort();

		LinkedList merged = fh.mergeTwoSortedLL(sh);

		this.head = merged.head;
		this.tail = merged.tail;
		this.size = merged.size;

	}

	private LinkedList mergeTwoSortedLL(LinkedList other) {

		Node first = this.head;
		Node second = other.head;

		LinkedList sorted = new LinkedList();
		while (first != null && second != null) {

			if (first.data < second.data) {
				sorted.addLast(first.data);
				first = first.next;
			} else {
				sorted.addLast(second.data);
				second = second.next;
			}
		}
		while (first != null) {
			sorted.addLast(first.data);
			first = first.next;
		}
		while (second != null) {
			sorted.addLast(second.data);
			second = second.next;
		}

		return sorted;
	}

	public void createDummyList() {

		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 3;
		Node n4 = new Node();
		n4.data = 4;
		Node n5 = new Node();
		n5.data = 5;
		Node n6 = new Node();
		n6.data = 6;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n3;
		this.head = n1;
		this.tail = null;
	}

	public void detectRemoveLoop() {

		Node fast = this.head;
		Node slow = this.head;
		int countloop = 0;
		while (fast != null && fast.next != null) {

			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast) {
				while (slow.next != fast) {
					slow = slow.next;
					countloop++;
				}
				countloop++;
				slow = slow.next;
				break;
			}
		}

		System.out.println(countloop);

		if (slow == fast) {
			System.out.println("LOOP DETECTED");
			Node loop = slow;
			Node start = this.head;
			while (loop.next != start.next) {
				loop = loop.next;
				start = start.next;
			}
			loop.next = null;
		} else {
			System.out.println("NO LOOP");
		}
	}
}
