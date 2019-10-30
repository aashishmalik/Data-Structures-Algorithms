package BinarySearchTree;

public class Client {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		BST bst = new BST(in);
		bst.display();
//		System.out.println();
//		// bst.printDesc();
//		// System.out.println(bst.find(50));
//		// System.out.println(bst.max());
//		System.out.println();
//		System.out.println("==============");
//		// bst.printLowHi(15, 85);
//		// bst.replaceLarger();
//		System.out.println();
//		System.out.println("==================");
//		bst.display();
		System.out.println("================");
//		bst.addItem(55);
//		bst.display();
//		System.out.println(bst.max());
		bst.remove(50);
		bst.display();

	}

}
