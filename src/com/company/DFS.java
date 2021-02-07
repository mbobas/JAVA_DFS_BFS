package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFS {
    // tablica krawedzi ktora jest
    // przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
    // okreslonego indeksem tablicy
    private int[] listaKrawedzi;
    // tablica odwiedzonych wierzcholkow
    private boolean[] listaOdwiedzonychWierzcholkow;
    // wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
    private final int source;

    public DFS(PrzegladanieGrafu graph, int source) {
        this.source = source;
        listaKrawedzi = new int[graph.getNumberOfVertices()];
        listaOdwiedzonychWierzcholkow = new boolean[graph.getNumberOfVertices()];
        dfs(graph, source);
    }

    /**
     *
     * @param vertex
     *            indeks wierzcholka dla ktorego ma byc sprawdzenie istnienia
     *            sciezki
     * @return true jesli istnieje sciezka z wierzcholka zrodlowego danego w
     *         konstruktorze do wierzcholka {@code vertex}
     */
    public boolean hasPathTo(int vertex) {
        return listaOdwiedzonychWierzcholkow[vertex];
    }

    /**
     *
     * @param vertex
     *            docelowy wierzcholek
     * @return stos wierzcholkow prowadzacych ze zrodal {@code source} do celu
     *         {@code vertex} jesli sciezka nie istnieje zwracana jest pusta
     *         kolekcja
     */
    public Iterable<Integer> getPathTo(int vertex) {
        Deque<Integer> path = new ArrayDeque<Integer>();
        // jesli nie istnieje sciezka zwroc pusta sciezke
        if (!hasPathTo(vertex)) {
            return path;
        }
        // dopoki istnieje wierzcholek dodawaj go do stosu
        for (int w = vertex; w != source; w = listaKrawedzi[w]) {
            path.push(w);
        }
        // dodaj na koniec krawedz zrodlowa
        path.push(source);
        return path;
    }

    private void dfs(PrzegladanieGrafu graph, int vertex) {
        // oznaczamy wierzcholek jako odwiedzony
        listaOdwiedzonychWierzcholkow[vertex] = true;
        int w0 = vertex+65;
        char c0=(char)w0;
        System.out.println(c0);
        // dla kazdego sasiedniego wierzcholka jesli nie jest oznaczony
        // wywolujemy rekurencyjnie metode dfs, ktora odwiedzi wierzchoki i
        // zapisze trase
        for (int w : graph.getneighborList(vertex)) {
            if (!listaOdwiedzonychWierzcholkow[w]) {
                listaKrawedzi[w] = vertex;
                dfs(graph, w);
            }
        }
    }
}

