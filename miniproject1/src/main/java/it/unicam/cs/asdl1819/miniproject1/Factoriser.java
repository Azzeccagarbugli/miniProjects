package it.unicam.cs.asdl1819.miniproject1;

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
		 *
		 * È possibile controllare i fattori primi di un numero a proprio piacimento compilando
		 * il file main presente all'interno del package it.unicam.cs.asdl1819.miniproject1.
    	 */
    	if(n < 1) {
    		throw new IllegalArgumentException("Il numero richiesto è minore di 1");
    	}
    	
    	myMultiSet = new MyMultiset<Integer>();
    	
    	if(n == 1) {
    		return myMultiSet;
    	}
    	
    	crivelloPrime = new CrivelloDiEratostene((int)Math.ceil(Math.sqrt(n)));
    	
        for (Integer i : crivelloPrime.getPrimes()) {
            while ((n % i) == 0) {
            	n = n / i;
            	myMultiSet.add(i); 
            }
        }
        
        if(n != 1) {
        	myMultiSet.add(n);
        }
    	
        return myMultiSet;
    }
}
