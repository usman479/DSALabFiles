public class StackChar {
    int top;
    char name[];
    int size;

    StackChar(int size){
        this.size = size;
        name = new char[size];
        this.top = -1;
    }

    boolean isEmpty() {
        if(top == -1) {
            return true;
        }
        return false;
    }

    public void push(char letter){
        if(top == size-1){
            System.out.println("StackOverflow");
        } else {
            name[++top] = letter;
        }
    }

    public char peek() {
        if(top == -1) {
            System.out.println("Stack Underflow!");
            return '$';
        }
        return name[top];
    }

    public char pop() {
        if(top == -1) {
            System.out.println("Stack Underflow!");
            return '$';
        }

        return name[top--];
    }

    public void reverse(){
        if(top == -1){
            return;
        }
        System.out.print(name[top--]);
        reverse();
    }



}
