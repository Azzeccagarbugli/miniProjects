/**
 * 
 */
package it.unicam.cs.asdl1819.miniproject3;

/**
 * Questa interfaccia raggruppa le operazioni tipicamente associate a un nodo
 * facente parte di un grafo. I nodi del grafo sono etichettati con oggetti
 * della classe {@code V} e gli archi del grafo sono etichettati con oggetti
 * della classe {@code E}. Le interfacce {@code GraphEdge<V,E>} e
 * {@code Graph<V,E>} definiscono le operazioni generiche sugli archi e sul
 * grafo, rispettivamente.
 * 
 * Le operazioni sono quelle che sono usate dagli algoritmi su grafi più comuni:
 * attribuzione e modifica di un colore, di una distanza, di un puntatore a un
 * nodo predecessore e di tempi di ingresso/uscita durante una visita.
 * L'etichetta è immutabile, le altre informazioni possono cambiare.
 * 
 * Due nodi sono uguali se e solo se hanno etichetta uguale.
 * 
 * @author Luca Tesei
 * 
 * @param <V>
 *            etichette dei nodi
 *
 */
public interface GraphNode<V> {

    /**
     * Restituisce l'etichetta associata al nodo che lo identifica univocamente
     * nel grafo.
     * 
     * @return the label
     */
    public V getLabel();

    /**
     * Colore bianco associato al nodo.
     */
    public static int COLOR_WHITE = 0;

    /**
     * Colore grigio associato al nodo.
     */
    public static int COLOR_GREY = 1;

    /**
     * Colore nero associato al nodo.
     */
    public static int COLOR_BLACK = 2;

    /**
     * Restituisce il colore corrente del nodo.
     * 
     * @return the color
     */
    public int getColor();

    /**
     * 
     * Assegna al nodo un certo colore.
     * 
     * @param color
     *                  the color to set
     */
    public void setColor(int color);

    /**
     * Restituisce il valore corrente di una distanza intera associata al nodo.
     * 
     * @return the distance
     */
    public int getIntegerDistance();

    /**
     * Assegna al nodo un valore di una distanza intera ad esso associata.
     * 
     * @param distance
     *                     the distance to set
     */
    public void setIntegerDistance(int distance);

    /**
     * Restituisce il valore corrente di una distanza associata al nodo.
     * 
     * @return the distance
     */
    public double getFloatingPointDistance();

    /**
     * Assegna al nodo un valore di una distanza ad esso associata.
     * 
     * @param distance
     *                     the distance to set
     */
    public void setFloatingPointDistance(double distance);

    /**
     * Restituisce il nodo del grafo che correntemente è assegnato come
     * predecessore di questo nodo. Ad esempio può essere usato da un algoritmo
     * che costruisce un albero di copertura.
     * 
     * @return the previous
     */
    public GraphNode<V> getPrevious();

    /**
     * 
     * Assegna a questo nodo un nodo predecessore.
     * 
     * @param previous
     *                     the previous to set
     */
    public void setPrevious(GraphNode<V> previous);

    /**
     * Restituisce il tempo di ingresso in questo nodo durante una visita in
     * profondità.
     * 
     * @return il tempo di ingresso in questo nodo durante una visita in
     *         profondità
     */
    public int getEnteringTime();

    /**
     * Assegna un tempo di ingresso in questo nodo durante una visita in
     * profondità.
     * 
     * @param time
     *                 il tempo di ingresso da assegnare
     */
    public void setEnteringTime(int time);

    /**
     * Restituisce il tempo di uscita da questo nodo durante una visita in
     * profondità.
     * 
     * @return il tempo di uscita da questo nodo durante una visita in
     *         profondità
     */
    public int getExitingTime();

    /**
     * Assegna un tempo di uscita da questo nodo durante una visita in
     * profondità.
     * 
     * @param time
     *                 il tempo di uscita da assegnare
     */
    public void setExitingTime(int time);

}