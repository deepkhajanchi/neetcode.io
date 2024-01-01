class Node{
    int value;
    Node next, prev;
    Node(int value){
        this.value= value;
    }
}

public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int size;

    public int get(int index){
        Node cur= head;
        if(head == null) return 0;
        for(int i=0; i<index; i++){
            cur= cur.next;
        }
        return cur.value;
    }

    private Node getTail() {
        Node cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
    public void addAtHead(int value){
        Node newNode= new Node(value);
        newNode.next= head;
        if(head != null)    head.prev= newNode;
        head= newNode;
        size++;
    }

    public void addAtTail(int value){
        Node newNode = new Node(value);
        if (head == null) {
            addAtHead(value);
            return;
        }
        Node prev = getTail();
        prev.next = newNode;
        newNode.prev = prev;
        size++;
    }

    public void addAtIndex(int index, int value){
        Node newNode= new Node(value);
        if(index< 0 || index> size) return;

        if(index == 0) addAtHead(value);
        if(index == size) addAtTail(value);
        if(head == null){
            head= newNode;
            tail= newNode;
        }

        Node prev= head;
        Node temp= prev.next;
        Node next= temp;
       // newNode.prev= prev;
        newNode.next= next;
        temp= newNode;
        if(next != null)    next.prev= newNode;
        size++;
    }

    public void deleteAtIndex(int index){
        if(head == null)    return;
        else if(index == 0)  head= head.next;
        else if(index< 0 || index >= size)   return;
        else if(index == size-1) tail= tail.prev;
        else{
            Node prev= head;
            Node temp= null;
            temp= prev.next;
            prev.next= temp.next;
        }
        size--;
    }

    public void showLinkedList(){
        Node cur = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(cur != null) {
            //Prints each node by incrementing pointer
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll= new DoublyLinkedList();
        dll.addAtTail(0);
        dll.addAtHead(-1);
        dll.deleteAtIndex(0);
        dll.addAtIndex(1,4);
        dll.showLinkedList();
    }
}