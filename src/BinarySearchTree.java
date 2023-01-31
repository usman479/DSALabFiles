public class BinarySearchTree {  //  Inorder(Ascending) L root R // Pre Order Root L R // Post L R root
    BSTNode root;

    BinarySearchTree() {
        root=null;
    }

    public void insert(int data){
        BSTNode n = new BSTNode(data);
        if(root == null) {
            root = n;
            return;
        }
        BSTNode current = root;
        BSTNode prev = current;
        while(current != null) {
            prev= current;
            if(current.data < data) {
               current = current.right;
            } else if(current.data > data) {
                current = current.left;
            }
        }
        if(prev.data < data){
            prev.right = n;
        } else {
            prev.left = n;
        }
    }

    public void inOrder(BSTNode n){
        if(n != null) {
            inOrder(n.left);
            System.out.print(n.data+ ",");
            inOrder(n.right);
        }
    }

    public void preOrder(BSTNode n){
        if(n != null) {
            System.out.print(n.data + ",");
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void postOrder(BSTNode n){
        if(n != null) {
            postOrder(n.left);
            postOrder(n.right);
            System.out.print(n.data + ",");
        }
    }

    public boolean search(int key) {
        BSTNode current = root;
        while(current != null) {
            if(current.data == key){
                return true;
            } else if(current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public BSTNode minValue(BSTNode r) {
        BSTNode current = r;
        while(r.left != null) {
            r = r.left;
        }
        return r;
    }

    public BSTNode delete(BSTNode rt, int val) {
        if(rt == null) {
            return null;
        }
        if(rt.data > val){
            rt.left = delete(rt.left,val);
        } else if (rt.data < val) {
            rt.right = delete(rt.right,val);

        } else {
            if(rt.left == null){
                BSTNode temp = rt.right;
                return temp;
            } else if (rt.right == null) {
                BSTNode temp = rt.left;
                return temp;
            }
            BSTNode temp2 = minValue(rt.right);
            rt.data = temp2.data;
            rt.right = delete(rt.right, temp2.data);
        }
        return rt;
    }


}
