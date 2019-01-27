package it.unicam.cs.asdl1819.miniproject3;

import java.util.Set;
import java.util.HashSet;

/**
 * Implementazione dell'interfaccia {@code Graph<V,E>} per grafi diretti
 * utilizzando liste di adiacenza per la rappresentazione.
 * 
 * Questa classe non supporta le operazioni di rimozione di nodi e archi e le
 * operazioni indicizzate di ricerca di nodi e archi.
 * 
 * @author Luca Tesei
 *
 * @param <V>
 *            etichette dei nodi
 * @param <E>
 *            etichette degli archi
 */
public class AdjacentListDirectedGraph<V, E> implements Graph<V, E> {

	/*
	 * Instanzio un HashSet di nodi.
	 */
	private HashSet<GraphNode<V>> nodiGraph;

	/*
	 * Instanzio un HashSet di archi.
	 */
	private HashSet<GraphEdge<V, E>> archiGraph;

	/**
	 * Crea un grafo vuoto.
	 */
	public AdjacentListDirectedGraph() {
		nodiGraph = new HashSet<GraphNode<V>>();
		archiGraph = new HashSet<GraphEdge<V, E>>();
	}

	public int nodeCount() {
		/*
		 * Restituisco la size del HashSet in cui avevo eseguito lo storage dei nodi.
		 */
		return nodiGraph.size();
	}

	public int edgeCount() {
		/*
		 * Restituisco la size del HashSet in cui avevo eseguito lo storage degli
		 * archi.
		 */
		return archiGraph.size();
	}

	public int size() {
		/*
		 * Restitusico la size totale sommando le due size delle strutture dati le quali
		 * contengono sia nodi che gli archi.
		 */
		return nodiGraph.size() + archiGraph.size();
	}

	public boolean isEmpty() {
		/*
		 * Controllo che entrambe le strutture dati siano vuote.
		 */
		return nodiGraph.isEmpty() && archiGraph.isEmpty();
	}

	public void clear() {
		/*
		 * Elimino tutti gli elementi contenuti all'interno di entrambi gli HashSet
		 * contenenti i valori effettivi inseriti precedentemente.
		 */
		nodiGraph.clear();
		archiGraph.clear();
	}

	public boolean isDirected() {
		/*
		 * Metodo che conferma l'orientamento diretto del grafo.
		 */
		return true;
	}

	public Set<GraphNode<V>> getNodes() {
		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage di tutti i nodi.
		 */
		Set<GraphNode<V>> allNodes = new HashSet<GraphNode<V>>();

		/*
		 * Aggiungo tutti i nodi al Set.
		 */
		allNodes.addAll(nodiGraph);

		/*
		 * Restituisco il Set contenente tutti i nodi.
		 */
		return allNodes;
	}

	public boolean addNode(GraphNode<V> node) {
		if (node == null) {
			throw new NullPointerException("Impossibile aggiungere il nodo in quanto nullo");
		}

		if (this.nodiGraph.contains(node)) {
			/*
			 * Se questo nodo è già contenuto all'interno della struttura dati allora
			 * ritorno false.
			 */
			return false;
		} else {
			/*
			 * Se questo nodo non è contenuto all'interno della struttura dati allora lo
			 * aggiungo a quest'ultima e ritorno true.
			 */
			this.nodiGraph.add(node);
			return true;
		}
	}

	public boolean removeNode(GraphNode<V> node) {
		if (node == null)
			throw new NullPointerException("Tentativo di rimuovere un nodo null");
		throw new UnsupportedOperationException("Rimozione dei nodi non supportata");
	}

	public boolean containsNode(GraphNode<V> node) {
		if (node == null) {
			throw new NullPointerException("Il nodo che si vuole cercare è nullo");
		}

		/*
		 * Restituisco vero o falso in base alla presenza o meno del nodo all'interno
		 * del HashSet.
		 */
		return this.nodiGraph.contains(node);
	}

