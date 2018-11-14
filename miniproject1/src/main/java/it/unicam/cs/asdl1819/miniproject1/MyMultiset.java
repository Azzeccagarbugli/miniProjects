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
		 * occorenze di quest'ultimo.
		 */
		private E riferimento;
		private int occorrenze;

		public Elemento(E r, int n) {
			this.riferimento = r;
			this.occorrenze = n;
		}
		
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
    	int size = 0;
    	for(Elemento e : multiSet) {
    		size += e.occorrenze;
    	}
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
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			return e.occorrenze;
    		}
    	}
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
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			int backupOccurrences = e.occorrenze;
    			e.setOccorrenze(e.occorrenze + occurrences);
    			return backupOccurrences;
    		}
    	}
    	multiSet.add(new Elemento(element, occurrences));
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
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			e.setOccorrenze(++e.occorrenze);
    			return;
    		}
    	}
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
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			int tempOccorenze = e.occorrenze;
    			if(occurrences >= e.occorrenze) {
    				multiSet.remove(e);
    				return tempOccorenze;
    			}
    			else {
    				e.setOccorrenze(e.occorrenze - occurrences);
    				return tempOccorenze;
    			}
    		}
    	}
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
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			e.setOccorrenze(--e.occorrenze);
    			return true;
    		}
    	}
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
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			int tempOccorenze = e.occorrenze;
    			e.setOccorrenze(count);
    			return tempOccorenze;
    		}
    	}
    	
    	Elemento p = new Elemento(element, count);
    	multiSet.add(p);
    	
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
    	 * • clear():
    	 * 		Banalmente vengono eliminati tutti gli elementi 
    	 * 		all'interno dell'iteratore.
    	 */
    	Iterator<Elemento> itHash;
    	int conteggioOccorrenze;
    	Elemento tempRef;
    	
    	private MyMultiSetIterator() {
    		itHash = multiSet.iterator();
    		conteggioOccorrenze = 0;
    		tempRef = null;
    	}
    	
    	public boolean hasNext() {
    		if((conteggioOccorrenze != 0) || itHash.hasNext()) {
    			return true;
    		}
    		return false;
    	}
    	
    	public E next() {
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
    	
    	public void clear() {
    		while(itHash.hasNext()) {
    			itHash.next();
    			itHash.remove();
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
    	 * Il seguente metodo istanzia un oggetto di natura MyMultiSetIterator 
    	 * chiamato clearIt che non fa nient'altro che rimuovere tutti gli
    	 * elementi presenti all'interno del multiset.
    	 */
    	MyMultiSetIterator clearIt = new MyMultiSetIterator();
    	clearIt.clear();
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
    	 * Attraverso il seguente metodo è possibile ottenere l'hashCode 
    	 * identificativo del multiset.
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
