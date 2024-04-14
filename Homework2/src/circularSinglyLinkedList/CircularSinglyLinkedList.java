package circularSinglyLinkedList;
import java.util.Random;
public class CircularSinglyLinkedList {

	private Node tail;
    
	// Inserting a node at the end of the List
    public void insert(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    
    // Searching a node with value
    public boolean search(int value) {
        if (tail == null) { //List is empty
            return false;
        }
        Node current = tail.next;
        do {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        } while (current != tail.next);
        return false;
    }
    
    
    // Deleting random node
    public void deleteRandom() {
        if (tail == null) { // List is empty
            return;
        }

        // Determine the size of the list
        int size = 1;
        Node current = tail.next;
        while (current != tail) {
            size++;
            current = current.next;
        }

        // Generate a random position/index
        Random rand = new Random();
        int randomIndex = rand.nextInt(size);

        // Traverse to the random position/index
        current = tail;
        for (int i = 0; i < randomIndex; i++) {
            current = current.next;
        }

        // Delete the node at the random position
        
        // If it's the only node in the list
        if (current == tail && current.next == tail) {
            tail = null;
        } else {
        	
            // If the node to delete is the tail
            if (current == tail) {
                tail = findPrevious(tail);
            }
            findPrevious(current).next = current.next;
        }
    }

    // Finding the previous node
    private Node findPrevious(Node node) {
        Node current = tail;
        while (current.next != node) {
            current = current.next;
        }
        return current;
    }
}