	public int getNodeIndex(V label) {
		if (label == null)
			throw new NullPointerException("Tentativo di ricercare un nodo con etichetta null");
		throw new UnsupportedOperationException("Ricerca dei nodi con indice non supportata");
	}

	public GraphNode<V> getNodeAtIndex(int i) {
		throw new UnsupportedOperationException("Ricerca dei nodi con indice non supportata");
	}

	public Set<GraphNode<V>> getAdjacentNodes(GraphNode<V> node) {
		if (node == null) {
			throw new NullPointerException("Impossibile verificare quali nodi appartengono a un nodo nullo");
		}

		if (!this.containsNode(node)) {
			throw new IllegalArgumentException(
					"Impossibile verificare quali nodi appartengono a un nodo non esistente");
		}

		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage dei nodi adiacenti a un
		 * nodo dato.
		 */
		Set<GraphNode<V>> tempStorage = new HashSet<GraphNode<V>>();

		for (GraphEdge<V, E> graphEdge : this.getEdges()) {
			/*
			 * Ciclo tutti gli archi all'interno del HashSet in cui sono presenti.
			 */
			if (graphEdge.getNode1().equals(node)) {
				/*
				 * Se l'arco che collega il nodo sorgente è uguale al nodo passato come
				 * parametro locale all'interno del metodo, allora aggiungo al Set il nodo
				 * destinazione.
				 */
				tempStorage.add(graphEdge.getNode2());
			}
			if (graphEdge.getNode2().equals(node)) {
				/*
				 * Se l'arco che collega il nodo destinazione è uguale al nodo passato come
				 * parametro locale all'interno del metodo, allora aggiungo al Set il nodo
				 * sorgente.
				 */
				tempStorage.add(graphEdge.getNode1());
			}
		}

		/*
		 * Restituisco il Set contenente i vari nodi adiacenti a quello dato nel metodo.
		 */
		return tempStorage;
	}

	public Set<GraphNode<V>> getPredecessorNodes(GraphNode<V> node) {
		if (node == null) {
			throw new NullPointerException("Impossibile verificare quali nodi appartengono a un nodo nullo");
		}

		if (!this.containsNode(node)) {
			throw new IllegalArgumentException(
					"Impossibile verificare quali nodi appartengono a un nodo non esistente");
		}

		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage dei nodi predecessori a
		 * un nodo dato.
		 */
		Set<GraphNode<V>> tempStorage = new HashSet<GraphNode<V>>();

		for (GraphEdge<V, E> graphEdge : this.getEdges()) {
			/*
			 * Ciclo tutti gli archi all'interno del HashSet in cui sono presenti.
			 */
			if (node.equals(graphEdge.getNode2())) {
				/*
				 * Aggiungo alla lista il nodo precedente a quello dato.
				 */
				tempStorage.add(graphEdge.getNode1());
			}
		}

		/*
		 * Restituisco la lista con tutti i nodi predecessori rispetto a quello dato.
		 */
		return tempStorage;
	}

	public Set<GraphEdge<V, E>> getEdges() {
		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage di tutti gli archi.
		 */
		Set<GraphEdge<V, E>> allEdges = new HashSet<GraphEdge<V, E>>();

		/*
		 * Aggiungo tutti gli archi al Set.
		 */
		allEdges.addAll(archiGraph);

		/*
		 * Restituisco il Set contenente tutti gli archi.
		 */
		return allEdges;
	}

