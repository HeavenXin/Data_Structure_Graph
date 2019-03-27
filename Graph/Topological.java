package Graph;
/**
 * 
 * @author Heaven
 *	拓补排序
 */
public class Topological {
	private Iterable<Integer> order;
	public Topological(Digraph G) {//查找有无有向环
		DirectedCycle dCycle = new DirectedCycle(G);
		if (!dCycle.hasCycle()) {
			DepthFirstOrder dOrder = new DepthFirstOrder(G);
			order = dOrder.reversePost();
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	private boolean isDAG() {
		return order!=null;
	}
}
