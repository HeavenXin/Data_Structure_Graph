package weightedgraph;

import Graph.Graph;
import edu.princeton.cs.algs4.IndexMinPQ;
/**
 * 
 * @author Heaven
 *	优化的思路为,按顺序添加最小的边的长度,然后不停的修改已经有的边
 *	把遍历到的比连接到相同结点的边,取权重小的边替换现有队列中的边
 *
 */
public class PrimMST {
	private Edge[] edgeTo;//距离树最近的边
	private double[] distTo;//保存edge中对应的权重;
	private boolean[] marked;//判断是否已经在树中
	private IndexMinPQ<Double> pq;//有效的横切边
	public PrimMST(EdgeWeightedGraph G) {
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;//设置为无限大
		}
		pq = new IndexMinPQ<Double>(G.V());
		distTo[0] = 0.0;//初识化0位
		pq.insert(0, 0.0);//开始插入
		while (!pq.isEmpty()) {//只要不为空
			Visit(G,pq.delMin());
		}
	}
	
	private void  Visit(EdgeWeightedGraph G,int V) {
		marked[V] = true;//加入树中
		for (Edge n : G.adj(V)) {//遍历顶点V的所有边
			int m = n.other(V);//查询对立的边
			if (marked[m]) {
				continue;//如果已经对点已经在树中,跳过
			}
			if (n.weight()<distTo[m]) {//如果小于已经记录的权重
				edgeTo[m] = n;//改变连接树和w的最佳边
				distTo[m] = n.weight();
				if (pq.contains(m)) {//如果列表中已经存在了
					pq.change(m, distTo[m]);//更改
				}else {
					pq.insert(m, distTo[m]);//(由于默认的边是无穷大)插入
				}
			}
		}
	}
}
