package practico_02A;

import java.util.ArrayList;
import java.util.List;

public class CharTree {

	private CharTreeNode root;
	
	public CharTree() {
		this.root = null;
	}
	
	public String toString() {
		return root == null ? "Arbol Vacio" : root.toString();
	}
	
	public char getRoot() {	return this.root.getValue();}
	
	
	// FIJARSE DE VER SI SE PUEDE HACER MEJOR
	public List<Character> ej6(int num){
		ArrayList<Character> res = new ArrayList<>();
		ArrayList<Character> current = new ArrayList<>();
		MutableInteger i = new MutableInteger(0);
		findWordList(this.root,res,current,num,i);
		return res;
	}

	private void findWordList(CharTreeNode node,ArrayList<Character> res,ArrayList<Character> current, int num, MutableInteger i) {
		if(node.getLeft() == null && node.getRight() == null)  {
			current.add(node.getValue());
			if(num == i.getValue()) {
				res.addAll(current);
				i.increment();;
				return;
			}
			else {
				i.increment();
				current.remove(current.size()-1);
			}
		}
		current.add(node.getValue());
		if(node.getLeft() != null) {
			findWordList(node.getLeft(),res,current,num,i);
		}
		if(node.getRight() != null) {
			findWordList(node.getRight(),res,current,num,i);
		}
		current.remove(current.size()-1);
	}
	
	public void imprimirArbol() {
		CharTreeFormatter formatter = new CharTreeFormatter();
	    System.out.println(formatter.topDown(root));
	}
	
	
	public void setRoot(CharTreeNode root) {
		this.root = root;
	}
	
	private static class MutableInteger {
        private int value;

        public MutableInteger(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void increment() {
            value++;
        }
    }
}
