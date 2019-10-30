package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GTASGN {
	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GTASGN() {
		this.root = construct(null, -1);
	}

	// create the ith child of parent
	private Node construct(Node parent, int ith) {
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for  " + ith + " child of " + parent.data);
		}

		int item = sc.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println("No of children for " + nn.data);
		int noc = sc.nextInt();

		for (int i = 0; i < noc; i++) {
			Node child = construct(nn, i);
			nn.children.add(child);
		}
		return nn;
	}

	public void display() {
		System.out.println("--------------------");
		display(this.root);
		System.out.println("--------------------");
	}

	private void display(Node node) {

		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (int i = 0; i <= node.children.size() - 1; i++) {
			display(node.children.get(i));
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {

		int sum = 0;
		for (Node child : node.children) {
			sum += size(child);
		}

		return sum + 1;
	}

	public int max() {

		return max(this.root);
	}

	private int max(Node node) {

		int max = node.data;
		for (Node child : node.children) {
			int cm = max(child);
			max = Math.max(max, cm);

		}
		return max;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}
//	private boolean find(Node node, int item) {
//
//		if (item == node.data) {
//			return true;
//		}
//		boolean ans = false;
//		for (Node child : node.children) {
//			if (item == child.data)
//				return true;					//wrong here works only for right most branch	
//			ans = find(child, item);
//		}
//
//		return ans;
//	}

	private boolean find(Node node, int item) {

		if (item == node.data) {
			return true;
		}
		boolean ans = false;
		for (Node child : node.children) {
			ans = find(child, item);   // or use ans=ans||find(child) remove -- if(ans)
			if (ans)
				return true;
		}

		return ans;
	}

	public int height() {

		return height(this.root);
	}

	private int height(Node node) {

		int size = -1; // for zero size of tree

		for (Node child : node.children) {
			int sz = height(child);
			size = Math.max(sz, size);
		}
		return size + 1;
	}

	public void mirrorTree() {

		mirrorTree(this.root);
	}

	private void mirrorTree(Node node) {

		int i = 0;
		int j = node.children.size() - 1;
		while (i < j) {

			Node l = node.children.get(i);
			Node r = node.children.get(j);
			node.children.set(i, r);
			node.children.set(j, l);
			i++;
			j--;
		}
		for (Node child : node.children) {
			mirrorTree(child);
		}

	}

	public void preOrder() {
		preOreder(this.root);
	}

	private void preOreder(Node node) {

		System.out.print(node.data + ".");
		for (Node child : node.children) {
			preOreder(child);
		}
	}

	public void postOrder() {
		postOreder(this.root);
	}

	private void postOreder(Node node) {
		for (Node child : node.children) {
			postOreder(child);
		}
		System.out.print(node.data + ",");
	}

	public void leverOrder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				queue.addLast(child);

			}

		}
		System.out.println();
	}

	public void levelOrderLW() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.addLast(this.root);

		while (!primary.isEmpty()) {

			Node rn = primary.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				helper.addLast(child);
			}

			if (primary.isEmpty()) {
				System.out.println();
				primary = helper;
				helper = new LinkedList<>();

			}
		}
	}

	public void levelOrderZZ() {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.addLast(this.root);
		int count = 0;
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");
			if (count % 2 == 0) {
				for (Node child : rn.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--)
					stack.addFirst(rn.children.get(i));
			}
			if (queue.isEmpty()) {
				count++;
				System.out.println();
				queue = stack;
				stack = new LinkedList<>();
			}
		}
	}

	public void printAtLevel(int level) {
		printAtLevel(this.root, 0, level);
	}

	private void printAtLevel(Node node, int count, int level) {
		// TODO Auto-generated method stub
		if (count == level)
			System.out.println(node.data);
		for (Node child : node.children)
			printAtLevel(child, count + 1, level);
	}

	private class Heapmover {
		int size = 0;
		int max = Integer.MIN_VALUE;
		int height = 0;
		boolean find = false;
		Node pred;
		Node succ;
		Node jl;
	}

	public void multiSolver(int item) {
		Heapmover mover = new Heapmover();
		multSolver(this.root, item, 0, mover);
		System.out.println("SIZE :" + mover.size);
		System.out.println("MAX :" + mover.max);
		System.out.println("HEIGHT :" + mover.height);
		System.out.println("find " + item + " :" + mover.find);
		System.out.println("pred " + item + " :" + (mover.pred == null ? null : mover.pred.data));
		System.out.println("succ " + item + " :" + (mover.succ == null ? null : mover.succ.data));
		System.out.println("jl " + item + " :" + (mover.jl == null ? null : mover.jl.data));
	}

	private void multSolver(Node node, int item, int count, Heapmover mover) {
		mover.size++;

		if (count > mover.height)
			mover.height = count;

		if (node.data > mover.max)
			mover.max = node.data;

		if (node.data > item) {
			if (mover.jl == null || mover.jl.data > node.data)
				mover.jl = node;
		}
		if (mover.find == true && mover.succ == null)
			mover.succ = node;

		if (node.data == item)
			mover.find = true;

		if (mover.find == false)
			mover.pred = node;

		for (Node child : node.children)
			multSolver(child, item, count + 1, mover);

	}
//
//	private class HeapMover2 {
//		int pre;
//		int suc;
//		int justLarger;
//	}
//
//	public void multiSolver2(int item) {
//		HeapMover2 mover = new HeapMover2();
//		multiSolver2(this.root, item, mover);
//	}
//
//	private void multiSolver2(Node node, int item, HeapMover2 mover) {
//		
//		
//	if(item==node.data) {
//		
//	}

}
