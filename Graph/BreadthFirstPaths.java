package Graph;

import java.util.Iterator;
import java.util.Stack;

import Queue.Queue;

/**
 * 
 * @author Heaven 使用广度优先查找图
 */
public class BreadthFirstPaths {
	private boolean[] marked;// 标记数组
	private int[] edgeTo;// 标记上位
	private int strat;// 开始位

	public BreadthFirstPaths(Graph G, int s) {// 构造函数
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];// 创建两个数组
		strat = s;// 设置开始位
		find(G, s);
	}

	public void find(Graph G, int s) {// 开始寻找
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);// 加入
		while (!queue.isEmpty()) {// 只要不为空
			int v = queue.dequeue();
			for (int c : G.adj(v)) {
				if (!marked[c]) {// 不存在
					marked[c] = true;
					edgeTo[c] = v;
					queue.enqueue(c);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {// 查看路径
		if (!marked[v]) {// 不存在直接返回
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();// stack设置一个
		for (int i = v; i < strat; i = edgeTo[i]) {
			path.push(i);// 压进去
		}
		path.push(strat);// 最后进去根节点
		return path;
	}
}
