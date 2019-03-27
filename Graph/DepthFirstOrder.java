package Graph;

import java.util.Stack;

import Queue.Queue;

/**
 * 
 * @author Heaven 使用各类的顺序去遍历搜索经过的结点
 */
public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;

	public DepthFirstOrder(Digraph G) {
		pre = new Queue<Integer>();//按照遍历顺序
		post = new Queue<Integer>();//按照遍历完成的顺序
		reversePost = new Stack<Integer>();//按照遍历完成,组成一个栈
		marked = new boolean[G.V()];
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i]) {
				search(G, i);
			}
		}
	}

	private void search(Digraph G, int s) {// 进行查找
		pre.enqueue(s);
		marked[s] = true;// 设置为ture,已经找了
		for (int i : G.adj(s)) {// 查询所有相邻的
			if (!marked[i]) {// 如果没被标记
				search(G, i);
			}
		}
		post.enqueue(s);
		reversePost.push(s);
	}
	public Queue<Integer> pre(){
		return pre;
	}
	public Queue<Integer>post(){
		return post;
	}
	public Iterable<Integer>reversePost(){
		return reversePost;
	}
}
