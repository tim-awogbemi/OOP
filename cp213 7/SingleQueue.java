package cp213;

/**
 * A single linked queue structure of <code>Node T</code> objects. Only the
 * <code>T</code> value contained in the queue is visible through the standard
 * queue methods. Extends the <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> the SingleQueue data type.
 */
public class SingleQueue<T> extends SingleLink<T> {

    /**
     * Combines the contents of the left and right SingleQueues into the current
     * SingleQueue. Moves nodes only - does not refer to values in any way, or call
     * the high-level methods insert or remove. left and right SingleQueues are
     * empty when done. Nodes are moved alternately from left and right to this
     * SingleQueue.
     *
     * You have two source queues named left and right. Move all nodes from these
     * two queues to the current queue. It does not make a difference if the current
     * queue is empty or not, just get nodes from the right and left queues and add
     * them to the current queue. You may use any appropriate SingleLink helper
     * methods available.
     *
     * Do not assume that both right and left queues are of the same length.
     *
     * @param left  The first SingleQueue to extract nodes from.
     * @param right The second SingleQueue to extract nodes from.
     */
    public void combine(final SingleQueue<T> left, final SingleQueue<T> right) {

    	SingleNode<T> currL = left.front;
    	SingleNode<T> currR = right.front;

    	while(currL != null && currR != null ) {
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
     * Adds value to the rear of the queue. Increments the queue length.
     *
     * @param datum The value to added to the rear of the queue.
     */
    public void insert(final T datum) {

    	SingleNode<T> newNode = new SingleNode<T>(datum, null);

    	if(this.getLength() == 0) {
    		this.front = this.rear = newNode;
    	}
    	else {
    		this.rear.setNext(newNode);
    		this.rear = newNode;
    	}

    	this.length += 1;
    }
    	 
    /**
     * Returns the front value of the queue and removes that value from the queue.
     * The next node in the queue becomes the new first node. Decrements the queue
     * length.
     *
     * @return The value at the front of the queue.
     */
    public T remove() {

    	SingleNode<T> removed = this.front;

    	 removed.setNext(null);

    	 this.front = this.front.getNext();
    	 this.length -= 1;

    	 return removed.getDatum();
    	 }
    /**
     * Splits the contents of the current SingleQueue into the left and right
     * SingleQueues. Moves nodes only - does not move value or call the high-level
     * methods insert or remove. this SingleQueue is empty when done. Nodes are
     * moved alternately from this SingleQueue to left and right. left and right may
     * already contain values.
     *
     * This is the opposite of the combine method.
     *
     * @param left  The first SingleQueue to move nodes to.
     * @param right The second SingleQueue to move nodes to.
     */
    public void splitAlternate(final SingleQueue<T> left, final SingleQueue<T> right) {

    	SingleNode<T> currNode = this.front;
    	 boolean flag = true;

    	 while(currNode != null) {
    	 if(flag == true) {
    	 if(left.getLength() == 0) {
    	 left.front = left.rear = currNode;
    	 }
    	 else {
    	 left.rear.setNext(currNode);
    	 left.rear = currNode;

    	 }
    	 left.length += 1;
    	 }
    	 else {
    	 if(right.getLength() == 0) {
    	 right.front = right.rear = currNode;
    	 }
    	 else {
    	 right.rear.setNext(currNode);
    	 right.rear = currNode;
    	 }

    	 right.length += 1;
    	 }

    	 flag = !flag;
    	 currNode.setNext(null);
    	 this.front = this.front.getNext();
    	 currNode = this.front;

    	 this.length -= 1;
    	 }
    	 }
    	}
