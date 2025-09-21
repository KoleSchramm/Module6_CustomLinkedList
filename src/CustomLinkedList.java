import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {
    Node head;

    public void insert(int data){
        //If head is null, add node with data to head
        if(this.head == null){
            this.head = new Node(data);
        }
        //If head is not null, make new node head and link old head to new head
        else{
            Node newNode = new Node(data);
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void delete(int data){
        //If list is empty, do nothing
        if(head == null){
            return;
        }
        //If deleted data is head, unlink head
        if(head.data == data){
            head = head.next;
            return;
        }
        //Loop through each node
        Node current = head;
        while ((current.next != null) && (current.next.data!=data)){
            current = current.next;
        }
        //If current node is data to be deleted, unlink node
        if (current.next != null) {
            current.next = current.next.next;
        }
    }





    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
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