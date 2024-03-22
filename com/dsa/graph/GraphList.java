package com.dsa.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.dsa.Answer;

public class GraphList {

    private LinkedList<Integer>[] adjList;
    private int V;
    private int E;

    GraphList(int nodes) {
        this.adjList = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjList[i] = new LinkedList<>();
        }
        this.V = nodes;
        this.E = 0;
    }

    /**
     * Adds an undirected edge between two vertices in the graph.
     * 
     * @param vertices1 The first vertex of the edge.
     * @param vertices2 The second vertex of the edge.
     */
    public void addEdge(int vertices1, int vertices2) {
        this.adjList[vertices1].add(vertices2);
        this.adjList[vertices2].add(vertices1);
        this.E++; // Increment the number of edges
    }

    /**
     * Returns a string representation of the graph.
     * 
     * @return A string containing information about the vertices and edges of the
     *         graph.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.V + " vertices, " + this.E + " edges \n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (int w : adjList[i]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Performs a breadth-first search (BFS) traversal of the graph, starting from
     * vertex 0.
     * Prints the visited vertices in the order they are visited.
     */
    public void bfs() {
        boolean[] visited = new boolean[this.V]; // Track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal
        queue.offer(0); // Start BFS from vertex 0
        visited[0] = true; // Mark vertex 0 as visited
        System.out.print("Breadth First Search: ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue vertex from queue
            System.out.print(vertex + " "); // Print visited vertex
            // Enqueue adjacent vertices that have not been visited
            for (int adjVertex : this.adjList[vertex]) {
                if (!visited[adjVertex]) {
                    queue.offer(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
        System.out.println();
    }

    /**
     * Performs a depth-first search (DFS) traversal of the graph, starting from
     * vertex 0.
     * Prints the visited vertices in the order they are visited.
     */
    public void dfs() {
        boolean[] visited = new boolean[this.V]; // Track visited vertices
        Stack<Integer> stack = new Stack<>(); // Stack for DFS traversal
        stack.push(0); // Start DFS from vertex 0
        visited[0] = true; // Mark vertex 0 as visited
        System.out.print("Depth First Search: ");
        while (!stack.isEmpty()) {
            int vertex = stack.pop(); // Pop vertex from stack
            System.out.print(vertex + " "); // Print visited vertex
            // Push adjacent vertices that have not been visited onto the stack
            for (int adjVertex : this.adjList[vertex]) {
                if (!visited[adjVertex]) {
                    stack.push(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }
        System.out.println();
    }

    /**
     * Performs a depth-first search (DFS) traversal of the graph starting from the
     * specified source vertex.
     * Prints the visited vertices in the order they are visited.
     *
     * @param s The source vertex from which DFS traversal starts.
     */
    public void dfs(int s) {
        boolean[] visited = new boolean[this.V]; // Track visited vertices
        System.out.print("Depth First Search (Recursion): ");
        dfsRecursive(s, visited); // Start DFS traversal from the source vertex
        System.out.println();
    }

    /**
     * Helper method for performing DFS traversal recursively.
     *
     * @param vertex  The current vertex being visited.
     * @param visited Array to track visited vertices.
     */
    private void dfsRecursive(int vertex, boolean[] visited) {
        visited[vertex] = true; // Mark the current vertex as visited
        System.out.print(vertex + " "); // Print the visited vertex
        // Recursively visit all adjacent vertices that have not been visited yet
        for (int adjVertex : this.adjList[vertex]) {
            if (!visited[adjVertex]) {
                dfsRecursive(adjVertex, visited);
            }
        }
    }

    /**
     * Checks if two vertices are connected in the graph.
     *
     * @param vertex1 The first vertex.
     * @param vertex2 The second vertex.
     * @return {@code true} if the vertices are connected, {@code false} otherwise.
     */
    public boolean isConnected(int vertex1, int vertex2) {
        // Get the component IDs for each vertex
        int[] compId = connectedComponent();
        // Check if the component IDs of the two vertices are the same
        return compId[vertex1] == compId[vertex2];
    }

    /**
     * Calculates the number of connected components in the graph.
     *
     * @return The number of connected components.
     */
    public int getConnectedComponents() {
        // Get the component IDs for each vertex
        int[] compId = connectedComponent();
        // Calculate the number of unique component IDs
        return getComponents(compId);
    }

    /**
     * Helper method to calculate the number of unique component IDs.
     *
     * @param compId An array containing the component IDs for each vertex.
     * @return The number of unique component IDs.
     */
    private int getComponents(int[] compId) {
        // Create a set to store unique component IDs
        Set<Integer> compIds = new HashSet<>();
        // Iterate over the array of component IDs
        for (int i : compId) {
            // Add each component ID to the set
            compIds.add(i);
        }
        // Return the size of the set, which represents the number of unique component
        // IDs
        return compIds.size();
    }

    /**
     * Finds connected components in the graph and assigns component IDs to each
     * vertex.
     * Each connected component is printed on a separate line.
     */
    public int[] connectedComponent() {
        boolean[] visited = new boolean[this.V]; // Array to keep track of visited vertices
        int[] compId = new int[this.V]; // Array to store component IDs
        int count = 0; // Counter for component IDs

        // Iterate through each vertex and find connected components
        for (int v = 0; v < this.V; v++) {
            if (!visited[v]) {
                // System.out.print("Component " + v + ": ");
                connectedComponent(visited, compId, count, v); // Call recursive function to find connected component
                // System.out.println(); // Move to the next line for the next component
                count++; // Increment component ID counter
            }
        }
        return compId;
    }

    /**
     * Recursive helper function to find connected components starting from a given
     * vertex.
     * 
     * @param visited Array to keep track of visited vertices
     * @param compId  Array to store component IDs
     * @param count   Counter for component IDs
     * @param vertex  Current vertex being explored
     */
    private void connectedComponent(boolean[] visited, int[] compId, int count, int vertex) {
        visited[vertex] = true; // Mark the current vertex as visited
        compId[vertex] = count; // Assign the component ID to the current vertex
        // System.out.print(vertex + " "); // Print the current vertex

        // Explore all adjacent vertices of the current vertex
        for (int v : this.adjList[vertex]) {
            if (!visited[v]) {
                connectedComponent(visited, compId, count, v); // Recursively find connected components
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Example usage of GraphList class to create and print a graph.
         */
        GraphList g = new GraphList(4); // Create a graph with 4 vertices
        g.addEdge(0, 1); // Add an edge between vertices 0 and 1
        g.addEdge(1, 2); // Add an edge between vertices 1 and 2
        g.addEdge(2, 3); // Add an edge between vertices 2 and 3
        g.addEdge(3, 0); // Add an edge between vertices 3 and 0
        System.out.println(g); // Print the adjacency list representation of the graph

        /**
         * Example usage of GraphList class to create, print, and perform traversals on
         * a graph.
         */
        GraphList g2 = new GraphList(5); // Create a graph with 5 vertices
        g2.addEdge(0, 3); // Add an edge between vertices 0 and 3
        g2.addEdge(0, 1); // Add an edge between vertices 0 and 1
        g2.addEdge(2, 4); // Add an edge between vertices 2 and 4
        g2.addEdge(1, 2); // Add an edge between vertices 1 and 2
        g2.addEdge(3, 2); // Add an edge between vertices 3 and 2
        System.out.println(g2); // Print the adjacency list representation of the graph
        g2.bfs(); // Perform Breadth-First Search traversal on the graph
        g2.dfs(); // Perform Depth-First Search traversal (iterative) on the graph
        g2.dfs(0); // Perform Depth-First Search traversal (recursive) on the graph starting from
                   // vertex 0

        /**
         * Example usage of GraphList class to create a graph with 6 vertices, add
         * edges, print the graph,
         * and find connected components.
         */
        GraphList g3 = new GraphList(6); // Create a graph with 6 vertices
        g3.addEdge(0, 3); // Add an edge between vertices 0 and 3
        g3.addEdge(0, 1); // Add an edge between vertices 0 and 1
        g3.addEdge(2, 4); // Add an edge between vertices 2 and 4
        System.out.println(g3); // Print the adjacency list representation of the graph
        g3.connectedComponent(); // Find connected components in the graph

        int compNum = g3.getConnectedComponents();
        Answer.print(compNum, "Number of Components");
        boolean isConnected = g3.isConnected(0, 2);
        Answer.print(isConnected, "Is Connected");

    }
}
