/**
 * 
 */
package it.unicam.cs.asdl1819.miniproject3;

import java.util.Set;

/**
 * Interfaccia per un generico grafo i cui nodi sono etichettati con elementi
 * della classe {@code V} ed i cui archi sono etichettati con elementi della
 * classe {@code E}. Le interfacce {@code GraphNode<V>} e {@code GraphEdge<V,E>}
 * definiscono le operazioni generiche sui nodi e sugli archi.
 * 
 * Il grafo può essere diretto o non diretto, la classe che implementa questa
 * interfaccia specifica questo aspetto. Tale informazione è disponibile tramite
 * il metodo {@code isDirected()}.
 * 
 * Le etichette dei nodi sono obbligatorie ed uniche, cioè un nodo non può avere
 * etichetta nulla e due nodi con la stessa etichetta sono lo stesso nodo.
 * 
 * Le etichette degli archi sono opzionali.
 * 
 * @author Luca Tesei
 * 
 * @param <V>
 *            etichette dei nodi
 * @param <E>
 *            etichette degli archi
 *
 */
public interface Graph<V, E> {

    /**
     * Restituisce il numero di nodi in questo grafo.
     * 
     * @return il numero di nodi in questo grafo.
     */
    public int nodeCount();

    /**
     * Restituisce il numero di archi in questo grafo.
     * 
     * @return il numero di archi in questo grafo.
     */
    public int edgeCount();

    /**
     * Restituisce la dimensione di questo grafo definita come il numero di nodi
     * più il numero di archi.
     * 
     * @return la dimensione di questo grafo definita come il numero dei nodi
     *         più il numero degli archi.
     */
    public int size();

    /**
     * Determina se questo grafo è vuoto, cioè senza nodi e senza archi.
     * 
     * @return se questo grafo è vuoto, false altrimenti.
     */
    public boolean isEmpty();

    /**
     * Cancella tutti i nodi e gli archi di questo grafo portandolo ad essere un
     * grafo vuoto.
     */
    public void clear();

    /**
     * Determina se questo grafo è diretto oppure no.
     * 
     * @return true se questo grafo è diretto, false altrimenti.
     */
    public boolean isDirected();

    /**
     * Restituisce l'insieme dei nodi di questo grafo.
     * 
     * @return l'insieme dei nodi di questo grafo, possibilmente vuoto.
     */
    public Set<GraphNode<V>> getNodes();

    /**
     * Aggiunge un nodo a questo grafo.
     * 
     * @param node
     *                 il nuovo nodo da aggiungere
     * @return true se il nodo è stato aggiunto, false altrimenti cioè se il
     *         nodo è già presente
     * @throws NullPointerException
     *                                  se il nodo passato è null
     */
    public boolean addNode(GraphNode<V> node);

    /**
     * Rimuove un nodo da questo grafo. Tutti gli archi collegati al nodo
     * vengono anch'essi eliminati.
     * 
     * Questa operazione è opzionale.
     * 
     * @param node
     *                 il nodo da rimuovere
     * @return true se il nodo è stato rimosso, false se il nodo non era
     *         presente
     * @throws NullPointerException
     *                                           se il nodo passato è null
     * 
     * @throws UnsupportedOperationException
     *                                           se l'implementazione del grafo
     *                                           non supporta questa operazione
     */
    public boolean removeNode(GraphNode<V> node);

    /**
     * Determina se c'è un certo nodo in questo grafo.
     * 
     * @param node
     *                 il nodo cercato
     * @return true se il nodo {@code node} esiste in questo grafo
     * 
     * @throws NullPointerException
     *                                  se il nodo passato è null
     */
    public boolean containsNode(GraphNode<V> node);

    /**
     * Restituisce il nodo di questo grafo avente l'etichetta passata.
     * 
     * @param label
     *                  l'etichetta del nodo da restituire
     * 
     * @return il nodo di questo grafo che ha l'etichetta uguale a {@code label}
     * 
     * @throws NullPointerException
     *                                      se l'etichetta è nulla
     * 
     * @throws IllegalArgumentException
     *                                      se non esiste un nodo di questo
     *                                      grafo avente l'etichetta uguale a
     *                                      {@code label}
     */
    public GraphNode<V> getNode(V label);

