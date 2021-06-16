package new_sem.lab_5a;

import java.util.Arrays;
import java.util.Comparator;

public class Kruscal {
    private final int V; // Количество вершин в графе
    private int N; // Текущее количество вершин
    private final int[] parent;
    private final double[][] min ;
    private final Edge[] edge; // Список ребер

    public Kruscal(int v, int e) {
        this.V = v;
        this.N = 0;
        edge = new Edge[e];
        parent = new int[V];
        min = new double[V][V];
        N = 0;
    }

    // Добавление ребра
    public void addEdge(int start, int end, int weight) {
        edge[N] = new Edge(start, end, weight);
        N++;
    }

    // Поиск
    public int find(int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    public void connect(int i, int j, int[] size) {
        i = find(i);
        j = find(j);
        if (size[i] > size[j]) {
            parent[j] = i;
            size[i] += size[j];
        } else {
            parent[i] = j;
            size[j] += size[i];
        }
    }
    

    public void kruskal() {
        Arrays.sort(edge, new SortByWeight()); // Сортировка по весу ребра
        int[] size = new int[V];
        double min_dist = 0;
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 0;
        }

        int edge_count = 0;
        int k = 0;
        while (k < V - 1) {
            Edge e = edge[edge_count];
            edge_count++;
            if (find(e.either()) != find(e.getW())) {
                connect(find(e.either()), find(e.getW()), size);
                min[e.either()][e.getW()] = e.weight();
                k++;
            }
        }
        for (int i = 0; i < min.length; i++) {
            for (int j = 0; j < min.length; j++) {
                if (min[i][j] != 0) {
                    System.out.printf("%d - %d веса = %.2f \n", i, j, min[i][j]);
                    min_dist += min[i][j];
                }
            }
        }
        System.out.println("");
        System.out.printf("Минимальное расстояние = %.2f", min_dist);
    }
}

// Сортировка по весу ребра
 class SortByWeight implements Comparator<Edge> {
    public int compare(Edge a, Edge b) {
        if ( a.weight() < b.weight() )
            return -1;
        else if ( a.weight() == b.weight() )
            return 0;
        else
            return 1;
    }
 }