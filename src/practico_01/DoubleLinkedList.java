package practico_01;

public class DoubleLinkedList<T extends Comparable<T>> extends MySimpleLinkedList<T> {
	protected DoubleLinkedNode<T> tail;
	
	public DoubleLinkedList() {
		super();
		this.tail = null;
	}
	
	@Override
    public void insertFront(T dato) {
		DoubleLinkedNode<T> tmp = new DoubleLinkedNode<T>();
		tmp.setInfo(dato);
        if (this.first == null) {
            this.first = tmp;
            this.tail = tmp;
        } else {
        	DoubleLinkedNode<T> head = (DoubleLinkedNode<T>) this.first;
            tmp.setNext(head);
            head.setPrev(tmp);
            this.first = tmp;
        }
    }
}