    /**
     * Restituisce un indice unico attualmente associato a un certo nodo
     * nell'intervallo <code>[0, this.nodeCount() - 1]</code>. Questa
     * funzionalità è tipicamente disponibile se il grafo è rappresentato con
     * una matrice di adiacenza. Tale indice può anche essere usato per
     * identificare i nodi in strutture dati esterne come array o liste che
     * contengono informazioni aggiuntive calcolate, ad esempio, da un algoritmo
     * sul grafo.
     * 
     * Questa operazione è opzionale.
     * 
     * @param label
     *                  l'etichetta del nodo di cui restituire l'indice
     * 
     * @return un indice unico nell'intervallo
     *         <code>[0, this.nodeCount() - 1]</code> attualmente associato al
     *         nodo con etichetta {@code label}. L'indice può cambiare se il
     *         grafo viene modificato togliendo dei nodi
     * 
     * @throws NullPointerException
     *                                           se l'etichetta passata è null
     * @throws IllegalArgumentException
     *                                           se un nodo con l'etichetta
     *                                           {@code label} non esiste in
     *                                           questo grafo
     * 
     * @throws UnsupportedOperationException
     *                                           se questa operazione non è
     *                                           supportata dall'implementazione
     *                                           di questo grafo
     */
    public int getNodeIndex(V label);

    /**
     * Restituisce il nodo attualmente associato a un certo indice
     * nell'intervallo <code>[0, this.nodeCount() - 1]</code>. Questa
     * funzionalità è tipicamente disponibile se il grafo è rappresentato con
     * una matrice di adiacenza.
     * 
     * Questa operazione è opzionale.
     * 
     * @param i
     *              l'indice del nodo.
     * @return l'etichetta del nodo correntemente associato all'indice i
     * 
     * @throws IndexOutOfBoundsException
     *                                           se l'indice passato non
     *                                           corrisponde a nessun nodo o è
     *                                           fuori dai limiti
     *                                           dell'intervallo
     *                                           <code>[0, this.nodeCount() - 1]</code>
     * @throws UnsupportedOperationException
     *                                           se questa operazione non è
     *                                           supportata dall'implementazione
     *                                           di questo grafo
     */
    public GraphNode<V> getNodeAtIndex(int i);

    /**
     * Restituisce l'insieme degli archi tra due nodi indicizzati
     * nell'intervallo <code>[0, this.nodeCount() - 1]</code>. Questa
     * funzionalità è tipicamente disponibile se il grafo è rappresentato con
     * una matrice di adiacenza. Nel caso di grafo orientato vengono restituiti
     * gli archi che hanno come sorgente il nodo corrispondente al primo indice
     * e come destinazione il nodo corrispondente al secondo indice.
     * 
     * Questa operazione è opzionale.
     * 
     * @param index1
     *                   indice del primo nodo (nodo sorgente in caso di grafo
     *                   orientato)
     * @param index2
     *                   indice del secondo nodo (nodo destinazione in caso di
     *                   grafo orientato)
     * @return l'insieme, possibilmente vuoto, degli archi che collegano i due
     *         nodi corrispondenti agli indici passati
     * 
     * @throws IndexOutOfBoundsException
     *                                           se almeno uno degli indici
     *                                           passati non corrisponde a
     *                                           nessun nodo o è fuori dai
     *                                           limiti dell'intervallo
     *                                           <code>[0, this.nodeCount() - 1]</code>
     * 
     * @throws UnsupportedOperationException
     *                                           se questa operazione non è
     *                                           supportata dall'implementazione
     *                                           di questo grafo
     */
    public Set<GraphEdge<V, E>> getEdgesBetween(int index1, int index2);

    /**
     * Restituisce l'insieme degli archi tra due nodi. Nel caso di grafo diretto
     * vengono restituiti gli archi che hanno come sorgente il nodo
     * corrispondente al primo indice e come destinazione il nodo corrispondente
     * al secondo indice.
     * 
     * 
     * @param node1
     *                  primo nodo (nodo sorgente in caso di grafo diretto)
     * @param node2
     *                  secondo nodo (nodo destinazione in caso di grafo
     *                  diretto)
     * @return l'insieme, possibilmente vuoto, degli archi che collegano i due
     *         nodi passati
     * 
     * @throws IllegalArgumentException
     *                                      se almeno uno dei due nodi passati
     *                                      non esiste
     * 
     * @throws NullPointerException
     *                                      se almeno uno dei due nodi passati è
     *                                      nullo
     * 
     */
    public Set<GraphEdge<V, E>> getEdgesBetween(GraphNode<V> node1,
            GraphNode<V> node2);

    /**
     * Restituisce l'insieme di tutti i nodi adiacenti a un certo nodo. Se il
     * grafo è diretto, i nodi restituiti sono solo quelli collegati da un un
     * arco uscente dal nodo passato.
     * 
     * @param node
     *                 il nodo di cui cercare i nodi adiacenti
     * @return l'insieme di tutti i nodi adiacenti al nodo specificato
     * 
     * @throws IllegalArgumentException
     *                                      se il nodo passato non esiste
     * @throws NullPointerException
     *                                      se il nodo passato è nullo
     */
    public Set<GraphNode<V>> getAdjacentNodes(GraphNode<V> node);

