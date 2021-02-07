package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class WczytajGraph {  // zrobić abstract jak zadziala wczytanie
    // liczba krawedzi
    private int e;
    // liczba wierzcholkow
    private int v;
    // tablica list sasiedztwa danego wierzcholka
    private List<Integer>[] neighborList;
    //punkt poczatkowy czytania grafu
    private int start;

    /**
     * pobieranie grafu z pliku tekstowego podanego w kosntruktorze
     * linia po lini
     * @param fileName
     */
    public WczytajGraph(String fileName) {
        try {

            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            boolean first = true;
            String line;
            int lineCounter = 0; // licznik wczytanych lini


            while ((line = br.readLine()) != null) {
                String[] linia0 = line.split(" ");
                        //wczytanie lini 0; .
                        if (lineCounter == 0) {
                            int v = linia0.length;
                            System.out.println("Liczba wierzchołków: " + v + "\n");
                            addNewNeighborList(v);
                            System.out.print("Linia 0) ");
                            for (String j : linia0) {
                                System.out.print(j + " ");

                            }
                            System.out.print("\n");
                        }

                        // linie od 1 do N+1 - listy sasiedztwa oddzielonee spacjami (wierzchołek lista sąsiadów)
                        if (lineCounter > 0 && lineCounter <= v) {
                            String[] kolejnaLinia = line.split(" ");

                            //System.out.println(lineNext);
                            //System.out.println("Wczytana Linia " +kolejnaLinia );
                            //graph.addEdge(i,i);
                            System.out.println("\n");

                            int counterOfLetter = 0; // zmienna pomocnicza do pominiecia znaku0 w lini
                            for (String j : kolejnaLinia) {
                                //zamiana String na int - znak wierzcholka pierwszego
                                BigInteger sign0 =new BigInteger(kolejnaLinia[0].getBytes());
                                int vv=sign0.intValue() -65;//BigInt to Int.
                                //zamiana String na int - znak wierzcholkow polaczonych krawedzia
                                BigInteger lineNext = new BigInteger(j.getBytes());
                                int ww = lineNext.intValue() -65;//BigInt to Int.
                                System.out.print(j + "("+ lineNext+ ") ");
                                if (counterOfLetter==0) {
                                    System.out.println("nie dodano"); // pomijamy dodanie wierzcholka spojnego a-a, b-b itd.
                                }else {
                                    addEdge(vv, ww);
                                    System.out.println("Dodano: " +vv+ "," +ww);
                                }
                                counterOfLetter++;
                            }

                        }
                        //wierzcholek startowy
                        if (lineCounter == v+1) {
                            System.out.println("DFS \n");
                            DFS dfs = new DFS(this, 0);
                            System.out.println("BFS \n");
                            BFS bfs = new BFS(this, 0);
                }
                //wypisanie grafu w postaci listy sasiedztwa
//                System.out.println("Graf nieskierowany: " + toString());
                lineCounter++; // zwiekszamy licznik wczytanych lini
            }



            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param v
     *            dodawanie pustych wierzcholkow (Vertices) w grafie do listy sąsiedztwa
     */
    @SuppressWarnings("unchecked")
    void addNewNeighborList(int v) {
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
        //neighborList[w].add(v);
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
        s.append("wierzcholki: ").append(v).append("; krawedzie: ").append(e/2)
                .append(newLine);
        for (int i = 0; i < v; i++) {
            int w0 = i+65;
            char c0=(char)w0;
            s.append(c0).append(": ");
            for (int w : neighborList[i]) {
                int w1 = w+65;
                char c=(char)w1;
                s.append(c).append(" ");
            }
            s.append(newLine);
        }
        return s.toString();
    }

}

