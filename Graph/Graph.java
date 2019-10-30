package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private static HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() {
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);

		for (String nbr : vtx.nbrs.keySet()) {

			Vertex nbrVtx = vtces.get(nbr);
			nbrVtx.nbrs.remove(vname);
		}

		vtces.remove(vname);

	}

	public int numEdges() {

		int sum = 0;

		for (String key : vtces.keySet()) {

			Vertex vtx = vtces.get(key);
			sum += vtx.nbrs.size();

		}

		return sum / 2;
	}

	public static boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {

		System.out.println("==============");

		for (String key : vtces.keySet()) {
			System.out.println(key + " -> " + vtces.get(key).nbrs);
		}

		System.out.println("===============");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		if (containsEdge(src, dst)) {
			return true;
		}
		Vertex vtx = vtces.get(src);
		for (String nbr : vtx.nbrs.keySet()) {

			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}
		return false;
	}

	private class Pair {
		String name;
		String psf;
		String color;
	}

	public boolean BFS(String src, String dst) {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;
		queue.addLast(sp);

		while (!queue.isEmpty()) {

			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.name)) {
				continue;
			}
			processed.put(rp.name, true);

			if (containsEdge(rp.name, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			Vertex vtx = vtces.get(rp.name);
			for (String nbr : vtx.nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
			}

		}
		return false;
	}

	public boolean DFS(String src, String dst) {

		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		Pair sp = new Pair();
		sp.name = src;
		sp.psf = src;
		stack.addFirst(sp);

		while (!stack.isEmpty()) {

			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.name)) {
				continue;
			}
			processed.put(rp.name, true);

			if (containsEdge(rp.name, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			Vertex vtx = vtces.get(rp.name);
			for (String nbr : vtx.nbrs.keySet()) {
				if (!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.name = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
			}

		}
		return false;
	}

	public void BFT() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				processed.put(rp.name, true);

				System.out.println(rp.name + " Via " + rp.psf);

//				if (containsEdge(rp.name, dst)) {
//					System.out.println(rp.psf + dst);
//					return true;
//				}

				Vertex vtx = vtces.get(rp.name);
				for (String nbr : vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}

			}
		}

	}

	public void DFT() {

		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) // for disconnected graph
				continue;

			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			stack.addFirst(sp);

			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				processed.put(rp.name, true);

//				if (containsEdge(rp.name, dst)) {
//					System.out.println(rp.psf + dst);
//					return true;
//				}

				System.out.println(rp.name + " Via " + rp.psf);

				Vertex vtx = vtces.get(rp.name);
				for (String nbr : vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst(np);
					}
				}
			}
		}
	}

	public boolean isConnected() {

		int connected = 0;
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (!processed.containsKey(src)) { // times visited return no of components
				continue;
			}
			connected++;
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}
				processed.put(rp.name, true);

//				if (containsEdge(rp.name, dst)) {
//					System.out.println(rp.psf + dst);
//					return true;
//				}

				// System.out.println(rp.name + " Via " + rp.psf);

				Vertex vtx = vtces.get(rp.name);
				for (String nbr : vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
		if (connected > 1)
			return false;
		else
			return true;
	}

	public boolean isCyclic() {

		int cyclic = 0;
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					cyclic = 1;
					continue;
				}

				if (cyclic == 1)
					return true;

				processed.put(rp.name, true);

//				if (containsEdge(rp.name, dst)) {
//					System.out.println(rp.psf + dst);
//					return true;
//				}

				// System.out.println(rp.name + " Via " + rp.psf);

				Vertex vtx = vtces.get(rp.name);
				for (String nbr : vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}
			}
		}
		return false;
	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getComponents() {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			ArrayList<String> component = new ArrayList<>();
			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				processed.put(rp.name, true);

				component.add(rp.name);
				// System.out.println(rp.name + " Via " + rp.psf);

//				if (containsEdge(rp.name, dst)) {
//					System.out.println(rp.psf + dst);
//					return true;
//				}

				Vertex vtx = vtces.get(rp.name);
				for (String nbr : vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
				}

			}
			ans.add(component);
		}

		return ans;
	}

	public boolean isBipartite() {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, String> processed = new HashMap<>();

		for (String src : vtces.keySet()) {

			if (processed.containsKey(src)) {
				continue;
			}

			Pair sp = new Pair();
			sp.name = src;
			sp.psf = src;
			sp.color = "r";
			queue.addLast(sp);

			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {

					String oc = processed.get(rp.name);
					String nc = rp.color;
					if (!oc.equals(nc)) {
						return false;
					}
					continue;
				}
				processed.put(rp.name, rp.color);

//			if (containsEdge(rp.name, dst)) {
//				System.out.println(rp.psf + dst);
//				return true;
//			}

				Vertex vtx = vtces.get(rp.name);
				for (String nbr : vtx.nbrs.keySet()) {
					if (!processed.containsKey(nbr)) {

						Pair np = new Pair();
						np.name = nbr;
						np.psf = rp.psf + nbr;
						np.color = rp.color.equals("r") ? "g" : "r";
						queue.addLast(np);
					}
				}
			}
		}
		return true;

	}
}