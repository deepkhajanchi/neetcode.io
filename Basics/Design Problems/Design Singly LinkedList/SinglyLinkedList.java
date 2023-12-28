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
        System.out.println("At "+index+" position, node value "+ cur.value);
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
            for(int i=0; i<index-1; i++){
                prev= prev.next;
            }
            cur.next= prev.next;
            prev.next= cur;
        }
        size++;
        System.out.println("Added node: "+ cur.value+" at index: "+ index);
    }

    public void addAtHead(int value){

        Node cur= new Node(value);
        if(head == null){
            head= cur;
            tail= cur;
        }else{
            cur.next= head;
            head= cur;
        }
        size++;

    }
    public void addAtTail(int value){
        addAtIndex(size, value);
    }

    public void deleteAtIndex(int index) {
        if(index< 0 || index>= size)    return;
        if(index == 0)  head= head.next;
        else {
            Node prev = head;
            Node temp= null;
            for (int i = 0; i < index-1; i++) {
                prev = prev.next;
            }
            temp= prev.next;
            prev.next = temp.next;
            size--;
            System.out.println("Deleted Node: "+ temp.value+" at index: "+ index);
        }
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
        ll.addAtIndex(0,22);
        ll.addAtIndex(1,23);
        ll.showLinkedList();
        System.out.println(ll.get(0));
       // ll.deleteAtIndex(1);
        ll.addAtHead(20);
        ll.showLinkedList();
        ll.addAtTail(21);
        ll.showLinkedList();
    }
}