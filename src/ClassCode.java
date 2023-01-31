// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class node{
    int data;
    node next;
    node prev;

    public node(int data)
    {
        this.data=data;
        next=null;
        prev=null;
    }
}
class DLL{
    node head;
    node tail;
    // int Count
    public DLL()
    {
        head=tail=null;
    }

    public void Insert(int data)
    {
        // Count++;
        node n=new node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }
        else
        {
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
    }

    public void Print()
    {
        node curr=head;
        while(curr!=null)
        {
            System.out.println(curr.data);
            curr=curr.next;
        }
    }

    public void PrintRev()
    {
        node curr=tail;
        while(curr!=null)
        {
            System.out.println(curr.data);
            curr=curr.prev;
        }
    }

    public void insertAt(int pos,int data)
    {
        node n=new node(data);
        int c=1;
        node curr=head;
        if(pos==1)
        {
            n.next=head;
            head.prev=n;
            head=n;
        }
        else{
            while(curr!=null)
            {
                if(c==pos)
                {
                    curr.prev.next=n;
                    n.prev=curr.prev;
                    n.next=curr;
                    curr.prev=n;
                }
                c++;
                curr=curr.next;
            }
        }
    }

    public void Delete(int val)
    {

        if(val==head.data)
        {
            head=head.next;
            head.prev=null;
        }
        if(tail.data==val)
        {
            node curr=head;
            System.out.println(curr.data);
            while(curr!=null)
            {
                if(curr.next.next==null)
                {
                    tail=curr;
                    tail.next=null;
                    // break;
                }
                curr=curr.next;
            }
        }

        if(val!=head.data&&val!=tail.data){
            node curr=head;
            System.out.println(curr.data);
            while(curr!=null)
            {
                if(curr.data==val)
                {
                    curr.next.prev=curr.prev;
                    curr.prev.next=curr.next;
                }

                curr=curr.next;
            }
        }
    }
}
class HelloWorld {
    public static void main(String[] args) {
        DLL obj=new DLL();
        obj.Insert(5);
        obj.Insert(191);
        obj.Insert(5);
        obj.Insert(13);
        obj.Insert(5);
        obj.Insert(5);
        obj.Delete(5);
        //   obj.Print();
        //obj.PrintRev();
    }
}