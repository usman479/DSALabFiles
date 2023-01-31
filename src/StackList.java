public class StackList {
    StackNode top = null;

    public void push(int data){
        StackNode n = new StackNode(data);
        if (top != null) {
            n.next = top;
        }
        top = n;
    }

    public StackNode pop() {
        if(top == null) {
            System.out.println("Stack Underflow!");
            return null;
        }
        StackNode temp = top;
        top = top.next;
        return temp;
    }

//    public Node peek(){
//
//    }
}
