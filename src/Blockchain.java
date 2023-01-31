public class Blockchain {
    Block genesis;
    int counter;

    public Blockchain(){
        counter=0;
        genesis=null;
    }

    public void addBlock(String data){
        if(genesis == null){
            Block b= new Block(data,"0");
            genesis = b;
        } else {
            Block curr=genesis;
            while(curr.next != null){
                curr=curr.next;
            }
            Block b = new Block(data,curr.hash);
            curr.next = b;
        }
        counter++;
    }

    public void PrintChain()
    {
        int i=1;
        Block curr=genesis;
        while(curr!=null)
        {
            System.out.println("\nBlock: "+ i+"\nData: "+curr.data+"\nHash: "+curr.hash+"\nPrevious Hash: "+curr.preHash);

            i++;
            curr=curr.next;
        }
    }

    public boolean IsValid()
    {
        int i=0;
        Block curr=genesis;
        Block prev;

        if(!(genesis.preHash.equals("0")&&genesis.hash.equals(genesis.getSHA(genesis.data+genesis.timestamp+genesis.preHash))))
        {

            return false;
        }
        while(curr.next!=null)
        {
            i++;
            prev=curr;
            curr=curr.next;
            if(!curr.hash.equals(curr.getSHA(curr.data+curr.timestamp+curr.preHash)))
            {

                return false;
            }
            if(!curr.preHash.equals(prev.hash))
            {

                return false;
            }
        }
        return true;

    }
}
