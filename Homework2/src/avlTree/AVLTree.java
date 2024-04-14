package avlTree;


public class AVLTree {
	private Node root;
	
    // Height of the tree
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }
    
    // Right rotate subtree rooted with (y)
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        // Return new root
        return x;
    }

    //Left rotate subtree rooted with (x)
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        // Return new root
        return y;
    }
    
    //Balance factor of node N
    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    
    //Inserting value into tree
    public void insert(int value) {
        root = insert(root, value);
    }
    
    private Node insert(Node node, int value) {
        //Performing a normal BST inserting
        if (node == null)
            return (new Node(value));

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else // Duplicate values not allowed
            return node;
        
        //Update the height of ancestor
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether this node became unbalanced 
        int balance = getBalance(node);

        // If node becomes unbalanced apply correct rotate case:

        // Left-Left Rotate Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right-Right Rotate Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left-Right Rotate Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right-Left Rotate Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
        
        
        // Searching recursively for a value in the tree
        public boolean search(int value) {
            return searchRecursive(root, value);
        }
        
        private boolean searchRecursive(Node current, int value) {
            if (current == null) {
                return false; // Value not found
            }

            if (value == current.value) {
                return true; // Value found
            } else if (value < current.value) {
                return searchRecursive(current.left, value); // Search in the left subtree
            } else {
                return searchRecursive(current.right, value); // Search in the right subtree
            }
        }
        
        
        //Deleting a node from the tree
        public void delete(int value) {
            root = delete(root, value);
        }

        private Node delete(Node node, int value) {
            if (node == null) {
                return null;
            }

            // Standard BST delete
            if (value < node.value) {
                node.left = delete(node.left, value);
            } else if (value > node.value) {
                node.right = delete(node.right, value);
            } else {
                // Node with only one child or no child
                if (node.left == null || node.right == null) {
                    node = (node.left == null) ? node.right : node.left;
                } else {
                    // Node with two children (inorder successor)
                    node.value = minValue(node.right);
                    node.right = delete(node.right, node.value);
                }
            }

            if (node == null) return null;

            // Update height of the current node
            node.height = 1 + Math.max(height(node.left), height(node.right));

            // Re-balancing the node if necessary
            return rebalance(node);
        }

        private int minValue(Node node) {
            int minValue = node.value;
            while (node.left != null) {
                minValue = node.left.value;
                node = node.left;
            }
            return minValue;
        }

        private Node rebalance(Node node) {
            int balance = getBalance(node);

            // Left-Left Rotate 
            if (balance > 1 && getBalance(node.left) >= 0) {
                return rightRotate(node);
            }

            // Left-Right Rotate
            if (balance > 1 && getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right-Right Rotate
            if (balance < -1 && getBalance(node.right) <= 0) {
                return leftRotate(node);
            }

            // Right-Left Rotate
            if (balance < -1 && getBalance(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

    }

