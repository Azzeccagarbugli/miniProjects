package it.unicam.cs.asdl1819.miniproject1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactoriserTest {
    
    private static Factoriser f;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        f = new Factoriser();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetFactorsLessThanOne() {
        Multiset<Integer> m = f.getFactors(0);
    }
    
    @Test
    public void testGetFactorsOne() {
        Multiset<Integer> m = f.getFactors(1);
        assertEquals(true,m.isEmpty());
    }
    
    @Test
    public void testGetFactors1() {
        Multiset<Integer> m1 = f.getFactors(32);
        Multiset<Integer> m2 = new MyMultiset<Integer>();
        m2.add(2,5);
        assertEquals(true, m1.equals(m2));
    }
    
    @Test
    public void testGetFactors2() {
        Multiset<Integer> m1 = f.getFactors(2);
        Multiset<Integer> m2 = new MyMultiset<Integer>();
        m2.add(2,1);
        assertEquals(true, m1.equals(m2));
    }
    
    @Test
    public void testGetFactors3() {
        Multiset<Integer> m1 = f.getFactors(2134440);
        Multiset<Integer> m2 = new MyMultiset<Integer>();
        m2.add(2,3);
        m2.add(3,2);
        m2.add(5);
        m2.add(7,2);
        m2.add(11,2);
        assertEquals(true, m1.equals(m2));
    }
    
    @Test
    public void testGetFactors4() {
        Multiset<Integer> m1 = f.getFactors(42890);
        Multiset<Integer> m2 = new MyMultiset<Integer>();
        m2.add(2);
        m2.add(5);
        m2.add(4289);
        assertEquals(true, m1.equals(m2));
    }

}
