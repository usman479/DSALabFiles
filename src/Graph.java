import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    Vertex [] VList;
    int numOfVertex;
    int [][] adjMat;

    public Graph(int size) {
        VList = new Vertex[size];
        adjMat = new int[size][size];
        numOfVertex = -1;
    }

    public boolean addVertex(char name) {
        if(numOfVertex == VList.length-1){
            return false;
        }
        Vertex v = new Vertex(name);
        numOfVertex++;
        VList[numOfVertex] = v;
        return true;
    }

    public void addEdge(char v1,char v2) {
        int a=0;
        int b=0;
        for(int i=0; i<VList.length; i++) {
            if(VList[i].name == v1){
                a=i;
            }
            if(VList[i].name == v2){
                b=i;
            }
        }
        adjMat[a][b] = 1;
        adjMat[b][a] = 1;
    }

    public void BFS() {
        Queue<Vertex> q = new LinkedList<>();
        int index = 0;
        q.add(VList[0]);
        VList[0].isVisited = true;
        while(q.size() != 0){
            System.out.print(q.peek().name + " <--> ");
            for(int i=0; i<VList.length; i++) {
                if(q.peek().name == VList[i].name){
                    index = i;
                    break;
                }
            }
            for(int i=0; i<VList.length; i++) {
                if(adjMat[index][i] == 1 && !VList[i].isVisited){
                    q.add(VList[i]);
                    VList[i].isVisited = true;
                }
            }
            q.remove();

        }
    }

    public void DFS() {
        Stack<Vertex> stack = new Stack<Vertex>();

        int index = 0;
        stack.push(VList[0]);
        VList[0].isVisited = true;
        System.out.println(stack.peek().name);
        while (stack.size() != 0) {
            for (int i = 0; i < VList.length; i++) {
                if (stack.peek().name == VList[i].name) {
                    index = i;
//                    break;
                }
            }
            boolean child = false;
            for (int i = 0; i < VList.length; i++) {
                if (adjMat[index][i] == 1 && !VList[i].isVisited) {
                    stack.push(VList[i]);
                    VList[i].isVisited = true;
                    System.out.println(stack.peek().name);
                    child = true;
                    break;
                }
            }
            if (!child) {
                stack.pop();
            }

        }
    }
}
