package Bag;

import java.util.Iterator;


public class Bag2<Item> implements Iterable<Item>{
	private	Node Start;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void add(Item item) {
		Node oldNode = Start;
		Start.item = item;//写入新的
		Start.next = oldNode;
		N++;
	}
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator();
	}
	public class BagIterator implements Iterator<Item>{
		private Node Current = Start;//导入Node
		@Override
		public boolean hasNext() {
			return Current != null;
		}

		@Override
		public Item next() {
			Item item = Current.item;
			Current = Current.next;
			return item;
		}
		
	}
	
}
