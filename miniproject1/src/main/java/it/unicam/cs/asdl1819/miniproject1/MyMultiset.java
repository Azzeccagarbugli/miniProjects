package it.unicam.cs.asdl1819.miniproject1;

import java.util.HashSet; // Utilizzare questa classe per i set
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.w3c.dom.Element;

/**
 * TODO spiegare come viene implementato il multiset.
 * 
 * @author Luca Tesei (template), Francesco Coppola (implementazione)
 *
 * @param <E>
 *            il tipo degli elementi del multiset
 */
public class MyMultiset<E> implements Multiset<E> {
    // TODO Inserire le variabili istanza che servono

	private HashSet<Elemento> multiSet;
	
    // TODO Inserire eventuali classi interne per gli elementi del multinsieme e
    // per l'iteratore.
	
	public class Elemento {
		private E riferimento;
		private int occorrenze;

		public Elemento(E r, int n) {
			this.riferimento = r;
			this.occorrenze = n;
		}
		
		public void setOccorrenze(int occorrenze) {
			if(occorrenze < 0) {
				throw new IllegalArgumentException("42");
			}
			this.occorrenze = occorrenze;
		}
	}
	
    /**
     * Crea un multiset vuoto.
     */
    public MyMultiset() {
    	multiSet = new HashSet<Elemento>();
    }

    public int size() {

    	int size = 0;
    	for(Elemento e : multiSet) {
    		size += e.occorrenze;
    	}
        return size;
    }

    public int count(Object element) {
    	if(element == null) {
    		throw new NullPointerException("42");
    	}
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			return e.occorrenze;
    		}
    	}
        return 0;
    }

    public int add(E element, int occurrences) {
    	if(occurrences < 0) {
    		throw new IllegalArgumentException("42");
    	}
    	
    	if(element == null) {
    		throw new NullPointerException("42");
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
    	if(element == null) {
    		throw new NullPointerException("42");
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
    	if(occurrences < 0) {
    		throw new IllegalArgumentException("42");
    	}
    	
    	if(element == null) {
    		throw new NullPointerException("42");
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
    	if(element == null) {
    		throw new NullPointerException("42");
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
    	if(count < 0) {
    		throw new IllegalArgumentException("42");
    	}
    	
    	if(element == null) {
    		throw new NullPointerException("42");
    	}
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			int tempOccorenze = e.occorrenze;
    			e.setOccorrenze(count);
    			return tempOccorenze;
    		}
    	}
        return 0;
    }

    public Set<E> elementSet() {
        Set<E> setStuff = new HashSet<E>();
        for(Elemento e : multiSet) {
        	setStuff.add(e.riferimento);
        }
        return setStuff;
    }

    public Iterator<E> iterator() {
        @SuppressWarnings("unchecked")
		Iterator<E> iterator = (Iterator<E>) multiSet.iterator();
        
        return iterator;
    }

    public boolean contains(Object element) {
    	if(element == null) {
    		throw new NullPointerException("42");
    	}
    	
    	for(Elemento e : multiSet) {
    		if(e.riferimento.equals(element)) {
    			return true;
            }
    	}
        return false;
    }

    public void clear() {
    	Iterator<E> clearIt = this.iterator();
    	while(clearIt.hasNext()) {
    		clearIt.next();
    		clearIt.remove();
    	}
    }

    public boolean isEmpty() {
    	if(this.size() == 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((multiSet == null) ? 0 : multiSet.hashCode());
		return result;
	}

    @SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
    	MyMultiset other = (MyMultiset) obj;
    	if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MyMultiset))
			return false;
		if (multiSet == null) {
			if (other.multiSet != null)
				return false;
		} else if (!multiSet.equals(other.multiSet))
			return false;
		
		return true;
	}

}
