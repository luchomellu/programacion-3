package practico_02A;

import java.util.List;

public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public String toString() {
		return root == null ? "Arbol Vacio" : root.toString();
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
	
	public boolean delete(Integer value) {
		if(this.root.getValue().equals(value)) {
			this.root = null;
			return true;
		}
		return findAndDelete(value,this.root);
	}
	
	public int getHeight(){
		return findHeight(this.root , 0);
	}

	private int findHeight(TreeNode node, int h) {
		if(node.getLeft() == null && node.getRight() == null) {
			return h;
		}
		else {
			int hLeft = 0;
			int hRight = 0;
			
			if(node.getLeft() != null) {
				hLeft = findHeight(node.getLeft(), h + 1);
			}
			if(node.getRight() != null) {
				hRight = findHeight(node.getRight(), h + 1);
			}
			
			if(hLeft > hRight) {
				return hLeft;
			}
			else {
				return hRight;
			}
		}
	}

	private boolean findAndDelete(Integer value, TreeNode node) {
		if(node == null) {
			return false;
		}
		if(node.getLeft() != null) {
			if(node.getLeft().getValue().equals(value)) {
				if(node.getLeft().getRight() != null) {
					node.setLeft(findSmallestFromRight(node.getLeft().getRight()));
				}
				else {
					node.setLeft(null);
				}
				return true;
			}
		}
		if(node.getRight() != null) {
			if(node.getRight().getValue().equals(value)) {
				if(node.getRight().getRight() != null) {
					node.setRight(findSmallestFromRight(node.getRight().getRight()));
				}
				else {
					node.setRight(null);
				}
				return true;
			}
		}
		return findAndDelete(value,node.getLeft()) || findAndDelete(value,node.getRight());
	}

	private TreeNode findSmallestFromRight(TreeNode node) {
		if(node.getLeft() == null) {
			return node;
		}
		else {
			return findSmallestFromRight(node.getLeft());
		}
	}
	
	public List<Integer> getLongestBranch() {
		return null;
	}
	
	public void imprimirArbol() {
		TreeFormatter formatter = new TreeFormatter();
	    System.out.println(formatter.topDown(root));
	}
	
	public void printPosOrder() {
		StringBuilder res = new StringBuilder();
		printPosOrden(this.root,res);
		System.out.println("Recorrido Pos-Order: " + res);
	}
	
	private void printPosOrden(TreeNode node,StringBuilder res) {
		if(node == null) {
			return;
		}
		
		printPosOrden(node.getLeft(),res);
		printPosOrden(node.getRight(), res);
		
		res.append(node.getValue()).append(" ");
	}
	
	public void printPreOrder() {
		StringBuilder res = new StringBuilder();
		printPreOrden(this.root,res);
		System.out.println("Recorrido Pre-Order: " + res);
	}
	
	private void printPreOrden(TreeNode node,StringBuilder res) {
		if(node == null) {
			return;
		}
		
		res.append(node.getValue()).append(" ");
		
		printPreOrden(node.getLeft(),res);
		printPreOrden(node.getRight(), res);
	}
	
	public void printInOrder() {
		StringBuilder res = new StringBuilder();
		printInOrden(this.root,res);
		System.out.println("Recorrido In-Order: " + res);
	}
	
	private void printInOrden(TreeNode node,StringBuilder res) {
		if(node == null) {
			return;
		}
		
		printInOrden(node.getLeft(),res);
		res.append(node.getValue()).append(" ");
		printInOrden(node.getRight(), res);
	}
}
