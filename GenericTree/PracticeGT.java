package GenericTree;
import java.util.ArrayList;
import java.util.Scanner;
public class PracticeGT {
	Scanner sc = new Scanner(System.in);
	class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	private Node root;
	public PracticeGT() {
		this.root = construct(null, -1);
	}
	private Node construct(Node parent, int i) {
		if (parent == null) {
			System.out.println(" enter root data");
		} else {
			System.out.println("enter data for ith node");
		}
		int n = sc.nextInt();
		Node nn = new Node();
		nn.data = n;
		System.out.println("Child for this Node");
		int noc = sc.nextInt();
		for (int p = 0; i < noc; p++) {
			Node child = construct(nn, p);
			nn.children.add(child);
		}
		return nn;
	}
	public void display() {
		System.out.println("-------------");
		display(this.root);
		System.out.println("-------------");
	}
	private void display(Node node) {
	}
}
