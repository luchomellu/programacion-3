package practico_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class AlgoritmoDFS <T>{
	
	private Grafo grafo;
	
	public AlgoritmoDFS(Grafo grafo) {
		this.grafo = grafo;
	}
	
	public ArrayList getDFS(){
		ArrayList visitados = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Iterator<T> vertices = (Iterator<T>) this.grafo.obtenerVertices(); //checkear el casteo
		while(vertices.hasNext()) {
			T vertice = vertices.next();
			System.out.println("Desde afuera de DFS agarro " + vertice);
			if(!visitados.contains(vertice)) {
				DFS(visitados,vertice);
			}
		}
		return visitados;
	}
	
	public void DFS(ArrayList<T> visitados, T vertice) {
		visitados.add(vertice);
		System.out.println("Entro DFS con estos vertices visitados: " + visitados);
		Stack pila = new Stack();
		pila.push(vertice);
		while(!pila.isEmpty()) {
			@SuppressWarnings("unchecked")
			T verticeActual = (T) pila.pop();//checkear este casteo
			//pila.remove(0);
			System.out.println("Saco " + verticeActual + " de la pila que queda asi: " + pila);
			@SuppressWarnings("unchecked")
			Iterator<T> adyacentes = (Iterator<T>) this.grafo.obtenerAdyacentes((int) verticeActual);//checkear este casteo
			while(adyacentes.hasNext()) {
				T ady = adyacentes.next();
				if(!visitados.contains(ady) && !pila.contains(ady)) {
					System.out.println("Meto " + ady + " a la pila");
					DFS(visitados,ady);
				}
			}
		}
	}
}
