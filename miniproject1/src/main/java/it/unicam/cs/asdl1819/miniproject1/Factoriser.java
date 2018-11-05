package it.unicam.cs.asdl1819.miniproject1;

import java.util.HashSet;
import java.util.SortedSet;

import it.unicam.cs.asdl1819.miniproject1.MyMultiset.Elemento;

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
	
    public Multiset<Integer> getFactors(int n) {
    	
    	if(n < 1) {
    		throw new IllegalArgumentException("Il numero richiesto è minore di 1");
    	}
    	
    	MyMultiset<Integer> myMultiSet = new MyMultiset<Integer>();
    	
    	if(n == 1) {
    		return myMultiSet;
    	}
    	
    	CrivelloDiEratostene crivelloPrime = new CrivelloDiEratostene(n);
    	
        for (int i = 2; n != 1; i = crivelloPrime.nextPrime(i)) {
            while (n % i == 0) {
            	n = n / i;
            	myMultiSet.add(i); 
            }
        }
    	return myMultiSet;
    }
}
