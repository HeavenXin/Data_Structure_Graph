package Graph;
/**
 * 
 * @author Heaven
 *	计算强通性分量
 */
public class KosarajuSCC {
	private int[] id;
	private boolean[] marked;
	private int count;

	public KosarajuSCC(Digraph G) {
		id = new int[G.V()];
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				search(G, i);
				count++;// 发现新子树,标记加1
			}
		}
	}

	private void search(Digraph G, int s) {// 进行查找
		marked[s] = true;// 设置为ture,已经找了
		DepthFirstOrder dOrder = new DepthFirstOrder(G.reverse());
		id[s] = count;
		for (int i : dOrder.reversePost()) {// 查询所有相邻的
			if (!marked[i]) {// 如果没被标记
				search(G, i);
			}
		}
	}
	public boolean stronglyconnected(int v, int w) {
		return id[v] == id[w];
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
		
	}
	
}