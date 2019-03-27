package weightedgraph;
import weightedgraph.Edge;
import java.io.IOException;
import java.io.InputStream;

import Bag.Bag2;
import edu.princeton.cs.algs4.Bag;

import edu.princeton.cs.algs4.In;

public class EdgeWeightedGraph {
	private int V;
	private int E;
	private Bag2<weightedgraph.Edge>[] adj;// 创建一个邻接表

	public EdgeWeightedGraph(int V) {
		this.V = V;
		E = 0;
		adj = (Bag2<Edge>[]) new Bag2[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag2<Edge>();
		}
	}

	public EdgeWeightedGraph(In input) {
		// 获取输入
		this(input.readInt());// 读取V
		int E = input.readInt();
		for (int i = 0; i < E; i++) {
			int v = input.readInt();
			int w = input.readInt();
			double weight = input.readDouble();
			Edge edge = new Edge(v, w, weight);
			addEdge(edge);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) {
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;// 新增一个
	}

	public Iterable<Edge> edges() {
		Bag<Edge> list = new Bag<Edge>();
		for (int v = 0; v < V; v++) {
			int count = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}

				else if (e.other(v) == v) {
					if (count % 2 == 0)
						list.add(e);
					count++;
				}
			}
		}
		return list;
	}

	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E );
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (Edge e : adj[v]) {
				s.append(e + "  ");
			}

		}
		return s.toString();
	}

}
