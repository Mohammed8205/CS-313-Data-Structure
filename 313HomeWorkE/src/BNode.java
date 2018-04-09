//package class13;

import java.util.ArrayList;
import java.util.Iterator;

//import class12.Node;

public class BNode<K> extends Node<K> {
	BNode<K> left, right;

	public BNode(K d, BNode<K> p, BNode<K> l, BNode<K> r) {
		setData(d);
		setParent(p);
		left = l;
		right = r;
	}

	public void setLeft(BNode<K> n) {
		left = n;
	}

	public void setRight(BNode<K> n) {
		right = n;
	}

	public BNode<K> getLeft() {
		return left;
	}

	public BNode<K> getRight() {
		return right;
	}

	public Iterator<BNode<K>> children() {
		ArrayList<BNode<K>> v = new ArrayList<>();
		if (left != null) v.add(left);
		if (right != null) v.add(right);
		return v.iterator();
	}
	
	public void removeChild(BNode<K> n) {
		if (getLeft() == n) setLeft(null);
		else setRight(null);
	}
}