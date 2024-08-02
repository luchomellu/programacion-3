package practico_03;

import java.util.Iterator;
import java.util.List;

public class Main {

	public static <T> void mostrarGrafo (Grafo<T> grafo)
	{
		// Recorremos todos los vertices
		Iterator<Integer> it = grafo.obtenerVertices();
		
		while (it.hasNext()) {
			Integer v = (Integer) it.next();
			System.out.println("Vertice" + v);
			// Recorremos todos los adyacentes de cada vertice
			Iterator<Arco<T>> itA = grafo.obtenerArcos(v);
			while (itA.hasNext()) {
				Arco<T> arco = itA.next();
				System.out.println("    " + v + "-> " + arco.getVerticeDestino() + " (" + arco.getEtiqueta() + ")");
			}
		}
	}
	
	public static void main(String[] args) {

		GrafoDirigido<Integer> g = new GrafoDirigido<Integer>();

		// Cargamos un grafo dirigido
		// Primero los vértices
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);

		// Luego los arcos
		g.agregarArco(1, 2, 12);
		g.agregarArco(1, 3, 13);
		g.agregarArco(1, 4, 14);
		g.agregarArco(2, 6, 26);
		g.agregarArco(3, 5, 35);
		g.agregarArco(4, 7, 47);
		g.agregarArco(5, 6, 56);

	    mostrarGrafo(g);
	    
	    AlgoritmoDFS dfs = new AlgoritmoDFS(g);
	    List<Integer> resDFS = dfs.getDFS();
	    System.out.println("DFS: (mas comun: [1, 2, 6, 3, 5, 4, 7])");
	    System.out.println(resDFS);
	}
	
}
