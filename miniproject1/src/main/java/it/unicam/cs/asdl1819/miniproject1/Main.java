package it.unicam.cs.asdl1819.miniproject1;

public class Main {
	public static void main (String [ ] args) {
		
		Factoriser f = new Factoriser();
		Multiset<Integer> m = f.getFactors(42890);
		Multiset<Integer> m2 = new MyMultiset<Integer>();
        m2.add(2);
        m2.add(5);
        m2.add(4289);

		System.out.println(m.toString());
		System.out.println(m2.toString());
		System.out.println(m.equals(m2));

		System.out.println(m.size());

		System.out.println(m2.size());
		/*
		MyMultiset<Integer> m1 = new MyMultiset<Integer>();
        m1.add(3,5);
        m1.setCount(4,7);
        m1.setCount(5,9);
        MyMultiset<Integer> m3 = new MyMultiset<Integer>();
        m3.add(5,9);
        m3.add(3);
        m3.setCount(3,5);
        m3.add(4);
        m3.add(4,6);
        
        System.out.println(m1);

        System.out.println(m3);
        System.out.println("Dimesnione M1: "+ m1.size());
        System.out.println("Dimesnione M2: " +m3.size());
        System.out.println("I Multiset sono uguali? " + m1.equals(m3));
		*/
	}
}
