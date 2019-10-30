package BinarySearchTree;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {

		this.root = construct(in, 0, in.length - 1);

	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi)
			return null;

		int mid = (ilo + ihi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);

		return nn;
	}

	public void display() {

		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null)
			str += node.left.data;

		str += " ->" + node.data + "<- ";

		if (node.right != null)
			str += node.right.data;

		System.out.println(str);

		display(node.left);

		display(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		if (node == null)
			return 0;

		int lsum = size(node.left);
		int rsum = size(node.right);

		return lsum + rsum + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node == null)
			return Integer.MIN_VALUE;

		if (node.right != null)
			return max(node.right);
		else
			return node.data;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		if (node == null)
			return -1;
		int lh, rh;

		lh = height(node.left);

		rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}
		if (item < node.data)
			return find(node.left, item);
		else if (item > node.data)
			return find(node.right, item);
		else
			return true;

	}

	public void printDesc() {
		printDesc(this.root);
	}

	private void printDesc(Node node) {

		if (node == null)
			return;
		printDesc(node.right);

		System.out.print(node.data + " ");
		printDesc(node.left);

	}

	public void printLowHi(int lo, int hi) {
		printLowHi(this.root, lo, hi);
	}

	private void printLowHi(Node node, int lo, int hi) {

		if (node == null)
			return;

		if (node.data >= hi)
			printLowHi(node.left, lo, hi);
		else if (node.data < lo)
			printLowHi(node.right, lo, hi);
		else {
			printLowHi(node.left, lo, hi);
			System.out.print(node.data + " ");
			printLowHi(node.right, lo, hi);
		}
	}

	class HeapMover {
		int sum;
	}

	public void replaceLarger() {

		replaceLarger(this.root, new HeapMover());
	}

	private void replaceLarger(Node node, HeapMover mover) {

		if (node == null)
			return;

		replaceLarger(node.right, mover);
		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;
		replaceLarger(node.left, mover);

	}

	public void addItem(int item) {
		addItem(this.root, item);
	}

	private void addItem(Node node, int item) {

		if (node.data > item) {
			if (node.left != null)
				addItem(node.left, item);
			else {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			}
		} else {
			if (node.right != null)
				addItem(node.right, item);
			else {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			}
		}
	}

	public void remove(int item) {

		remove(this.root, null, item);

	}

	private void remove(Node node, Node parent, int item) {
		if (node == null) {
			return;
		}
		if (node.data < item) {
			remove(node.right, node, item);
		} else if (node.data > item) {
			remove(node.left, node, item);
		} else {
			if (node.left == null && node.right == null) {

				if (parent.left == node)
					parent.left = null;
				else
					parent.right = null;

			} else if (node.left != null && node.right == null) {

				if (parent.left == node)
					parent.left = node.left;
				else
					parent.right = node.left;

			} else if (node.right != null && node.left == null) {

				if (parent.right == node)
					parent.right = node.right;
				else
					parent.left = node.right;

			} else {

				int temp = max(node.left);
				remove(node.left, node, temp);
				node.data = temp;

			}
		}

	}

}
