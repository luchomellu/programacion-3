package practico_02A;

public class main {
	public static void main(String[] args) {
		Tree arbol = new Tree();
		
		arbol.add(76);
		arbol.add(1234);
		arbol.add(453);
		arbol.add(9);
		arbol.add(734);
		arbol.add(23);
		arbol.add(777);
		arbol.add(1);
		arbol.add(2);
		arbol.add(3);
		
		
		System.out.println(arbol.delete(453));
		arbol.imprimirArbol();
		System.out.println(arbol.hasElem(453));
		System.out.println("Altura: " + arbol.getHeight());
		arbol.printPosOrder();
		arbol.printPreOrder();
		arbol.printInOrder();
		System.out.println("Longest Branch: " + arbol.getLongestBranch());
		System.out.println("Frontera: " + arbol.getFrontera());
		System.out.println("Elemento Mas Grande: " + arbol.getMaxElem());
		System.out.println("Elementos en nivel 0 " + arbol.getElemAtLevel(0));
		System.out.println("Elementos en nivel 1 " + arbol.getElemAtLevel(1));
		System.out.println("Elementos en nivel 2 " + arbol.getElemAtLevel(2));
		System.out.println("Elementos en nivel 3 " + arbol.getElemAtLevel(3));
		System.out.println("Elementos en nivel 4 " + arbol.getElemAtLevel(4));
		
		System.out.println("Suma de todos los nodos: " + arbol.getSumaAllNodos());
		System.out.println("Lista de numeros mayores a 3: " + arbol.getLeafsHigherThan(3));
		
		arbol.ej2setNulls();
		arbol.imprimirArbol();
		arbol.ej2();
		arbol.imprimirArbol();
		
	}
	
}
