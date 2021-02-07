package com.company;

import java.io.*;
import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrzegladanieGrafu {  // zrobić abstract jak zadziala wczytanie
    // liczba krawedzi
    private int e;
    // liczba wierzcholkow
    private int v;
    // tablica list sasiedztwa danego wierzcholka
    private List<Integer>[] neighborList;

    /**
     * pobieranie grafu z pliku tekstowego podanego w kosntruktorze
     * linia po lini
     * @param fileName
     */
//    public  PrzegladanieGrafu(String fileName) {
//        try {
//
//            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
//            boolean first = true;
//            String line;
//            int lineCounter = 0; // licznik wczytanych lini
//
//
//            while ((line = br.readLine()) != null) {
//
//
//                String[] linia0 = line.split(" ");
//                int iloscWierzcholkow = linia0.length;
//
//
//                        //wczytanie lini 0; .
//                        if (lineCounter == 0) {
//                            System.out.println("Liczba wierzchołków: " + iloscWierzcholkow + "\n");
//                            PrzegladanieGrafu graph = new PrzegladanieGrafu(iloscWierzcholkow);
//                            System.out.print("Linia 0) ");
//                            for (String j : linia0) {
//                                System.out.print(j + " ");
//
//                            }
//                            System.out.print("\n");
//                        }
//
//                        // linie od 1 do N+1 - listy sasiedztwa oddzielonee spacjami (wierzchołek lista sąsiadów)
//                        if (lineCounter > 0 && lineCounter <= iloscWierzcholkow + 1) {
//                            String[] kolejnaLinia = line.split(" ");
//                            BigInteger lineNext = new BigInteger(line.getBytes());
//                            //System.out.println(lineNext);
//                            System.out.println("Wczytana Linia " +lineNext );
//                            //graph.addEdge(i,i);
//                        }
//                //wypisanie grafu w postaci listy sasiedztwa
//                System.out.println("Graf nieskierowany: " + graph);
//                lineCounter++; // zwiekszamy licznik wczytanych lini
//            }
//
//            br.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//

    /**
     *
     * @param v
     *            dodawanie pustych wierzcholkow (Vertices) w grafie do listy sąsiedztwa
     */
    @SuppressWarnings("unchecked")
    public PrzegladanieGrafu(int v) {
        this.v = v;
        this.e = 0;
        //lista sądziedztwa
        neighborList = (List<Integer>[]) new List[v];
        for (int i = 0; i < v; i++) {
            neighborList[i] = new ArrayList<Integer>();
        }
    }

    /**
     * Dodaje krawedz v-w do grafu nieskierowanego.
     *
     * @param v
     *            jeden z wierzcholkow krawedzi
     * @param w
     *            drugi z wierzcholkow krawedzi
     */
    public void addEdge(int v, int w) {
        neighborList[v].add(w);
        neighborList[w].add(v);
        e++;
    }

    /**
     *
     * @return liczbe krawedzi
     */
    public int getNumberOfEdges() {
        return e;
    }

    /**
     * @return liczbe wierzcholkow
     */
    public int getNumberOfVertices() {
        return v;
    }

    /**
            * Zwraca liste sasiedztwa danego wierzcholka.
	 *
             * @param v
	 *            indeks wierzcholka skierowanego
	 * @return zwraca iterowalna kolekcje wierzcholkow sasiadujacych
	 */
    public Iterable<Integer> getneighborList(int v) {
        return neighborList[v];
    }

    /**
     * @return opis grafu.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        s.append("wierzcholki: ").append(v).append("; krawedzie: ").append(e)
                .append(newLine);
        for (int i = 0; i < v; i++) {
            s.append(i).append(": ");
            for (int w : neighborList[i]) {
                s.append(w).append(" ");
            }
            s.append(newLine);
        }
        return s.toString();
    }

}

