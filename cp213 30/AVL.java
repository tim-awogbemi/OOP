package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author your name here
 * @author David Brown
 * @version 2022-05-12
 */
public class AVL<T extends Comparable<T>> extends BST<T> {

    /**
     * Returns the balance item of node. If greater than 1, then left heavy, if less
     * than -1, then right heavy. If in the range -1 to 1 inclusive, the node is
     * balanced. Used to determine whether to rotate a node upon insertion.
     *
     * @param node The TreeNode to analyze for balance.
     * @return A balance number.
     */
    private int balance(final TreeNode<T> node) {

    	return this.nodeHeight(node.getLeft()) - this.nodeHeight(node.getRight());
    }

    /**
     * Performs a left rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateLeft(final TreeNode<T> node) {

    	TreeNode<T> x = node.getRight();
    	TreeNode<T> t2 = x.getLeft();

    	x.setLeft(node);
    	node.setRight(t2);

    	node.updateHeight();
    	return x;



    }
    /**
     * Performs a right rotation around node.
     *
     * @param node The subtree to rotate.
     * @return The new root of the subtree.
     */
    private TreeNode<T> rotateRight(final TreeNode<T> node) {

    	TreeNode<T> x = node.getLeft();
    	TreeNode<T> t2 = x.getRight();
    	x.setRight(node);
    	node.setLeft(t2);

    	node.updateHeight();
    	return x;


    }

    /**
     * Auxiliary method for insert. Inserts data into this AVL.
     *
     * @param node The current node (TreeNode).
     * @param cs   Data to be inserted into the node.
     * @return The inserted node.
     */
    @Override
    protected TreeNode<T> insertAux(TreeNode<T> node, final CountedStore<T> cs) {

    	if (node == null) {
    		 // Base case - add a new node containing the data.
    		 node = new TreeNode<>(data);
    		 this.size++;
    		} else {
    		 // Compare the node data against the insert data.
    		 final int result = node.getData().compareTo(data);
    		 if (result > 0) {
    		// General case - check the left subtree.
    		node.setLeft(this.insertAux(node.getLeft(), data));
    		node.updateHeight();
    		// As a left insertion, can only be unbalanced on the left.
    		balance = this.balance(node);
    		}
    		 } else if (result < 0) {
    		// General case - check the right subtree.
    		node.setRight(this.insertAux(node.getRight(), data));
    		node.updateHeight();
    		// As a right insertion, can only be unbalanced on the right.
    		balance = this.balance(node);
    		if (balance < -1 && this.balance(node.getRight()) <= 0) {
    		 // Right Right Case - single rotation
    		 node = this.rotateLeft(node);
    		} else if (balance < -1 && this.balance(node.getRight()) > 0) {
    		 // Right Left Case - double rotation
    		 node.setRight(this.rotateRight(node.getRight()));
    		 node = this.rotateLeft(node);
    		}
    		 } else {
    		// Base case - data is already in the tree.
    		node.incrementCount();
    		 }
    		}
    		return node;
    		 }

    /**
     * Auxiliary method for valid. Determines if a subtree based on node is a valid
     * subtree. An AVL must meet the BST validation conditions, and additionally be
     * balanced in all its subtrees - i.e. the difference in height between any two
     * children must be no greater than 1.
     *
     * @param node The root of the subtree to test for validity.
     * @return true if the subtree base on node is valid, false otherwise.
     */
    @Override
    protected boolean isValidAux(final TreeNode<T> node, TreeNode<T> minNode, TreeNode<T> maxNode) {

    	boolean valid = false;

    	if (node == null) {
    	valid = true;
    	}

    	else if (Math.max(this.nodeHeight(node.getLeft()), this.nodeHeight(node.getRight())) != node.getHeight() - 1) {
    	valid = false;
    	}

    	else if (node.getLeft() != null && node.getLeft().getValue().compareTo(node.getValue()) >= 0
    	|| node.getRight() != null && node.getRight().getValue().compareTo(node.getValue()) <= 0) {
    	valid = false;
    	}

    	else {
    	valid = this.isValidAux(node.getLeft()) && this.isValidAux(node.getRight());
    	}
    	return valid;

    	}
    
    	/**
    	* Determines whether two AVLs are identical.
    	*
    	* @param target The AVL to compare this AVL against.
    	* @return true if this AVL and target contain nodes that match in
    	* position, value, count, and height, false otherwise.
    	*/


    	public boolean equals(final AVL<T> target)

    	{
    	return super.equals(target);
    	}

    /**
     * Determines whether two AVLs are identical.
     *
     * @param target The AVL to compare this AVL against.
     * @return true if this AVL and target contain nodes that match in position,
     *         item, count, and height, false otherwise.
     */
    public boolean equals(final AVL<T> target) {
	return super.equals(target);
    }

}
