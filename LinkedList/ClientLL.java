package LinkedList;

public class ClientLL {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.addLast(80);
		list.addLast(25);
		//list.removeLast();
		list.addLast(6);
		list.display();
		//list.display();
		/*System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(4));
		System.out.println(list.removeFirst());*/
		/*list.display();
		System.out.println(list.removeLast());
		list.display();
		System.out.println(list.getAt(4));
		list.removeAt(3);
		list.display();
		list.addFirst(110);
		list.display();
		list.addAt(2, 200);
		list.display();*/
		//list.reverse();
		//list.display();
		//list.reverseP();
		//list.reversePR();
		//list.reverseDR();
		//list.reverseDRHeap();
		//list.fold();
		//System.out.println(list.kthFromLast(3));
		//list.kReverse(3);
//		LinkedList list2=new LinkedList();
//		list2.addLast(1);
//		list2.addLast(2);
//		list2.addLast(3);
//		list2.addLast(100);
//		list2.display();
//  	list.mergesort();
		list.createDummyList();
//		list.display();
		list.detectRemoveLoop();
		list.display();
		
		
		//System.out.println(list.mid());
	}

}