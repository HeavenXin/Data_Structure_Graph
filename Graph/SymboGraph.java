package Graph;

import SequentialSearchST.SequentialSearchST;
import edu.princeton.cs.algs4.In;

public class SymboGraph {
	private SequentialSearchST<String,Integer>st;//创建一个符号表,符号名,索引
	private String[] keys;//索引,符号名
	private Graph G;//图,记录连接
	public SymboGraph(String filename,String delim) {//构造方法
		st= new SequentialSearchST<String, Integer>();
		In in = new In(filename);
		while (in.hasNextLine()) {//持续输入
			String []  a= in.readLine().split(delim);
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i])) {
					st.put(a[i], st.size());//把链表本身数量当值
				}
			}
		}
		keys = new String[st.size()];//创建一个数组
		for (String string : st.keys()) {
			keys[st.get(string)] = string;//反向索引	
		}
		G = new Graph(st.size());//建造图
		in = new In(filename);//再次获取.用于建造图
		while (in.hasNextLine()) {
			String []a =in.readLine().split(delim);//创建数组
			int v = st.get(a[0]);//获取第一位的索引
			for (int i = 1; i < a.length; i++) {
				G.addEdge(v, st.get(a[i]));
			}
		}
	}
	public boolean contains(String x) {
		return st.contains(x);
	}
	public int index(String s) {
		return st.get(s);
	}
	public String name(int v) {
		return keys[v];
	}
	public Graph G() {
		return G;
	}
}
