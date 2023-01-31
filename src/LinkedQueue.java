public class LinkedQueue {
    QNode front;
    QNode rear;

    LinkedQueue() {
        front = rear = null;
    }

    public void enqueue(int d) {
        QNode n = new QNode(d);
        if(front == null) {
            front = rear = n;
            return;
        }
        rear.next = n;
        rear = n;
    }

    public QNode dequeue() {
        if(front == null){
            System.out.println("Queue is empty");
            return null;
        } else if(front == rear){
            QNode temp = front;
            front = rear = null;
            return temp;
        }
        QNode temp = front;
        front = front.next;
        return temp;
    }

    public QNode peek() {
        return front;
    }
}
