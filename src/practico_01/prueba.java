package practico_01;

public class prueba {
	public static void main (String[] args) {
		/*
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
		System.out.println(lista.toString());
		lista.insertFront(1);
		System.out.println(lista.toString());
		lista.insertFront(2);
		lista.insertFront(3);
		lista.insertFront(4);
		System.out.println(lista.toString());
		lista.extractFront();
		System.out.println(lista.toString());
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));
		System.out.println(lista.get(2));
		System.out.println(lista.get(-3));
		
		*/
		
		MySimpleLinkedList<Integer> lista1Ejercico6a = new MySimpleLinkedList<Integer>();
		lista1Ejercico6a.insertFront(234);
		lista1Ejercico6a.insertFront(21);
		lista1Ejercico6a.insertFront(33);
		lista1Ejercico6a.insertFront(4353453);
		lista1Ejercico6a.insertFront(5);
		lista1Ejercico6a.insertFront(646);
		lista1Ejercico6a.insertFront(36677);
		lista1Ejercico6a.insertFront(942234);
		
		System.out.println("Lista 1 desordenada:\n" + lista1Ejercico6a.toString());
		
		MySimpleLinkedList<Integer> lista2Ejercico6a = new MySimpleLinkedList<Integer>();
		lista2Ejercico6a.insertFront(33);//repite
		lista2Ejercico6a.insertFront(14);
		lista2Ejercico6a.insertFront(87);
		lista2Ejercico6a.insertFront(-13);
		lista2Ejercico6a.insertFront(94);
		lista2Ejercico6a.insertFront(5);//repite
		lista2Ejercico6a.insertFront(145);
		lista2Ejercico6a.insertFront(21);//repite
		
		System.out.println("Lista 2 desordenada:\n" + lista2Ejercico6a.toString());
		
		System.out.println("Lista resultado ejercicio 6 a:\n" + lista2Ejercico6a.ejercicio_6_desordenado(lista1Ejercico6a, lista2Ejercico6a));
		
		MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<Integer>();
		lista1.insertFront(210);
		lista1.insertFront(189);
		lista1.insertFront(167);
		lista1.insertFront(145);
		lista1.insertFront(123);
		lista1.insertFront(101);
		lista1.insertFront(95);
		lista1.insertFront(89);
		lista1.insertFront(77);
		lista1.insertFront(68);
		lista1.insertFront(56);
		lista1.insertFront(42);
		lista1.insertFront(23);
		lista1.insertFront(15);
		lista1.insertFront(3);
		
		MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
		lista2.insertFront(189);  // Común
		lista2.insertFront(115);
		lista2.insertFront(99);
		lista2.insertFront(84);
		lista2.insertFront(77);   // Común
		lista2.insertFront(76);
		lista2.insertFront(58);
		lista2.insertFront(56);   // Común
		lista2.insertFront(49);
		lista2.insertFront(42);   // Común
		lista2.insertFront(37);
		lista2.insertFront(28);
		lista2.insertFront(23);   // Común
		lista2.insertFront(15);   // Común
		lista2.insertFront(3);    // Común
		
		System.out.println("Lista resultado ejercicio 6 b:\n" + lista2Ejercico6a.ejercicio_6_ordenado(lista1, lista2));
		
		System.out.println(ejercicio9("sugus"));
		System.out.println(ejercicio9("pene"));
		/*
		System.out.println("\nCreo una pila\n");
		MySimpleLinkedList<String> pila = new MySimpleLinkedList<String>();
		pila.push("Pan");
		pila.push("Carne");
		pila.push("Lechuga");
		pila.push("Tomate");
		pila.push("Mayo");
		pila.push("Pan");
		System.out.println(pila.pilaToString());
		System.out.println("\nSaco el primer elemento -> " + pila.pop() + "\n");
		System.out.println(pila.pilaToString());
		pila.reverse();
		System.out.println("Pila dada vuelta: \n" + pila.pilaToString());
		pila.reverse();
		System.out.println("Pila original devuelta: \n" + pila.pilaToString());
		
		System.out.println(lista.toString());
		System.out.println("Indice de 2: " + lista.indexOf(2) + "\nIndice de 1: " + lista.indexOf(1) + "\nIndice de 3: " + 
							lista.indexOf(3) + "\nIndice de 10: " + lista.indexOf(10));
		*/
		
		System.out.println(convertirABinario(26));
	}
	
	public static boolean ejercicio9(String texto) {
		texto = texto.replaceAll("\\s+", "").toLowerCase();
		return esPalindromoRecursivo(texto, 0,texto.length() -1);
	}

	private static boolean esPalindromoRecursivo(String texto, int inicio, int fin) {
		//esto es si se cruzan los indices o llegan al mismo (unica letra)
		if(inicio >= fin) {
			return true;
		}
		
		if(texto.charAt(inicio) != texto.charAt(fin)) {
			return false;
		}
		
		return esPalindromoRecursivo(texto, inicio + 1, fin - 1);
	}
	
	public static String convertirABinario(int numero) {
		// Caso base: si el número es 0, su representación binaria es "0"
        if (numero == 0) {
            return "0";
        }
        // Caso base: si el número es 1, su representación binaria es "1"
        if (numero == 1) {
            return "1";
        }
        // Llamada recursiva: dividir el número por 2 y concatenar el residuo (número % 2)
        return convertirABinario(numero / 2) + (numero % 2);
	}
}
