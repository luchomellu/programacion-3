package practico_02;

import java.util.ArrayList;

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
		System.out.println("Arreglo ordenado con algoritmo de burbujeo: " + bubbleSort(arreglo) +"\n");
	}
	
	public static ArrayList<Integer> selectionSort(ArrayList<Integer> arreglo){
		ArrayList<Integer> copia = arreglo;
		
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
		ArrayList<Integer> copia = arreglo;
		
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
}
