package new_sem.lab_5a;

import java.util.*;

@SuppressWarnings("unchecked")
public class Dijkstra {
    private final int V; // Количество вершин
    private ArrayList<DirectedEdge>[] adj;
    private DirectedEdge[] edgeTo; // Ребра кратчайших путей
    private double[] distTo; // Кратчайший путь до источника
    private IndexPQ<Double> pq; // Очередь с приоритетом 

    public Dijkstra(int V){
    this.V = V;
    adj = new ArrayList[V];
    for(int i = 0; i < V; i++)
        adj[i] = new ArrayList<>();
    }
    public int V(){
        return V;
    }

    // Добавление ребра
    public void addEdge(DirectedEdge e){ 
        adj[e.getV()].add(e);
    }

    // Возвращает ребро направленное из v
    public Iterable<DirectedEdge> adj(int v){ 
        return adj[v];
    }

    public Iterable<DirectedEdge> edges(){
        ArrayList<DirectedEdge> list = new ArrayList<>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e: adj[v]) {
                list.add(e);
                System.out.println(e);
            }
        return list;
    }

    @SuppressWarnings("rawtypes")
    public void DIjkstra(int s){ // s - начальная точка
        edgeTo = new DirectedEdge[V()];
        distTo =new double[V()];
        pq = new IndexPQ(V());
        for (int v = 0; v < V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s]=0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty())
            relax( pq.delMin());
    }

    private void  relax( int v){
        for(DirectedEdge e: adj(v)){
            int w = e.getW();
            if(distTo[w] > distTo[v]+ e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w]= e;
                if(pq.contains(w))
                    pq.change(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);

            }
        }
    }

    // Вывод
    public void print(){
        for(int i = 0; i < edgeTo.length; i++){
            DirectedEdge e = edgeTo[i];
            if(e!=null) {
                System.out.println(e);
            }

        }
    }

    // Путь до вершины
    public double distTo(int v){
        return distTo[v];
    }

    // Проверка на наличие пути до вершины
    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    @SuppressWarnings("rawtypes")
    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<DirectedEdge> path = new Stack();
        String str = String.format("путь из 0 в %d", v);
        System.out.println(str);
        for(DirectedEdge e = edgeTo[v]; e!=null; e = edgeTo[e.getV()]){
            path.push(e);
            System.out.println(e.toString());
        }
        System.out.println("вес пути = " + distTo(v));

        return path;
    }
}

// Направленное взвешенное ребро
 class DirectedEdge {
    private final int v; // Начальная вершина
    private final int w; // Конечная вершина
    private final double weight;// Вес ребра
    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // Вес
    public double weight(){
        return weight;
    }

    // Получение начальной вершины
    public int getV(){
        return v;
    }

    // Получение конечной вершины
    public int getW(){
        return w;
    }

    // Вывод
    public String toString(){
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
