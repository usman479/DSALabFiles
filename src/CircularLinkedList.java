public class CircularLinkedList {
    DoublyNode head;
    DoublyNode tail;

    CircularLinkedList(){
        this.head=this.tail=null;
    }
    public void insert(int data){
        DoublyNode n = new DoublyNode(data);
        if(head == null){
            head=n;
            tail=n;
            head.next=tail;
            head.prev=tail;
            tail.prev=head;
            tail.next=head;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
            tail.next = head;
            head.prev = tail;
        }
    }

    public void taversing(){
        DoublyNode current = head;

        do {
            System.out.println(current.data + "==> ");
            current = current.next;
        } while(current != head);

//        while(current.next != head){
//            System.out.println(current.data + "==> ");
//            current = current.next;
//        }
    }
}
