package weightedgraph;

import edu.princeton.cs.algs4.*;

/**
 * 
 * @author Heaven 即创建一个优先队列保存所有的权重,一个union-find数据类型来识别已经保存的边,一个队列保存所有最小生成树的所有
 *         然后从小到大的顺序遍历权重,添加到最小生成树的队列,同时用union-find数据类型识别是否可以被添加进去
 */
public class KruskalMST {
	private Queue<Edge> mst;// 保存最小树的权重

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>(G.edges());
		UF uf = new UF(G.V());
		while ((mst.size() < G.V() - 1) && (!pq.isEmpty())) {// 如果不为空且数量小于V-1
			Edge edge = pq.delMin();
			int v = edge.either();
			int w = edge.other(v);
			if (uf.connected(v, w))// 如果已经存在,pass
				continue;
			uf.union(v, w);// 并上权数
			mst.enqueue(edge);// 添加上去
		}

	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight() {
		int total = 0;
		for (Edge edge : mst) {
			total += edge.weight();
		}
		return total;
	}
}
