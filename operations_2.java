package practice;

public class DoubleLinkedList {

    class Node{
        private int value;
        private Node next;
        private Node prev;
        /* A generic Node of double Linked List*/ 
        public Node(int v, Node n, Node p){
            value=v;
            next=n;
            prev=p;
        }
        /* The first or any node with agiven value should be of this structure */
        Node (int v){
            value=v;
            next=null;
            prev=null;
        }
    }
    private Node head;
    private Node tail;
    private int size=0;

    public void addHead(int value){
        Node newNode=new Node(value, null, null);
        if(size==0){
            head=tail=newNode;
        }
        else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
            
        }
        size++;
    }

    public void addTail(int value){
        Node newNode=new Node(value, null, null);
        if (size==0) {
            head=tail=newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void deleteList(){
        head=null;
        tail=null;
        size=0;
        System.out.println("\nList is deleted");
    }

    public void sortedInsert(int value) {
        Node temp = new Node(value);

        Node curr = head;
        if (curr == null)// first element
        {
            head = temp;
            tail = temp;
        }

        if (head.value >= value)// at the begining
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
            System.out.println("\n Node is inserted at the beginning");
        }

        while (curr.next != null && curr.next.value < value)// treversal
        {
            curr = curr.next;
        }

        if (curr.next == null)// at the end
        {
            tail = temp;
            temp.prev = curr;
            curr.next = temp;
            System.out.println("\n Node is inserted at the end");
        } else/// all other
        {
            temp.next = curr.next;
            temp.prev = curr;
            curr.next = temp;
            temp.next.prev = temp;
            System.out.println("\n Node is inserted ");
        }
    }


    public void reverseList() {
        Node curr = head;
        Node tempNode;
        while (curr != null) {
            tempNode = curr.next;
            curr.next = curr.prev;
            curr.prev = tempNode;

            if (curr.prev == null) {
                tail = head;
                head = curr;
                System.out.println("\nThe list is reversed");
            }
            curr = curr.prev;
        }
    }


    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    
    public static void main(String[] args) {
        DoubleLinkedList dll1=new DoubleLinkedList();
        dll1.addHead(100);
        dll1.addTail(200);
        dll1.addTail(300);
        dll1.addTail(400);
        dll1.addTail(500);
        dll1.print();
        dll1.sortedInsert(10);
        dll1.print();
        dll1.sortedInsert(350);
        dll1.print();
        dll1.sortedInsert(550);
        dll1.print();
        dll1.reverseList();
        dll1.print();      
    }
}
