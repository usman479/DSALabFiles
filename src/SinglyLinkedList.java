public class SinglyLinkedList {
    Node head;
    Node tail;
    SinglyLinkedList(){
        head = null;
        tail = null;
    }
    public void insertLast (int data){
        Node n = new Node(data);
        if(head != null){
            tail.next = n;
        } else {
            head = n;
        }
        tail = n;
    }

    public void traverse(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+ " ==> ");
            temp = temp.next;
        }
    }

    public boolean search(int key){
        Node temp = head;
        while(temp != null){
            if(key == temp.data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean update(int oldKey,int newKey){
        Node temp = head;
        while(temp != null){
            if(oldKey == temp.data){
                temp.data = newKey;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean insertAfter(int data, Node newNode){
        Node temp = head;
        boolean flag = false;
        while(temp != null){
            if(data == temp.data){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            newNode.next = temp.next;
            temp.next = newNode;
            return true;
        }
        return false;
    }

    public void printReverse(Node n){
        Node temp = n;
        if(temp != null){
            printReverse(temp.next);
            System.out.println(temp.data);
        }
    }

    public void delete(int key){
        Node temp = head;
        if(head.data == key){
            head = head.next;
        } else if(tail.data == key){
            while(temp.next != null){
                if(temp.next.data == key){
                    temp.next = null;
                    tail = temp;
                    return;
                }
            }
        } else {
            while(temp.next.data != key){
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
}
