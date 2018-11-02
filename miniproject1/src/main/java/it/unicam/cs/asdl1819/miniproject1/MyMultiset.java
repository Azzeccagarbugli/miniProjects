package it.unicam.cs.asdl1819.miniproject1;

import java.util.HashSet; // Utilizzare questa classe per i set
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.w3c.dom.Element;

import it.unicam.cs.asdl1819.miniproject1.MyMultiset.Elemento;

/**
 * TODO spiegare come viene implementato il multiset.
 * 
 * @author Luca Tesei (template), Francesco Coppola (implementazione)
 *
 * @param <E>
 *            il tipo degli elementi del multiset
 */
public class MyMultiset<E> implements Multiset<E> {
	
	private HashSet<Elemento> multiSet;
	
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
		
		@Override
		public String toString() {
			return "Oggetto: " + riferimento.toString() + ", occorrenze: " + occorrenze;
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
    	
    	Elemento p = new Elemento(element, count);
    	multiSet.add(p);
    	
        return 0;
    }

    public Set<E> elementSet() {
        Set<E> setStuff = new HashSet<E>();
        for(Elemento e : multiSet) {
        	setStuff.add(e.riferimento);
        }
        return setStuff;
    }
    
    private class MyMultiSetIterator implements Iterator<E> {
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
        return new MyMultiSetIterator();
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
    	MyMultiSetIterator clearIt = new MyMultiSetIterator();
    	clearIt.clear();
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
