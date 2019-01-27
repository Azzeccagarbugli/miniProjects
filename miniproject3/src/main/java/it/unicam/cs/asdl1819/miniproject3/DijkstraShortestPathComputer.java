package it.unicam.cs.asdl1819.miniproject3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Gli oggetti di questa classe sono calcolatori di cammini minimi con sorgente
 * singola su un certo grafo diretto e pesato dato. Il grafo su cui lavorare
 * deve essere passato quando l'oggetto calcolatore viene costruito e non può
 * contenere archi con pesi negativi. Il calcolatore implementa il classico
 * algoritmo di Dijkstra per i cammini minimi con sorgente singola utilizzando
 * una coda con priorità che estrae il minimo in tempo lineare rispetto alla
 * lunghezza della coda. In questo caso il tempo di esecuzione dell'algoritmo di
 * Dijkstra è {@code O(n^2)} dove {@code n} è il numero dei nodi del grafo.
 * 
 * @author Luca Tesei
 *
 * @param <V>
 *            il tipo delle etichette dei nodi del grafo
 * @param <E>
 *            il tipo delle etichette degli archi del grafo
 */
public class DijkstraShortestPathComputer<V, E> {

	/*
	 * Grafo.
	 */
	private Graph<V, E> graphStructure;

	/*
	 * Nodo iniziale sul quale attivare l'algoritmo di Dijkstra.
	 */
	private GraphNode<V> sourceNode;

	/*
	 * Attivazione algortimo di Dijkstra.
	 */
	private boolean isComputed;

	/**
	 * Crea un calcolatore di cammini minimi a sorgente singola per un grafo diretto
	 * e pesato privo di pesi negativi.
	 * 
	 * @param graph
	 *            il grafo su cui opera il calcolatore di cammini minimi
	 * @throws NullPointerException
	 *             se il grafo passato è nullo
	 * 
	 * @throws IllegalArgumentException
	 *             se il grafo passato è vuoto
	 * 
	 * @throws IllegalArgumentException
	 *             se il grafo passato non è diretto
	 * 
	 * @throws IllegalArgumentException
	 *             se il grafo passato non è pesato, cioè esiste almeno un arco il
	 *             cui peso è {@code Double.NaN}.
	 * @throws IllegalArgumentException
	 *             se il grafo passato contiene almeno un peso negativo.
	 */
	public DijkstraShortestPathComputer(Graph<V, E> graph) {
		if (graph == null) {
			throw new NullPointerException("Grafo inserito nullo");
		}

		if (graph.isEmpty()) {
			throw new IllegalArgumentException("Grafo inserito vuoto");
		}

		if (!graph.isDirected()) {
			throw new IllegalArgumentException("Grafo inserito non orientato");
		}

		for (GraphEdge<V, E> edgeGraph : graph.getEdges()) {
			Double NaNEdge = edgeGraph.getWeight();

			if (NaNEdge.equals(Double.NaN)) {
				throw new IllegalArgumentException("Grafo inserito non pesato");
			}

			if (edgeGraph.getWeight() < 0) {
				throw new IllegalArgumentException("Il grafo contiene almeno un peso negativo");
			}
		}

		/*
		 * Inizializzo il grafo sui cui andrò a svlogere l'algortimo di Dijkstra.
		 */
		this.graphStructure = graph;

		/*
		 * Finchè Dijkstra non è stato lanciato la variabile booleana che ne dimostra il
		 * uso avvio viene settata su valore false.
		 */
		this.isComputed = false;
	}

