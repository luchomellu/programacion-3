package practico_01;

import java.util.Iterator;

public class CustomIterator<T extends Comparable<T>> implements Iterator<T>{

	private Node<T> cursor;
	
	public CustomIterator(Node<T> first) {
		this.cursor = first;
	}
	
	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public T next() {
		T info = this.cursor.getInfo();
		this.cursor = this.cursor.getNext();
		
		return info;
	}
}
