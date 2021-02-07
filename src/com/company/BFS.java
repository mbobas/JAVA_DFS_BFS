package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
        // tablica krawedzi ktora jest
        // przechowuje wierzcholki z ktorych mozna sie dostac do biezacego
        // okreslonego indeksem tablicy
        private int[] edgeTo;
        // tablica odwiedzonych wierzcholkow
        private boolean[] marked;
        // wierzcholek zrodlowy, z ktorego rozpoczynamy przeszukiwanie
        private final int source;
        private Queue<Integer> priorityQueue;

        public BFS(WczytajGraph graph, int source) {
            this.source = source;
            edgeTo = new int[graph.getNumberOfVertices()];
            marked = new boolean[graph.getNumberOfVertices()];
            priorityQueue = new PriorityQueue<Integer>(graph.getNumberOfVertices());
            priorityQueue.offer(source);
            bfs(graph, source);
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
            return marked[vertex];
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
            for (int w = vertex; w != source; w = edgeTo[w]) {
                path.push(w);
               //System.out.println(w);
            }
            // dodaj na koniec krawedz zrodlowa
            path.push(source);
            return path;
        }

        private void bfs(WczytajGraph graph, int vertex) {
            // oznaczamy wierzcholek jako odwiedzony
            marked[vertex] = true;
            int w0 = vertex+65;
            char c0=(char)w0;
            //System.out.println(c0);
            // dodajemy wierzcholek zrodlowy do kolejki
            priorityQueue.offer(vertex);

            // dopoki kolejka nie jest pusta, wybieramy krawedz o najnizszym
            // priorytecie
            // i oznaczamy jako odwiedzone wierzcholki z listy sasiedztwa usuwanego
            // wierzcholka
            // oraz dodajemy wierzcholki z listy sasiedztwa do kolejki
            while (!priorityQueue.isEmpty()) {
                int v = priorityQueue.remove();
                int w1 = v+65;
                char c1=(char)w1;
                System.out.println(c1);
                for (int w : graph.getneighborList(v)) {
                    if (!marked[w]) {
                        edgeTo[w] = v;
                        marked[w] = true;
                        priorityQueue.offer(w);
                    }
                }
            }
        }
    }
