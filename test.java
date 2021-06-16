package new_sem.lab_5a;

public class test {
    public static void main(String[] args) {

        Dijkstra a = new Dijkstra(8);
        DirectedEdge d1 = new DirectedEdge(0, 2, 3);
        DirectedEdge d2 = new DirectedEdge(0, 4, 5);
        DirectedEdge d3 = new DirectedEdge(2, 7, 1);
        DirectedEdge d4 = new DirectedEdge(4, 7, 8);
        DirectedEdge d5 = new DirectedEdge(4, 5, 4);
        DirectedEdge d6 = new DirectedEdge(7, 3, 5);
        DirectedEdge d7 = new DirectedEdge(7, 5, 9);
        DirectedEdge d8 = new DirectedEdge(3, 6, 1);
        DirectedEdge d9 = new DirectedEdge(5, 7, 2);
        DirectedEdge d10 = new DirectedEdge(5, 1, 6);
        DirectedEdge d11 = new DirectedEdge(5, 4, 3);
        DirectedEdge d12 = new DirectedEdge(1, 3, 7);
        DirectedEdge d13 = new DirectedEdge(6, 2, 8);
        DirectedEdge d14 = new DirectedEdge(6, 0, 5);
        DirectedEdge d15 = new DirectedEdge(6, 4, 4);

        a.addEdge(d1);
        a.addEdge(d2);
        a.addEdge(d3);
        a.addEdge(d4);
        a.addEdge(d5);
        a.addEdge(d6);
        a.addEdge(d7);
        a.addEdge(d8);
        a.addEdge(d9);
        a.addEdge(d10);
        a.addEdge(d11);
        a.addEdge(d12);
        a.addEdge(d13);
        a.addEdge(d14);
        a.addEdge(d15);

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Дейкстры:\n");

        a.DIjkstra(0);
        a.pathTo(7);//путь в вершину 7
        a.pathTo(5);//путь в 5

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Флойда-Уоршела:\n");
        Floyd_Warshall g = new Floyd_Warshall(8);
        g.addEdge(0, 2, 3);
        g.addEdge(0, 4, 5);
        g.addEdge(2, 7, 1);
        g.addEdge(4, 7, 8);
        g.addEdge(4, 5, 4);
        g.addEdge(7, 3, 5);
        g.addEdge(7, 5, 9);
        g.addEdge(3, 6, 1);
        g.addEdge(5, 7, 2);
        g.addEdge(5, 1, 6);
        g.addEdge(5, 4, 3);
        g.addEdge(1, 3, 7);
        g.addEdge(6, 2, 8);
        g.addEdge(6, 0, 5);
        g.addEdge(6, 4, 4);
        g.FW();

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("DFS (обход в глубину):\n");
        DFS b = new DFS(4);
 
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 2);
        b.addEdge(2, 0);
        b.addEdge(2, 3);
        b.addEdge(3, 3);
 
        b.DFs(2);

        System.out.println("");

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("BFS (обход в ширину):\n");

        BFS c = new BFS(4);
 
        c.addEdge(0, 1);
        c.addEdge(0, 2);
        c.addEdge(1, 2);
        c.addEdge(2, 0);
        c.addEdge(2, 3);
        c.addEdge(3, 3);
 
        c.BFs(2);

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Крускала:\n");

        Kruscal с = new Kruscal(8,15);
        с.addEdge(0, 2, 3);
        с.addEdge(0, 4, 5);
        с.addEdge(2, 7, 1);
        с.addEdge(4, 7, 8);
        с.addEdge(4, 5, 4);
        с.addEdge(7, 3, 5);
        с.addEdge(7, 5, 9);
        с.addEdge(3, 6, 1);
        с.addEdge(5, 7, 2);
        с.addEdge(5, 1, 6);
        с.addEdge(5, 4, 3);
        с.addEdge(1, 3, 7);
        с.addEdge(6, 2, 8);
        с.addEdge(6, 0, 5);
        с.addEdge(6, 4, 4);

        с.kruskal();

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Прима:\n");

        Prim d = new Prim(7);
        Edge e1 = new Edge(0,1, 2);
        Edge e2 = new Edge(0,2, 1);
        Edge e3 = new Edge(0,3, 3);
        Edge e4 = new Edge(0,5, 6);
        Edge e5 = new Edge(1,4, 3);
        Edge e6 = new Edge(1,3, 1);
        Edge e7 = new Edge(2,5, 3);
        Edge e8 = new Edge(2,3, 2);
        Edge e9 = new Edge(4,6, 4);
        Edge e10 = new Edge(5,6, 7);
        Edge e12 = new Edge(3,6, 7);
        d.addEdge(e1);
        d.addEdge(e2);
        d.addEdge(e3);
        d.addEdge(e4);
        d.addEdge(e5);
        d.addEdge(e6);
        d.addEdge(e7);
        d.addEdge(e8);
        d.addEdge(e9);
        d.addEdge(e9);
        d.addEdge(e10);
        d.addEdge(e12);

        d.PRim();

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");
    
    }
}

