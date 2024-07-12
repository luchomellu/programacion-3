package practico_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer,ArrayList<Arco<T>>> grafo;
	private Integer cant_arcos;
	
	public GrafoDirigido() {
		this.grafo =  new HashMap<Integer,ArrayList<Arco<T>>>();
		this.cant_arcos = 0;
	}
	
	@Override
	public void agregarVertice(int verticeId) {
		if(!contieneVertice(verticeId)) {
			grafo.put(verticeId, new ArrayList<Arco<T>>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		//Falta eliminar arcos hacia verticeId
		this.grafo.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		//Falta hacer checkeo de si existen los vertices y si existe el arco
		grafo.get(verticeId1).add(new Arco<T>(verticeId1,verticeId2,etiqueta));
		this.cant_arcos++;
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1)) {
			Iterator<Arco<T>> itr = this.grafo.get(verticeId1).iterator();
			
			while(itr.hasNext()) {
				Arco<T> arco = itr.next();
				if((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)) {
					itr.remove();
					this.cant_arcos--;
					return;
				}
			}
			System.out.println("El arco " + verticeId1 + " -> " + verticeId2 + " a borrar no existe");
		}
		else {
			System.out.println("Vertice " + verticeId1 + " no existe");
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.grafo.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1)) {
			Iterator<Arco<T>> itr = this.grafo.get(verticeId1).iterator();
			
			while(itr.hasNext()) {
				Arco<T> arco = itr.next();
				if((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)) {
					return true;
				}
			}
			return false;
		}
		else {
			return false;
		}
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(contieneVertice(verticeId1)) {
			Iterator<Arco<T>> itr = this.grafo.get(verticeId1).iterator();
			
			while(itr.hasNext()) {
				Arco<T> arco = itr.next();
				if((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)) {
					return arco;
				}
			}
			return null;
		}
		else {
			return null;
		}
	}

	@Override
	public int cantidadVertices() {
		return this.grafo.size();
	}

	@Override
	public int cantidadArcos() {
		// TODO Auto-generated method stub
		return this.cant_arcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.grafo.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {	
		return new AdjIterator<T>(obtenerArcos(verticeId));
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		return new ArcoIterator<T>(grafo.entrySet().iterator());
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return this.grafo.get(verticeId).iterator();
	}

}