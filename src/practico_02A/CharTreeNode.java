package practico_02A;

public class CharTreeNode{
	private Character value;
	private CharTreeNode left;
	private CharTreeNode right;

	public CharTreeNode(char value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public CharTreeNode getLeft() {
		return left;
	}

	public void setLeft(CharTreeNode left) {
		this.left = left;
	}

	public CharTreeNode getRight() {
		return right;
	}

	public void setRight(CharTreeNode right) {
		this.right = right;
	}

	public char getValue() {
		return value;
	}
	
	public void setValue(char value) {
		this.value = value;
	}
}
