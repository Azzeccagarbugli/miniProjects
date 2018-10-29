package it.unicam.cs.asdl1819.miniproject1;

import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class CrivelloDiEratosteneTest {

    @Test(expected=IllegalArgumentException.class)
    public void testCrivelloDiEratostene() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(1);
    }

    @Test
    public void testNextPrime() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(7);
        assertEquals(2,c.nextPrime(1));
        assertEquals(3,c.nextPrime(2));
        assertEquals(7,c.nextPrime(6));
        assertEquals(-1,c.nextPrime(7));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testNextPrimeExceptions1() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(7);
        int i = c.nextPrime(0);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNextPrimeExceptions2() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(7);
        int i = c.nextPrime(8);
    }
    
    @Test
    public void testGetPrimes() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(32);
        SortedSet<Integer> p = new TreeSet<Integer>();
        p.add(2);
        p.add(3);
        p.add(5);
        p.add(7);
        p.add(11);
        p.add(13);
        p.add(17);
        p.add(19);
        p.add(23);
        p.add(29);
        p.add(31);
        assertEquals(p, c.getPrimes());
    }
    

    @Test
    public void testGetCapacity() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(32);
        assertEquals(32, c.getCapacity());
    }

    @Test
    public void testIsPrime() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(32);
        assertEquals(true, c.isPrime(1));
        assertEquals(true, c.isPrime(2));
        assertEquals(false, c.isPrime(32));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIsPrimeExceptions1() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(32);
        assertEquals(true, c.isPrime(0));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testIsPrimeExceptions2() {
        CrivelloDiEratostene c = new CrivelloDiEratostene(32);
        assertEquals(true, c.isPrime(33));
    }
    
}