	public boolean addEdge(GraphEdge<V, E> edge) {
		if (edge == null) {
			throw new NullPointerException("Impossibile aggiungere l'arco in quanto nullo");
		}

		if (!this.containsNode(edge.getNode1()) || !this.containsNode(edge.getNode2())) {
			throw new IllegalArgumentException(
					"Impossibile aggiungere l'arco in quanto uno dei due archi specificati non esiste");
		}

		if ((!this.isDirected()) || (!edge.isDirected())) {
			throw new IllegalArgumentException("L'arco e o questo grafo non sono diretti, o meglio orientati");
		}

		if (this.archiGraph.contains(edge)) {
			/*
			 * Se l'arco fosse già presente, restituisco il valore false.
			 */
			return false;
		} else {
			/*
			 * Aggiungo l'arco all'HashSet in cui farò lo storage di quest'ultimi e
			 * restituisco il valore true in quanto quest'arco non era presente nella
			 * struttura dati.
			 */
			this.archiGraph.add(edge);
			return true;
		}
	}

	public boolean removeEdge(GraphEdge<V, E> edge) {
		throw new UnsupportedOperationException("Rimozione degli archi non supportata");
	}

	public boolean containsEdge(GraphEdge<V, E> edge) {
		if (edge == null) {
			throw new NullPointerException("L'arco che si vuole verificare è nullo");
		}

		if (!this.containsNode(edge.getNode1()) || !this.containsNode(edge.getNode2())) {
			throw new IllegalArgumentException("Uno dei due archi che si vuole cercare deriva da un nodo inesistente");
		}

		/*
		 * Restituisco vero o falso in base alla presenza o meno del nodo all'interno
		 * del HashSet.
		 */
		return this.archiGraph.contains(edge);
	}

	public Set<GraphEdge<V, E>> getEdges(GraphNode<V> node) {
		if (node == null) {
			throw new NullPointerException("Impossibile verificare quali archi appartengono a un nodo nullo");
		}

		if (!this.containsNode(node)) {
			throw new IllegalArgumentException(
					"Impossibile verificare quali archi appartengono a un nodo non esistente");
		}

		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage di tutti gli archi
		 * uscenti a partire da un nodo.
		 */
		Set<GraphEdge<V, E>> allEdges = new HashSet<GraphEdge<V, E>>();

		for (GraphEdge<V, E> graphEdge : this.archiGraph) {
			/*
			 * Sfoglio tutti gli archi all'interno della struttura dati in cui ho fatto
			 * fatto lo storage di quest'utlimi.
			 */
			if (graphEdge.getNode1().equals(node)) {
				/*
				 * Se il nodo sorgente dell'arco è uguale al nodo passato come paramentro locale
				 * all'interno del metodo allora aggiungo l'arco al Set definito in precendenza.
				 */
				allEdges.add(graphEdge);
			}
		}

		/*
		 * Restituisco il Set contenente tutti gli archi uscenti a partire da un certo
		 * nodo.
		 */
		return allEdges;
	}

	public Set<GraphEdge<V, E>> getIngoingEdges(GraphNode<V> node) {
		if (!this.isDirected()) {
			throw new UnsupportedOperationException("Grafo non orientato");
		}

		if (node == null) {
			throw new NullPointerException("Impossibile verificare quali nodi appartengono a un nodo nullo");
		}

		if (!this.containsNode(node)) {
			throw new IllegalArgumentException(
					"Impossibile verificare quali nodi appartengono a un nodo non esistente");
		}

		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage di tutti gli archi
		 * entrati in un certo nodo in un grafo diretto.
		 */
		Set<GraphEdge<V, E>> resultFinal = new HashSet<GraphEdge<V, E>>();

		for (GraphEdge<V, E> graphEdge : this.archiGraph) {
			/*
			 * Sfoglio tutti gli archi all'interno della struttura dati in cui ho fatto
			 * fatto lo storage di quest'utlimi.
			 */
			if (node.equals(graphEdge.getNode2())) {
				/*
				 * Se il nodo destinazione dell'arco è uguale al nodo passato come paramentro
				 * locale all'interno del metodo allora aggiungo l'arco al Set definito in
				 * precendenza.
				 */
				resultFinal.add(graphEdge);
			}
		}

		/*
		 * Restituisco il Set contenente tutti gli archi entranti a partire da un certo
		 * nodo.
		 */
		return resultFinal;
	}

