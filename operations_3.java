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


    public void copyList(){
        DoubleLinkedList dll2=new DoubleLinkedList();
        Node curr=head;

        while (curr!=null) {
            dll2.addTail(curr.value);
            curr=curr.next;
        }
        System.out.println("\n The new Copied List is");
        dll2.print();
    }

    public void copyListReverse(){
        DoubleLinkedList dll3=new DoubleLinkedList();
        Node curr=head;

        while (curr!=null) {
            dll3.addHead(curr.value);
            curr=curr.next;
        }
        System.out.println("\nThe copied reverse list is");
        dll3.print();
    }

    public void removeDuplicates(){
        Node curr=head;
        Node deleteMe;

        while (curr!=null) {
            if ((curr.next!=null) && curr.value==curr.next.value) {
                deleteMe=curr.next;
                curr.next=deleteMe.next;
                curr.next.prev=curr;
                if (deleteMe==tail) {
                    tail=curr;
                }
            }else{
                curr=curr.next;
            }
        }
        System.out.println("\nThe new list is");
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
        dll1.addTail(400);
        dll1.addTail(500);
        dll1.print();
        dll1.copyList();
        dll1.copyListReverse();
        dll1.removeDuplicates();
        dll1.print();
    }
}
