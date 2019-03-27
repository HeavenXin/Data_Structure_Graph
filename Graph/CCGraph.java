package Graph;

import java.awt.Point;

/**
 * 
 * @author Heaven
 *	查找一个树中有多少连通树,并且方便我们调用是否连通
 */
public class CCGraph {
	private int[] id;
	private boolean[] marked;
	private int count;

	public CCGraph(Graph G) {
		id = new int[G.V()];
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				search(G, i);
				count++;// 发现新子树,标记加1
			}
		}
	}

	private void search(Graph G, int s) {// 进行查找
		marked[s] = true;// 设置为ture,已经找了
		id[s] = count;
		for (int i : G.adj(s)) {// 查询所有相邻的
			if (!marked[i]) {// 如果没被标记
				search(G, i);
			}
		}
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
		
	}
	
}
