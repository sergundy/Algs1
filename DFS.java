package new_sem.lab_5a;

import java.util.*;
 
@SuppressWarnings("unchecked")

public class DFS
{
    public LinkedList<Integer> adjLists[]; //Список смежности
    public boolean visited[]; // Посешённые вершины
 
    // Конструктор
    DFS(int vertices)
    {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];
 
        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }
 
    // Добавление ребра
    public void addEdge(int src, int dest)
    {
        adjLists[src].add(dest);
    }
 
    @SuppressWarnings("rawtypes")
    public void DFs(int vertex)
    {
        visited[vertex] = true;
        System.out.print(vertex + " ");
 
        Iterator ite = adjLists[vertex].listIterator();
        while (ite.hasNext())
        {
            int adj = (int) ite.next();
            if (!visited[adj])
                DFs(adj);
        }
    }
}
    