public class Stack {
    int top;
    int elements[];
    int size;

    Stack(int size){
        this.size = size;
        elements = new int[size];
        this.top = -1;
    }


    public void push(int letter){
        if(top == size-1){
            System.out.println("StackOverflow");
        } else {
            elements[++top] = letter;
        }
    }

    public int pop() {
        if(top == -1) {
            return -1;
        }

        return elements[top--];
    }


}
