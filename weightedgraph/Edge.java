package weightedgraph;
/**
 * 
 * @author Heaven
 *	权重的边的数据类型实现
 */
public class Edge implements Comparable<Edge> {// 权重边的实现
	private int v;// 顶点
	private int w;// 另一个顶点
	private double weight;// 边的权重

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int either() {
		return v;
	}

	public int other(int v) {
		if (v == this.v) {
			return w;
		} else {
			return v;
		}
	}

	public int compareTo(Edge o) {
		if (this.weight < o.weight) {
			return -1;
		} else if (this.weight > o.weight) {
			return 1;
		} else {
			return 0;
		}
	}
	public String toString() {
		return String.format("%d-%d %.2f",v,w,weight);
	}
}
