package it.unicam.cs.asdl1819.miniproject2;
/**
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Un AVLTree è un albero binario di ricerca che si mantiene sempre bilanciato.
 * In questa particolare classe si possono inserire elementi ripetuti di tipo
 * {@code E} e non si possono inserire elementi {@code null}.
 * 
 * @author Luca Tesei
 * 
 * @param E
 *            il tipo degli elementi che possono essere inseriti in questo
 *            AVLTree. La classe {@code E} deve avere un ordinamento naturale
 *            definito tra gli elementi.
 *
 */
public class AVLTree<E extends Comparable<E>> {

	// puntatore al nodo radice, se questo puntatore è null allora questo
	// AVLTree è vuoto
	private AVLTreeNode root;

	// Numero di elementi inseriti in questo AVLTree, comprese le ripetizioni
	private int size;

	// Numero di nodi in questo AVLTree
	private int numberOfNodes;

	/**
	 * Costruisce un AVLTree vuoto.
	 */
	public AVLTree() {
		this.root = null;
		this.size = 0;
		this.numberOfNodes = 0;
	}

	/**
	 * Costruisce un AVLTree che consiste solo di un nodo radice.
	 * 
	 * @param rootElement
	 *            l'informazione associata al nodo radice
	 * @throws NullPointerException
	 *             se l'elemento passato è null
	 */
	public AVLTree(E rootElement) {
		/*
		 * Se l'elemento passato all'interno del costruttore risulta nullo allora viene
		 * lanciata un'eccezione.
		 */
		if (rootElement == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * Se l'elemento risulta essere non nullo viene inizializzato un AVLTreeNode
		 * avente come radice l'elemento stesso.
		 */
		this.root = new AVLTreeNode(rootElement);
		this.size = 1;
		this.numberOfNodes = 1;
	}

	/**
	 * Gli elementi di questa classe sono i nodi di un AVLTree, che è la classe
	 * "involucro" della struttura dati.
	 * 
	 * @author Luca Tesei
	 *
	 */
	public class AVLTreeNode {
		// etichetta del nodo
		private E el;

		// molteplicità dell'elemento el
		private int count;

		// sottoalbero sinistro
		private AVLTreeNode left;

		// sottoalbero destro
		private AVLTreeNode right;

		// genitore del nodo, null se questo nodo è la radice dell'AVLTree
		private AVLTreeNode parent;

		// altezza del sottoalbero avente questo nodo come radice
		private int height;

		/**
		 * Create an AVLTreeNode as a root leaf
		 * 
		 * @param el
		 *            the element
		 */
		public AVLTreeNode(E el) {
			this.el = el;
			this.count = 1;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.height = 0;
		}

		/**
		 * Create an AVLTreeNode node containing one element to be considered child of
		 * the given parent.
		 * 
		 * @param el
		 *            the element
		 * @param parent
		 *            the parent of the node
		 */
		public AVLTreeNode(E el, AVLTreeNode parent) {
			this.el = el;
			this.count = 1;
			this.left = null;
			this.right = null;
			this.parent = parent;
			this.height = 0;
		}

		/**
		 * Restituisce il nodo predecessore di questo nodo. Si suppone che esista un
		 * nodo predecessore, cioè che questo nodo non contenga l'elemento minimo del
		 * sottoalbero di cui è radice.
		 * 
		 * @return il nodo predecessore
		 */
		public AVLTreeNode getPredecessor() {
			if (this.left != null) {
				/*
				 * Se il sottoalbero sinistro è diverso da null allora ritorno l'elemento
				 * massimo di cui questo nodo è radice.
				 */
				return this.left.getMaximum();
			} else {
				/*
				 * Assegno delle variabile temporanee al genitore del nodo e al nodo stesso.
				 */
				AVLTreeNode antenatoVar = this.parent;
				AVLTreeNode figlioVar = this;

				/*
				 * Finchè il nodo è diverso da null, il genitore del sottoalbero sinistro
				 * altrettanto e il genitore del sottoalbero sinsitro risulta uguale al figlio
				 * allora effettuo delle operazioni sulle varibili temporanee.
				 */
				while ((figlioVar != null) && (antenatoVar.left != null) && (antenatoVar.left.equals(figlioVar))) {
					antenatoVar = antenatoVar.parent;
					figlioVar = figlioVar.parent;
				}

				/*
				 * Restituisco il genitore del nodo
				 */
				return antenatoVar;
			}
		}

		/**
		 * Restituisce il nodo successore di questo nodo. Si suppone che esista un nodo
		 * successore, cioè che questo nodo non contenga l'elemento massimo del
		 * sottoalbero di cui è radice.
		 * 
		 * @return il nodo successore
		 */
		public AVLTreeNode getSuccessor() {
			if (this.right != null) {
				/*
				 * Se il sottoalbero destro è diverso da null allora ritorno l'elemento minimo
				 * di cui questo nodo è radice.
				 */
				return this.right.getMinimum();
			} else {
				/*
				 * Assegno delle variabile temporanee al genitore del nodo e al nodo stesso.
				 */
				AVLTreeNode antenatoVar = this.parent;
				AVLTreeNode figlioVar = this;

				/*
				 * Finchè il nodo è diverso da null, il genitore del sottoalbero destro
				 * altrettanto e il genitore del sottoalbero destro risulta uguale al figlio
				 * allora effettuo delle operazioni sulle varibili temporanee.
				 */
				while ((figlioVar != null) && (antenatoVar.right != null) && (antenatoVar.right.equals(figlioVar))) {
					antenatoVar = antenatoVar.parent;
					figlioVar = figlioVar.parent;
				}

				/*
				 * Restituisco il genitore del nodo
				 */
				return antenatoVar;
			}
		}

		/**
		 * Restituisce il nodo contenente l'elemento massimo del sottoalbero di cui
		 * questo nodo è radice.
		 * 
		 * @return il nodo contenente l'elemento massimo del sottoalbero di cui questo
		 *         nodo è radice.
		 */
		public AVLTreeNode getMaximum() {
			/*
			 * Se il sottoalbero destro è uguale a null allora ritorno questo nodo,
			 * altrimenti restituisco il valore massimo del sottoalbero di cui questo nodo è
			 * radice.
			 */
			if (this.right == null) {
				return this;
			} else {
				return this.right.getMaximum();
			}
		}

		/**
		 * Restituisce il nodo contenente l'elemento minimo del sottoalbero di cui
		 * questo nodo è radice.
		 * 
		 * @return il nodo contenente l'elemento minimo del sottoalbero di cui questo
		 *         nodo è radice.
		 */
		public AVLTreeNode getMinimum() {
			/*
			 * Se il sottoalbero sinistro è uguale a null allora ritorno questo nodo,
			 * altrimenti restituisco il valore minimo del sottoalbero di cui questo nodo è
			 * radice.
			 */
			if (this.left == null) {
				return this;
			} else {
				return this.left.getMinimum();
			}
		}

		/**
		 * Determina se questo è un nodo foglia.
		 * 
		 * @return true se questo nodo non ha figli, false altrimenti.
		 */
		public boolean isLeaf() {
			/*
			 * Resituisco vero o falso a secondo se questo nodo sia una foglia o no.
			 */
			return ((this.right == null) && (this.left == null));
		}

		/**
		 * Restituisce l'altezza del sottoalbero la cui radice è questo nodo.
		 * 
		 * @return l'altezza del sotto albero la cui radice è questo nodo.
		 */
		public int getHeight() {
			return this.height;
		}

		/**
		 * Aggiorna l'altezza del sottoalbero la cui radice è questo nodo supponendo che
		 * l'altezza dei nodi figli sia già stata aggiornata.
		 */
		public void updateHeight() {
			if (this.isLeaf()) {
				/*
				 * Se questo nodo è una foglia allora setto l'altezza a zero
				 */
				this.height = 0;
			} else {
				/*
				 * Se il sottoalbero sinistro è uguale a null, allora setto l'altezza uguale
				 * all'altezza del sottoalbero destro più uno.
				 */
				if (this.left == null) {
					this.height = this.right.height + 1;
				} else {
					/*
					 * Se il sottoalbero destro è uguale a null, allora setto l'altezza uguale
					 * all'altezza del sottoalbero sinistro più uno.
					 */
					if (this.right == null) {
						this.height = this.left.height + 1;
					} else {
						/*
						 * Se il sottoalbero destro non è nullo allora l'altezza sarà uguale al valore
						 * più alto tra le altezza del sottoalbero sinistro o destro più il valore uno.
						 */
						this.height = 1 + Math.max(this.left.getHeight(), this.right.getHeight());
					}
				}
			}
		}

		/**
		 * Determina il fattore di bilanciamento di questo nodo. Se il nodo è una foglia
		 * il fattore di bilanciamento è 0. Se il nodo ha solo il figlio sinistro allora
		 * il fattore di bilanciamento è l'altezza del figlio sinistro + 1. Se il nodo
		 * ha solo il figlio destro allora il fattore di bilanciamento è l'altezza del
		 * figlio destro + 1, moltiplicata per -1. Se il nodo ha entrambi i figli il
		 * fattore di bilanciamento è l'altezza del figlio sinistro meno l'altezza del
		 * figlio destro.
		 * 
		 * @return il fattore di bilanciamento di questo nodo.
		 */
		public int getBalanceFactor() {
			if (this.isLeaf()) {
				/*
				 * Se questo nodo è una foglia allora restituisco il valore zero.
				 */
				return 0;
			} else if ((this.left != null) && (this.right == null)) {
				/*
				 * Se il sottoalbero sinistro è diverso da null e quello destro è uguale a null
				 * allora aggiorno l'altezza del sottoalbero sinistro e restituisco la sua
				 * altezza più uno.
				 */
				this.left.updateHeight();
				return this.left.height + 1;
			} else if ((this.right != null) && (this.left == null)) {
				/*
				 * Se il sottoalbero destro è diverso da null e quello sinistro è uguale a null
				 * allora aggiorno l'altezza del sottoalbero destro e restituisco la sua altezza
				 * più uno ma moltiplicata per un fattore di correzione pari a meno uno.
				 */
				this.right.updateHeight();
				return (-1) * (this.right.height + 1);
			} else {
				/*
				 * Se non viene rispettata nessuna delle condizioni precedenti allora vengono
				 * aggiornate le altezze del sottoalbero sinistro e destro e viene restituito il
				 * valore intero rappresentante la differenza tra l'altezza del sottoalbero
				 * sinistro meno quella del sottoalbero destro.
				 */
				this.left.updateHeight();
				this.right.updateHeight();
				return this.left.height - this.right.height;
			}
		}

		/**
		 * Determina se questo nodo e tutti i suoi discendenti hanno un fattore di
		 * bilanciamento compreso tra -1 e 1.
		 * 
		 * @return true se questo nodo e tutti i suoi discendenti sono bilanciati, false
		 *         altrimenti.
		 */
		public boolean isBalanced() {
			if (Math.abs(this.getBalanceFactor()) > 1) {
				/*
				 * Se il valore assoluto del fattore di bilanciamento è maggiore di uno allora
				 * restituisco il valore booleano false.
				 */
				return false;
			}
			if ((!this.isLeaf()) && (this.left == null) && (this.right != null) && (this.right.isBalanced())) {
				/*
				 * Se questo nodo non è una foglia e il sottoalbero sinistro è nullo e quello
				 * destro è sia diverso da nullo e al tempo stesso bilanciato allora restituisco
				 * il valore booleano true.
				 */
				return true;
			}
			if ((!this.isLeaf()) && (this.left != null) && (this.right == null) && (this.left.isBalanced())) {
				/*
				 * Se questo nodo non è una foglia e il sottoalbero sinistro è nullo e quello
				 * destro risulta essere nullo e al tempo stesso il sottoalbero sinistro è
				 * bilanciato allora restituisco il valore booleano true.
				 */
				return true;
			}
			if ((!this.isLeaf()) && (this.left.isBalanced()) && (this.right.isBalanced())) {
				/*
				 * Se questo nodo non è una foglia e sia il sottoalbero sinistro che destro sono
				 * bilanciati allora restituisco il valore booleano true.
				 */
				return true;
			}

			/*
			 * Se non viene rispettata nessuna delle condizioni precedenti viene restituito
			 * il valore booleano true.
			 */
			return true;
		}

		/**
		 * @return the el
		 */
		public E getEl() {
			return el;
		}

		/**
		 * @param el
		 *            the el to set
		 */
		public void setEl(E el) {
			this.el = el;
		}

		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count
		 *            the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * @return the left
		 */
		public AVLTreeNode getLeft() {
			return left;
		}

		/**
		 * @param left
		 *            the left to set
		 */
		public void setLeft(AVLTreeNode left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public AVLTreeNode getRight() {
			return right;
		}

		/**
		 * @param right
		 *            the right to set
		 */
		public void setRight(AVLTreeNode right) {
			this.right = right;
		}

		/**
		 * @return the parent
		 */
		public AVLTreeNode getParent() {
			return parent;
		}

		/**
		 * @param parent
		 *            the parent to set
		 */
		public void setParent(AVLTreeNode parent) {
			this.parent = parent;
		}

		/**
		 * @param height
		 *            the height to set
		 */
		public void setHeight(int height) {
			this.height = height;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuffer s = new StringBuffer();
			s.append("(");
			s.append(this.el);
			s.append(", ");
			if (this.left == null)
				s.append("()");
			else
				s.append(this.left.toString());
			s.append(", ");
			if (this.right == null)
				s.append("()");
			else
				s.append(this.right.toString());
			s.append(")");
			return s.toString();
		}

		/**
		 * Ricerca un elemento a partire da questo nodo.
		 * 
		 * @param el
		 *            the element to search for
		 * 
		 * @return the node containing the element or null if the element is not found
		 */
		public AVLTreeNode search(E el) {
			if (this.el.compareTo(el) == 0) {
				/*
				 * Se l'elemento che sto cercando corrisponde al nodo stesso allora restitusico
				 * quest'ultimo.
				 */
				return this;
			}

			if (this.el.compareTo(el) > 0) {
				/*
				 * Eseguo una ricerca lungo il sottoalbero sinistro.
				 */
				if (this.left != null) {
					/*
					 * Opero in maniera ricorsiva finchè non arrivo a trovare l'elemento passato
					 * nell'argomento come parametro all'interno del sottoalbero sinistro.
					 */
					return this.left.search(el);
				} else {
					/*
					 * Se si arriva a questo punto vuol dire che si è arrivati alle foglie e quindi
					 * che l'elemento non è presente, di conseguenza restituisco il valore null
					 */
					return null;
				}
			}

			if (this.el.compareTo(el) < 0) {
				/*
				 * Eseguo una ricerca lungo il sottoalbero destro.
				 */
				if (this.right != null) {
					/*
					 * Opero in maniera ricorsiva finchè non arrivo a trovare l'elemento passato
					 * nell'argomento come parametro all'interno del sottoalbero destro.
					 */
					return this.right.search(el);
				} else {
					/*
					 * Se si arriva a questo punto vuol dire che si è arrivati alle foglie e quindi
					 * che l'elemento non è presente, di conseguenza restituisco il valore null
					 */
					return null;
				}
			}

			/*
			 * Di default, se non vengono rispetatte le condizioni descritte in precendenza,
			 * ritorno il valore null.
			 */
			return null;
		}

		/**
		 * Inserisce un elemento nell'albero AVL a partire da questo nodo. Se l'elemento
		 * è già presente ne aumenta semplicemente la molteplicità di uno. Se l'elemento
		 * non è presente aggiunge un nodo nella opportuna posizione e poi procede al
		 * ribilanciamento dell'albero se l'inserimento del nuovo nodo provoca uno
		 * sbilanciamento in almeno un nodo.
		 * 
		 * @param el
		 *            l'elemento da inserire
		 * 
		 * @return il numero di confronti tra elementi della classe {@code E} effettuati
		 *         durante l'inserimento.
		 */
		public int insert(E el) {
			/*
			 * Se questo nodo è minore del valore del paramentro, secondo l'ordinamento
			 * naturale, viene inserito a destra
			 */
			if (this.el.compareTo(el) < 0) {
				/*
				 * Eseguo un inserimento all'interno del sottoalbero destro.
				 */
				if (this.right == null) {
					/*
					 * Se il sottoalbero destro è uguale a null, allora instazio un nuovo
					 * sottoalbero avente come elemento l'elemento passato come paramentro locale e
					 * come genitore il nodo stesso.
					 */
					this.right = new AVLTreeNode(el, this);

					/*
					 * Vengono aggiornate ricorsivamente le altezze di tutti i genitori.
					 */
					AVLTreeNode tempHeightUpdate = this;
					while (tempHeightUpdate != null) {
						tempHeightUpdate.updateHeight();
						tempHeightUpdate = tempHeightUpdate.parent;
					}

					if (this.parent != null) {
						/*
						 * Se il genitore è diverso da null instazio delle variabile temporanee che mi
						 * serviranno poi per il primo step verso il bilancimento dell'albero.
						 */
						AVLTreeNode x1_NodeTemp = this.right;
						AVLTreeNode x2_NodeTemp = this;
						AVLTreeNode x3_NodeTemp = this.parent;

						while (x3_NodeTemp.isBalanced()) {
							if (x3_NodeTemp.parent != null) {
								x3_NodeTemp = x3_NodeTemp.parent;
							} else {
								return 1;
							}
							x2_NodeTemp = x2_NodeTemp.parent;
							x1_NodeTemp = x1_NodeTemp.parent;
						}

						/*
						 * Se il genitore è diverso da null allora inizio una serie di operazioni che
						 * portano al bilanciamento dell'albero stesso, avvenuto dopo l'inserimento,
						 * mediante delle rotazioni di natura Sinistra-Sinistra, Destra-Destra,
						 * Sinistra-Destra, Destra-Sinistra.
						 */

						// Caso Sinistra-Sinistra
						if ((x3_NodeTemp.left != null) && (x2_NodeTemp.left != null)
								&& (x3_NodeTemp.left.equals(x2_NodeTemp)) && (x2_NodeTemp.left.equals(x1_NodeTemp))) {
							rotationSS(x3_NodeTemp);
							// Ritorno il valore intero uno in quanto viene effettuato solo un confronto.
							return 1;
						}
						// Caso Sinistra-Destra
						if ((x3_NodeTemp.left != null) && (x2_NodeTemp.right != null)
								&& (x3_NodeTemp.left.equals(x2_NodeTemp)) && (x2_NodeTemp.right.equals(x1_NodeTemp))) {
							rotationSD(x3_NodeTemp);
							// Ritorno il valore intero uno in quanto viene effettuato solo un confronto.
							return 1;
						}
						// Caso Destra-Sinistra
						if ((x3_NodeTemp.right != null) && (x2_NodeTemp.left != null)
								&& (x3_NodeTemp.right.equals(x2_NodeTemp)) && (x2_NodeTemp.left.equals(x1_NodeTemp))) {
							rotationDS(x3_NodeTemp);
							// Ritorno il valore intero uno in quanto viene effettuato solo un confronto.
							return 1;
						}
						// Caso Destra-Destra
						if ((x3_NodeTemp.right != null) && (x2_NodeTemp.right != null)
								&& (x3_NodeTemp.right.equals(x2_NodeTemp)) && (x2_NodeTemp.right.equals(x1_NodeTemp))) {
							rotationDD(x3_NodeTemp);
							// Ritorno il valore intero uno in quanto viene effettuato solo un confronto.
							return 1;
						}

					}
					// Ritorno il valore intero uno in quanto viene effettuato solo un confronto.
					return 1;
				} else {
					/*
					 * Se il sottoalbero destro è diverso da null allora inserisco l'elemento e
					 * restituisco il valore di confronti effettuati più, ovviamente, il valore uno.
					 */
					return this.right.insert(el) + 1;
				}
			} else if (this.el.compareTo(el) > 0) {
				/*
				 * Eseguo un inserimento all'interno del sottoalbero sinistro.
				 */
				if (this.left == null) {
					/*
					 * Se il sottoalbero sinistro è uguale a null, allora instazio un nuovo
					 * sottoalbero avente come elemento l'elemento passato come paramentro locale e
					 * come genitore il nodo stesso.
					 */
					this.left = new AVLTreeNode(el, this);

					/*
					 * Vengono aggiornate ricorsivamente le altezze di tutti i genitori.
					 */
					AVLTreeNode tempHeightUpdate = this;
					while (tempHeightUpdate != null) {
						tempHeightUpdate.updateHeight();
						tempHeightUpdate = tempHeightUpdate.parent;
					}

					if (this.parent != null) {
						/*
						 * Se il genitore è diverso da null instazio delle variabile temporanee che mi
						 * serviranno poi per il primo step verso il bilancimento dell'albero.
						 */

						AVLTreeNode x1_NodeTemp = this.left;
						AVLTreeNode x2_NodeTemp = this;
						AVLTreeNode x3_NodeTemp = this.parent;

						while (x3_NodeTemp.isBalanced()) {
							if (x3_NodeTemp.parent != null) {
								x3_NodeTemp = x3_NodeTemp.parent;
							} else {
								return 2;
							}
							x2_NodeTemp = x2_NodeTemp.parent;
							x1_NodeTemp = x1_NodeTemp.parent;
						}

						/*
						 * Se il genitore è diverso da null allora inizio una serie di operazioni che
						 * portano al bilanciamento dell'albero stesso, avvenuto dopo l'inserimento,
						 * mediante delle rotazioni di natura Sinistra-Sinistra, Destra-Destra,
						 * Sinistra-Destra, Destra-Sinistra.
						 */

						// Caso Sinistra-Sinistra
						if ((x3_NodeTemp.left != null) && (x2_NodeTemp.left != null)
								&& (x3_NodeTemp.left.equals(x2_NodeTemp)) && (x2_NodeTemp.left.equals(x1_NodeTemp))) {
							rotationSS(x3_NodeTemp);
							// Ritorno il valore intero due in quanto viene effettuato solo un confronto.
							return 2;
						}
						// Caso Sinistra-Destra
						if ((x3_NodeTemp.left != null) && (x2_NodeTemp.right != null)
								&& (x3_NodeTemp.left.equals(x2_NodeTemp)) && (x2_NodeTemp.right.equals(x1_NodeTemp))) {
							rotationSD(x3_NodeTemp);
							// Ritorno il valore intero due in quanto viene effettuato solo un confronto.
							return 2;
						}
						// Caso Destra-Sinistra
						if ((x3_NodeTemp.right != null) && (x2_NodeTemp.left != null)
								&& (x3_NodeTemp.right.equals(x2_NodeTemp)) && (x2_NodeTemp.left.equals(x1_NodeTemp))) {
							rotationDS(x3_NodeTemp);
							// Ritorno il valore intero due in quanto viene effettuato solo un confronto.
							return 2;
						}
						// Caso Destra-Destra
						if ((x3_NodeTemp.right != null) && (x2_NodeTemp.right != null)
								&& (x3_NodeTemp.right.equals(x2_NodeTemp)) && (x2_NodeTemp.right.equals(x1_NodeTemp))) {
							rotationDD(x3_NodeTemp);
							// Ritorno il valore intero due in quanto viene effettuato solo un confronto.
							return 2;
						}
					}
					// Ritorno il valore intero due in quanto viene effettuato solo un confronto.
					return 2;
				} else {
					/*
					 * Se il sottoalbero sinistro è diverso da null allora inserisco l'elemento e
					 * restituisco il valore di confronti effettuati più, ovviamente, il valore due.
					 */
					return this.left.insert(el) + 2;
				}
			}

			/*
			 * Questa parte di di codice viene raggiunta solamente nel caso in cui arrivo in
			 * un nodo con un elemento uguale a quello passato dall'argomento. Di
			 * conseguenza la struttura dell'albero rimane invariate e sopratutto vengono
			 * effettuati solamente due confronti.
			 */
			count += 1;
			return 2;
		}

		/*
		 * Rotazione Sinistra-Sinistra.
		 * 
		 * Si esegue quando un nodo ha un coefficiente di bilanciamento di -2 ed il suo
		 * figlio destro un coefficiente di bilanciamento uguale a +1 o 0.
		 */
		private void rotationSS(AVLTreeNode x3) {
			/*
			 * Istanzio un oggetto di tipo AVLTreeNode il quale contiene il genitore del
			 * parent della variabile passato come argomento del metodo.
			 */
			AVLTreeNode x3Padre = x3.parent;

			/*
			 * Istanzio un oggetto di tipo AVLTreeNode a cui associo il sottoalbero sinistro
			 * del parametro locale passato nel metodo.
			 */
			AVLTreeNode x2 = x3.left;

			if (x3Padre != null) {
				/*
				 * Se x3Padre è diverso da null allora controllo se assegnare x2 al sottoalbero
				 * sinistro o destro.
				 */
				if (x3Padre.left.equals(x3)) {
					x3Padre.left = x2;
				} else {
					x3Padre.right = x2;
				}
				x2.parent = x3Padre;
			} else {
				/*
				 * Altrimenti setto semplicimente il genitore di x2 uguale a null, definendolo
				 * quindi come radice.
				 */
				x2.parent = null;
				setRoot(x2);
			}

			/*
			 * Il genitore di x3 a questo punto viene assegnato alla variabile x2.
			 */
			x3.parent = x2;

			/*
			 * Se il sottoalbero destro di x2 è diverso da null allora effettuo degli
			 * spostamenti di variabili altrimenti setto il sottoalbero sinistro uguale a
			 * null.
			 */
			if (x2.right != null) {
				x2.right.parent = x3;
				x3.left = x2.right;
			} else {
				x3.left = null;
			}

			/*
			 * Il sottoalbero destro a questo punto diventa uguale al valore passato come
			 * argomento locale del metodo.
			 */
			x2.right = x3;

			/*
			 * Aggiorno l'altezza di x3.
			 */
			x3.updateHeight();

			/*
			 * Creo un nodo temporaneo a cui assegno il valore di x2 e finchè è diverso da
			 * null continuo ad aggiornare la sua altezza.
			 */
			AVLTreeNode tempUpdate = x2;
			while (tempUpdate != null) {
				tempUpdate.updateHeight();
				tempUpdate = tempUpdate.parent;
			}
		}

		/*
		 * Rotazione Destra-Destra.
		 * 
		 * Si esegue quando un nodo ha un coefficiente di bilanciamento di +2 e il suo
		 * figlio sinistro un coefficiente di bilanciamento uguale a -1 o 0.
		 */
		private void rotationDD(AVLTreeNode x3) {
			/*
			 * Istanzio un oggetto di tipo AVLTreeNode il quale contiene il genitore del
			 * parent della variabile passato come argomento del metodo.
			 */
			AVLTreeNode x3Padre = x3.parent;

			/*
			 * Istanzio un oggetto di tipo AVLTreeNode a cui associo il sottoalbero sinistro
			 * del parametro locale passato nel metodo.
			 */
			AVLTreeNode x2 = x3.right;

			if (x3Padre != null) {
				/*
				 * Se x3Padre è diverso da null allora controllo se assegnare x2 al sottoalbero
				 * sinistro o destro.
				 */
				if (x3Padre.right.equals(x3)) {
					x3Padre.right = x2;
				} else {
					x3Padre.left = x2;
				}
				x2.parent = x3Padre;
			} else {
				/*
				 * Altrimenti setto semplicimente il genitore di x2 uguale a null, definendolo
				 * quindi come radice.
				 */
				x2.parent = null;
				setRoot(x2);
			}

			/*
			 * Il genitore di x3 a questo punto viene assegnato alla variabile x2.
			 */
			x3.parent = x2;

			/*
			 * Se il sottoalbero sinistro di x2 è diverso da null allora effettuo degli
			 * spostamenti di variabili altrimenti setto il sottoalbero destro uguale a
			 * null.
			 */
			if (x2.left != null) {
				x2.left.parent = x3;
				x3.right = x2.left;
			} else {
				x3.right = null;
			}

			/*
			 * Il sottoalbero sinistro a questo punto diventa uguale al valore passato come
			 * argomento locale del metodo.
			 */
			x2.left = x3;

			/*
			 * Aggiorno l'altezza di x3.
			 */
			x3.updateHeight();

			/*
			 * Creo un nodo temporaneo a cui assegno il valore di x2 e finchè è diverso da
			 * null continuo ad aggiornare la sua altezza.
			 */
			AVLTreeNode tempUpdate = x2;
			while (tempUpdate != null) {
				tempUpdate.updateHeight();
				tempUpdate = tempUpdate.parent;
			}
		}

		/*
		 * Rotazione Sinistra-Destra.
		 * 
		 * Si esegue quando un nodo ha un coefficiente di bilanciamento di +2 e il suo
		 * figlio sinistro un coefficiente di bilanciamento uguale a -1.
		 */
		private void rotationSD(AVLTreeNode x3) {
			/*
			 * Assegno alla variable x2, di natura AVLTreeNode, il sottoalbero sinstro del
			 * parametro locale passato nel metodo.
			 */
			AVLTreeNode x2 = x3.left;

			/*
			 * Assegno alla variabile x1, di natura AVLTreeNode, il sottoalbero destro del
			 * parametro locale passato nel metodo.
			 */
			AVLTreeNode x1 = x2.right;

			/*
			 * Effettuo degli spostamenti tra le varie variabili.
			 */
			x1.parent = x3;
			x3.left = x1;
			x2.parent = x1;

			/*
			 * Se il sottoalbero sinistro è diverso da null allora sovrascrivo il
			 * sottoalbero destro di x2 con il sottoalbero sinistro di x1. Altrimenti il
			 * sottoalbero destro di x2 sarà semplicemente uguale a null.
			 */
			if (x1.left != null) {
				x1.left.parent = x2;
				x2.right = x1.left;
			} else {
				x2.right = null;
			}

			/*
			 * Il valore di x2 viene assegnato al sottoalbero sinistro di x1.
			 */
			x1.left = x2;

			/*
			 * Creo un nodo temporaneo a cui assegno il valore di x2 e finchè è diverso da
			 * null continuo ad aggiornare la sua altezza.
			 */
			AVLTreeNode tempUpdate = x2;
			while (tempUpdate != null) {
				tempUpdate.updateHeight();
				tempUpdate = tempUpdate.parent;
			}

			/*
			 * Effettuo una rotazione di tipo Sinistra-Sinistra lungo il nodo x3.
			 */
			rotationSS(x3);
		}

		/*
		 * Rotazione Destra-Sinistra.
		 * 
		 * Si esegue quando un nodo ha un coefficiente di bilanciamento di -2 e il suo
		 * figlio destro un coefficiente di bilanciamento uguale a +1
		 */
		private void rotationDS(AVLTreeNode x3) {
			/*
			 * Assegno alla variable x2, di natura AVLTreeNode, il sottoalbero destro del
			 * parametro locale passato nel metodo.
			 */
			AVLTreeNode x2 = x3.right;

			/*
			 * Assegno alla variabile x1, di natura AVLTreeNode, il sottoalbero sinistro del
			 * parametro locale passato nel metodo.
			 */
			AVLTreeNode x1 = x2.left;

			/*
			 * Effettuo degli spostamenti tra le varie variabili.
			 */
			x1.parent = x3;
			x3.right = x1;
			x2.parent = x1;

			/*
			 * Se il sottoalbero destro è diverso da null allora sovrascrivo il sottoalbero
			 * sinistro di x2 con il sottoalbero destro di x1. Altrimenti il sottoalbero
			 * sinistro di x2 sarà semplicemente uguale a null.
			 */
			if (x1.right != null) {
				x1.right.parent = x2;
				x2.left = x1.right;
			} else {
				x2.left = null;
			}

			/*
			 * Il valore di x2 viene assegnato al sottoalbero destro di x1.
			 */
			x1.right = x2;

			/*
			 * Creo un nodo temporaneo a cui assegno il valore di x2 e finchè è diverso da
			 * null continuo ad aggiornare la sua altezza.
			 */
			AVLTreeNode tempUpdate = x2;
			while (tempUpdate != null) {
				tempUpdate.updateHeight();
				tempUpdate = tempUpdate.parent;
			}

			/*
			 * Effettuo una rotazione di tipo Destra-Destra lungo il nodo x3.
			 */
			rotationDD(x3);
		}
	}

	/**
	 * Determina se questo AVLTree è vuoto.
	 * 
	 * @return true, se questo AVLTree è vuoto.
	 */
	public boolean isEmpty() {
		return (this.root == null);
	}

	/**
	 * Restituisce il numero di elementi contenuti in questo AVLTree. In caso di
	 * elementi ripetuti essi vengono contati più volte.
	 * 
	 * @return il numero di elementi di tipo {@code E} presenti in questo AVLTree.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Restituisce il numero di nodi in questo AVLTree.
	 * 
	 * @return il numero di nodi in questo AVLTree.
	 */
	public int getNumberOfNodes() {
		return this.numberOfNodes;
	}

	/**
	 * Restituisce l'altezza di questo AVLTree. Se questo AVLTree è vuoto viene
	 * restituito il valore -1.
	 * 
	 * @return l'altezza di questo AVLTree, -1 se questo AVLTree è vuoto.
	 */
	public int getHeight() {
		/*
		 * Se questo albero è vuoto allora restituisco l valore negativo intero meno uno
		 * altrimenti restituisco, molto banalmente, il valore intero dell'altezza.
		 */
		if (isEmpty()) {
			return -1;
		} else {
			return root.height;
		}
	}

	/**
	 * @return the root
	 */
	public AVLTreeNode getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(AVLTreeNode root) {
		this.root = root;
	}

	/**
	 * Determina se questo AVLTree è bilanciato. L'albero è bilanciato se tutti i
	 * nodi hanno un fattore di bilanciamento compreso tra -1 e +1.
	 * 
	 * @return true, se il fattore di bilanciamento di tutti i nodi dell'albero è
	 *         compreso tra -1 e +1.
	 */
	public boolean isBalanced() {
		return root.isBalanced();
	}

	/**
	 * Inserisce un nuovo elemento in questo AVLTree. Se l'elemento è già presente
	 * viene incrementato il suo numero di occorrenze.
	 * 
	 * @param el
	 *            l'elemento da inserire.
	 * @return il numero di confronti tra elementi della classe {@code E} effettuati
	 *         durante l'inserimento
	 * @throws NullPointerException
	 *             se l'elemento {@code el} è null
	 */
	public int insert(E el) {
		/*
		 * In caso il parametro in input sia nullo allora viene lanciata un'eccezione di
		 * tipo NullPointerException.
		 */
		if (el == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * Se questo albero è vuoto viene inizializzato con size pari a uno e con root
		 * uguale all'elemento passato come parametro locale del metodo.
		 */
		if (this.isEmpty()) {
			root = new AVLTreeNode(el);
			size = 1;
			numberOfNodes = 1;
		}

		/*
		 * Creo un variabile temporanea di tipo booleano a cui assegno il valore vero o
		 * falso a seconda se l'elemento è presente già nell'albero.
		 */
		boolean tempFlagContains = this.contains(el);

		/*
		 * Eseguo lo storage dei confronti effettuati in una varibile di tipo intero.
		 */
		int tempEachComparison = root.insert(el);

		/*
		 * Incremento la size ogni volta che inserisco un elemento.
		 */
		size = size + 1;

		/*
		 * Finchè l'elemento non è presente nell'albero continuo ad incrementare il
		 * numero dei nodi all'interno di esso.
		 */
		if (!tempFlagContains) {
			numberOfNodes = numberOfNodes + 1;
		}

		/*
		 * Restituisco il numero di confronti effettuati.
		 */
		return tempEachComparison;
	}

	/**
	 * Determina se questo AVLTree contiene un certo elemento.
	 * 
	 * @param el
	 *            l'elemento da cercare
	 * @return true se l'elemento è presente in questo AVLTree, false altrimenti.
	 * @throws NullPointerException
	 *             se l'elemento {@code el} è null
	 */
	public boolean contains(E el) {
		/*
		 * In caso il parametro in input sia nullo allora viene lanciata un'eccezione di
		 * tipo NullPointerException.
		 */
		if (el == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * Se il valore non è presente nell'albero allora restituisco il valore falso
		 * altrimenti il valore true.
		 */
		if (root.search(el) == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Determina se un elemento è presente in questo AVLTree e ne restituisce il
	 * relativo nodo.
	 * 
	 * @param el
	 *            l'elemento da cercare
	 * @return il nodo di questo AVLTree che contiene l'elemento {@code el} e la sua
	 *         molteplicità, oppure {@code null} se l'elemento {@code el} non è
	 *         presente in questo AVLTree.
	 * @throws NullPointerException
	 *             se l'elemento {@code el} è null
	 * 
	 */
	public AVLTreeNode getNodeOf(E el) {
		/*
		 * In caso il parametro in input sia nullo allora viene lanciata un'eccezione di
		 * tipo NullPointerException.
		 */
		if (el == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * Se l'elemento è presente restituisco il nodo a cui esso appartiene altrimenti
		 * restituisco il valore null.
		 */
		if (this.contains(el)) {
			return root.search(el);
		} else {
			return null;
		}
	}

	/**
	 * Determina il numero di occorrenze di un certo elemento in questo AVLTree.
	 * 
	 * @param el
	 *            l'elemento di cui determinare il numero di occorrenze
	 * @return il numero di occorrenze dell'elemento {@code el} in questo AVLTree,
	 *         zero se non è presente.
	 * @throws NullPointerException
	 *             se l'elemento {@code el} è null
	 */
	public int getCount(E el) {
		/*
		 * In caso il parametro in input sia nullo allora viene lanciata un'eccezione di
		 * tipo NullPointerException.
		 */
		if (el == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * Se il valore è presente nell'albero conto quante occorrenze esso presenta
		 * altrimenti restituisco il valore zero in quanto significa che l'elemento non
		 * è presente all'interno di esso.
		 */
		if (contains(el)) {
			return root.search(el).getCount();
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String descr = "AVLTree [root=" + root.el.toString() + ", size=" + size + ", numberOfNodes=" + numberOfNodes
				+ "]\n";
		return descr + this.root.toString();
	}

	/**
	 * Restituisce la lista degli elementi contenuti in questo AVLTree secondo
	 * l'ordine determinato dalla visita in-order. Per le proprietà dell'albero AVL
	 * la lista ottenuta conterrà gli elementi in ordine crescente rispetto
	 * all'ordinamento naturale della classe {@code E}. Nel caso di elementi
	 * ripetuti, essi appaiono più volte nella lista consecutivamente.
	 * 
	 * @return la lista ordinata degli elementi contenuti in questo AVLTree, tenendo
	 *         conto della loro molteplicità.
	 */
	public List<E> inOrderVisit() {
		/*
		 * Inizializzo un ArrayList di elementi di natura E.
		 */
		ArrayList<E> listTree = new ArrayList<E>();

		/*
		 * Creo una variabile in cui inserisco il minimo elemento dell'albero AVL.
		 */
		AVLTreeNode nodeMin = root.getMinimum();

		/*
		 * Inizializzo un contatore uguale a zero per effettuare delle operazioni in
		 * seguito.
		 */
		int countReverse = 0;

		/*
		 * Finchè il valore minimo dell'albero non coincide con il valore massimo allora
		 * inizio ad aggiungere gli elementi all'ArrayList.
		 */
		while (!(nodeMin.equals(root.getMaximum()))) {
			countReverse = nodeMin.getCount();
			while (countReverse > 0) {
				listTree.add(nodeMin.getEl());
				countReverse = countReverse - 1;
			}
			nodeMin = nodeMin.getSuccessor();
		}

		/*
		 * Aggiungo il massimo all'ArrayList
		 */
		countReverse = nodeMin.getCount();
		while (countReverse > 0) {
			listTree.add(nodeMin.getEl());
			countReverse = countReverse - 1;
		}

		/*
		 * Restituisco la lista composta da tutti gli elementi dell'albero appena
		 * visitati.
		 */
		return listTree;
	}

	/**
	 * Restituisce l'elemento minimo presente in questo AVLTree.
	 * 
	 * @return l'elemento minimo in questo AVLTree, {@code null} se questo AVLTree è
	 *         vuoto.
	 */
	public E getMinimum() {
		/*
		 * Se il root, ovvero la radice, è uguale a null ovviamente il valore minimo non
		 * sarà presente e quindi restituirò il valore null. Altrimenti andrò ad
		 * effettuare una scansione ricorsiva finchè questo non venga restituito.
		 */
		if (root == null) {
			return null;
		} else {
			return root.getMinimum().getEl();
		}
	}

	/**
	 * Restituisce l'elemento massimo presente in questo AVLTree.
	 * 
	 * @return l'elemento massimo in questo AVLTree, {@code null} se questo AVLTree
	 *         è vuoto.
	 */
	public E getMaximum() {
		/*
		 * Se il root, ovvero la radice, è uguale a null ovviamente il valore massimo
		 * non sarà presente e quindi restituirò il valore null. Altrimenti andrò ad
		 * effettuare una scansione ricorsiva finchè questo non venga restituito.
		 */
		if (root == null) {
			return null;
		} else {
			return root.getMaximum().getEl();
		}
	}

	/**
	 * Restituisce l'elemento <b>strettamente</b> successore, in questo AVLTree, di
	 * un dato elemento. Si richiede che l'elemento passato sia presente
	 * nell'albero.
	 * 
	 * @param el
	 *            l'elemento di cui si chiede il successore
	 * @return l'elemento <b>strettamente</b> successore, rispetto all'ordinamento
	 *         naturale della classe {@code E}, di {@code el} in questo AVLTree,
	 *         oppure {@code null} se {@code el} è l'elemento massimo.
	 * @throws NullPointerException
	 *             se l'elemento {@code el} è null
	 * @throws IllegalArgumentException
	 *             se l'elemento {@code el} non è presente in questo AVLTree.
	 */
	public E getSuccessor(E el) {
		/*
		 * In caso il parametro in input sia nullo allora viene lanciata un'eccezione di
		 * tipo NullPointerException.
		 */
		if (el == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * In caso il parametro non sia contenuto all'interno dell'albero allora lancerò
		 * un'eccezione di tipo IllegalArgumentException.
		 */
		if (!contains(el)) {
			throw new IllegalArgumentException("Elemento non presente nell'albero AVL");
		}

		/*
		 * Se l'elemento coincide con il massimo allora restituisco il valore null, in
		 * quanto non esiste un suo successore.
		 */
		if (el.equals(getMaximum())) {
			return null;
		}

		/*
		 * Restituisco il valore successico a quello cercato.
		 */
		return root.search(el).getSuccessor().getEl();
	}

	/**
	 * Restituisce l'elemento <b>strettamente</b> predecessore, in questo AVLTree,
	 * di un dato elemento. Si richiede che l'elemento passato sia presente
	 * nell'albero.
	 * 
	 * @param el
	 *            l'elemento di cui si chiede il predecessore
	 * @return l'elemento <b>strettamente</b> predecessore rispetto all'ordinamento
	 *         naturale della classe {@code E}, di {@code el} in questo AVLTree,
	 *         oppure {@code null} se {@code el} è l'elemento minimo.
	 * @throws NullPointerException
	 *             se l'elemento {@code el} è null
	 * @throws IllegalArgumentException
	 *             se l'elemento {@code el} non è presente in questo AVLTree.
	 */
	public E getPredecessor(E el) {
		/*
		 * In caso il parametro in input sia nullo allora viene lanciata un'eccezione di
		 * tipo NullPointerException.
		 */
		if (el == null) {
			throw new NullPointerException("Elemento nullo");
		}

		/*
		 * In caso il parametro non sia contenuto all'interno dell'albero allora lancerò
		 * un'eccezione di tipo IllegalArgumentException.
		 */
		if (!contains(el)) {
			throw new IllegalArgumentException("Elemento non presente nell'albero AVL");
		}

		/*
		 * Se l'elemento coincide con il minimo allora restituisco il valore null, in
		 * quanto non esiste un suo predecessore.
		 */
		if (el.equals(getMinimum())) {
			return null;
		}

		/*
		 * Restituisco il valore precedente a quello cercato.
		 */
		return root.search(el).getPredecessor().getEl();
	}
}
