package practico_01;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{
	protected int size;
	protected Node<T> first;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	//Complejidad Computacional = O(1)
	public void insertFront(T info) {
		//Se crea un nodo con la info pasada por parametro
		Node<T> tmp = new Node<T>(info,null);
		//A este nuevo nodo le indicamos que tiene que apuntar al nodo que anteriormente era el primero
		tmp.setNext(this.first);
		//Ahora indicamos en la variable first que el nuevo nodo creado va a ser el primero
		this.first = tmp;
		//Incrementamos la variable de tamanio
		this.size++;
	}
	
	public T extractFront() {		
		Node<T> aux = this.first;
		this.first = this.first.getNext();
		this.size--;
		return aux.getInfo();
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	//Complejidad Computacional = O(n)
	public T get(int index) {
		//Creo un iterador para recorrer la lista
		Iterator<T> itr = this.iterator();
		//Creo variable pos para controlar el numero de posiciones que voy moviendo
		int pos = 0;
		while(pos != index && itr.hasNext()) {
			itr.next();
			pos++;
		}
		//Si despues de recorrer la lista la posicion es la indicada devuelvo la info del nodo apuntado
		if(pos == index) {
			return itr.next();
		}
		return null;
	}
	
	//Complejidad Computacional = O(1) 
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		
		if(this.first == null) {
			return "Lista vacia";
		}
		String res = "";
		//Modo sin iterator
		/*
			Node<T> aux = this.first;
			while(aux != null) {
				res += aux.getInfo();
				aux = aux.getNext();
			}
		*/
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			res += itr.next() + " ";
		}
		
		return res;
	}

	@Override
	public Iterator<T> iterator() {
		return new CustomIterator<T>(this.first);
	}
	
	public int indexOf(T info) {
		int contador = 0;
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			if(info == itr.next()) {
				return contador;
			}
			contador++;
		}
		return -1;
	}
	
	public <T extends Comparable<T>> Node<T> mergeSort(Node<T> head){
		//Si la lista solo tiene un elemento o es vacio retorno retorno
		//System.out.println("Entro al mergeSort");
		if(head.getNext() == null || head == null) {
			//System.out.println("Cabeza esta vacia o no hay siguiente retorno:" + head.toString());
			return head;
		}
		
		//Divido la lista en dos mitades
		Node<T> medio = getMedio(head);
		//System.out.println("Medio: " + medio);
		Node<T> siguienteMedio = medio.getNext();
		//System.out.println("Sigueinte a medio " + siguienteMedio);
		medio.setNext(null);
		
		//Llamo recursivamente a dividir las dos mitades
		Node<T> headL = mergeSort(head);
		Node<T> headR = mergeSort(siguienteMedio);
		
		return merge(headL, headR);
	}
	
	private <T extends Comparable<T>> Node<T> merge(Node<T> headL, Node<T> headR) {
		if(headL == null) {
			return headR;
		}
		if(headR == null) {
			return headL;
		}
		
		Node<T> res;
		if(headL.getInfo().compareTo(headR.getInfo()) <= 0) {
			res = headL;
			res.setNext(merge(headL.getNext(),headR));
		}
		else {
			res = headR;
			res.setNext(merge(headL,headR.getNext()));
		}
		return res;
	}

	private <T extends Comparable<T>> Node<T> getMedio(Node<T> head) {
		if(head == null) {
			return head;
		}
		
		Node<T> lento = head;
		Node<T> rapido = head.getNext();
		
		while(rapido != null && rapido.getNext() !=null) {
			lento = lento.getNext();
			rapido = rapido.getNext().getNext();
		}
		return lento;
	}

	public MySimpleLinkedList<T> ejercicio_6_desordenado(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2){
		MySimpleLinkedList<T> res = new MySimpleLinkedList<T>();
		Iterator<T> itr1 = lista1.iterator();
		while(itr1.hasNext()) {
			T info = itr1.next();
			Iterator<T> itr2 = lista2.iterator();
			boolean found = false;
			while(!found && itr2.hasNext()) {
				if(info == itr2.next()) {
					res.insertFront(info);
					found = true;
				}
			}
		}
		System.out.println("lista antes merge sort:\n" + res.toString());
		res.first = mergeSort(res.first);
		return res;
	}
	
	
	//arreglado en teoria
	public MySimpleLinkedList<T> ejercicio_6_ordenado(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2){
		MySimpleLinkedList<T> res = new MySimpleLinkedList<T>();
		Iterator<T> itr1 = lista1.iterator();
		Iterator<T> itr2 = lista2.iterator();
		T info1 = itr1.next();
		T info2 = itr2.next();
		while(itr1.hasNext() || itr2.hasNext()) {
			//System.out.println("Nodo lista 1: " + info1.toString());
			//System.out.println("Nodo lista 2: " + info2.toString());
			if(info1.compareTo(info2) < 0) {
				if(itr1.hasNext()) {
					info1 = itr1.next();
				}
			}
			if(info2.compareTo(info1) < 0) {
				if(itr2.hasNext()) {
					info2 = itr2.next();
				}
			}
			if(info1.compareTo(info2) == 0) {
				//nSystem.out.println("Encontre comun: " + info2.toString());
				res.insertFront(info1);
				if(itr1.hasNext() && itr2.hasNext()) {
					info1 = itr1.next();
					info2 = itr2.next();
				}
				else {
					return res;
				}
			}
		}
		
		return res;
	}
	
	public MySimpleLinkedList<T> ejercicio7 (MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2){
		MySimpleLinkedList<T> res = new MySimpleLinkedList<T>();
		Iterator<T> itr1 = lista1.iterator();
		while(itr1.hasNext()) {
			T info = itr1.next();
			Iterator<T> itr2 = lista2.iterator();
			boolean found = false;
			while(!found && itr2.hasNext()) {
				if(info == itr2.next()) {
					found = true;
				}
			}
			if(!found) {
				res.insertFront(info);
			}
		}
		return res;
	}
	//Pila
	
	public void push(T info){
		this.insertFront(info);
	}
	
	public T pop() {
		T info = this.first.getInfo();
		this.first = this.first.getNext();
		return info;
	}
	
	public T top() {
		return this.first.getInfo();
	}
	
	public void reverse() {
        // Creamos una pila auxiliar para almacenar temporalmente los elementos
        MySimpleLinkedList<T> pilaAuxiliar = new MySimpleLinkedList<>();

        // Desapilamos todos los elementos de la pila original y los apilamos en la pila auxiliar
        while (!isEmpty()) {
            pilaAuxiliar.push(pop());
        }
        
        //Cambio el primer nodo por el primer nodo de la "pila" invertida
        this.first = pilaAuxiliar.first;      
    }
	
	public String pilaToString() {
		if(this.first == null) {
			return "Pila Vacia";
		}
		String res = "";
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			res += itr.next() + "\n";
		}
		
		return res;
	}
}