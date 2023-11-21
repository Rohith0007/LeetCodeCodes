import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class graph {
    int V;
    LinkedList adj[];
    graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int i, int i1) {
        adj[i].add(i1);
    }

    void BFS(int s)
    {
        boolean visited[] = new boolean[V];
        for (boolean b : visited) {
            b = false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(queue.size() != 0) {
            int queueInt = queue.poll();
            System.out.print(queueInt + " ");
            for (int i : (Iterable<Integer>) adj[queueInt]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void printOut() {
        for (int i=0; i<V; i++) {
            System.out.println(adj[i]);
        }
    }

    public static void main(String[] args) {
        graph g = new graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
    }

}
