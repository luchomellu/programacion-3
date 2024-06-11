package practico_02A;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	
	/*
	 * Implemente la estructura de Árbol Binario para búsquedas. Métodos:
		● Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer), boolean delete(Integer),
		int getHeight(), void printPosOrder(), void printPreOrder(), void printInOrder(), List getLongestBranch(),
		List getFrontera(), Integer getMaxElem(), List getElemAtLevel(int)
			1. ¿Cuál es la complejidad de cada uno de estos métodos?*/
	
	public Integer getRoot() {
		if(this.root != null) {
			return this.root.getValue();
		}
		return null;
	}
	
	public boolean hasElem(Integer value) {
		return findElem(root,value);
	}

	private boolean findElem(TreeNode node, Integer value) {
		if(node == null) {
			return false;
		}
		if(node.getValue().equals(value)) {
			return true;
		}
		return findElem(node.getLeft(),value) || findElem(node.getRight(),value);
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
}
