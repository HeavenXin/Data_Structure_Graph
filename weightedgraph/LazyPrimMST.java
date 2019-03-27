package weightedgraph;

import edu.princeton.cs.algs4.*;

public class LazyPrimMST {
	private boolean[] marked;
	private Queue<Edge> mst;//最小树的边
	private MinPQ<Edge> pq;//最小优先队列(保存横切边)	
	public LazyPrimMST(EdgeWeightedGraph G) {
		marked = new boolean[G.V()];
		pq = new MinPQ<Edge>();
		mst = new Queue<Edge>();
		Visit(G, 0);//添加第一条
		while (!pq.isEmpty()) {//只要不为空
			Edge edge = pq.delMin();//删除最小值
			int v =edge.either(),w =edge.other(v);
			if (marked[v]&&marked[w]) 
				continue;
			mst.enqueue(edge);//添加到边
			if (!marked[v]) {//将边添加到树中
				Visit(G, v);
			}
			if (!marked[w]) {
				Visit(G, w);
			}
		}
	}
	private void  Visit(EdgeWeightedGraph G,int V) {
		marked[V] = true;
		for (Edge n : G.adj(V)) {
			if (!marked[n.other(V)]) {//如果另一条边每标记过
				pq.insert(n);
			}
		}
	}
	public Iterable<Edge> edges(){
		return  mst;
	}
	public double weight() {
		double weight = 0; 
		for (Edge b : mst) {
			weight +=b.weight();
		}
		return weight;
	}
}
