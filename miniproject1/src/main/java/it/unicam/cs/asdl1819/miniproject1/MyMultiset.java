package it.unicam.cs.asdl1819.miniproject1;

import java.util.HashSet; // Utilizzare questa classe per i set
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Un multiset è un insieme di dati in cui gli elementi possiedono un conteggio (o
 * molteplicità o frequenza), cioè un numero di occorrenze. Il conteggio può
 * essere zero: questo equivale a dire che l'elemento non appartiene al
 * multiset. Se, invece, il conteggio è un intero positivo {@code n} allora il
 * elemento si verifica {@code n} volte nel multiset.
 * 
 * In un classico multiset gli elementi al suo interno non possiedono nessun 
 * tipo di ordinamento.
 * 
 * È severamente vietato inserire un elemento di tipo nullo nel multiset.
 * 
 * @author Luca Tesei (template), Francesco Coppola (implementazione)
 *
 * @param <E>
 *            il tipo degli elementi del multiset
 */
public class MyMultiset<E> implements Multiset<E> {
	/*
	 * Dichiarazione della varibile multiSet come un HashSet, avente
	 * come interfaccia l'inner class Elemento, costruita appositamente
	 * per il funzionamento generale del codice.
	 */
	private HashSet<Elemento> multiSet;
	
	public class Elemento {
		/*
		 * La classe Elemento definisce, sostanzialmente, due punti cardini
		 * dell'intero progetto: il riferimento dell'oggetto contenuto nella 
		 * struttura dati in cui verrà implementata e il numero di 
		 * occorrenze di quest'ultimo.
		 */
		private E riferimento;
		private int occorrenze;
		
		/*
		 * Il costruttore della classe Elemento che prende come argomento
		 * una variabile di tipo E, la quale indicherà il riferimento dell'oggetto
		 * stesso, e una variabile di tipo intero che andrà a definire la frequenza
		 * dell'oggetto stesso.
		 */
		public Elemento(E r, int n) {
			this.riferimento = r;
			this.occorrenze = n;
		}
		
		/*
		 * Mediante il seguente metodo si vanno a definire le occorrenze per un 
		 * determinato oggetto.
		 */
		public void setOccorrenze(int occorrenze) {
			if(occorrenze < 0) {
				throw new IllegalArgumentException("Numero di occorenze minore di zero");
			}
			
			if(occorrenze > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("Numero di occorenze maggiore di Integer.MAX_VALUE");
			}
			
			this.occorrenze = occorrenze;
		}
		
		@Override
		public String toString() {
			return "Oggetto: " + riferimento.toString() + ", occorrenze: " + occorrenze;
		}
	}
	
    public MyMultiset() {
    	/*
         * Generazione di multiset attualmente vuoto.
         */
    	multiSet = new HashSet<Elemento>();
    }

    public int size() {
    	/*
    	 * Metodo che inizializza una varibile intera chiamata size, inizialmente 
    	 * impostata a 0, la quale viene incrementata per ogni elemento 
    	 * trovato all'interno del multiset.
    	 * 
    	 * Nel caso in cui nel multiset ci siano due elementi identici, essi 
    	 * verranno comunque considerati come differenti, e di conseguenza
    	 * la variabile size terrà conto di entrambi.
    	 */
    	
    	/*
    	 * Inializzo una varibile intera size in cui farò il salvataggio di tutte
    	 * le occorrenze recuperate all'interno della struttura dati.
    	 */
    	int size = 0;
    	
    	/*
    	 * Per ogni oggetto trovato all'interno del multiset viene incrementata 
    	 * la variabile size, che quindi terrà conto anche della frequanza multipla
    	 * di un singolo oggetto.
    	 */
    	for(Elemento e : multiSet) {
    		size += e.occorrenze;
    	}
    	
    	/*
    	 * Restituisco la size del multiset.
    	 */
        return size;
    }

