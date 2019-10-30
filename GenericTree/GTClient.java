package GenericTree;

public class GTClient {
	
	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0
		GTASGN gt = new GTASGN();
		gt.display();
		System.out.println(gt.size());
		System.out.println();
		System.out.println(gt.max());
		System.out.println(gt.find(50));
		System.out.println(gt.height());
		// gt.mirrorTree();
		gt.display();
		// gt.preOrder();
		System.out.println();
		// gt.postOrder();
		//gt.leverOrder();
		//gt.levelOrderLW();
		//gt.levelOrderZZ();
		//gt.printAtLevel(1);
		
		gt.multiSolver(50);
	}

}