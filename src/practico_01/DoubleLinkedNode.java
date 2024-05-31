package practico_01;

public class DoubleLinkedNode<T extends Comparable<T>> extends Node<T>{
	protected DoubleLinkedNode<T> prev;
	
	public DoubleLinkedNode() {
		super();
		this.prev = null;
	}
	
	public DoubleLinkedNode(DoubleLinkedNode<T> next, DoubleLinkedNode<T> prev, T info) {
		super(info,next);
		this.prev = prev;
	}
	
	public void setPrev(DoubleLinkedNode<T> prev) {
		this.prev = prev;
	}

}
