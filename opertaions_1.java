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


    public void  isPresent(int key) {
        boolean flag = false;
        Node temp=head;
        int i=1;
        while (temp!=null) {
            if (temp.value==key) {
                flag=true;
                break;
            }
            temp.next=temp;
            i++;
        }
        if(flag==true)  
        System.out.println("\nNode is present in the list at the position : " + i);  
   else  
        System.out.println("\nNode is not present in the list");  
    }

    public void removeHead(){
        if (size==0) {
            System.out.println("List is empty");
        }
        head=head.next;

        if (head==null) {
            tail=null;
        }
        else{
            tail.prev=null;
        }
        size--;
        System.out.println("\nHead Node deleted sucessfully");
    }

    public void removeNode(int key) {
        Node curr = head;
        if (curr == null)// empty list
            System.out.println("\nlist is empty");

        if (curr.value == key)// head is the node with value key.
        {
            head = head.next;
            size--;
            if (head != null)
                head.prev = null;
            else
                tail = null; // only one element in list.
                System.out.println("\n Node deleted sucessfully");
        }

        while (curr.next != null) {
            if (curr.next.value == key) {
                curr.next = curr.next.next;
                if (curr.next == null)// last element case.
                    tail = curr;
                else
                    curr.next = curr;
                size--;
                System.out.println(" \nNode deleted sucessfully");
            }
            curr = curr.next;
        }
        System.out.println("\nNode deleted");
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
        dll1.isPresent(100);
        dll1.removeHead();
        dll1.print();
        dll1.removeNode(200);
        dll1.print();
    }
}
