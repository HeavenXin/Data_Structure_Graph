package Directed;


import Bag.Bag2;
import edu.princeton.cs.algs4.In;

public class EdgeweightedDigraph {
	private final int V;// 顶点长度
	private int E;// 边的数
	private Bag2<DirectedEdge>[] adj;// 邻接表

	public EdgeweightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag2<DirectedEdge>[]) new Bag2[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag2<DirectedEdge>();
		}
	}

	public EdgeweightedDigraph(In in) {
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			addEdge(new DirectedEdge(v, w, weight));
		}
	}

	public void addEdge(DirectedEdge edge) {
		adj[edge.from()].add(edge);// 给过来的点添加边
	}

	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}

	public Iterable<DirectedEdge> Edges() {
		Bag2<DirectedEdge> edges= new Bag2<DirectedEdge>();
		for (int i = 0; i < V; i++) {
			for (DirectedEdge e : adj[i]) {
				edges.add(e);
			}
		}
		return edges;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

}