    /**
     * Restituisce l'insieme di tutti i nodi collegati tramite un arco entrante
     * in un certo nodo in un grafo diretto.
     * 
     * @param node
     *                 il nodo di cui cercare i nodi successori
     * @return l'insieme di tutti i nodi collegati tramite un arco entrante al
     *         nodo specificato
     * @throws UnsupportedOperationException
     *                                           se il grafo su cui il metodo è
     *                                           chiamato non è diretto
     * @throws IllegalArgumentException
     *                                           se il nodo passato non esiste
     * @throws NullPointerException
     *                                           se il nodo passato è nullo
     */
    public Set<GraphNode<V>> getPredecessorNodes(GraphNode<V> node);

    /**
     * Restituisce l'insieme di tutti gli archi in questo grafo.
     * 
     * @return un insieme, possibilmente vuoto, contenente tutti gli archi di
     *         questo grafo
     */
    public Set<GraphEdge<V, E>> getEdges();

    /**
     * Aggiunge un arco a questo grafo.
     * 
     * @param edge
     *                 l'arco da inserire
     * @return true se l'arco è stato inserito, false se un arco esattamente
     *         uguale già esiste
     * @throws NullPointerException
     *                                      se l'arco passato è nullo
     * @throws IllegalArgumentException
     *                                      se almeno uno dei due nodi
     *                                      specificati nell'arco non esiste
     * @throws IllegalArgumentException
     *                                      se l'arco è diretto e questo grafo
     *                                      non è diretto o viceversa
     */
    public boolean addEdge(GraphEdge<V, E> edge);

    /**
     * Rimuove un arco da questo grafo.
     * 
     * @param edge
     *                 l'arco da rimuovere
     * 
     * @return true se l'arco è stato rimosso, false se l'arco non era presente
     * @throws IllegalArgumentException
     *                                           se almeno uno dei due nodi
     *                                           specificati nell'arco non
     *                                           esiste
     * @throws NullPointerException
     *                                           se l'arco passato è nullo
     * @throws UnsupportedOperationException
     *                                           se l'implementazione del grafo
     *                                           non supporta questa operazione
     */
    public boolean removeEdge(GraphEdge<V, E> edge);

    /**
     * Cerca se c'è un certo arco in questo grafo.
     * 
     * @param edge
     *                 l'arco da cercare
     * 
     * @return true se in questo grafo c'è l'arco specificato, false altrimenti
     * 
     * @throws NullPointerException
     *                                      se l'arco passato è nullo
     * @throws IllegalArgumentException
     *                                      se almeno uno dei due nodi
     *                                      specificati nell'arco non esiste
     * 
     */
    public boolean containsEdge(GraphEdge<V, E> edge);

    /**
     * Restituisce l'insieme di tutti gli archi connessi a un certo nodo in un
     * grafo. Nel caso di grafo diretto vengono restituiti solo gli archi
     * uscenti.
     * 
     * @param node
     *                 il nodo di cui sono richiesti gli archi connessi
     * 
     * @return un insieme contenente tutti gli archi connessi al nodo
     *         specificato in questo grafo (solo gli archi uscenti in caso di
     *         grafo diretto)
     * 
     * @throws IllegalArgumentException
     *                                      se il nodo passato non esiste
     * @throws NullPointerException
     *                                      se il nodo passato è nullo
     */
    public Set<GraphEdge<V, E>> getEdges(GraphNode<V> node);

    /**
     * Restituisce l'insieme di tutti gli archi entranti in un certo nodo in un
     * grafo diretto.
     * 
     * @param node
     *                 il nodo di cui determinare tutti gli archi entranti
     * 
     * @return un insieme contenente tutti gli archi entranti nel nodo con
     *         etichetta label in questo grafo diretto.
     * 
     * @throws UnsupportedOperationException
     *                                           se il grafo su cui il metodo è
     *                                           chiamato non è diretto
     * @throws IllegalArgumentException
     *                                           se il nodo passato non esiste
     * @throws NullPointerException
     *                                           se il nodo passato è nullo
     */
    public Set<GraphEdge<V, E>> getIngoingEdges(GraphNode<V> node);

    /**
     * Restituisce il grado di un nodo, cioè il numero di archi connessi al
     * nodo. Nel caso di grafo diretto è la somma del numero di archi in entrata
     * e del numero di archi in uscita.
     * 
     * @param node
     *                 il nodo di cui calcolare il grado
     * @return il grado del nodo passato
     * 
     * @throws IllegalArgumentException
     *                                      se il nodo passato non esiste
     * @throws NullPointerException
     *                                      se il nodo passato è nullo
     */
    public int getDegree(GraphNode<V> node);

}
