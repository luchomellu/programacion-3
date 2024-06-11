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
		
		System.out.println(arbol.hasElem(1));
		System.out.println(arbol.hasElem(9));
		
		
	}
	
}
