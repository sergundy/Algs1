package new_sem.lab_5a;

import java.util.*;

@SuppressWarnings("unchecked")

public class BFS
{
    private int V;   // Количество вершин
    private LinkedList<Integer> adj[]; //Список смежности
 
    @SuppressWarnings("rawtypes")
    // Конструктор
    BFS (int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Функция добавления ребра в граф
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    public void BFs(int s)
    {
        // Все вершины по умолчанию не посещённые
        boolean visited[] = new boolean[V];
 
        // Создаётся очередь
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Отмечается текущий узел как посещенный и поставить его в очередь
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Удаляем вершину из очереди и выводим её
            s = queue.poll();
            System.out.print(s + " ");
 
            // Получаем все вершины смежные с s
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

