package practico_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
	public static void main (String[] args) {
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		arreglo.add(1);
		arreglo.add(234);
		arreglo.add(59664);
		arreglo.add(54);
		arreglo.add(97);
		arreglo.add(345);
		arreglo.add(107);
		arreglo.add(8401);
		arreglo.add(0);
		
		System.out.println("Arreglo desordenado: " + arreglo +"\n");
		System.out.println("Arreglo ordenado con algoritmo de seleccion: " + selectionSort(arreglo) +"\n");
		System.out.println("Arreglo desordenado: " + arreglo +"\n");
		System.out.println("Arreglo ordenado con algoritmo de burbujeo: " + bubbleSort(arreglo) +"\n");
		System.out.println("Arreglo desordenado: " + arreglo +"\n");
		ArrayList<Integer> copiaArray = new ArrayList<Integer>(arreglo);
		quickSort(copiaArray,0,copiaArray.size()-1);
		System.out.println("Arreglo ordenado con algoritmo de pivote (quicksort) FALTA TERMINAR: " + copiaArray +"\n");
		
	}
	
	public static ArrayList<Integer> selectionSort(ArrayList<Integer> arreglo){
		ArrayList<Integer> copia = new ArrayList<Integer>(arreglo);
		
		for(int i = 0; i < copia.size(); i++) {
			int min = i;
			for(int j = i + 1; j < copia.size(); j++) {
				if(copia.get(j) < copia.get(min)) {
					min = j;
				}
			}
			int temp = copia.get(i);
			copia.set(i , copia.get(min));
			copia.set(min, temp);
		}
		
		return copia;
	}
	
	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arreglo){
		ArrayList<Integer> copia = new ArrayList<Integer>(arreglo);
		
		for(int i = copia.size(); i > 0; i--) {
			//System.out.println(i);
			for(int j = 0; j < i - 1; j++) {
				//System.out.println(j);
				if(copia.get(j) > copia.get(j + 1)) {
					int temp = copia.get(j);
					copia.set(j, copia.get(j + 1));
					copia.set(j + 1, temp);
				}
			}
		}
		
		return copia;
	}
	
	public static void quickSort(List<Integer> arreglo, int inicio , int fin) {
		/*
		 * //elijo un pivote random?
		//int pivote = arreglo.get((int) (Math.random() * arreglo.size()));
		int pivote = arreglo.get(arreglo.size() - 1);
		int indice = -1;
		 
		System.out.println("pivote = " + pivote);
		//swap(arreglo,arreglo.indexOf(pivote),arreglo.size() - 1);
		for(int verde = 0; verde < arreglo.size();verde++) {
			if(arreglo.get(verde) <= pivote) {
				System.out.println(arreglo.get(verde) + " es menor o igual al pivote " + pivote);
				indice++;
				swap(arreglo,verde,indice);
			}
		}
		System.out.println(arreglo);
		System.out.println("Indice: " + indice);
		if(indice > 0) {
			quickSort(arreglo.subList(0, indice - 1));
		}
		if(arreglo.subList(indice + 1, arreglo.size() -1).size() > 1) {
			System.out.println("hola");
			quickSort(arreglo.subList(indice + 1, arreglo.size() -1));
		}
		*/
		if(inicio < fin) {
			int indicePivote = partition(arreglo,inicio,fin);
			quickSort(arreglo, inicio, indicePivote - 1);
            quickSort(arreglo, indicePivote + 1, fin);
		}
		
	}
	
	public static int partition(List<Integer> arreglo, int inicio, int fin) {
		int pivote = arreglo.get(fin);
		int indice = inicio - 1;
		
		for(int i = inicio; i < fin; i++) {
			if(arreglo.get(i) <= pivote) {
				indice++;
				swap(arreglo,i,indice);
			}
		}
		
		swap(arreglo,indice + 1,fin);
		return indice + 1;
	}
	
	public static void swap(List<Integer> arreglo,int i,int j) {
		int temp = arreglo.get(i);
		arreglo.set(i, arreglo.get(j));
		arreglo.set(j, temp);
	}
}
