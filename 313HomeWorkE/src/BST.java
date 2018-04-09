//package class22;

///import class13.BNode;
//import class13.BinaryTree;

public class BST<K extends Comparable<K>> extends BinaryTree<K> implements
		BSTree<K> {
	public BNode<K> findNode(K x) {
		if (root() == null){
			return null;
		}
		return findNode((BNode<K>) root(), x);
	}

	public BNode<K> findNode(BNode<K> n, K x) {
		BNode<K> nn = null;
		if (n.getData().compareTo(x) == 0){
			return n;
		}
		if (n.getData().compareTo(x) > 0){
			nn = n.getLeft();
		}
		else{
			nn = n.getRight();
		}
		if (nn == null){
			return n;
		}
		return findNode(nn, x);
		 //return null;
	}

	public void remove(K x) {
		BNode<K> n = findNode(x);
		if (n == null || !n.getData().equals(x))
			return; // x is not present
		removeNode(n);
	}

	public void insert(K x) throws Exception {
		BNode<K> n = findNode(x);
		if (n == null)
			addRoot(x);
		else if ((n.getData()).compareTo(x) > 0)
			addLeft(n, x);
		else if ((n.getData()).compareTo(x) < 0)
			addRight(n, x);
	}

	public boolean find(K x) {
		BNode<K> n = findNode(x);
		if (n == null || !n.getData().equals(x))
			return false;
		return true;
	}
}