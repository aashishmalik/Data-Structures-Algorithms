package Graph;

public class Client {

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 20);
		graph.addEdge("B", "C", 85);
		graph.addEdge("C", "D", 43);
		graph.addEdge("D", "E", 51);
		graph.addEdge("E", "F", 220);
		graph.addEdge("F", "G", 30);
		graph.addEdge("E", "G", 70);

		graph.display();

		// graph.removeEdge("D", "E");
		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));

		// graph.display();
//
//		System.out.println(graph.BFS("A", "F"));
//		System.out.println(graph.DFS("A", "F"));

		graph.BFT();

		graph.DFT();

		System.out.println(graph.isConnected());
		System.out.println(graph.isCyclic());
		System.out.println(graph.isTree());

//		graph.removeEdge("D", "E");
		System.out.println(graph.getComponents());
		System.out.println(graph.isBipartite());

	}

}
