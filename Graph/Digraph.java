package Graph;

import java.io.IOException;
import java.io.InputStream;

import Bag.Bag2;

public class Digraph {
	private int v;// 静态无法改变
	private int E;
	private Bag2<Integer>[] adj;

	public Digraph(int v) {
		this.v = v;
		E = 0;
		adj = (Bag2<Integer>[]) new Bag2[v];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Bag2<Integer>();
		}
	}
	public Digraph(InputStream input) throws IOException {//获取输入
		this(input.read());//读取V
		int E = input.read();
		for (int i = 0; i < E; i++) {
			int v= input.read();
			int w= input.read();
			addEdge(v,w);
		}
	}
	public int V() {
		return v;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public Digraph reverse() {
		Digraph temp = new Digraph(v);
		for (int i = 0; i < adj.length; i++) {
			for (int w : adj[i]) {
				temp.addEdge(w, i);//反向添加
			}
		}
		return temp;
	}
}
