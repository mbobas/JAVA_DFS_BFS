package com.company;

public class Main {


//klasa abstrakcyjna Przeglądanie grafu
    //metody abstrakcyjne
    //wstaw(numer_wierzcholka);
    ///pobierz(numer_wierzcholka);

//do zapamietania wierzchołków wykorzystać array list
// List<Wierzchołek> list = new ArrayList<>();

    //Graf przedstawić w postaci list sasiedztwa lub macierzy
    //informacje ografie wczytywane z pliku,
    //nazwa pliku moze byc podana w konstrukotrze,

    // nastepnie napisz klasy DFS, BFS

    public static void main(String[] args) {
	// write your code here


        WczytajGraph graph = new WczytajGraph("graf.txt");
        System.out.println("\n Graf nieskierowany: " + graph);
//        System.out.println("DFS \n");
//
//        DFS dfs = new DFS(graph, 0);
//        System.out.println("\n BFS \n");
//        BFS bfs = new BFS(graph, 0);

        // grafy nieskierowane
        // PrzegladanieGrafu graph = new PrzegladanieGrafu(6);

//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//
//        graph.addEdge(1, 4);
//
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 5);
//
//        graph.addEdge(3, 0);
//
//        graph.addEdge(4, 3);

//        System.out.println("Graf nieskierowany: " + graph);


    }
}
