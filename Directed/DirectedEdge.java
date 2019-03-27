package Directed;

/**
 * 
 * @author Heaven 加权有向图边的数据类型实现
 */
public class DirectedEdge {
	private int start;// 起点
	private int end;// 结束
	private double weight;// 边的权重

	public DirectedEdge(int start, int end, double weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	public double  weight() {
		return weight;
	}
	public int from() {
		return start;
	}
	public int to() {
		return end;
	}

	public String toString() {
		return String.format("%d->%d %.2f",start,end,weight);
		
	}
}
