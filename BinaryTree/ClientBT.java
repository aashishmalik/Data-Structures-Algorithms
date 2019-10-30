package BinaryTree;

public class ClientBT {

	public static void main(String[] args) {

		// 10 true 20 true 40 false false true 50 false false true 30 false false

		// diameter
//10 true 20 true 30 true 40 true 50 false false false true 60 false true 70 false true 80 false false true 90 false false 
		
		int[] pre= {10,20,40,50,100,80,30,70,90};
		//int[] post= {40,20,60,70,50,30,10};
		int[] in= {40,20,100,50,80,10,70,30,90};
		
		BinaryTree bt = new BinaryTree(pre,in);//pre order
		bt.display();
		//BinaryTree bt = new BinaryTree(post,in);//post order const
		//bt.display();
//		System.out.println("MAX : " + bt.max());
//		System.out.println("height : " + bt.height());
//		System.out.println("find : " + bt.find(50));
//		System.out.println("Diameter : " + bt.diameter());
//		System.out.println("Diameter2 : " + bt.diameter2());
//		System.out.println(bt.isBalanced());
//		bt.preOrderR();
//		System.out.println("=================");
//		bt.preOrderIterative();
//		System.out.println(bt.isBST());
		bt.verticalOrderDisplay();
		
	}

}