	public int getDegree(GraphNode<V> node) {
		if (node == null) {
			throw new NullPointerException("Impossibile verificare il grado di un nodo nullo");
		}

		if (!this.containsNode(node)) {
			throw new IllegalArgumentException("Impossibile verificare il grado di un nodo non esistente");
		}

		/*
		 * Restituisco la somma delle size del numero di archi entrati e uscenti a
		 * partire da un certo nodo, ovvero quello passato come parametro locale del
		 * metodo.
		 */
		return this.getEdges(node).size() + this.getIngoingEdges(node).size();
	}

	public Set<GraphEdge<V, E>> getEdgesBetween(int index1, int index2) {
		throw new UnsupportedOperationException("Operazioni con indici non supportate");
	}

	public Set<GraphEdge<V, E>> getEdgesBetween(GraphNode<V> node1, GraphNode<V> node2) {
		if (node1 == null || node2 == null) {
			throw new NullPointerException("Almeno uno dei due nodi è nullo");
		}

		if (!this.containsNode(node1) || !this.containsNode(node2)) {
			throw new IllegalArgumentException("Almeno uno dei due nodi inseriti non esiste");
		}

		/*
		 * Creo un Set temporaneo in cui andrò a fare lo storage di tutti gli archi
		 * compresi tra i due nodi passati come parametri locali all'interno del metodo.
		 */
		Set<GraphEdge<V, E>> storageTemp = new HashSet<GraphEdge<V, E>>();

		/*
		 * Creo un Set in cui eseguo lo storage di tutti gli archi uscenti dal primo
		 * nodo.
		 */
		Set<GraphEdge<V, E>> exitingEdges = this.getEdges(node1);

		/*
		 * Creo un Set in cui eseguo lo storage di tutti gli archi entranti dal secondo
		 * nodo.
		 */
		Set<GraphEdge<V, E>> ingoingEdges = this.getIngoingEdges(node2);

		for (GraphEdge<V, E> edgeOne : exitingEdges) {
			/*
			 * Sfoglio tutti gli archi uscenti.
			 */
			for (GraphEdge<V, E> edgeTwo : ingoingEdges) {
				/*
				 * Sfoglio tutti gli archi entranti.
				 */
				if (edgeOne.getLabel() == edgeTwo.getLabel()) {
					/*
					 * Se i due archi hanno la stessa etichetta allora vuol dire che collegano i due
					 * nodi passati come parametro e quindi aggiungo l'arco all'interno del Set
					 * creato precedentemente.
					 */
					storageTemp.add(edgeOne);
				}
			}
		}

		/*
		 * Restituisco il Set contenente gli archi compresi tra i due nodi definiti
		 * all'interno del metodo.
		 */
		return storageTemp;
	}

	public GraphNode<V> getNode(V label) {
		if (label == null) {
			throw new NullPointerException("Impossibile verificare l'etichetta di un nodo nullo");
		}

		/*
		 * Creo un GraphNode temporaneo.
		 */
		GraphNode<V> tempGraph = null;

		for (GraphNode<V> graphNode : this.nodiGraph) {
			/*
			 * Sfoglio tutti i nodi all'interno della struttura dati in cui sono allocati.
			 */
			if (graphNode.getLabel().equals(label)) {
				/*
				 * Se il nodo incontrato possiede la stessa etichetta passata come parametro
				 * locale all'interno del metodo allora assegno il nodo definito precedentemente
				 * al nodo sfogliato nel ciclo.
				 */
				tempGraph = graphNode;

				/*
				 * Restituisco il seguente nodo.
				 */
				return tempGraph;
			}
		}

		/*
		 * Lancio l'eccezione che dimostra la non presenza del nodo avete quella
		 * particolare etichetta.
		 */
		throw new IllegalArgumentException("L'etichetta che si sta cercando non appartiene a nessuno nodo");
	}
}
