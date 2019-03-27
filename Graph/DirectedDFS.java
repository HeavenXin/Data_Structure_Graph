package Graph;
/**
 * 
 * @author Heaven
 * 	利用深度优先的方法进行查找有序图中的连通点
 *
 */
public class DirectedDFS {
	private boolean[] marked;
	public DirectedDFS(Graph G,int v) {//构造方法1
		marked = new boolean[G.V()];
		dfs(G,v);
	}
	public DirectedDFS(Graph G,Iterable<Integer> sources) {
		marked =new boolean[G.V()];
		for (Integer integer : sources) {
			if (!marked[integer]) {
				dfs(G, integer);
			}
		}
	}
	private void dfs(Graph g, int v) {
		marked[v] = true;
		for (int a : g.adj(v)) {//遍历
			if (!marked[a]) {
				dfs(g, a);
			}
		}
	}
	public boolean marked(int v) {
		return marked[v];
	}
	
}
