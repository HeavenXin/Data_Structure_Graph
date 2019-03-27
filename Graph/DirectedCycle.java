package Graph;
/**
 * 
 * @author Heaven
 *	此方法只为了查找有向图中是否具有有向环
 *		并返回有向环的顺序
 */

import java.util.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private boolean[] onStack;// 用于判断是否成环
	private int[] edgeTo;
	private Stack<Integer> cycle;// 承载顺序

	public DirectedCycle(Digraph G) {
		onStack = new boolean[G.V()];
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				search(G, i);
			}
		}
	}

	private void search(Digraph G, int s) {// 进行查找
		onStack[s] = true;
		marked[s] = true;// 设置为ture,已经找了
		for (int i : G.adj(s)) {// 查询所有相邻的
			if (this.hasCycle()) {
				return;
			} else if (!marked[i]) {// 如果没被标记
				edgeTo[i] = s;// 记录上一步
				search(G, i);
			}else if (onStack[s]) {//如果被标记了,就看看是否回环
				cycle = new Stack<Integer>();
				for (int x = s; x != i; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(i);
				cycle.push(s);
			}
		}
	}

	public boolean hasCycle() {
		return cycle!=null;
	}
	public Iterable<Integer> Cycle(){
		return cycle;
	}
}
