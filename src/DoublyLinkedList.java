public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    DoublyLinkedList(){
        this.head = this.tail = null;
    }

    public void insertLast(int data){
        DoublyNode n = new DoublyNode(data);
        if(head == null){
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public void traverseStart(){
        DoublyNode temp = head;
        while(temp != null) {
            System.out.print(temp.data +" ==> ");
            temp = temp.next;
        }
    }

    public void traverseLast(){
        DoublyNode temp = tail;
        while(temp != null){
            System.out.print(temp.data +" ==> ");
            temp = temp.prev;
        }
    }

    public void insertList(DoublyLinkedList list) {
        DoublyNode temp = list.head;
        while(temp != null){
            tail.next = temp;
            temp.prev = tail;
            this.tail = temp;
            temp = temp.next;
        }
    }

    public boolean twoWaySearch(int key){
        // homework
        if(head.data == key){
            return true;
        }
        DoublyNode tempHead = head.next;
        DoublyNode tempTail = tail;

        while(tempHead != tempTail && tempTail.next != tempHead.prev){
            if(tempHead.data == key || tempTail.data == key){
                return true;
            }
            tempHead = tempHead.next;
            tempTail = tempTail.prev;
        }
        return false;
    }

    public boolean insertAt(int data,int pos){
        DoublyNode n = new DoublyNode(data);
        int i=1;
        if(pos == 1){
            n.next = head;
            head.prev = n;
            head = n;
            return true;
        }
        DoublyNode temp = head;

        while(temp != null ){

            if(pos == i){
                temp.prev.next = n;
                n.prev = temp.prev;
                n.next = temp;
                temp.prev = n;
                return true;
            }
            temp = temp.next;
            i++;
        }

        return false;

    }

    public boolean twoWayDelete(int key){
        DoublyNode tempHead = head.next;
        DoublyNode tempTail = tail;
        if(head.data == key){
            head = tempHead;
            head.prev = null;
            return true;
        }

        while(tempHead != tempTail && tempTail.next != tempHead.prev){
            if(tempHead.data == key){
                tempHead.prev.next = tempHead.next;
                tempHead.next.prev = tempHead.prev;
                return true;
            } else if(tempTail.data == key){
                tempTail.prev.next = tempTail.next;
                tempTail.next.prev = tempTail.prev;
                return true;
            }
            tempHead = tempHead.next;
            tempTail = tempTail.prev;
        }


        return false;

    } // incomplete

//    public boolean delete(int key){ // incomplete
//        DoublyNode temp = head;
//        if(head.data == key){
//            head = temp.next;
//            head.prev = null;
//            return true;
//        }
//        if(tail.data == key){
//            while(temp != null){
//                if(temp.next.next == null){
//                    tail = temp;
//                    tail.next = null;
//                    return true;
//                }
//            }
//        }
//        if(){
//            while(temp != null){
//                if(temp.data == key){
//                    temp.next.prev = temp.prev;
//                    temp.prev.next = temp.next;
//                }
//                temp = temp.next;
//            }
//        }
//        return false;
//    }

    // swap two consecative nodes // homework
}

