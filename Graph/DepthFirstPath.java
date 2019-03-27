package Graph;

import java.util.Stack;

public class DepthFirstPath {
	private boolean[] marked;//判断是否标定
	private int[] edgeTo;//判断走到根节点的上一个
	private final int s;//根节点
	public DepthFirstPath(Graph G,int s) {//构造方法
		this.s = s;
		marked = new boolean[G.V()];//创建新的数组
		edgeTo = new int[G.V()];
		search(G,s);
	}
	private void search(Graph G,int s) {//进行查找
		marked[s] = true;//设置为true,已经找了
		for (int i : G.adj(s)) {//查询所有相邻的
			if (!marked[i]) {//如果没被标记
				edgeTo[i] = s;//记录上一步
				search(G, i);
			}
		}
	}
	public boolean hasPathTo(int v) {//看是否被标记
		return marked[v];
	}
	public Iterable<Integer>pathTo(int v){//查看路径
		if (!marked[v]) {//不存在直接返回
			return  null;
		}
		Stack<Integer>path = new Stack<Integer>();//stack设置一个
		for (int i = v; i < s; i = edgeTo[i]) {
			path.push(i);//压进去
		}
		path.push(s);//最后进去根节点
		return  path;
	}
}
