package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class BinaryTree {

	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		this.root = construct(null, true);
	}

	private Node construct(Node node, boolean ilc) {

		if (node == null) {
			System.out.println("Enter data for root node");
		} else {
			if (ilc)
				System.out.println("Enter data for left child of" + node.data);
			else
				System.out.println("Enter data for right child of" + node.data);
		}

		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println("has left child");
		boolean hlc = sc.nextBoolean();
		if (hlc)
			nn.left = construct(nn, true);

		System.out.println("has right child");
		boolean hrc = sc.nextBoolean();
		if (hrc)
			nn.right = construct(nn, false);

		return nn;
	}

	public void display() {
		System.out.println();
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

		// dont check node.left since it will allso be a new node and will be null
		int lmax = max(node.left);

		int rmax = max(node.right);
		return node.data > Math.max(lmax, rmax) ? node.data : Math.max(lmax, rmax);
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

		if (node == null)
			return false;
		if (node.data == item)
			return true;

		boolean lh = find(node.left, item);
		boolean rh = find(node.right, item);

		return lh || rh;

	}

// all are O(n) but diameter is of O(n2)
	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null)
			return 0;
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sp = height(node.left) + height(node.right) + 2; // self participation
		return Math.max(sp, Math.max(ld, rd));
	}

	public int diameter2() {

		return diameter2(this.root).diameter;

	}

	private class DiaPair {
		int diameter = 0;
		int ht = -1;
	}

	private DiaPair diameter2(Node node) {

		if (node == null) {
			return new DiaPair();
		}
		DiaPair ldp = diameter2(node.left);
		DiaPair rdp = diameter2(node.right);
		DiaPair np = new DiaPair();

		np.ht = Math.max(ldp.ht, rdp.ht) + 1;
		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sp = ldp.ht + rdp.ht + 2;
		np.diameter = Math.max(sp, Math.max(ld, rd));

		return np;
	}

	private class BalPair {

		int ht = -1;
		boolean ans = true;
	}

	public boolean isBalanced() {

		return isBalanced(this.root).ans;
	}

	private BalPair isBalanced(Node node) {
		if (node == null)
			return new BalPair();
		BalPair lb = isBalanced(node.left);
		BalPair rb = isBalanced(node.right);

		BalPair np = new BalPair();
		np.ht = Math.max(lb.ht, rb.ht) + 1;
		int bf = Math.abs(lb.ht - rb.ht);

		if (lb.ans && rb.ans && (bf == 0 || bf == 1))
			np.ans = true;
		else
			np.ans = false;
		return np;
	}

	public void preOrderR() {
		preOrderR(this.root);
	}

	private void preOrderR(Node node) {

		if (node == null)
			return;

		System.out.println(node.data);

		// left
		preOrderR(node.left);

		// right
		preOrderR(node.right);
	}

	class Pair {
		Node node;
		boolean sd, ld, rd;
	}

	public void preOrderIterative() {

		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			Pair tp = stack.getFirst();
			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tp.sd == false) {
				System.out.print(tp.node.data + " ");
				tp.sd = true;
			} else if (tp.ld == false) {
				Pair np = new Pair();
				np.node = tp.node.left;
				stack.addFirst(np);
				tp.ld = true;
			} else if (tp.rd == false) {
				Pair np = new Pair();
				np.node = tp.node.right;
				stack.addFirst(np);
				tp.rd = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	public BinaryTree(int[] pre, int[] in) {

		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		// pre order construction
		if (plo > phi || ilo > ihi) {
			return null;
		}
		Node nn = new Node();
		nn.data = pre[plo];
		int si = -1;

		for (int i = ilo; i <= ihi; i++) {
			if (nn.data == in[i]) {
				si = i;
				break;
			}
		}
		int nel = si - ilo;
		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);
		return nn;
	}

	class BstPair {
		boolean isBst = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
	}

	public boolean isBST() {

		return isBst(this.root).isBst;
	}

	private BstPair isBst(Node node) {

		if (node == null) {
			return new BstPair();
		}

		BstPair lp = isBst(node.left);
		BstPair rp = isBst(node.right);
		BstPair sp = new BstPair();

		sp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min = Math.min(node.data, Math.min(lp.min, rp.min));

		if (node.data > lp.max && node.data < rp.min && lp.isBst && rp.isBst) {
			sp.isBst = true;
			return sp;
		} else {
			sp.isBst = false;
			return sp;
		}
	}

	class VOPair {
		Node node;
		int hlevel;
		int vlevel;

		public String toString() {
			return node.data + " ";
		}
	}

	public void verticalOrderDisplay() {

		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();
		verticalOrderDisplay(this.root, map, 0, 0);

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (Integer key : keys) {

			Collections.sort(map.get(key), new VOPairComparator());
			System.out.println(key + " -> " + map.get(key));
		}
	}

	private void verticalOrderDisplay(Node node, HashMap<Integer, ArrayList<VOPair>> map, int hl, int vl) {

		if (node == null)
			return;

		VOPair np = new VOPair();
		np.node = node;
		np.hlevel = hl;
		np.vlevel = vl;

		if (!map.containsKey(vl))
			map.put(vl, new ArrayList<VOPair>());

		map.get(vl).add(np);

		verticalOrderDisplay(node.left, map, hl + 1, vl - 1);
		verticalOrderDisplay(node.right, map, hl + 1, vl + 1);

	}

	private class VOPairComparator implements Comparator<VOPair> {

		@Override
		public int compare(VOPair o1, VOPair o2) {
			return o1.hlevel - o2.hlevel;
		}

	}

}
