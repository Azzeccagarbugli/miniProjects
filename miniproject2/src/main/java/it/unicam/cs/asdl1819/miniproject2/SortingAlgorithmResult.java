package it.unicam.cs.asdl1819.miniproject2;

import java.util.List;

/**
 * Risultato di un algoritmo di ordinamento. Contiene la sequenza ordinata di
 * elementi e il numero di operazioni di confronto effettuate.
 * 
 * @author Luca Tesei
 *
 * @param <E>
 *            Tipo degli elementi della sequenza ordinata.
 */
public class SortingAlgorithmResult<E> {

    private List<E> l;

    private int countCompare;

    /**
     * Costruisce un risultato di un algoritmo di odinamento
     * 
     * @param l
     *                         la lista ordinata
     * @param countCompare
     *                         il numero di operazioni di confronto effettuate
     */
    public SortingAlgorithmResult(List<E> l, int countCompare) {
        this.l = l;
        this.countCompare = countCompare;
    }

    /**
     * Restituisce la lista ordinata.
     * 
     * @return la lista ordinata
     */
    public List<E> getL() {
        return l;
    }

    /**
     * Restituisce il numero di confronti effettuati.
     * 
     * @return il numero di confronti effettuati.
     */
    public int getCountCompare() {
        return countCompare;
    }

}
