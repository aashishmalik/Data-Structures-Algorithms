package DSPractice;

class LL {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("Empty List");
		}
		return this.tail.data;
	}

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (this.size > 0)
			nn.next = this.head;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}
	}

	public void addLast(int item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (this.size > 0)
			this.tail.next = nn;

		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	public int getAt(int idx) throws Exception {
		if (this.size - 1 < idx)
			throw new Exception("Invalid index");

		if (idx == 0)
			return getFirst();
		else if (idx == this.size - 1)
			return getLast();
		else {
			Node temp = new Node();
			temp = head;
			int i = 1;
			while (i <= idx) {
				temp = temp.next;
				i++;
			}
			return temp.data;

		}
	}

	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("List Empty");
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
		if (this.size == 0)
			throw new Exception("LIst empty");

		System.out.println("----------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("----------------");

	}

//	public void addAt(int idx, int item) throws Exception {
//		if (idx < 0 || idx > this.size + 1)
//			throw new Exception("Invalid Index");
//		if (idx == 0)
//			addFirst(item);
//		else if (idx == this.size)
//			addLast(item);
//		else {
//			int i = 0;
//			Node temp = this.head;
//			Node nn = new Node();
//			nn.data = item;
//			nn.next = null;
//			while (i < idx - 1) {
//				temp = temp.next;
//				i++;
//			}
//			nn.next = temp.next;
//			temp.next = nn;
//			this.size++;
//		}

//	public int removeAt(int idx) {
//
//	}
//
//	public int removeLast(int idx) {
//
//	}
//
//	public int removeLast(int idx) {
//
//	}

	public void reverseData() throws Exception {
		int i = 0;
		int j = this.size - 1;
		while (i < j) {
			Node l1 = getNodeAt(i);
			Node l2 = getNodeAt(j);
			int temp = l1.data;
			l1.data = l2.data;
			l2.data = temp;
			i++;
			j--;

		}

	}

	public void reversePointer() throws Exception {

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

	public void reversePointerR() {
		reversePointerR(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePointerR(Node prev, Node curr) {

		if (curr == null)
			return;

		reversePointerR(curr, curr.next);
		curr.next = prev;

	}

	public void reverseDataR() {
		
		reverseDataR();
		
		
		
	}

	
}

public class LLClient {
	public static void main(String[] args) throws Exception {
		LL list = new LL();

		list.addFirst(10);
		list.addFirst(20);
		list.addLast(30);
		list.addFirst(40);
		list.addLast(50);

		System.out.println(list.getAt(3));

		list.display();
		list.reverseData();
		list.reversePointerR();
		list.display();
	}
}