    public int count(Object element) {
    	/*
    	 * Dato in input un particolare oggetto, il metodo count restituirà 
    	 * le occorrenze con cui quest'ultimo appare all'interno del multiset.
    	 * 
    	 * Nel caso in cui venga dato in input un oggetto nullo allora il metodo
    	 * lancerà un'eccezione. 
    	 */
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	/*
    	 * Attraverso il seguente costrutto calcolo le occorrenze di un particolare 
    	 * oggetto che viene passato come argomento del metodo stesso.
    	 */
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			return e.occorrenze;
    		}
    	}
    	
    	/*
    	 * Nel caso in cui l'oggetto non sia presente all'interno del metodo stesso
    	 * allora ritornerà il valore 0.
    	 */
        return 0;
    }

    public int add(E element, int occurrences) {
    	/*
    	 * Questo metodo permette di aggiungere un determinato numero 
    	 * di volte, determinato appunto dal parametro locale 'occurrences', un 
    	 * particolare tipo oggetto di natura E al multiset instanziato.
    	 * 
    	 * Nel caso in cui venga dato in input un numero negativo o maggiore 
    	 * del valore Integer.MAX_VALUE allora il metodo lancerà un'eccezione; stessa
    	 * cosa accadrà quando l'oggetto dato in input risulti nullo.
    	 */
    	if(occurrences < 0) {
			throw new IllegalArgumentException("Numero di occorenze minore di zero");
		}
		
		if(occurrences > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Numero di occorenze maggiore di Integer.MAX_VALUE");
		}
    	
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	/*
    	 * Viene inizialmente ciclata la struttura dati. Se l'oggetto inserito 
    	 * al suo interno è già presente allora verrà semplicemente aumentata 
    	 * la sua moltiplicità di 'occurrences' volte, ovvero di quante volte
    	 * l'utente ha intenzione di aggiungere l'oggetto stesso.
    	 */
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			int backupOccurrences = e.occorrenze;
    			e.setOccorrenze(e.occorrenze + occurrences);
    			/*
    			 * Viene restituito il valore dell'occorrenze prima dell'operazione
    			 * di aggiunta dell'oggetto all'interno del multiset.
    			 */
    			return backupOccurrences;
    		}
    	}
    	
    	/*
    	 * Nel caso in cui l'oggetto non sia già presente nel multiset allora
    	 * esso verrà inserito con una frequenza determinata dal parametro intero
    	 * 'occurrences' passato come argomento del metodo stesso.
    	 */
    	multiSet.add(new Elemento(element, occurrences));
    	
    	/*
    	 * Nel caso in cui l'oggetto non fosse già presente, e quindi la
    	 * sua frequenza fosse uguale a zero, verrà restituto il valore 0.
    	 */
        return 0;
    }

    public void add(E element) {
    	/*
    	 * Metodo che aggiunge una sola occorrenza di un determinato 
    	 * elemento al multiset.
    	 *  
    	 * Nel caso in cui venga dato in input un oggetto nullo allora il metodo
    	 * lancerà un'eccezione. 
    	 */
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	/*
    	 * Viene completamente ciclata la struttura dati. Se l'oggetto inserito 
    	 * al suo interno è già presente al suo interno allora verrà semplicemente
    	 * aumentata la sua moltiplicità.
    	 */
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			e.setOccorrenze(++e.occorrenze);
    			return;
    		}
    	}
    	
    	/*
    	 * Nel caso in cui l'oggetto non sia già presente nel multiset allora
    	 * esso verrà inserito con una frequenza uguale a 1.
    	 */
    	multiSet.add(new Elemento(element, 1));
    }

    public int remove(Object element, int occurrences) {
    	/*
    	 * Grazie a questo metodo è possibile andare a rimuovere un preciso 
    	 * elemento nel multiset per un numero 'occurrences' di volte, dove
    	 * quest'ultimo è proprio il secondo parametro locale del metodo.
    	 * 
    	 * In caso in cui la molteplicità dell'elemento, all'interno del 
    	 * multiset, da rimuovere sia minore di quello del parametro locale 
    	 * allora tutti gli elementi della stessa natura verranno rimossi.
    	 * 
    	 * Nel caso in cui venga dato in input un numero negativo 
    	 * allora il metodo lancerà un'eccezione; stessa
    	 * cosa accadrà quando l'oggetto dato in input risulti nullo.
    	 */
    	if(occurrences < 0) {
    		throw new IllegalArgumentException("Numero di occorenze minore di zero");
    	}
    	
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	/*
    	 * Viene ciclata la struttura dati.
    	 */
    	for(Elemento e : multiSet) {
    		/*
    		 * Nel caso in cui l'esito del costrutto if sia positivo allora verrà
    		 * rimosso un oggetto per 'occurrences' volte desiderate dall'utente.
    		 */
    		if(e.riferimento.equals(element)) {
    			/*
    			 * Variabile temporanea in cui vengono salvate le occorrenze dell'oggetto
    			 * desiderato prima di effettuare delle possibili operzioni di rimozione.
    			 */
    			int tempOccorenze = e.occorrenze;
    			
    			if(occurrences >= e.occorrenze) {
    				/*
    				 * Siccome le occorrenze richieste per la rimozione dell'oggetto
    				 * risultano essere maggiori di quelle dell'oggetto stesso all'interno
    				 * al multiset allora l'oggetto verrà rimosso completamente.
    				 */
    				multiSet.remove(e);
    				
    				/*
    				 * Viene restituito il valore dell'occorrenze prima dell'operazione
    				 * di rimozione.
    				 */
    				return tempOccorenze;
    			}
    			else {
    				/*
    				 * Viene decrementato il valore dell'occorrenze di uno specifico oggetto
    				 * di 'occurrences' volte.
    				 */
    				e.setOccorrenze(e.occorrenze - occurrences);
    				
    				/*
    				 * Viene restituito il valore dell'occorrenze prima dell'operazione
    				 * di rimozione.
    				 */
    				return tempOccorenze;
    			}
    		}
    	}
    	
    	/*
    	 * Nel caso in cui l'oggetto non fosse già presente, e quindi la
    	 * sua frequenza fosse uguale a zero, verrà restituto il valore 0.
    	 */
    	return 0;
    }

    public boolean remove(Object element) {
    	/*
    	 * Il fine di questo metodo è andare a rimuovere una singola
    	 * occorrenza di un dato oggetto in input all'interno del multiset.
    	 * 
    	 * Nel caso in cui venga dato in input un oggetto nullo allora il metodo
    	 * lancerà un'eccezione. 
    	 */
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	/*
    	 * Viene decrementato di un'unità il valore della frequanza di un oggetto.
    	 */
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			e.setOccorrenze(--e.occorrenze);
    			/*
    			 * Confermo la presenza dell'oggetto all'interno del multiset 
    			 * e l'esito della rimozione andando a restituire un valore booleano
    			 * true.
    			 */
    			return true;
    		}
    	}
    	
    	/*
		 * Non confermo la presenza dell'oggetto all'interno del multiset 
		 * né tanto meno l'esito della rimozione andando a restituire un 
		 * valore booleano false.
		 */
        return false;
    }

    public int setCount(E element, int count) {
    	/*
    	 * Il seguente metodo setCount permette di andare ad aggiungere o rimuovere
    	 * un determinato numero di volte, dato dal parametro locale intero count, un 
    	 * elemento personalizzato all'interno del multiset.
    	 * 
    	 * L'utilità di setCount è davvero importante in quanto permette 
    	 * di compiere operazioni di aggiunzione e rimozione nel multiset 
    	 * utilizzando un solo metodo.
    	 * 
    	 * Nel caso in cui venga dato in input un numero negativo 
    	 * allora il metodo lancerà un'eccezione; stessa
    	 * cosa accadrà quando l'oggetto dato in input risulti nullo.
    	 */
    	if(count < 0) {
    		throw new IllegalArgumentException("Numero di occorenze minore di zero");
    	}
    	
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	/*
    	 * Una volta ciclato tutto il multiset vengono aggiunti o rimossi
    	 * oggetti, e in caso aumentata o decrementata la loro frequenza,
    	 * all'interno della struttura dati.
    	 */
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			int tempOccorenze = e.occorrenze;
    			e.setOccorrenze(count);
    			return tempOccorenze;
    		}
    	}
    	
    	/*
    	 * Viene creato un oggetto temporaneo p che viene immediatamente aggiunto 
    	 * al multiset solamente nel caso in cui non sia già presente all'interno
    	 * della struttura dati.
    	 */
    	Elemento p = new Elemento(element, count);
    	multiSet.add(p);
    	
    	/*
    	 * Nel caso in cui l'oggetto non fosse già presente, e quindi la
    	 * sua frequenza fosse uguale a zero, verrà restituto il valore 0.
    	 */
        return 0;
    }

    public Set<E> elementSet() {
    	/*
    	 * Attraverso elemenetSet è possibile ottenere il set di elementi 
    	 * contenuti all'interno del multiset. Essi verranno comunque disposti 
    	 * in un oridine non definito e, soprattutto, in caso di oggetti aventi
    	 * una molteplicità maggiore di uno essi verranno considerati 
    	 * soltano una volta.
    	 */
        Set<E> setStuff = new HashSet<E>();
        for(Elemento e : multiSet) {
        	setStuff.add(e.riferimento);
        }
        return setStuff;
    }
    
    private class MyMultiSetIterator implements Iterator<E> {
    	/*
    	 * La classe privata MyMultiSetIterator implementa l'interfaccia 
    	 * Iterator e non fa nient'altro che andare a definire un iteratore 
    	 * personalizzato che posside dei metodi ben definiti:
    	 * 
    	 * • hasNext():
    	 * 		Restitusice un valore booleano dipendente dal
    	 * 		caso in cui ci sia un elemento successivo a quello
    	 * 		selezionato.
    	 * • next():
    	 * 		Restituisce l'elemento successivo a quello selezionato.
    	 * 		In caso in cui non ci siano più elementi all'interno
    	 * 		dell'iteratore verrà lanciata un eccezione.
    	 */
    	Iterator<Elemento> itHash;
    	int conteggioOccorrenze;
    	Elemento tempRef;
    	
    	/*
    	 * Costruisco il mio oggetto MyMultiSetIterator.
    	 */
    	private MyMultiSetIterator() {
    		itHash = multiSet.iterator();
    		conteggioOccorrenze = 0;
    		tempRef = null;
    	}
    	
    	public boolean hasNext() {
    		/*
    		 * Attraverso il seguente costrutto if controllo se un determinato
    		 * oggetto posside un elemento successivo oppure no. 
    		 * 
    		 * Nel caso positivo il metodo restituirà un valore true mentre in 
    		 * caso negativo il valore restituito sarà false.
    		 */
    		if((conteggioOccorrenze != 0) || itHash.hasNext()) {
    			return true;
    		}
    		return false;
    	}
    	
    	public E next() {
    		/*
    		 * Restituisco l'oggetto di natura E successivo a quello corrente.
    		 */
    		if(conteggioOccorrenze == 0) {
    			tempRef = itHash.next();
    			if(tempRef == null) {
    				throw new NoSuchElementException("Elementi iteratore terminati");
    			}
    			conteggioOccorrenze = tempRef.occorrenze;
    			conteggioOccorrenze -= 1;
    			return tempRef.riferimento;
    		}
    		else {
    			conteggioOccorrenze -= 1;
    			return tempRef.riferimento;
    		}
    	}
    }

    public Iterator<E> iterator() {
    	/*
    	 * Mediante questo metodo iterator è possibile ottenere un iteratore
    	 * per il multiset. L'iteratore deve contenere obbligatoriamente tutti
    	 * gli elementi del multiset e per ognuno di essi deve anche presentare 
    	 * la loro moltiplicità.
    	 */
        return new MyMultiSetIterator();
    }

    public boolean contains(Object element) {
    	/*
    	 * Il metodo contains di natura booleana restituisce un valore 
    	 * vero o falso a seconda di:
    	 * 
    	 * • True: 
    	 * 		Il parametro locale passato in input è presente all'interno 
    	 * 		del multiset.
    	 * • False:
    	 * 		Il parametro locale passato in input non è presente all'interno 
    	 * 		del multiset.
    	 * 
    	 * Nel caso in cui venga dato in input un oggetto nullo allora il metodo
    	 * lancerà un'eccezione.
    	 */
    	if(element == null) {
    		throw new NullPointerException("Oggetto inserito in input non valido");
    	}
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			return true;
            }
    	}
        return false;
    }

    public void clear() {
    	/*
    	 * Il seguente metodo ripulisce interamente l'intero multiset, andando
    	 * a cancellare ogni elemento che si trova al suo interno utilizzando il
    	 * metodo 'clear' già definito nel HashSet.
    	 */
    	multiSet.clear();
    }

    public boolean isEmpty() {
    	/*
    	 * Il metodo isEmpty di natura booleana restituisce un valore 
    	 * vero o falso a seconda di:
    	 * 
    	 * • True: 
    	 * 		Il multiset non contiene nessun elemento.
    	 * • False:
    	 * 		Il multiset contiene almeno un elemento, o meglio, non
    	 * 		è vuoto.
    	 */
    	if(this.size() == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    @Override
	public int hashCode() {
    	/*
    	 * Attraverso il seguente metodo, generato in maniera autonoma 
    	 * dall'IDE, è possibile ottenere l'hashCode univoco identificativo 
    	 * del multiset.
    	 */
		final int prime = 31;
		int result = 1;
		result = prime * result + ((multiSet == null) ? 0 : multiSet.hashCode());
		return result;
	}

    @SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
    	/*
    	 * Il metodo equals effettua un operazione di uguaglianza su due multiset.
    	 * 
    	 * Più precisamente esso controlla innanzitutto se tutti gli oggetti all'interno
    	 * del primo multiset corrispondono agli oggetti presenti nel secondo multiset.
    	 * 
    	 * In secondo luogo esso verificherà che gli oggetti precedentemente scansionati
    	 * possiedano la medesima molteplicità all'interno dei due multiset.
    	 * 
    	 * Se entrambe le operazioni termineranno con esito positivo vorrà dire che
    	 * i due multiset sono uguali, mentre nel caso in cui una delle due fallisca,
    	 * l'esito finale sarà negativo.
    	 */
    	if (!(obj instanceof Multiset) || ((Multiset) obj).size() != size()) {
    	    return false;
    	}

	    for (Elemento element : multiSet) {
	    	if (this.count(element) != ((Multiset) obj).count(element)) {
    	        return false;
	      	}
    	}

	    return true;
	}
    
    @Override
    public String toString() {
		/*
		 * Metodo personalizzato toString() utilizzato per l'operazione di debugging.
		 */
      MyMultiset<Elemento> added = new MyMultiset<Elemento>();
      String result = "[";

      for (Elemento element : multiSet) {
        if (!added.contains(element)) {
          if (added.size() > 0) {
            result += "; ";
          }
          result += element.toString();
        }
        added.add(element);
      }
      return result + "]";
    }
}
