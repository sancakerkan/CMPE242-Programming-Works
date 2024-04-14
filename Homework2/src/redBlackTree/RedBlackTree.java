package redBlackTree;

public class RedBlackTree {

    // Constants representing node colors
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    // Root node of the Red-Black Tree
    private Node root;

    // Constructor initializing an empty Red-Black Tree
    public RedBlackTree() {
        root = null;
    }

    // Method to fix violations in the Red-Black Tree after insertion
    private void fixViolations(Node node) {
        Node parentNode = null;
        Node grandParentNode = null;

        // Continue fixing violations until the root or both parent and grandparent are black
        while (node != root && color(node) == RED && color(node.parent) == RED) {
            parentNode = node.parent;
            grandParentNode = parentNode.parent;

            // Case A: Parent is the left child of grandparent
            if (parentNode == grandParentNode.left) {
                Node uncle = grandParentNode.right;

                // Case A.1: The uncle of node is also red
                if (color(uncle) == RED) {
                    grandParentNode.color = RED;
                    parentNode.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParentNode;
                } else {
                    // Case A.2: node is the right child of its parent
                    if (node == parentNode.right) {
                        rotateLeft(parentNode);
                        node = parentNode;
                        parentNode = node.parent;
                    }

                    // Case A.3: node is the left child of its parent
                    rotateRight(grandParentNode);
                    swapColors(parentNode, grandParentNode);
                    node = parentNode;
                }
            }
            // Case B: Parent is the right child of grandparent
            else {
                Node uncle = grandParentNode.left;

                // Case B.1: The uncle of node is also red
                if (color(uncle) == RED) {
                    grandParentNode.color = RED;
                    parentNode.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParentNode;
                } else {
                    // Case B.2: node is the left child of its parent
                    if (node == parentNode.left) {
                        rotateRight(parentNode);
                        node = parentNode;
                        parentNode = node.parent;
                    }

                    // Case B.3: node is the right child of its parent
                    rotateLeft(grandParentNode);
                    swapColors(parentNode, grandParentNode);
                    node = parentNode;
                }
            }
        }

        // Ensure the root is always black
        root.color = BLACK;
    }

    // Method to perform a left rotation on the given node
    private void rotateLeft(Node node) {
        if (node != null) {
            Node rightNode = node.right;
            node.right = rightNode.left;
            if (node.right != null) {
                node.right.parent = node;
            }
            rightNode.parent = node.parent;

            // Update the root if necessary
            if (node.parent == null) {
                root = rightNode;
            } else if (node == node.parent.left) {
                node.parent.left = rightNode;
            } else {
                node.parent.right = rightNode;
            }

            rightNode.left = node;
            node.parent = rightNode;
        }
    }

    // Method to perform a right rotation on the given node
    private void rotateRight(Node node) {
        if (node != null) {
            Node leftNode = node.left;
            node.left = leftNode.right;
            if (node.left != null) {
                node.left.parent = node;
            }
            leftNode.parent = node.parent;

            // Update the root if necessary
            if (node.parent == null) {
                root = leftNode;
            } else if (node == node.parent.right) {
                node.parent.right = leftNode;
            } else {
                node.parent.left = leftNode;
            }

            leftNode.right = node;
            node.parent = leftNode;
        }
    }

    // Method to get the color of a node (defaulting to black if the node is null)
    private boolean color(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    // Method to swap the colors of two nodes
    private void swapColors(Node node1, Node node2) {
        boolean temp = node1.color;
        node1.color = node2.color;
        node2.color = temp;
    }

    // Public method to insert a value into the Red-Black Tree
    public void insert(int value) {
        // Create a new node with the given value
        Node node = new Node(value);
        // Insert the node into the tree
        root = insertRec(root, node);
        // Fix any violations that may have occurred during insertion
        fixViolations(node);
    }

    // Private recursive method to insert a node into the Red-Black Tree
    private Node insertRec(Node root, Node node) {
        if (root == null) {
            return node; // If the root is null, the node becomes the new root
        }

        // Compare the value of the node with the current root
        if (node.value < root.value) {
            // If the value is less, recursively insert into the left subtree
            root.left = insertRec(root.left, node);
            root.left.parent = root;
        } else if (node.value > root.value) {
            // If the value is greater, recursively insert into the right subtree
            root.right = insertRec(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    // Public method to search for a value in the Red-Black Tree
    public boolean search(int value) {
        return searchRec(root, value);
    }

    // Private recursive method to search for a value in the Red-Black Tree
    private boolean searchRec(Node node, int value) {
        if (node == null) {
            return false; // Value not found
        }

        if (value == node.value) {
            return true; // Value found
        } else if (value < node.value) {
            return searchRec(node.left, value); // Search in the left subtree
        } else {
            return searchRec(node.right, value); // Search in the right subtree
        }
    }
}
