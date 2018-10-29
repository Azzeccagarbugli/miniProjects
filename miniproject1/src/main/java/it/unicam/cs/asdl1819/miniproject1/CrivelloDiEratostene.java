package it.unicam.cs.asdl1819.miniproject1;

import java.util.TreeSet; // Utilizzare questa classe per il SortedSet
import java.util.SortedSet;

/**
 * Il crivello di Eratostene è un modo per determinare tutti i numeri primi da
 * {@code 1} a un certo intero {@code n} assegnato.
 * 
 * @author Luca Tesei (template), Francesco Coppola (implementazione)
 *
 */
public class CrivelloDiEratostene {
    // TODO definire le variabili istanza appropriate
	
	private TreeSet<Integer> primesNumbers;
	private int maxCapacity;

    /**
     * Costruisce il crivello di Eratostene fino a un certo numero. Il numero
     * deve essere almeno 2.
     * 
     * @param n
     *        numero di entrate nel crivello
     * @throws IllegalArgumentException
     *         se il numero {@code n} è minore di {@code 2}
     */
    public CrivelloDiEratostene(int n) {
    	primesNumbers = new TreeSet<Integer>();
    	maxCapacity = n;
    	
    	if (n < 2) {
    		throw new IllegalArgumentException("Il numero inserito è minore di 2");
    	}
    	else {
    		for(int i = 2; i < n + 1; i++) {
        		primesNumbers.add(i);
        	}
    	}
    	
    	for(int i = 2; i < n + 1; i++) {
    		if(primesNumbers.contains(i)) {
    			for(int j = 2; j < n + 1; j++) {
    				if(primesNumbers.contains(j) && j != i && j % i == 0) {
    					primesNumbers.remove(j);
    				}
    			}
    		}
    	}	
    }

    /**
     * Cerca nel crivello l'indice del numero primo successivo a un numero dato.
     * 
     * @param n
     *         il numero da cui partire
     * @return il numero primo successivo a {@code n} in questo crivello oppure
     *         -1 se in questo crivello non ci sono numeri primi maggiori di
     *         {@code n}
     * @throws IllegalArgumentException
     *         se il numero passato {@code n} eccede la capacità di questo
     *         crivello o se è un numero minore di 1.
     */
    public int nextPrime(int n) {
    	handleException(n ,"Ciao amici");
        if (n >= primesNumbers.last()) {
        	return -1;
        }
        else {
        	return primesNumbers.higher(n);
        }
    }

    /**
     * Restituisce l'insieme dei numeri primi calcolati attraverso questo
     * crivello. Per convenzione il numero primo {@code 1} non viene incluso nel
     * risultato.
     * 
     * @return l'insieme dei numeri primi calcolati attraverso questo crivello.
     */
    public SortedSet<Integer> getPrimes() {
        return primesNumbers;
    }

    /**
     * Restituisce la capacità di questo crivello, cioè il numero massimo di
     * entrate.
     * 
     * @return la capacità di questo crivello
     */
    public int getCapacity() {
        return maxCapacity;
    }

    /**
     * Controlla se un numero è primo. Può rispondere solo se il numero passato
     * come parametro è minore o uguale alla capacità di questo crivello.
     * 
     * @param n
     *         il numero da controllare
     * @return true se il numero passato è primo
     * @throws IllegalArgumentException
     *         se il numero passato {@code n} eccede la capacità di questo
     *         crivello o se è un numero minore di 1.
     */
    public boolean isPrime(int n) {
    	handleException(n , "Ciao amici");
    	if (n == 1) {
    		return true;
    	}
    	else {
    		return primesNumbers.contains(n);
    	}
    }

    // TODO inserire eventuali metodi accessori come privati
    private void handleException(int n, String msg) {
    	if (n < 1 || n > maxCapacity) {
    		throw new IllegalArgumentException(msg); 
    	}
    }
    

}
