class Node{
    int value;
    Node next;
    public Node(int value){
        this.value= value;
    }
}

public class SinglyLinkedList{
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList(){
        head= null;
        tail= null;
        size= 0;
    }
    public int get(int index){
        if(index>= size || index< 0)   return -1;
        Node cur= head;
        for(int i= 0; i< index; i++){
            cur= cur.next;
        }
        return cur.value;
    }
    public void addAtIndex(int index, int value){
        Node cur= new Node(value);
        if(index> size)    return;
        if(index< 0)   index= 0;

        if(head == null){
            head= cur;
            tail= cur;
        }else{
            Node prev= head;
            for(int i= 0; i< index-1; i++){
                prev= prev.next;
            }
            cur.next= prev.next;
            prev.next= cur;
        }
        size++;
        return;
    }
    public void addAtHead(int value){
        addAtIndex(0, value);
    }
    public void addAtTail(int value){
        addAtIndex(size, value);
    }

    public void deleteAtIndex(int index) {
        if(index< 0 || index>= size)    return;
        Node prev= head;
        for(int i= 0; i< index; i++){
            prev= prev.next;
        }
        prev.next= prev.next.next;
        size--;
    }

    public void showLinkedList(){
        Node cur = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(cur != null) {
            //Prints each node by incrementing pointer
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        SinglyLinkedList ll= new SinglyLinkedList();
        System.out.println(ll);
        ll.addAtIndex(0,22);
        ll.addAtIndex(1,23);
        ll.showLinkedList();
        System.out.println(ll.get(0));
        ll.deleteAtIndex(1);
        System.out.println(ll.get(1));
    }
}