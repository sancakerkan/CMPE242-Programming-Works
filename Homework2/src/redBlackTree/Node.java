package redBlackTree;


class Node {
    public boolean RED = true;
	public boolean BLACK = false;
    
    
    int value;
    Node left, right, parent;
    boolean color;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = RED; // New nodes are red by default
    }
}