package new_sem.lab_5a;

import java.util.ArrayList;

public class Prim {

    private final int V; // Количество вершин графа
    private final ArrayList<Edge>[] adj; // Список смежности

    @SuppressWarnings("unchecked")
    public Prim(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    // Добавление ребра
    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    private Edge[] edgeTo; // Кратчайшие ребра из вершины
    private double[] distTo; // Вес ребер
    private boolean[] marked; // Отмеченные ребра
    private IndexPQ<Double> pq; // Пригодные перекрестные ребра

    @SuppressWarnings("rawtypes")
    public void PRim() {
        edgeTo = new Edge[V()];
        distTo = new double[V()];
        marked = new boolean[V()];
        for (int i = 0; i < V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
            
        pq = new IndexPQ(V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty())
            visit(pq.delMin());
        
    }

    // "Посещение" вершины
    public void visit(int v) {
        marked[v] = true;
        for (Edge e : adj(v)) {
            int w = e.other(v);
            if (marked[w])
                continue;
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w))
                    pq.change(w, distTo[w]);
                else {
                    System.out.println(e.toString());
                    pq.insert(w, distTo[w]);
                }

            }
        }
    }
}

class Edge implements Comparable<Edge> {
    private final int v; // Первая вершина
    private final int w; // Вторая вершина
    private final double weight; // Вес ребра

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // Возвращает вес
    public double weight() {
        return weight;
    }

    // Возвращает вершину
    public int either() {
        return v;
    }

    public int other(int vertex){
        if(vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("недопустимое ребро");
    }


    // Фнкция сравнения весов
    public int compareTo(Edge that){
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else return 0;
    }

    // Вывод
    public String toString(){
        return String.format("%d - %d веса = %.2f", v, w, weight);
    }

    // Возвращает вторую вершину
    public int getW(){
        return w;
    }
}

