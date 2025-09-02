package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

    	SingleNode<T> pointer = this.front;//points to the front node of the list
    	 //goes through the list
    	 while(pointer != null) {
    	 //checks if pointer data node equals to key
    	 if(pointer.getDatum().compareTo(key) == 0) {
    	 return pointer;//returns pointer value
    	 }

    	 pointer = pointer.getNext();//moves to the next node
    	 }

    	 return null;//returns null if nothing is found
    	 }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param datum The value to append.
     */
    public void append(final T datum) {

    	SingleNode<T> newNode = new SingleNode<T>(datum, null);//creates new node
    	//checks if list is empty
    	if(this.front == null && this.rear == null) {
    		this.front = this.rear = newNode;//adds node to both head and tail
    	}
    	else {
    		//sets next node of the rear to newNode
    		this.rear.setNext(newNode);
    		this.rear = newNode;//updates rear to new node
    	}

    	this.length += 1;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {

    	SingleNode<T> ptr1 = null, ptr2 = null, dup = null;
    	ptr1 = this.front;

    	while(ptr1 != null && ptr1.getNext() != null) {
    		ptr2 = ptr1;

    		while(ptr2.getNext() != null) {
    			if(ptr1.getDatum().compareTo(ptr2.getNext().getDatum()) == 0) {
    				dup = ptr2.getNext();
    				ptr2.setNext(ptr2.getNext().getNext());
    				System.gc();
    			}
    			else {
    				ptr2 = ptr2.getNext();
    			}
    		}
    		ptr1 = ptr1.getNext();
    	}
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

    	SingleNode<T> currL = left.front;
    	SingleNode<T> currR = right.front;

    	while(currL != null || currR != null ) {
    		if(right.getLength() == 0) {
    			if(this.getLength() == 0) {
    				this.front = this.rear = currL;
    			}
    			else {
    				this.rear.setNext(currL);
    				this.rear = currL;
    			}
    			this.length += 1;

    			currL.setNext(null);
    			left.front = left.front.getNext();
    			currL = left.front;
    			left.length -= 1;
    		}
    		else if(left.getLength() == 0) {
    			if(this.getLength() == 0) {
    				this.front = this.rear = currR;
    			}
    			else {
    				this.rear.setNext(currR);
    				this.rear = currR;
    			}

    			this.length += 1;

    			currR.setNext(null);
    			right.front = right.front.getNext();
    			currR = right.front;
    			right.length -= 1;
    		}
    		else {
    			if(this.getLength() == 0) {
    				this.front = this.rear = currL;
    				this.rear.setNext(currR);
    				this.rear = currR;

    			}
    			else {
    				this.rear.setNext(currL);
    				this.rear = currL;
    				this.rear.setNext(currR);
    				this.rear = currR;

    			}
    			this.length += 2;

    			currL.setNext(null);
    			left.front = left.front.getNext();
    			currL = left.front;
    			left.length -= 1;

    			currR.setNext(null);
    			right.front = right.front.getNext();
    			currR = right.front;
    			right.length -= 1;

    		}
    	}
    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

    	SingleNode<T> cont = this.linearSearch(key);

    	if(cont == null) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

    	int count = 0;
    	SingleNode<T> curr = this.front;

    	while(curr != null) {
    		if(curr.getDatum().compareTo(key) == 0) {
    			count += 1;
    		}
    		curr = curr.getNext();
    	}
    	return count;


    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {

    	SingleNode<T> point = this.linearSearch(key);

    	return point.getDatum();
    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

    	SingleNode<T> curr = this.front;

    	int count = 0;
    	while(count != n) {
    		curr = curr.getNext();
    		count += 1;
    	}

    	return curr.getDatum();


    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {

    	SingleNode<T> curr1 = this.front;
    	SingleNode<T> curr2 = source.front;

    	while(curr1 != null && curr2 != null) {
    		if(curr1.getDatum().compareTo(curr2.getDatum()) != 0) {
    			return false;
    		}

    		curr1 = curr1.getNext();
    		curr2 = curr2.getNext();
    	}

    	return(curr1 == null && curr2 == null);
    }
    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

    	int index = 0;

    	SingleNode<T> curr = this.front;

    	while(curr != null) {
    		if(curr.getDatum().compareTo(key) == 0) {
    			return index;
    		}

    		index += 1;
    		curr = curr.getNext();

    	}

    	return -1;
    }

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i     The index to insert the new data at.
     * @param datum The new value to insert into this SingleList.
     */
    public void insert(int i, final T datum) {

    	int index = 0;
    	SingleNode<T> newNode = new SingleNode<T>(datum, null);
    	SingleNode<T> prev = null;
    	SingleNode<T> curr = this.front;

    	if(this.front == null && this.rear == null) {
    		this.front = this.rear = newNode;
    	}

    	else if(i > this.getLength()) {
    		this.rear.setNext(newNode);
    		this.rear = newNode;
    	}
    	else if(i <= 0) {
    		newNode.setNext(this.front);
    		this.front = newNode;
    	}
    	else {
    		while(index != i) {
    			prev = curr;
    			curr = curr.getNext();
    			index += 1;
    		}

    		prev.setNext(newNode);
    		newNode.setNext(curr);
    	}

    	this.length += 1;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	// your code here

	return;
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {

    	SingleNode<T> curr = this.front;
    	SingleNode<T> max = this.front;

    	while(curr != null) {
    		if(curr.getDatum().compareTo(max.getDatum()) > 0) {
    			max = curr;
    		}

    		curr = curr.getNext();
    	}

    	return max.getDatum();

    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {

    	SingleNode<T> curr = this.front;
    	SingleNode<T> min = this.front;

    	while(curr != null) {
    		if(curr.getDatum().compareTo(min.getDatum()) < 0) {
    			min = curr;
    		}

    		curr = curr.getNext();
    	}

    	return min.getDatum();
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param datum The value to insert into the front of this SingleList.
     */
    public void prepend(final T datum) {

    	SingleNode<T> newNode = new SingleNode<T>(datum, null);

    	if(this.getLength() == 0) {

    		this.front = this.rear = newNode;

    	}
    	else {
    		newNode.setNext(this.front);
    		this.front = newNode;
    	}

    	this.length += 1;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {

    	SingleNode<T> curr = this.front;
    	SingleNode<T> prev = null;
    	SingleNode<T> removed = null;

    	if(this.getLength() == 1) {
    		this.front = this.rear = null;
    	}
    	else {
    		while(curr.getDatum().compareTo(key) != 0) {
    			if(curr.getNext() == null) {
    				return null;
    			}

    			prev = curr;
    			curr = curr.getNext();
    		}
    		removed = curr;
    		prev.setNext(curr.getNext());
    		curr = curr.getNext();
    	}
    	this.length -= 1;
    	removed.setNext(null);

    	return removed.getDatum();

    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {

    	SingleNode<T> prevFront = this.front;

    	prevFront.setNext(null);
    	this.front = this.front.getNext();

    	this.length -= 1;
    	return prevFront.getDatum();
    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {

	// your code here

	return;
    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {

    	SingleNode<T> curr = this.front;
    	SingleNode<T> prev = null;
    	SingleNode<T> next;

    	while(curr != null) {
    		next = curr.getNext(); 
    		curr.setNext(prev); 
    		prev = curr; 
    		this.front = curr; 
    		curr = next; 
    		
    	}
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

    	SingleNode<T> curr = this.front;
    	int splitPoint = this.getLength()/2;
    	int count = 0;

    	if(splitPoint%2 != 0) {
    		splitPoint += 1;
    	}

    	while(curr != null) {
    		if(count >= splitPoint) {
    			if(right.front == null && right.rear == null) {
    				right.front = right.rear = curr;
    			}
    			else {
    				right.rear.setNext(curr);
    				right.rear = curr;
    			}

    			right.length += 1;

    		}

    		else {
    			if(left.front == null && left.rear == null) {
    				left.front = left.rear = curr;
    			}
    			else {

    				left.rear.setNext(curr);
    				left.rear = curr;
    			}

    			left.length += 1;

    		}
    		curr.setNext(null);
    		this.front = this.front.getNext();
    		curr = this.front;

    		this.length -= 1;
    	}


    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

    	SingleNode<T> curr = this.front;
    	boolean flag = true;

    	while(curr != null) {

    		if(flag == true) {
    			if(left.front == null && left.rear == null) {
    				left.front = left.rear = curr;
    			}
    			else {
    				left.rear.setNext(curr);
    				left.rear = curr;
    			}

    			left.length += 1;

    		}
    		else {
    			if(right.front == null && right.rear == null) {
    				right.front = right.rear = curr;
    			}
    			else {
    				right.rear.setNext(curr);
    				right.rear = curr;
    			}

    			right.length += 1;


    		}

    		flag = !flag;

    		curr.setNext(null);
    		this.front = this.front.getNext();
    		curr = this.front;

    		this.length -= 1;

    	}
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

    	SingleNode<T> currL = left.front;
    	SingleNode<T> currR = right.front;

    	while(currL != null) {
    		if(this.front == null && this.rear == null) {
    			this.front = this.rear = currL;
    		}
    		else {
    			this.rear.setNext(currL);
    			this.rear = currL;
    		}
    		currL = currL.getNext();
    		this.length += 1;

    	}

    	while(currR != null) {
    		if(this.front == null && this.rear == null) {
    			this.front = this.rear = currR;
    		}
    		else {
    			this.rear.setNext(currR);
    			this.rear = currR;
    		}

    		currR = currR.getNext();
    		this.length += 1;

    	}
    }
}
