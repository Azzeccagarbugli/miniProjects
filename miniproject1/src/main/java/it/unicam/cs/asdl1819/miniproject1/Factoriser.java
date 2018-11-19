package it.unicam.cs.asdl1819.miniproject1;

import java.util.SortedSet;

/**
 * Un fattorizzatore è un agente che fattorizza un qualsiasi numero naturale nei
 * sui fattori primi.
 * 
 * @author Luca Tesei (template), Francesco Coppola (implementazione)
 *
 */
public class Factoriser {
    /**
     * Fattorizza un numero restituendo il multinsieme dei suoi fattori primi.
     * La molteplicità di ogni fattore primo esprime quante volte il fattore
     * stesso divide il numero fattorizzato. Per convenzione non viene mai
     * restituito il fattore 1. Il minimo numero fattorizzabile è 1. In questo
     * caso viene restituito un multinsieme vuoto.
     * 
     * @param n
     *              un numero intero da fattorizzare
     * @return il multinsieme dei fattori primi di n
     * @throws IllegalArgumentException
     *                                      se si chiede di fattorizzare un
     *                                      numero minore di 1.
     */
	
	/*
	 * L'utilizzo dei seguenti oggetti permette di:
	 * 
	 * • myMultiSet:
	 * 		Andare a costruire un multiset in cui andare a fare lo storage
	 * 		dei fattori primi del numero precedentemente inserito.
	 * • crivelloPrime:
	 * 		Effettuare un procedimento matematico il cui fine è comprendere
	 * 		se la natura del numero selezionato all'interno di un procedura
	 * 		iterativa è di essere primo o meno.
	 */
	private MyMultiset<Integer> myMultiSet;
	private CrivelloDiEratostene crivelloPrime;
	
    public Multiset<Integer> getFactors(int n) {
    	/*
    	 * Il seguente metodo getFactors, dato un numero intero, ritorna i suoi fattori
    	 * primi grazie all'implementazione di un crivello che effettua una scrematura
    	 * dei numeri inseriti e grazie a un algoritmo matematico di natura iterativa.
    	 * 
    	 * Questi fattori primi, dopo essere stati calcolati, verranno inseriti
    	 * all'interno di un multiset, il quale, terrà conto della loro frequanza.
    	 * 
    	 * Considerando di andare a calcolare i fattori primi del numero 777, si otterrà
    	 * il seguente risultato:
    	 * 
    	 * 	• Factoriser f = new Factoriser();
		 *	  Multiset<Integer> m = f.getFactors(777);
		 *	  System.out.println(m);
		 *
		 *	  <i>[Oggetto: 3, occorrenze: 1; Oggetto: 37, occorrenze: 1; Oggetto: 7, occorrenze: 1]</i>
    	 */
    	if(n < 1) {
    		throw new IllegalArgumentException("Il numero richiesto è minore di 1");
    	}
    	
    	/*
    	 * Costruzione di un multiset composto da interi in cui verrà eseguito
    	 * lo storage dei fattori primi del numero richiesto.
    	 */
    	myMultiSet = new MyMultiset<Integer>();
    	
    	/*
    	 * Controllo che l'argomento del metodo getFactors sia uguale a 1, in maniera tale
    	 * da restituire semplicemente il multiset, generato precedentemente, vuoto.
    	 */
    	if(n == 1) {
    		return myMultiSet;
    	}
    	
    	/*
    	 * Calcolo i numeri primi del crivello fino ad arrivare alla radice quadrata di n
    	 * considerando l'algoritmo di fattorizzazione "Metodo forza bruta migliorato".
    	 * 
    	 * In questo modo l'efficenza del progetto aumenta decisamente in quanto nel caso peggiore 
    	 * il costo è di O(√n) <i>nell'assunzione poco reale di un modello di costo a costi costanti</i>.
    	 */
    	crivelloPrime = new CrivelloDiEratostene((int) Math.ceil(Math.sqrt(n)));
    	
    	/*
    	 * Inializzo una struttura dati di tipologia SortedSet, quindi iterabile, composta da 
    	 * interi in cui eseguo il salvataggio di tutti i numeri primi calcolati nel crivello.
    	 */
    	SortedSet<Integer> listaPrimi = crivelloPrime.getPrimes();
    	
    	/*
    	 * All'interno del seguente costrutto ciclico calcolo i fattori primi del numero
    	 * n, passato come parametro locale del metodo, mediante un algoritmo di natura matematica.
    	 * 
    	 * Se l'intero con cui si sta divedendo il numero primo selezionato all'interno della lista 
    	 * <i>listaPrimi</i> primi risulta avere resto 0 allora esso andrà ad essere aggiunto all'interno
    	 * del multiset, struttura dati nella quale risiedono i fattori primi di n.
    	 */
        for (Integer i : listaPrimi) {
            while ((n % i) == 0) {
            	n = n / i;
            	myMultiSet.add(i); 
            }
        }
        
        /*
         * L'espressione del costrutto if ha riscontro positivo soltanto se, dopo la
         * prima parte della fattorizzazione, non ho all'interno del crivello altri
         * numeri primi che siano fattori per l'argomento al metodo getFactors. In tal
         * caso allora il valore stesso di n residuo delle fattorizzazioni è un numero
         * primo da aggiungere al multiset dei fattori. 
         */
        if(n != 1) {
        	myMultiSet.add(n);
        }
    	
        /*
         * In conclusione, dopo aver eseguito le operzioni di add nel multiset, posso restituire
         * in maniera corretta la struttura dati contenente i fattori primi di n.
         */
        return myMultiSet;
    }
}
