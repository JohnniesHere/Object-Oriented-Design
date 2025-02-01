import java.util.Iterator;
import java.util.NoSuchElementException;

public class Group implements Iterable<Integer> {
    private Node head;
    private int size;

    // Node class for linked list implementation
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public Group() {
        head = null;
        size = 0;
    }

    // Part B: Add element to group
    public boolean add(int element) {
        // Check if element already exists
        if (search(element)) {
            return false;
        }

        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    // Part B: Remove element from group
    public boolean remove(int element) {
        if (head == null) {
            return false;
        }

        if (head.data == element) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == element) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Part B: Search for element in group
    public boolean search(int element) {
        Node current = head;
        while (current != null) {
            if (current.data == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Part C: Check if element is contained in group using for-each
    public boolean containsElement(int x) {
        for (int element : this) {
            if (element == x) {
                return true;
            }
        }
        return false;
    }

    // Part D: Intersection of two groups
    public Group intersection(Group R) {
        Group V = new Group();
        for (int element : this) {
            if (R.containsElement(element)) {
                V.add(element);
            }
        }
        return V;
    }

    // Part 1: Union of two groups
    public Group union(Group R) {
        Group V = new Group();
        
        // Add all elements from this group
        for (int element : this) {
            V.add(element);
        }
        
        // Add all elements from group R
        for (int element : R) {
            V.add(element);  // add() handles duplicates automatically
        }
        
        return V;
    }

    // Part 2: Iterator implementation
    @Override
    public Iterator<Integer> iterator() {
        return new GroupIterator();
    }

    private class GroupIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}