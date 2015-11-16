/**
 * Author: Guangpeng Li
 * ID: 200876363
 * Date: 20/10/13
 * Time: 14:08
 * University of Liverpool
 * Comp 213 Assignment 1
 */


/**
 *  An element in a doubly-linked list.
 *  A helper class to implement linked lists, each element consists
 *  of a Class, a pointer to the next element,
 *  and a pointer to the previous element.
 *  The empty list is represented by null.  Thus, for example,
 *  a list of length 1 is a node whose tail and previous element are both null.
 *
 * @author <a href="mailto:sggli@liverpool.ac.uk">Guangpeng Li</a>
 * @version 1.0
 */

public class LinkedList<E> {

    /**
     *  An element in the list.
     */
    private E head;

    /**
     *  The list that follows from the current element.
     */
    private LinkedList<E> tail;

    /**
     *  The element preceding this in the doubly-linked list.
     */
    private LinkedList<E> prev;

    /**
     * Creates a new <code>List</code> instance as a list of length 1;
     * the tail and prev pointers are both null.
     *
     * @param e the head to store at the current element.
     */
    public LinkedList(E e) {
        head = e;
    }

    /**
     * Creates a list by creating an element with a given value and tail.
     * The {@link #prev prev} node is null.
     *
     * @param e the Topic at the value of the list
     * @param l the tail of the list
     */
    public LinkedList(E e, LinkedList l) {
        head = e;
        tail = l;
        if (l != null) {
            l.prev = this;
        }
    }

    /**
     * Get the value of the list.
     *
     * @return the head at the value of the list (the current element)
     */
    public E getHead() {
        return head;
    }

    /**
     *  Get the tail of the list.
     *
     * @return the element linked to from the current element
     *         (null if the current element is the end of the list)
     */
    public LinkedList<E> getTail() {
        return tail;
    }

    /**
     *  Get the previous element in the list.
     *
     * @return the element previous to the current element
     *         (null if the current element is the start of the list)
     */
    public LinkedList<E> prev() {
        return prev;
    }

    /**
     *  Add an element to the end of the list.
     *
     * @param e the item to add
     */
    public void addEnd(E e)
    {
        tail = new LinkedList<E>(e);
        tail.prev = this;
    }

    /**
     *  Link two elements in the list
     *
     * @param l the element to link
     */
    public void link(LinkedList l) {
        tail = l;
        tail.prev = this;
    }

    /**
     *  Cut the list at the current element.
     *  The current element becomes the end of the list.
     */
    public void chop() {
        tail = null;
    }
}
