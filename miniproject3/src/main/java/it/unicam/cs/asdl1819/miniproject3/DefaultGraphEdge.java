package it.unicam.cs.asdl1819.miniproject3;

/**
 * Implementazione di default dell'interfaccia {@code GraphEdge<V,E>}.
 * 
 * @author Luca Tesei
 *
 * @param <V>
 *            etichette dei nodi del grafo
 * @param <E>
 *            etichette degli archi del grafo
 */
public class DefaultGraphEdge<V, E> implements GraphEdge<V, E> {

    private final GraphNode<V> node1;

    private final GraphNode<V> node2;

    private E label;

    private final boolean directed;

    private double weight;

    /**
     * Costruisce un arco di un grafo con etichetta e peso.
     * 
     * @param node1
     *                     primo nodo (nodo sorgente in caso di grafo diretto)
     * @param node2
     *                     secondo nodo (nodo destinazione in caso di grafo
     *                     diretto)
     * @param label
     *                     etichetta dell'arco
     * @param directed
     *                     true se l'arco è diretto, false altrimenti
     * @param weight
     *                     peso associato all'arco
     * 
     * @throws NullPointerException
     *                                  se almeno uno dei due nodi è nullo
     */
    public DefaultGraphEdge(GraphNode<V> node1, GraphNode<V> node2, E label,
            boolean directed, double weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.label = label;
        this.directed = directed;
        this.weight = weight;
    }

    /**
     * Costruisce un arco di un grafo con etichetta e senza peso.
     * 
     * @param node1
     *                     primo nodo (nodo sorgente in caso di grafo diretto)
     * @param node2
     *                     secondo nodo (nodo destinazione in caso di grafo
     *                     diretto)
     * @param label
     *                     etichetta dell'arco
     * @param directed
     *                     true se l'arco è diretto, false altrimenti
     * 
     * @throws NullPointerException
     *                                  se almeno uno dei due nodi è nullo
     */
    public DefaultGraphEdge(GraphNode<V> node1, GraphNode<V> node2, E label,
            boolean directed) {
        this.node1 = node1;
        this.node2 = node2;
        this.label = label;
        this.directed = directed;
        this.weight = Double.NaN;
    }

    /**
     * Costruisce un arco di un grafo senza etichetta e senza peso.
     * 
     * @param node1
     *                     primo nodo (nodo sorgente in caso di grafo diretto)
     * @param node2
     *                     secondo nodo (nodo destinazione in caso di grafo
     *                     diretto)
     * @param directed
     *                     true se l'arco è diretto, false altrimenti
     * 
     * @throws NullPointerException
     *                                  se almeno uno dei due nodi è nullo
     */
    public DefaultGraphEdge(GraphNode<V> node1, GraphNode<V> node2,
            boolean directed) {
        this.node1 = node1;
        this.node2 = node2;
        this.label = null;
        this.directed = directed;
        this.weight = Double.NaN;
    }

    public E getLabel() {
        return label;
    }

    public void setLabel(E label) {
        this.label = label;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GraphNode<V> getNode1() {
        return node1;
    }

    public GraphNode<V> getNode2() {
        return node2;
    }

    public boolean isDirected() {
        return directed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (directed ? 1231 : 1237);
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        // Modificata l'implementazione standard per rispettare la proprietà
        // dell'hashcode anche nel caso di archi non diretti con ordine diverso
        result = prime * result + ((node1 == null) ? 0 : node1.hashCode())
                + ((node2 == null) ? 0 : node2.hashCode());
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof DefaultGraphEdge))
            return false;
        DefaultGraphEdge<?, ?> other = (DefaultGraphEdge<?, ?>) obj;
        if (directed != other.directed)
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (Double.doubleToLongBits(weight) != Double
                .doubleToLongBits(other.weight))
            return false;
        // Modificato per la differenza tra il caso non diretto e il caso
        // diretto
        if (directed) {
            if (node1 == null) {
                if (other.node1 != null)
                    return false;
            } else if (!node1.equals(other.node1))
                return false;
            if (node2 == null) {
                if (other.node2 != null)
                    return false;
            } else if (!node2.equals(other.node2))
                return false;
            return true;
        } else { // caso speciale per grafi non diretti
            if (node1 == null && other.node1 == null && node2 == null
                    && other.node2 == null)
                return true;
            // Se non sono entrambi nulli ci deve essere una uguaglianza diretta
            // o incrociata
            if (node1.equals(other.node1) && node2.equals(other.node2))
                return true;
            if (node1.equals(other.node2) && node2.equals(other.node1))
                return true;
            // Se solo uno dei due è nullo allora l'uguaglianza deve essere sul
            // nodo non nullo
            if (node1 == null && node2 != null && other.node1 == null
                    && other.node2 != null && node2.equals(other.node2))
                return true;
            if (node1 == null && node2 != null && other.node1 != null
                    && other.node2 == null && node2.equals(other.node1))
                return true;
            if (node1 != null && node2 == null && other.node1 != null
                    && other.node2 == null && node1.equals(other.node1))
                return true;
            if (node1 != null && node2 == null && other.node1 == null
                    && other.node2 != null && node1.equals(other.node2))
                return true;
            // Negli altri casi non sono uguali
            return false;
        }
    }
}
