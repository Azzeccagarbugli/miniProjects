/**
 * 
 */
package it.unicam.cs.asdl1819.miniproject3;

/**
 * Questa interfaccia raggruppa le caratteristiche di un arco, possibilmente
 * pesato ed etichettato, facente parte di un grafo. I nodi del grafo sono
 * etichettati con oggetti della classe {@code V} e gli archi sono etichettati
 * con oggetti della classe {@code E}. Le interfacce {@code GraphNode<V>} e
 * {@code Graph<V,E>} definiscono le operazioni generiche sui nodi e sul grafo,
 * rispettivamente.
 * 
 * Un arco può essere diretto o non diretto, tale informazione è immutabile e
 * disponibile tramite il metodo {@code isDirected()}. I due nodi collegati
 * dall'arco sono immutabili e devono essere non nulli. L'etichetta dell'arco è
 * opzionale e può quindi essere nulla.
 * 
 * All'arco può essere associato un peso tramite i metodi
 * {@code setWeight(double} e {@code getWeight()}. Il peso, se non specificato
 * nel costruttore, è inizializzato automaticamente a {@code Double.NaN}.
 * 
 * Due archi sono uguali se e solo se collegano gli stessi nodi, hanno la stessa
 * etichetta, lo stesso peso e sono entrambi diretti o entrambi non diretti. Nel
 * caso di archi non diretti l'ordine dei nodi non conta, cioè un arco tra
 * {@code n1} ed {@code n2} e un arco tra {@code n2} ed {@code n1} sono lo
 * stesso arco se hanno la stessa etichetta e lo stesso peso, oltre ad essere
 * entrambi non diretti.
 * 
 * @author Luca Tesei
 * 
 * @param <V>
 *            etichette dei nodi
 * @param <E>
 *            etichette degli archi
 *
 */
public interface GraphEdge<V, E> {

    /**
     * Restituisce il primo nodo di questo arco, la sorgente in caso di arco
     * diretto.
     * 
     * @return il primo nodo di questo arco, la sorgente in caso di arco
     *         diretto.
     */
    public GraphNode<V> getNode1();

    /**
     * Restituisce il secondo nodo di questo arco, la destinazione in caso di
     * arco diretto.
     * 
     * @return il secondo nodo di questo arco, la destinazione in caso di arco
     *         diretto.
     */
    public GraphNode<V> getNode2();

    /**
     * Restituisce l'etichetta di questo arco.
     * 
     * @return l'etichetta correntemente associata a questo arco.
     */
    public E getLabel();

    /**
     * Assegna all'arco una certa etichetta.
     * 
     * @param label
     *                  l'etichetta da assegnare.
     */
    public void setLabel(E label);

    /**
     * Indica se questo arco è diretto o no.
     * 
     * @return true se questo arco è diretto, false altrimenti.
     */
    public boolean isDirected();

    /**
     * Restituisce il peso assegnato all'arco, zero di default.
     * 
     * @return il peso associato all'arco
     */
    public double getWeight();

    /**
     * Assegna un certo peso a questo arco.
     * 
     * @param weight
     *                   il peso da assegnare a questo arco
     */
    public void setWeight(double weight);

}
