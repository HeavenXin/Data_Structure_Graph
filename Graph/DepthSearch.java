package Graph;
/**
 * 
 * @author Heaven
 *	一种深度优先的遍历,类似走迷宫,从头走到位,为了配合无序图开发的
 */
public class DepthSearch {
	private boolean marked[];
	private int count;//计数
	public DepthSearch(Graph G,int v) {//传入起点和图
		marked = new boolean[v];
		depth(G,v);//调用
	}
	public void depth(Graph G,int v) {//开始走迷宫
		marked[v] = true;
		count++;
		for (int w:G.adj(v)) {//遍历
			if (!marked[w]) {
				depth(G, w);
			}
		}//递归
	}
	public boolean marked(int v) {
		return marked[v];
	}
	public int count() {
		return count;
		
	}
}
