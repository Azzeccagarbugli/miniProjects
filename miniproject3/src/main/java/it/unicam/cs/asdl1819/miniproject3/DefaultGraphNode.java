/**
 * 
 */
package it.unicam.cs.asdl1819.miniproject3;

/**
 * Implementazione di default dell'interfaccia {@code GraphNode<V>}.
 * 
 * @author Luca Tesei
 * 
 * @param <V>
 *            etichette dei nodi del grafo
 *
 */
public class DefaultGraphNode<V> implements GraphNode<V> {
    private final V label;

    private int color;

    private double floatingPointDistance;

    private int integerDistance;

    private int enteringTime;

    private int exitingTime;

    private GraphNode<V> previous;

    /**
     * Costruisce un nodo assegnando tutti i valori associati ai valori di
     * default.
     * 
     * @param label
     *                  l'etichetta da associare al nodo
     * 
     * @throws NullPointerException
     *                                  se l'etichetta è null.
     */
    public DefaultGraphNode(V label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public double getFloatingPointDistance() {
        return floatingPointDistance;
    }

    public void setFloatingPointDistance(double floatingPointDistance) {
        this.floatingPointDistance = floatingPointDistance;
    }

    public int getIntegerDistance() {
        return integerDistance;
    }

    public void setIntegerDistance(int integerDistance) {
        this.integerDistance = integerDistance;
    }

    public int getEnteringTime() {
        return enteringTime;
    }

    public void setEnteringTime(int enteringTime) {
        this.enteringTime = enteringTime;
    }

    public int getExitingTime() {
        return exitingTime;
    }

    public void setExitingTime(int exitingTime) {
        this.exitingTime = exitingTime;
    }

    public GraphNode<V> getPrevious() {
        return previous;
    }

    public void setPrevious(GraphNode<V> previous) {
        this.previous = previous;
    }

    public V getLabel() {
        return label;
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
        result = prime * result + ((label == null) ? 0 : label.hashCode());
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
        if (!(obj instanceof DefaultGraphNode))
            return false;
        DefaultGraphNode<?> other = (DefaultGraphNode<?>) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return label.toString();
    }
    
}
