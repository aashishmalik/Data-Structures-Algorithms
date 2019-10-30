package Heap;

import java.util.ArrayList;

import Generics.Cars;

public class HeapGClient {

	public static void main(String[] args) {

		HeapGeneric<Cars> heapg = new HeapGeneric<>();

		Cars[] car = new Cars[5];
		car[0] = new Cars(10, 206, "red");
		car[1] = new Cars(20, 203, "green");
		car[2] = new Cars(600, 210, "black");
		car[3] = new Cars(80, 250, "blue");
		car[4] = new Cars(90, 200, "white");

		for (int i = 0; i < car.length; i++) {
			heapg.add(car[i]);
		}

//		while (!heapg.isEmpty()) {
//			System.out.println(heapg.remove());
//			heapg.display();
//		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);
		list.get(0).add(40);
		list.get(1).add(2);
		list.get(1).add(3);
		list.get(1).add(5);
		list.get(1).add(7);
		list.get(2).add(6);
		list.get(2).add(15);
		list.get(2).add(23);
		list.get(2).add(50);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(9);
		list2.add(1);
		list2.add(15);
		list2.add(3);
		list2.add(26);
		list2.add(99);
		list2.add(54);
		list2.add(16);

		// System.out.println(mergeSortLists(list));
		
		System.out.println(kLargestElemensts(list2,4));

	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int idxNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}

	}

	public static ArrayList<Integer> mergeSortLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();
		for (int i = 0; i < lists.size(); i++) {

			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.idxNo = 0;
			np.listNo = i;
			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);

			rp.idxNo++;

			if (rp.idxNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);
			}
		}
		return ans;
	}

	public static ArrayList<Integer> kLargestElemensts(ArrayList<Integer> list,int k) {

		ArrayList<Integer> ans = new ArrayList<>();
		HeapGeneric<Integer> heap=new HeapGeneric<Integer>();
		
		for(int i=0;i<k;i++) {
			heap.add(list.get(i));
		}
		System.out.println(heap.getHP());
		int j=k;
		while(j<list.size()) {
			//changed CompareTo method here (change for previous ques)
			if(heap.getHP()>list.get(j)){	
				
			}else
			{
				heap.remove();
				heap.add(list.get(j));
			}
			j++;
		}
		
		while(!heap.isEmpty()) {
			ans.add(heap.remove());
		}
		return ans;
	}
}
