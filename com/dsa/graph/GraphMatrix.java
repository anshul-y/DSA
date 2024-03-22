package com.dsa.graph;

import com.dsa.Answer;

public class GraphMatrix {

    private int[][] adjMatrix;
    private int V;
    private int E;

    /**
     * Constructs a graph with the specified number of vertices.
     *
     * @param verticesNum the number of vertices in the graph
     */
    GraphMatrix(int verticesNum) {
        this.adjMatrix = new int[verticesNum][verticesNum];
        this.V = verticesNum;
        this.E = 0;
    }

    /**
     * Adds an undirected edge between two vertices in the graph.
     *
     * @param vertices1 the index of the first vertex
     * @param vertices2 the index of the second vertex
     */
    public void addEdge(int vertices1, int vertices2) {
        this.adjMatrix[vertices1][vertices2] = 1;
        this.adjMatrix[vertices2][vertices1] = 1;
        this.E++;
    }

    public void print() {
        Answer.print(this.adjMatrix, "Matrix");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.V + " vertices, "+this.E+" edges \n  ");
        for (int i = 0; i < adjMatrix.length; i++) {
            sb.append(" "+i);
        }

        sb.append("\n");
        for (int i = 0; i < adjMatrix.length; i++) {
            sb.append(i+": ");
            for(int w : adjMatrix[i]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
    }
}