	/**
	 * Inizializza le informazioni necessarie associate ai nodi del grafo associato
	 * a questo calcolatore ed esegue l'algoritmo di Dijkstra sul grafo.
	 * 
	 * @param sourceNode
	 *            il nodo sorgente da cui calcolare i cammini minimi verso tutti gli
	 *            altri nodi del grafo
	 * @throws NullPointerException
	 *             se il nodo passato è nullo
	 * 
	 * @throws IllegalArgumentException
	 *             se il nodo passato non esiste nel grafo associato a questo
	 *             calcolatore
	 */
	public void computeShortestPathsFrom(GraphNode<V> sourceNode) {
		if (sourceNode == null) {
			throw new NullPointerException("Nodo nullo");
		}

		if (!graphStructure.containsNode(sourceNode)) {
			throw new IllegalArgumentException("Il nodo passato non esiste nel grafo associato a questo calcolatore");
		}

		/*
		 * Lanciando il seguente metodo viene attivato l'algortimo di Dijkstra e quindi
		 * viene modificato il valore della variabile booleana.
		 */
		this.isComputed = true;

		/*
		 * Il nodo iniziale sul quale viene eseguito l'algortimo di Dijkstra viene
		 * salvato in memoria in una varibile definita precedentemente.
		 */
		this.sourceNode = sourceNode;

		/*
		 * Inizializzo un Set temporaneo.
		 */
		Set<GraphNode<V>> setTemp = new HashSet<GraphNode<V>>();

		for (GraphNode<V> graphNode : getGraph().getNodes()) {
			/*
			 * Sfoglio tutti i nodi all'interno del grafo.
			 */
			if (graphNode.equals(sourceNode)) {
				/*
				 * Il nodo iniziale, quello su cui ho 'startato' l'algoritmo di Dijkstra, avrà
				 * una distanza pari a 0.
				 */
				sourceNode.setFloatingPointDistance(0);

				/*
				 * Il suo nodo predecessore, ovviamente, sarà un nodo di natura null.
				 */
				sourceNode.setPrevious(null);

				/*
				 * Aggiungo il primo nodo alla struttura dati.
				 */
				setTemp.add(sourceNode);
			} else {
				/*
				 * Per ogni nodo che non corrisponde al nodo iniziale setto: 
				 * • La distanza di ogni nodo uguale a Double.POSITIVE_INFINITY. 
				 * • Ogni nodo avrà come precendente un nodo di natura null.
				 * 
				 * Aggiungo quindi ogni nodo all Set definito in precendenza.
				 */
				graphNode.setFloatingPointDistance(Double.POSITIVE_INFINITY);
				graphNode.setPrevious(null);
				setTemp.add(graphNode);
			}
		}

		/*
		 * Finchè il Set non sarà vuoto completamente eseguo delle operazioni varie e
		 * soprattutto la procedura di 'Relax' necessaria al funzionamento complessivo
		 * dell'algoritmo di Dijkstra.
		 */
		while (!setTemp.isEmpty()) {
			/*
			 * Definisco un nodo minimo all'interno del Set creato precedentemente grazie a
			 * una inner class creata ad hoc che implementa un Comparator, il quale mi dà la
			 * possibilità di selezionare un nodo minimo.
			 */
			GraphNode<V> nodoV1 = Collections.min(setTemp, new NodeComparator());

			/*
			 * Rimuovo il nodo minimo dalla struttura dati.
			 */
			setTemp.remove(nodoV1);

			/*
			 * Visito ogni arco che lega nodoV1
			 */
			for (GraphEdge<V, E> arco : graphStructure.getEdges(nodoV1)) {
				/*
				 * Eseguo lo storage del nodo destinazione considerando lo stesso arco
				 */
				GraphNode<V> nodoV2 = arco.getNode2();

				/*
				 * <i>"Operazione del rilassamento: durante l’esecuzione dell’algoritmo è un
				 * limite superiore per δ(s,v) [d[v] ≥ δ(s,v)]; mentre alla fine sarà uguale a
				 * δ(s,v)"</i>
				 * 
				 * Quando viene rilassato l’arco (u,v) si verifica se è possibile ottenere un
				 * cammino più breve di quello di costo d[v] attraversando l’arco (u,v)
				 */
				if (nodoV2.getFloatingPointDistance() > nodoV1.getFloatingPointDistance() + arco.getWeight()) {
					nodoV2.setFloatingPointDistance(nodoV1.getFloatingPointDistance() + arco.getWeight());
					nodoV2.setPrevious(nodoV1);
				}
			}
		}
	}

	/**
	 * Determina se è stata invocata almeno una volta la procedura di calcolo dei
	 * cammini minimi a partire da un certo nodo sorgente specificato.
	 * 
	 * @return true, se i cammini minimi da un certo nodo sorgente sono stati
	 *         calcolati almeno una volta da questo calcolatore
	 */
	public boolean isComputed() {
		/*
		 * Restituisco il valore della variabile booleana che mi attesta l'attivazione o
		 * meno dell'algoritmo di Dijkstra.
		 */
		return isComputed;
	}

	/**
	 * Restituisce il nodo sorgente specificato nell'ultima chiamata effettuata a
	 * {@code computeShortestPathsFrom(GraphNode<V>)}.
	 * 
	 * @return il nodo sorgente specificato nell'ultimo calcolo dei cammini minimi
	 *         effettuato
	 * 
	 * @throws IllegalStateException
	 *             se non è stato eseguito nemmeno una volta il calcolo dei cammini
	 *             minimi a partire da un nodo sorgente
	 */
	public GraphNode<V> getLastSource() {
		/*
		 * Se l'attivazione dell'algoritmo di Dijkstra è avvenuta allora posso ritornare
		 * il sourceNode, ovvero il nodo su cui avevo 'startato' l'algoritmo stesso.
		 */
		if (this.isComputed()) {
			return sourceNode;
		} else {
			/*
			 * Se l'attivazione dell'algoritmo non è avvenuta, allora non posso restituire
			 * il nodo su cui esso è stato attivato.
			 */
			throw new IllegalStateException("Non è stato ancora eseguito il calcolo dei cammini minimi");
		}
	}

