class Node{
    int value
    Node next;
    public Node(int value, Node next=null){
        this.value= value;
        this.next= next;
    }
}

public class SinglyLinkedList{
    private Node head;
    private Node tail;

    public SinglyLinkedList(){
        this.head= null;
        this.tail= null;
    }
    public int get(int index){}
    public void addAtHead(int value){}
    public void addAtTail(int value){}
    public void addAtIndex(int value, int index){}
    public void deleteAtIndex(int index) {}
}