package it.unicam.cs.asdl1819.miniproject1;

import java.util.Iterator;
import java.util.Set;

/**
 * A multiset (also called bag) is a set in which the elements have a count (or
 * multiplicity, or frequency), that is a number of occurrences. The count can
 * be zero: this is equivalent to say that the element does not belong to the
 * multiset. If, instead, the count is a positive integer {@code n} then the
 * element occurs {@code n} times in the multiset.
 * 
 * As in classical sets, in a multiset the elements are not ordered and they are
 * not indexed.
 * 
 * It is forbidden to insert a {@code null} value in a multiset.
 * 
 * Since the count is represented by an {@code int}, a multiset can never
 * contains more than {@code Integer.MAX_VALUE} occurrences for each element.
 * 
 * @author Luca Tesei
 *
 * @param <E>
 *            the type of the elements of the multiset. If a multiset containing
 *            heterogeneous types is needed, {@code Object} can be used as type.
 */
public interface Multiset<E> {
    /**
     * Returns the total number of elements in this multiset counting all the
     * occurrences. For instance, {@code [1,2,3,1,4].size()} must return five by
     * counting the two occurrences of {@code 1}.
     * 
     * @return the number of elements in this multiset counting all the
     *         occurrences
     *
     */
    public int size();

    /**
     * Returns the number of occurrences of an element in this multiset.
     *
     * @param element
     *                    the element to count occurrences of
     * @return the number of occurrences of the {@code element} in this
     *         multiset; possibly zero but never negative
     * @throws NullPointerException
     *                                  if {@code element} is null
     */
    public int count(Object element);

    /**
     * Adds a number of occurrences of an element to this multiset.
     *
     * @param element
     *                        the element to add occurrences of
     * @param occurrences
     *                        the number of occurrences of the element to add.
     *                        May be zero, in which case no change will be made.
     * @return the count of the element before the operation; possibly zero
     * @throws IllegalArgumentException
     *                                      if {@code occurrences} is negative,
     *                                      or if this operation would result in
     *                                      more than {@code Integer.MAX_VALUE}
     *                                      occurrences of the element
     * @throws NullPointerException
     *                                      if {@code element} is null.
     */
    public int add(E element, int occurrences);

    /**
     * Adds a single occurrence of the specified element to this multiset.
     *
     *
     * @param element
     *                    the element to add one occurrence of
     * @throws NullPointerException
     *                                      if {@code element} is null
     * @throws IllegalArgumentException
     *                                      if {@code Integer.MAX_VALUE}
     *                                      occurrences of {@code element} are
     *                                      already contained in this multiset
     */
    public void add(E element);

    /**
     * Removes a number of occurrences of the specified element from this
     * multiset. If the multiset contains fewer than this number of occurrences,
     * all occurrences will be removed.
     *
     * @param element
     *                        the element to conditionally remove occurrences of
     * @param occurrences
     *                        the number of occurrences of the element to
     *                        remove. May be zero, in which case no change will
     *                        be made.
     * @return the count of the element before the operation; possibly zero
     * @throws IllegalArgumentException
     *                                      if {@code occurrences} is negative
     * @throws NullPointerException
     *                                      if {@code element} is null
     */
    public int remove(Object element, int occurrences);

    /**
     * Removes a <i>single</i> occurrence of the specified element from this
     * multiset, if present.
     *
     * @param element
     *                    the element to remove one occurrence of
     * @return {@code true} if an occurrence was found and removed
     * @throws NullPointerException
     *                                  if {@code element} is null
     */
    public boolean remove(Object element);

    /**
     * Adds or removes the necessary occurrences of an element such that the
     * element attains the desired count.
     *
     * @param element
     *                        the element to add or remove occurrences of
     * @param occurrences
     *                        the desired count of the element in this multiset
     * @return the count of the element before the operation; possibly zero
     * @throws IllegalArgumentException
     *                                      if {@code count} is negative
     * @throws NullPointerException
     *                                      if {@code element} is null
     */
    public int setCount(E element, int occurrences);

    /**
     * Returns the set of distinct elements contained in this multiset. The
     * order of the elements in the element set is unspecified.
     *
     * @return the set of distinct elements in this multiset
     */
    public Set<E> elementSet();

    /**
     * Returns an iterator for the multiset. The iterator must present all
     * elements of the multiset and for each element it must present all the
     * occurrences. Occurrences of the same element must be presented in
     * sequence. The iterator is not required to implement the remove operation.
     * 
     * @return an iterator for this multiset
     */
    public Iterator<E> iterator();

    /**
     * Determines whether this multiset contains the specified element.
     *
     * @param element
     *                    the element to check for
     * @return {@code true} if this multiset contains at least one occurrence of
     *         the element
     * @throws NullPointerException
     *                                  if {@code element} is null
     */
    public boolean contains(Object element);

    /**
     * Removes all of the elements from this multiset. The multiset will be
     * empty after this method returns.
     *
     */
    public void clear();

    /**
     * Returns <tt>true</tt> if this multiset contains no elements.
     *
     * @return <tt>true</tt> if this multiset contains no elements
     */
    public boolean isEmpty();

    /**
     * Compares the specified object with this multiset for equality. Returns
     * {@code true} if the given object is also a multiset and contains equal
     * elements with equal counts, regardless of order.
     */
    public boolean equals(Object object);

    /**
     * Returns the hash code for this multiset.
     */
    public int hashCode();

}
