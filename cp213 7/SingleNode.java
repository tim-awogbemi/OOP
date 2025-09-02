package cp213;

/**
 * DO NOT CHANGE THE CONTENTS OF THIS CLASS.
 *
 * The individual node of a linked structure that stores <code>T</code> objects.
 * This is a singly linked node. The node link can be updated, but not the node
 * datum, in order to avoid copying or moving values between nodes. Data
 * structures must be updated by moving nodes, not by copying or moving data.
 *
 * @author David Brown
 * @version 2022-10-26
 */
public final class SingleNode<T> {

    /**
     * Link to the next Node.
     */
    private SingleNode<T> next = null;
    /**
     * The generic data stored in the node.
     */
    private T datum = null;

    /**
     * Creates a new node with datum and link to next node. Not copy safe as it
     * accepts a reference to the datum rather than a copy of the datum.
     *
     * @param datum the data to store in the node.
     * @param next  the next node to link to.
     */
    public SingleNode(final T datum, final SingleNode<T> next) {
	this.datum = datum;
	this.next = next;
    }

    /**
     * Returns the next node in the linked structure.
     *
     * @return The node that follows this node.
     */
    public SingleNode<T> getNext() {
	return this.next;
    }

    /**
     * Returns the node datum. Not copy safe as it returns a reference to the datum,
     * not a copy of the datum.
     *
     * @return The datum portion of the node.
     */
    public T getDatum() {
	return this.datum;
    }

    /**
     * Links this node to the next node.
     *
     * @param next The new node to link to.
     */
    public void setNext(final SingleNode<T> next) {
	this.next = next;
    }
}
