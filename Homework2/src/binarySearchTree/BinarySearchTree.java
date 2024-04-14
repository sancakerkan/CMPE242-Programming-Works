package binarySearchTree;
public class BinarySearchTree {
    
	// Constructor to initialize an empty BST.
	private Node root; // Root node of the BST.
    public BinarySearchTree() {
        this.root = null;
        
    }	
    
    // Inserting a new value into the tree.
    public void insert(int value) {
        root = insertRecursive(root, value);
    }
    
    /*Finds the smallest value in a given subtree
     * for deleting a node with two children in a BST
     */
    private int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
    
    //Inserting a value recursively and according to BST rules.
    private Node insertRecursive(Node current, int value) {
        if (current == null) {  // Base case: If current node is null, create a new node with value.
            return new Node(value);
        }
        	// Decision to traverse left or right subtree based on comparison.
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }
    
    //Searching a value with recursion.
    public boolean search(int value) {
    	return searchRecursive(root,value);	
    }
    
    public boolean searchRecursive(Node current, int value) {
        if (current == null) { //// Base case: if current node is null, value is not found.
            return false;
        }

        if (value == current.value) {
            return true;
        }
        
        if (value < current.value) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    	 	
    }
    
    // Deleting a value from the tree with recursion.
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node with no or one child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Node with two children
            
            current.value = minValue(current.right);// Replace value with the in-order successor's value.
            current.right = deleteRecursive(current.right, current.value);// Delete the in-order successor.
        } else if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else {
            current.right = deleteRecursive(current.right, value);
        }
        return current;
    }
    
 }
