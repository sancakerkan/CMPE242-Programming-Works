package avlTree;

class Node {
    int value;
    Node left, right;
    int height;

    public Node(int d) {
        value = d;
        height = 1;
    }
}