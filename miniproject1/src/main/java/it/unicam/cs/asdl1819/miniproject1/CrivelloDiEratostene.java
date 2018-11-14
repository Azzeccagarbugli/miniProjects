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
	/*
	 * Utilizzo del TreeSet giustificato dal fatto che gli elementi sono già ordinati
	 * secondo l'ordine naturale (ordine crescente nel caso dei numeri del crivello)
	 * e dal costo in termini computazionali di log(n) per quanto riguarda le
	 * operazioni base sfruttate nella classe.
	 */
	private TreeSet<Integer> primesNumbers;
	private int maxCapacity;

    /*
     * Costruisce il crivello di Eratostene fino a un certo numero. Il numero
     * deve essere almeno 2.
     * 
     * @param n
     *        numero di entrate nel crivello
     * @throws IllegalArgumentException
     *         se il numero {@code n} è minore di {@code 2}
     */
    public CrivelloDiEratostene(int n) {
    	/*
    	 * Il crivello viene costruito fino al numero in input al costruttore, che deve
    	 * essere almeno due. Quando il costruttore è chiamato il crivello viene
    	 * costruito e i numeri primi sono direttamente filtrati, pronti per gli altri
    	 * metodi della classe.
    	 */
    	primesNumbers = new TreeSet<Integer>();
    	maxCapacity = n;
    	
    	if (n < 2) {
			throw new IllegalArgumentException("Il numero inserito in input al crivello è minore di due");
		} 
    	else {
			for (int z = 2; z <= this.maxCapacity; z++) {
				primesNumbers.add(z);
			}
		}
		
		/*
		 * Vengono eliminati i multipli dei numeri primi presenti nel crivello. Si
		 * gestiscono solo numeri dispari in quanto tutti i primi diversi da due sono
		 * dispari.
		 */
		for (int var_1 = 2; var_1 <= maxCapacity; var_1++) {
			int var_2 = (var_1 * 2);
			while ((primesNumbers.contains(var_1)) && (var_2 <= maxCapacity)) {
				primesNumbers.remove(var_2);
				var_2 = var_2 + var_1;
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
    	/*
    	 * Il metodo restituisce il numero primo successivo all'intero passato come
    	 * argomento durante la chiamata. Restituisce errore se si fa una ricerca fuori
    	 * dalla capacità del crivello. 
    	 * 
    	 * Restituisce -1 se non ci sono numeri primi dopo l'intero passato come 
    	 * argomento durante la chiamata.
    	 */
    	handleException(n ,"Il numero passato in input per la ricerca del numero primo eccede "
    						+ "la capacità massima del crivello oppure è minore di uno");
        if (primesNumbers.higher(n) != null) {
        	return primesNumbers.higher(n);
        }
        else {
        	return -1;
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
    	/*
    	 * Restituisce un SortedSet contenente tutti i numeri primi, a partire da 2,
    	 * contenuti nel crivello, ottenuti già durante l'invocazione del metodo
    	 * costruttore della classe.
    	 */
        return primesNumbers.tailSet(2);
    }

    /**
     * Restituisce la capacità di questo crivello, cioè il numero massimo di
     * entrate.
     * 
     * @return la capacità di questo crivello
     */
    public int getCapacity() {
    	/*
    	 * Restituisce il numero massimo di numeri che può contenere il crivello creato.
    	 * Infatti viene restituito il valore massimo passato come argomento al
    	 * costruttore durante la costruzione del crivello.
    	 */
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
    	/*
    	 * Restituisce un valore booleano che indica se il valore inserito come
    	 * argomento è un numero primo. Il calcolo del valore booleano è influenzato dal
    	 * crivello a cui ci si riferisce durante la chiamata di questo metodo (con
    	 * particolare riferimento alla sua capacità massima). Restituisce errore se si
    	 * fa una ricerca fuori dalla capacità del crivello.
    	 */
    	handleException(n ,"Il numero passato in input per la ricerca del numero primo eccede "
							+ "la capacità massima del crivello oppure è minore di uno");
    	if (n == 1) {
    		return true;
    	}
    	else {
    		return primesNumbers.contains(n);
    	}
    }
    
    /**
     * Metodo privato di natura void che esegue un semplice controllo 
     * matematico sul crivello. In caso di errore viene lanciata
     * un eccezione.
     * 
     * @param n
     *         il numero da controllare
     * @param msg
     * 		   il messaggio visualizzato in caso di errore
     */
    private void handleException(int n, String msg) {
    	if (n < 1 || n > maxCapacity) {
    		throw new IllegalArgumentException(msg); 
    	}
    }
}