	/**
	 * Restituisce il grafo su cui opera questo calcolatore.
	 * 
	 * @return il grafo su cui opera questo calcolatore
	 */
	public Graph<V, E> getGraph() {
		/*
		 * Resituisco il grafo sul quale sto operando.
		 */
		return this.graphStructure;
	}

	/**
	 * Restituisce una lista di archi dal nodo sorgente dell'ultimo calcolo di
	 * cammini minimi al nodo passato. Tale lista corrisponde a un cammino minimo
	 * tra il nodo sorgente e il nodo target passato.
	 * 
	 * @param targetNode
	 *            il nodo verso cui restituire il cammino minimo dalla sorgente
	 * @return la lista di archi corrispondente al cammino minimo; la lista è vuota
	 *         se il nodo passato è il nodo sorgente. Viene restituito {@code null}
	 *         se il nodo passato non è raggiungibile dalla sorgente
	 * 
	 * @throws NullPointerException
	 *             se il nodo passato è nullo
	 * 
	 * @throws IllegalArgumentException
	 *             se il nodo passato non esiste
	 * 
	 * @throws IllegalStateException
	 *             se non è stato eseguito nemmeno una volta il calcolo dei cammini
	 *             minimi a partire da un nodo sorgente
	 * 
	 */
	public List<GraphEdge<V, E>> getShortestPathTo(GraphNode<V> targetNode) {
		if (targetNode == null) {
			throw new NullPointerException("Il nodo passato è nullo");
		}

		if (!isComputed()) {
			throw new IllegalStateException("Non è stato ancora eseguito il calcolo dei cammini minimi");
		}

		if (!graphStructure.containsNode(targetNode)) {
			throw new IllegalArgumentException("Il nodo passato non esiste nel grafo");
		}

		/*
		 * Creo una List che corrisponderà poi a un cammino minimo tra il nodo sorgente
		 * e il nodo target passato all'interno del metodo.
		 */
		List<GraphEdge<V, E>> pathEdges = new ArrayList<GraphEdge<V, E>>();

		/*
		 * Definisco un nodo che corrisponde al nodo target, in quanto essi condividono
		 * la stessa label.
		 */
		GraphNode<V> node = getGraph().getNode(targetNode.getLabel());

		if (node.getFloatingPointDistance() == Double.POSITIVE_INFINITY) {
			/*
			 * Se il nodo target ha distanza uguale a Double.POSITIVE_INFINITY allora non
			 * esisteranno cammini minimi, quindi ritornerò null.
			 */
			return null;
		}

		while (node.getPrevious() != null) {
			/*
			 * Finchè il nodo target non avrà un nodo predecessore uguale a null allora
			 * andrò a eseguire lo storage di tutti gli archi compresi tra il nodo
			 * precedente e il nodo corrente.
			 */
			pathEdges.addAll(getGraph().getEdgesBetween(node.getPrevious(), node));

			/*
			 * In seguito aggiornerò il nodo corrente con quello precendente.
			 */
			node = node.getPrevious();
		}

		/*
		 * La lista dei cammini è in ordine inverso in quanto considerata a partire dal
		 * nodo target, quindi la considererò al contrario mediante l'aiuto di
		 * Collection.reverse.
		 */
		Collections.reverse(pathEdges);

		/*
		 * Restituisco la lista dei cammini minimi.
		 */
		return pathEdges;
	}

	/*
	 * Inner class di nome NodeComparator la quale implementa un Comparator di
	 * GraphNode<V> che mi permette di andare a comparara due nodi tra di loro, o
	 * meglio, la loro distanza.
	 */
	public class NodeComparator implements Comparator<GraphNode<V>> {
		public int compare(GraphNode<V> node1, GraphNode<V> node2) {
			return Double.compare(node1.getFloatingPointDistance(), node2.getFloatingPointDistance());
		}
	}

	/**
	 * Genera una stringa di descrizione di un path riportando i nodi attraversati e
	 * i pesi degli archi. Nel caso di cammino vuoto genera solo la stringa
	 * {@code "[ ]"}.
	 * 
	 * @param path
	 *            un cammino minimo
	 * @return una stringa di descrizione del cammino minimo
	 * @throws NullPointerException
	 *             se il cammino passato è nullo
	 */
	public String printPath(List<GraphEdge<V, E>> path) {
		if (path == null)
			throw new NullPointerException("Richiesta di stampare un path nullo");
		if (path.isEmpty())
			return "[ ]";
		// Costruisco la stringa
		StringBuffer s = new StringBuffer();
		s.append("[ " + path.get(0).getNode1().toString());
		for (int i = 0; i < path.size(); i++)
			s.append(" -- " + path.get(i).getWeight() + " --> " + path.get(i).getNode2().toString());
		s.append(" ]");
		return s.toString();
	}
}
