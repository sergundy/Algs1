package new_sem.lab_5a;

public  class Floyd_Warshall {
    private int V ; // количество вершин в графе
    private final int INF = 1000000;
    private int adj[][]; // матрица смежности
    
    public Floyd_Warshall(int v)
    {
        this.V = v;
        adj = new int[V][V];
        for(int j = 0; j < V; j++)
            for(int k = 0; k < V; k++)
            {
                if(j == k)
                    adj[j][k] = 0;
                else {
                adj[j][k] = INF;
                }
            }
    }

    class Vertex
    {
        public char с; // Метка
        public boolean isIn;
        public Vertex(char С)
        {
            с = С;
            isIn = false;
        }
    }

    // Добавление ребра в граф
    public void addEdge(int v, int w, int weight)
    {
        adj[v][w] = weight;
        adj[w][v] = weight;
    }

    void FW() {
        int distance[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++) {
                distance[i][j] = adj[i][j];
            }
        for (k = 0; k < V; k++) {
            for (i = 0; i < V;i++) {
                for (j = 0; j < V; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
        print(distance);
    }

    // Вывод
    void print(int n[][]) {
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (n[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(n[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
