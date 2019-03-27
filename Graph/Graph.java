package Graph;

import java.io.IOException;
import java.io.InputStream;

import Bag.Bag2;

/**
 * 
 * @author Heaven
 *	实现邻接表数组
 */
public class Graph {
	private int V;//顶点树
	private int E;//边数
	private Bag2<Integer>[] adj;
	public Graph(int V) {
		this.V = V;//赋值过去
		this.E = 0;
		adj =(Bag2<Integer>[]) new Bag2[V]; //创建一个链表
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Bag2<Integer>();
		}
	}
	public Graph(InputStream input) throws IOException {
		this(input.read()) ;
		int E = input.read();//读取
		for (int i = 0; i < E; i++) {
			int v= input.read();
			int w= input.read();
			addEdge(v,w);
		}
	}
	public Iterable<Integer> adj(int v) {
		return adj[v];//查找相邻的
		
		
	}
	public  void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);//相互添加
		E++;
	}
	public int V() {
		return V;
	}
	public int E() {
		return E;
	}
}
